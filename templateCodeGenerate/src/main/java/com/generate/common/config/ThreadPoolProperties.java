package com.generate.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * FreeMarker Properties
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@ConfigurationProperties("threadpool")
@Data
public class ThreadPoolProperties {
    /**
     * 核心线程数
     */
    private int corePoolSize;

    /**
     * 最大线程数
     */
    private int maximumPoolSize;

    /**
     * 非核心线程存活时间（单位：s）
     */
    private int keepAliveTime;

    /**
     * 阻塞队列长度
     */
    private int blockQueueSize;
}
