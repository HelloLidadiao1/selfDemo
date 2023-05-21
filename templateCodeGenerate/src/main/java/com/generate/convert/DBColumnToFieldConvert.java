package com.generate.convert;

import com.generate.entity.DBColumnEntity;
import com.generate.model.FieldModel;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
     * @param dbColumnEntityList
     * @return
     */
    public static List<FieldModel> convertDbColumnsToFieldModelList(List<DBColumnEntity> dbColumnEntityList) {
        List<FieldModel> fieldModelList = new ArrayList<>();

        for (DBColumnEntity dbColumnEntity : dbColumnEntityList) {
            FieldModel fieldModel = new FieldModel();
            // 将数据库列类型映射为对应的Java类型
            String dbColumnType = dbColumnEntity.getColumnType();
            String javaType = mapDbColumnTypeToJavaType(dbColumnType);
            fieldModel.setJavaType(javaType);
            fieldModel.setComment(dbColumnEntity.getColumnComment());
            fieldModel.setDbType(dbColumnType);
            fieldModel.setDbName(dbColumnEntity.getColumnName());
            // todo by 敏鸡 需要把 columnName 转驼峰然后设置到 name字段上
            //fieldModel.setName();
            fieldModelList.add(fieldModel);
        }

        return fieldModelList;
    }

    /**
     * 字段数据库类型转java类型
     * @param dbColumnType
     * @return
     */
    private static String mapDbColumnTypeToJavaType(String dbColumnType) {
        if(StringUtils.isBlank(dbColumnType)){
            return null;
        }
        String javaType;

        // 根据数据库列类型进行映射
        // todo by 敏鸡 常用类型补齐
        dbColumnType = dbColumnType.toUpperCase();
        switch (dbColumnType) {
            case "VARCHAR":
                javaType = "String";
                break;
            case "INT":
                javaType = "int";
                break;
            case "BIGINT":
                javaType = "long";
                break;
            case "DECIMAL":
                javaType = "BigDecimal";
                break;
            // 添加其他数据库列类型的映射关系
            default:
                javaType = "Object";
                break;
        }

        return javaType;
    }
}
