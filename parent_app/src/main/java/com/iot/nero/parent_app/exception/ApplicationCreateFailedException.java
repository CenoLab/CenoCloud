package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午10:46
 */
public class ApplicationCreateFailedException extends BaseException {
    public ApplicationCreateFailedException(String message) {
        super(message);
    }

    public ApplicationCreateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
