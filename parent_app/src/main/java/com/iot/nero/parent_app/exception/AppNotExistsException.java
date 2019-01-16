package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午10:01
 */
public class AppNotExistsException extends BaseException {
    public AppNotExistsException(String message) {
        super(message);
    }

    public AppNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
