package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   下午12:58
 */
public class AppMaxConnLimitException extends BaseException {
    public AppMaxConnLimitException(String message) {
        super(message);
    }

    public AppMaxConnLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}
