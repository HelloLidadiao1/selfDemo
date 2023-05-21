package com.generate.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
public class Constant {

    /**
     * 系统枚举
     */
    public enum SysEnum {
        ECA("ECA", "ECA");

        /**
         * 系统名称
         */
        private String sysName;

        /**
         * 系统对应数据库
         */
        private String tableSchema;

        SysEnum(String sysName, String tableSchema) {
            this.sysName = sysName;
            this.tableSchema = tableSchema;
        }

        public static String getSysTableSchema(String sysName){
            if(StringUtils.isBlank(sysName)){
                return null;
            }
            for (SysEnum sysEnum : values()) {
                if(sysEnum.getSysName().equalsIgnoreCase(sysName)){
                    return sysEnum.getTableSchema();
                }
            }
            return null;
        }

        public String getSysName() {
            return sysName;
        }

        public String getTableSchema() {
            return tableSchema;
        }
    }
}
