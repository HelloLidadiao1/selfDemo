package com.generate.handler;

import com.generate.common.constant.EnumConstant;
import com.generate.handler.common.AbstractGenerateCodeHandler;
import com.generate.model.GenerateCodeModel;
import org.springframework.stereotype.Component;

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

    /**
     * 通过模板生成代码
     * @param generateCodeModel
     */
    public void generateCodeByTemplate(GenerateCodeModel generateCodeModel){
        //
    }
}
