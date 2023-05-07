package com.lihongjie.service.impl;

import com.lihongjie.handler.common.GenerateCodeHandler;
import com.lihongjie.handler.common.GenerateCodeHandlerFactory;
import com.lihongjie.model.GenerateCodeModel;
import com.lihongjie.service.GenerateCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Service("generateCodeService")
public class GenerateCodeServiceImpl implements GenerateCodeService {

    @Resource
    private GenerateCodeHandlerFactory generateCodeHandlerFactory;

    @Override
    public void generateCodeByTemplate(GenerateCodeModel generateCodeModel) {
        GenerateCodeHandler handler = generateCodeHandlerFactory.getHandler(generateCodeModel.getSystemName());
        handler.generateCodeByTemplateMain(generateCodeModel);
    }
}
