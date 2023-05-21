package com.generate.model;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lihongjie
 * @date 2023/5/4
 */
public class FieldModel extends BaseModel{
    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性数据库类型
     */
    private String dbType;

    /**
     * 属性java类型
     */
    private String javaType;

    /**
     * 属性首字母大写
     */
    private String upperName;

    /**
     * 字段注释
     */
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getUpperName() {
        if(StringUtils.isBlank(name)){
            return name;
        }
        return this.name.substring(0,1).toUpperCase() + this.name.substring(1);
    }

    public void setUpperName(String upperName) {
        this.upperName = upperName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
