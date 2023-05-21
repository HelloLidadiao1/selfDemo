package com.generate.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 生成的文件名记录Model
 * @Author: hongjie.li
 * @Date: 2023/5/20
 */
@Data
public class GenerateFileNameModel implements Serializable {

    private static final long serialVersionUID = 339889428877758869L;

    /**
     * PO文件名
     */
    private String poFileName;

    /**
     * Model文件名
     */
    private String modelFileName;

    /**
     * mapper.xml文件名
     */
    private String mapperXmlFileName;

    /**
     * Dao文件名
     */
    private String daoFileName;

    /**
     * repo文件名
     */
    private String repoName;

    /**
     * repoImpl文件名
     */
    private String repoImplFileName;

    /**
     * svc文件名
     */
    private String svcFileName;

    /**
     * svcImpl文件名
     */
    private String svcImplFileName;

    /**
     * Dao文件名
     */
    private String serviceFileName;

    /**
     * serviceImpl文件名
     */
    private String serviceImplFileName;

    /**
     * Convert文件名
     */
    private String convertFileName;

    /**
     * Builder文件名
     */
    private String builderFileName;

    /**
     * validate文件名
     */
    private String validateFileName;
}
