package com.generate.service;

import com.generate.model.GenerateCodeModel;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
public interface GenerateCodeService {

    /**
     * 读取模板生成代码
     * @param generateCodeModel
     */
    void generateCodeByTemplate(GenerateCodeModel generateCodeModel);
}
