package com.lihongjie.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Data
public class GenerateCodeModel {
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

    /**
     * 系统类型
     */
    private String systemName;

    /**
     * 表字段名称集合
     */
    private List<FieldModel> fieldList;

    public GenerateCodeModel() {
    }

    public GenerateCodeModel(String fileKeyWords, String packageKeyWords, String tableName, String systemType) {
        this.fileKeyWords = fileKeyWords;
        this.packageKeyWords = packageKeyWords;
        this.tableName = tableName;
        this.systemName = systemType;
    }
}