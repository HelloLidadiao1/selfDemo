package com.generate.convert;

import com.generate.entity.DBColumnEntity;
import com.generate.model.FieldModel;

import java.util.List;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/20
 */
public class DBColumnToFieldConvert {

    /**
     * 目的：把查询出来的数据库表的字段信息做一个转换
     * 要求：List<DBColumnEntity> 转换成 List<FieldModel>
     * 注意点：主要是数据库类型转java类型这里，要想想怎么处理。
     * 例如：int-》对应java的int
     * bigint-》对应java的Long
     * varchar对应java的String
     * todo by 敏鸡
     * @param dbColumnEntityList
     * @return
     */
    public static List<FieldModel> convertDbColumnsToFieldModelList(List<DBColumnEntity> dbColumnEntityList) {
        return null;
    }
}
