package com.generate.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据库表列entity
 * @Author: hongjie.li
 * @Date: 2023/5/20
 */
@Data
public class DBColumnEntity implements Serializable {

    private static final long serialVersionUID = 5076247677582915567L;

    /**
     * 数据库库名，如：eca
     */
    private String tableSchema;

    /**
     * 数据库表名，如：eca_ecommerce_tracking_request_record
     */
    private String tableName;

    /**
     * 数据库列名，如：ID
     */
    private String columnName;

    /**
     * 数据库列数据类型，如：bigint
     */
    private String dataType;

    /**
     * 数据库列类型，如：bigint(20)
     */
    private String columnType;

    /**
     * 数据库备注，如：主键ID
     */
    private String columnComment;
}
