package com.generate.manager.impl;

import com.generate.dao.DBColumnDao;
import com.generate.entity.DBColumnEntity;
import com.generate.manager.DBColumnManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据库表列Manager
 * @Author: hongjie.li
 * @Date: 2023/5/20
 */
@Service("dBColumnManager")
public class DBColumnManagerImpl implements DBColumnManager {

    @Resource
    private DBColumnDao dBColumnDao;

    @Override
    public List<DBColumnEntity> queryDBColumnListBySchemaAndTabName(String tableSchema, String tableName) {
        if(StringUtils.isBlank(tableSchema) || StringUtils.isBlank(tableName)){
            return null;
        }
        DBColumnEntity dbColumnEntity = new DBColumnEntity();
        dbColumnEntity.setTableSchema(tableSchema);
        dbColumnEntity.setTableName(tableName);
        List<DBColumnEntity> dbColumnEntityList = dBColumnDao.queryDBColumnList(dbColumnEntity);
        return dbColumnEntityList;
    }
}
