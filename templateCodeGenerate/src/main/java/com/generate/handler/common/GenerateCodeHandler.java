package com.generate.handler.common;

import com.generate.model.GenerateCodeModel;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
public interface GenerateCodeHandler {
    /**
     * 获取系统名称
     * @return
     */
    String getSystemName();

    /**
     * 通过模板生成代码
     * @param generateCodeModel
     */
    void generateCodeByTemplateMain(GenerateCodeModel generateCodeModel);
}
