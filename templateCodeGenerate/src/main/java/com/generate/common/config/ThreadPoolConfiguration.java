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
import java.util.concurrent.*;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/21
 */
@Configuration
public class ThreadPoolConfiguration {

    Logger logger = LoggerFactory.getLogger(ThreadPoolConfiguration.class);

    @Bean(name="threadPool")
    public ExecutorService createThreadPool(ThreadPoolProperties threadPoolProperties){
        Executors.newCachedThreadPool();
        ExecutorService threadPool = new ThreadPoolExecutor(threadPoolProperties.getCorePoolSize(),
                threadPoolProperties.getMaximumPoolSize(),
                threadPoolProperties.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(threadPoolProperties.getBlockQueueSize()),
                new ThreadPoolExecutor.AbortPolicy());
        return threadPool;
    }
}
