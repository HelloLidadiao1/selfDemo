package com.generate.service.impl;

import com.generate.handler.common.GenerateCodeHandler;
import com.generate.handler.common.GenerateCodeHandlerFactory;
import com.generate.model.GenerateCodeModel;
import com.generate.service.GenerateCodeService;
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
