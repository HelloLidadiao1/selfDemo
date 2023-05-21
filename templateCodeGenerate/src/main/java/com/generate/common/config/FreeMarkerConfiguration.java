package com.generate.common.config;

import com.generate.common.constant.ErrorCode;
import com.generate.common.exception.GcsException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/21
 */
@Configuration
public class FreeMarkerConfiguration {

    Logger logger = LoggerFactory.getLogger(FreeMarkerConfiguration.class);

    @Bean(name="freeMarkerConfiguration")
    public freemarker.template.Configuration createFreeMarkerConfiguration(FreeMarkerProperties freeMarkerProperties){
        freemarker.template.Configuration freeMarkerCfg = null;
        try {
            freeMarkerCfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_22);
            freeMarkerCfg.setDirectoryForTemplateLoading(new File(freeMarkerProperties.getTemplateDirectory()));
            freeMarkerCfg.setDefaultEncoding(freeMarkerProperties.getCharset());
            freeMarkerCfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            logger.error("createFreeMarkerConfiguration 创建freeMarkerConfiguration错误，IOException：", e);
            throw new GcsException(ErrorCode.SYS_CREATE_FREEMARKER_CFG_ERROR, e.getMessage());
        }
        return freeMarkerCfg;
    }
}
