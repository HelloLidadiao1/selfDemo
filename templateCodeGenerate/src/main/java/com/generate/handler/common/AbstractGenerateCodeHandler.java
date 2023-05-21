package com.generate.handler.common;

import com.generate.common.constant.Constant;
import com.generate.common.constant.ErrorCode;
import com.generate.common.exception.GcsException;
import com.generate.common.util.GenerateCodeUtils;
import com.generate.convert.DBColumnToFieldConvert;
import com.generate.entity.DBColumnEntity;
import com.generate.manager.DBColumnManager;
import com.generate.model.FieldModel;
import com.generate.model.GenerateCodeModel;
import com.generate.model.GenerateFileNameModel;
import com.generate.vo.GenerateCodeVo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
public abstract class AbstractGenerateCodeHandler implements GenerateCodeHandler {

    Logger logger = LoggerFactory.getLogger(AbstractGenerateCodeHandler.class);

    @Resource
    private DBColumnManager dbColumnManager;

    @Resource
    private Configuration freeMarkerConfiguration;

    @Resource
    private ExecutorService threadPool;

    /**
     * 通过模板生成代码
     * @param generateCodeParamModel
     */
    public void generateCodeByTemplateMain(GenerateCodeModel generateCodeParamModel){
        // 1、参数校验
        validateGenerateCodeByTemplateMain(generateCodeParamModel);

        // 2、建立jdbc连接，获取表的所有字段、数据库类型（同时转换成java里的类型）
        GenerateCodeModel generateCodeModel = new GenerateCodeModel();
        BeanUtils.copyProperties(generateCodeModel, generateCodeParamModel);
        buildGenerateCodeFieldList(generateCodeModel);

        // 2、生成PO、Model
        GenerateFileNameModel generateFileNameModel = new GenerateFileNameModel();
        generateBeanFileMain(generateCodeModel, generateFileNameModel);

        // 3、生成dao接口以及mybatis.xml文件

        // 3、生成Convert、Builder、TrackingRequestRecordRepoImpl文件（Convert文件中有代码转换逻辑，Builder文件中有构造查询条件逻辑，repoImpl文件中需要写基础方法）
        // 4、生成无代码逻辑文件（TrackingRequestRecordSvc、TrackingRequestRecordSvcImpl、TrackingRequestRecordRepo、TrackingRequestRecordDao、TrackingRequestRecordValidator）
    }

