package com.lihongjie.handler;

import com.lihongjie.constant.EnumConstant;
import com.lihongjie.handler.common.GenerateCodeHandler;
import com.lihongjie.model.GenerateCodeModel;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
public class EcaGenerateCodeHandler implements GenerateCodeHandler {

    /**
     * 获取系统名称
     * @return
     */
    public String getSystemName(){
        return EnumConstant.SystemName.ECA;
    }

    /**
     * 通过模板生成代码
     * @param generateCodeModel
     */
    public void generateCodeByTemplateMain(GenerateCodeModel generateCodeModel){
        //
    }
}
