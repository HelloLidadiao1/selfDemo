package com.generate.handler.common;

import com.generate.common.constant.Constant;
import com.generate.common.constant.ErrorCode;
import com.generate.common.exception.GcsException;
import com.generate.convert.DBColumnToFieldConvert;
import com.generate.entity.DBColumnEntity;
import com.generate.manager.DBColumnManager;
import com.generate.model.FieldModel;
import com.generate.model.GenerateCodeModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
public abstract class AbstractGenerateCodeHandler implements GenerateCodeHandler {

    @Resource
    private DBColumnManager dbColumnManager;

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
        //generateEntityFile(generateCodeModel);

        // 3、生成dao接口以及mybatis.xml文件

        // 3、生成Convert、Builder、TrackingRequestRecordRepoImpl文件（Convert文件中有代码转换逻辑，Builder文件中有构造查询条件逻辑，repoImpl文件中需要写基础方法）
        // 4、生成无代码逻辑文件（TrackingRequestRecordSvc、TrackingRequestRecordSvcImpl、TrackingRequestRecordRepo、TrackingRequestRecordDao、TrackingRequestRecordValidator）
    }

    /**
     * 生成文件Model参数校验
     * 要求：因为这里是公共的抽象类，不管是哪个系统的handler都会先走这里的参数校验。
     * 所以这里只存放公共的参数校验，但是也得留个口子支持不同系统的handler有不同的参数校验
     * todo by 敏鸡
     * @param generateCodeParamModel
     */
    private void validateGenerateCodeByTemplateMain(GenerateCodeModel generateCodeParamModel) {

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
