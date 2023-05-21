package com.generate.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Data
public class GenerateCodeModel extends BaseModel {

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
     * 生成文件输出路径
     */
    private String fileOutPutPath;

    /**
     * 表字段名称集合
     */
    private List<FieldModel> fieldList;

    /**
     * 生成文件名Model
     */
    private GenerateFileNameModel generateFileNameModel;

    public GenerateCodeModel() {
    }

    public GenerateCodeModel(String fileKeyWords, String packageKeyWords, String tableName, String systemType) {
        this.fileKeyWords = fileKeyWords;
        this.packageKeyWords = packageKeyWords;
        this.tableName = tableName;
        this.systemName = systemType;
    }
}