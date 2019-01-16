package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/27
 * Time   下午7:46
 */
public class AppAuthFailedException extends BaseException {
    public AppAuthFailedException(String message) {
        super(message);
    }

    public AppAuthFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
