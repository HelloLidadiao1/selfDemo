package com.generate.handler;

import com.generate.common.constant.Constant;
import com.generate.common.constant.EnumConstant;
import com.generate.handler.common.AbstractGenerateCodeHandler;
import com.generate.model.GenerateCodeModel;
import com.generate.vo.GenerateCodeVo;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Component("ecaGenerateCodeHandler")
public class EcaGenerateCodeHandler extends AbstractGenerateCodeHandler {

    /**
     * 获取系统名称
     * @return
     */
    public String getSystemName(){
        return EnumConstant.SystemName.ECA;
    }

    @Override
    protected GenerateCodeVo buildGenerateEntityCodeVo(String fileAllOutPutPath, GenerateCodeModel generateCodeModel) {
        String fileKeyWords = generateCodeModel.getFileKeyWords();
        String className = fileKeyWords + "Entity";
        String generateFileAllPath = fileAllOutPutPath + File.separator + className + Constant.FileTypeEnum.JAVA.getFileSuffix();
        String entityTemplatePath = getEntityTemplatePath();
        GenerateCodeVo generateCodeVo = new GenerateCodeVo();
        generateCodeVo.setClassName(className);
        generateCodeVo.setGenerateFileAllPath(generateFileAllPath);
        generateCodeVo.setTemplatePath(entityTemplatePath);
        generateCodeVo.setFieldList(generateCodeModel.getFieldList());
        return generateCodeVo;
    }

    @Override
    protected GenerateCodeVo buildGenerateModelCodeVo(String fileAllOutPutPath, GenerateCodeModel generateCodeModel) {
        String fileKeyWords = generateCodeModel.getFileKeyWords();
        String className = fileKeyWords + "Model";
        String generateFileAllPath = fileAllOutPutPath + File.separator + className + Constant.FileTypeEnum.JAVA.getFileSuffix();
        String entityTemplatePath = getEntityTemplatePath();
        GenerateCodeVo generateCodeVo = new GenerateCodeVo();
        generateCodeVo.setClassName(className);
        generateCodeVo.setGenerateFileAllPath(generateFileAllPath);
        generateCodeVo.setTemplatePath(entityTemplatePath);
        generateCodeVo.setFieldList(generateCodeModel.getFieldList());
        return generateCodeVo;
    }
}
