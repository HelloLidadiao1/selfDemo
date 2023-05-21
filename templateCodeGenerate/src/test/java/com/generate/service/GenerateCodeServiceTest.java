package com.generate.service;

import com.generate.GenerateCodeApplication;
import com.generate.handler.common.GenerateCodeHandler;
import com.generate.handler.common.GenerateCodeHandlerFactory;
import com.generate.model.GenerateCodeModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 代码生成Service 单元测试类
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={GenerateCodeApplication.class})
public class GenerateCodeServiceTest{

    @Resource
    private GenerateCodeService generateCodeService;

    private GenerateCodeModel generateCodeModel;

    @Before
    private void buildGenerateCodeModel(){
        generateCodeModel = new GenerateCodeModel();
        generateCodeModel.setFileKeyWords("TrackingRequestRecord");
        generateCodeModel.setFileOutPutPath("D:\\lhjtest");
        generateCodeModel.setSystemName("ECA");
        generateCodeModel.setTableName("eca_ecommerce_tracking_request_record");
        generateCodeModel.setPackageKeyWords("com.lihongjie.test");
    }

    @Test
    public void generateCodeByTemplate() {
        generateCodeService.generateCodeByTemplate(generateCodeModel);
    }
}
