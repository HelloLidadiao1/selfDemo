package com.generate.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * FreeMarker Properties
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@ConfigurationProperties("freemarker")
@Data
public class FreeMarkerProperties {
    /**
     * 模板加载路径
     */
    private String templateDirectory;

    /**
     * 字符编码
     */
    private String charset;
}
