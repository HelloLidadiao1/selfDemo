package com.lihongjie.exception;

import lombok.Data;

import java.sql.ParameterMetaData;
import java.text.MessageFormat;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Data
public class MyException extends RuntimeException{
    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    public MyException() {
    }

    public MyException(String errorMsg) {
        super(errorMsg);
    }

    /*public MyException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }*/

    public MyException(String errorMsg, Object... params) {
        this.errorMsg = MessageFormat.format(errorMsg, params);
    }
}
