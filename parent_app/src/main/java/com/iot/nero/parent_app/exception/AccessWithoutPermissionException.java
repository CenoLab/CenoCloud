package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午10:04
 */
public class AccessWithoutPermissionException extends BaseException {
    public AccessWithoutPermissionException(String message) {
        super(message);
    }

    public AccessWithoutPermissionException(String message, Throwable cause) {
        super(message, cause);
    }
}