    /**
     * 生成实体文件主逻辑
     * @param generateCodeModel
     * @param generateFileNameModel
     */
    private void generateBeanFileMain(GenerateCodeModel generateCodeModel, GenerateFileNameModel generateFileNameModel) {
        List<FieldModel> fieldList = generateCodeModel.getFieldList();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                generateBeanFile(generateCodeModel, generateFileNameModel);
            }
        });
    }

    /**
     * 生成实体文件
     * @param generateCodeModel
     * @param generateFileNameModel
     * @return generateFileNameModel
     */
    protected void generateBeanFile(GenerateCodeModel generateCodeModel, GenerateFileNameModel generateFileNameModel) {
        try {
            String fileOutPutPath = generateCodeModel.getFileOutPutPath();
            String packageKeyWords = generateCodeModel.getPackageKeyWords();

            // 1、构建包对应的文件路径
            String entityPckName = getEntityPackageName();
            String entityAllPckFilePath = GenerateCodeUtils.unionManyPckNamFilePath(packageKeyWords, entityPckName);

            // 2、构建输出文件全路径
            String fileAllOutPutPath = GenerateCodeUtils.unionManyStrBySplit(File.separator, fileOutPutPath, entityAllPckFilePath);

            // 3、生成entity文件
            GenerateCodeVo generateEntityCodeVo = buildGenerateEntityCodeVo(fileAllOutPutPath, generateCodeModel);
            commonGenerateFile(generateEntityCodeVo);

            // 4、生成model文件
            /*GenerateCodeVo generateModelCodeVo = buildGenerateModelCodeVo(fileAllOutPutPath, generateCodeModel);
            commonGenerateFile(generateModelCodeVo);*/
        } catch (Exception e) {
            logger.error("generateBeanFile 生成实体文件错误，Exception：", e);
            throw new GcsException(ErrorCode.SYS_CREATE_FREEMARKER_CFG_ERROR, e.getMessage());
        }
    }

    /**
     * 构建entity代码生成VO
     * @param fileAllOutPutPath
     * @param generateCodeModel
     * @return
     */
    protected abstract GenerateCodeVo buildGenerateEntityCodeVo(String fileAllOutPutPath, GenerateCodeModel generateCodeModel);

    /**
     * 构建Model代码生成VO
     * @param fileAllOutPutPath
     * @param generateCodeModel
     * @return
     */
    protected abstract GenerateCodeVo buildGenerateModelCodeVo(String fileAllOutPutPath, GenerateCodeModel generateCodeModel);

    /**
     * 通用生成文件方法
     * @param fileAllOutPutPath
     * @param generateCodeModel
     */
    protected void commonGenerateFile(GenerateCodeVo generateCodeVo) {
        Writer out = null;
        try {
            String generateFileAllPath = generateCodeVo.getGenerateFileAllPath();
            File generateFile = new File(generateFileAllPath);
            // 创建父级目录
            GenerateCodeUtils.createParentDir(generateFile);
            out = new OutputStreamWriter(new FileOutputStream(generateFile));
            String templatePath = generateCodeVo.getTemplatePath();
            Template temp = freeMarkerConfiguration.getTemplate(templatePath);
            temp.process(generateCodeVo, out);
        } catch (Exception e) {
            logger.error("commonGenerateFile 生成文件错误，Exception：", e);
            throw new GcsException(ErrorCode.SYS_CREATE_FREEMARKER_CFG_ERROR, e.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                logger.error("commonGenerateFile 关闭流异常，IOException：", e);
            }
        }
    }

    /**
     * entity模板文件路径
     * @return
     */
    protected String getEntityTemplatePath() {
        return "entityTemplate.ftl";
    }

    /**
     * entity包名
     * @return
     */
    protected String getEntityPackageName() {
        return "entity";
    }

    /**
     * 生成文件Model参数校验
     * 要求：因为这里是公共的抽象类，不管是哪个系统的handler都会先走这里的参数校验。
     * 所以这里只存放公共的参数校验，但是也得留个口子支持不同系统的handler有不同的参数校验
     * todo by 敏鸡
     * @param generateCodeParamModel
     */
    private void validateGenerateCodeByTemplateMain(GenerateCodeModel generateCodeParamModel) {

        /*if(generateCodeParamModel == null){
            throw new GcsException(ErrorCode.PARAM_IS_NOT_EMPTY, "generateCodeParamModel");
        }

        if(StringUtils.isBlank(generateCodeParamModel.getFileKeyWords())){
            throw new GcsException(ErrorCode.PARAM_IS_NOT_EMPTY, "systemName");
        }*/
    }

    /**
     * 通过给定表名称，建立数据库连接，构建数据库字段List
     * @param generateCodeModel
     */
    private void buildGenerateCodeFieldList(GenerateCodeModel generateCodeModel) {
        if(generateCodeModel == null || StringUtils.isBlank(generateCodeModel.getTableName()) ||
                StringUtils.isBlank(generateCodeModel.getSystemName())){
            throw new GcsException(ErrorCode.PARAM_IS_NOT_EMPTY, "generateCodeModel");
        }
        String systemName = generateCodeModel.getSystemName();
        String tableSchema = Constant.SysEnum.getSysTableSchema(systemName);
        List<DBColumnEntity> dbColumnEntityList = dbColumnManager.queryDBColumnListBySchemaAndTabName(tableSchema, systemName);
        List<FieldModel> fieldList = DBColumnToFieldConvert.convertDbColumnsToFieldModelList(dbColumnEntityList);
        generateCodeModel.setFieldList(fieldList);
    }
}
