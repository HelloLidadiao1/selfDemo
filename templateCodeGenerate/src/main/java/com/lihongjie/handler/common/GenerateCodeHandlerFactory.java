package com.lihongjie.handler.common;

import com.lihongjie.constant.ErrorCode;
import com.lihongjie.exception.MyException;
import com.lihongjie.handler.EcaGenerateCodeHandler;
import com.lihongjie.handler.common.GenerateCodeHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Component
public class GenerateCodeHandlerFactory implements ApplicationContextAware {

    private static Map<String, GenerateCodeHandler> sysHandlerMap = new HashMap<>();

    private GenerateCodeHandlerFactory(){}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, GenerateCodeHandler> generateCodeHandlerMap = applicationContext.getBeansOfType(GenerateCodeHandler.class);
        generateCodeHandlerMap.values().forEach(handler->sysHandlerMap.put(handler.getSystemName(), handler));
    }

    /**
     * 获取handler
     * @param systemName
     * @return
     */
    public GenerateCodeHandler getHandler(String systemName){
        if(StringUtils.isBlank(systemName)){
            throw new MyException(ErrorCode.PARAM_IS_NOT_EMPTY, "systemName");
        }
        GenerateCodeHandler generateCodeHandler = this.sysHandlerMap.get(systemName);
        if(generateCodeHandler == null){
            throw new MyException(ErrorCode.SYS_HANDLER_IS_NOT_EXIST, "systemName");
        }
        return generateCodeHandler;
    }
}
