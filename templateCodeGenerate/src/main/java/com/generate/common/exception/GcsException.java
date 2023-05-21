package com.generate.common.exception;

import lombok.Data;

import java.text.MessageFormat;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Data
public class GcsException extends RuntimeException{
    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    public GcsException() {
    }

    public GcsException(String errorMsg) {
        super(errorMsg);
    }

    /*public MyException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }*/

    public GcsException(String errorMsg, Object... params) {
        this.errorMsg = MessageFormat.format(errorMsg, params);
    }
}
