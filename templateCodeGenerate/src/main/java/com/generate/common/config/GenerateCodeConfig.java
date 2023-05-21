package com.generate.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 生成文件配置
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@ConfigurationProperties("generateCode.config")
@Data
public class GenerateCodeConfig {
    /**
     * 文件名称
     */
    private String fileKeyWords;

    /**
     * 包名称
     */
    private String packageKeyWords;

    /**
     * 表名称
     */
    private String tableName;
}
