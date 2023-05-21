package com.generate.dao;

import com.generate.entity.DBColumnEntity;

import java.util.List;

/**
 * 数据库表columnsDao
 * @Author: hongjie.li
 * @Date: 2023/5/20
 */
public interface DBColumnDao {

    /**
     * 查询List集合
     * @param dbColumnEntity
     * @return
     */
    List<DBColumnEntity> queryDBColumnList(DBColumnEntity dbColumnEntity);
}
