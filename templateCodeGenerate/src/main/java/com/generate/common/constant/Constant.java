package com.generate.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
public class Constant {

    public static class Charator{
        public static final String dot = ".";
    }

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

    /**
     * 文件类型枚举
     */
    public enum FileTypeEnum {
        JAVA("java", "JAVA文件");

        /**
         * 系统名称
         */
        private String val;

        /**
         * 系统对应数据库
         */
        private String msg;

        FileTypeEnum(String val, String msg) {
            this.val = val;
            this.msg = msg;
        }

        public String getFileSuffix(){
            return Charator.dot + this.val.toLowerCase();
        }

        public String getVal() {
            return val;
        }

        public String getMsg() {
            return msg;
        }
    }
}
