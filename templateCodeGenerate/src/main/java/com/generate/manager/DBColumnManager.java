package com.generate.manager;

import com.generate.entity.DBColumnEntity;

import java.util.List;

/**
 * 数据库表列Manager
 * @Author: hongjie.li
 * @Date: 2023/5/20
 */
public interface DBColumnManager {

    /**
     * 根据库名、表名查询，查询数据库表列集合
     * @param tableSchema
     * @param tableName
     * @return
     */
    List<DBColumnEntity> queryDBColumnListBySchemaAndTabName(String tableSchema, String tableName);
}
