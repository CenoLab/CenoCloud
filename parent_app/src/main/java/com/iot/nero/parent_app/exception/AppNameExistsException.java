package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   上午11:37
 */
public class AppNameExistsException extends BaseException{
    public AppNameExistsException(String message) {
        super(message);
    }

    public AppNameExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
