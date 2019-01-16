package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   下午1:16
 */
public class DataPointExistsException extends BaseException {
    public DataPointExistsException(String message) {
        super(message);
    }

    public DataPointExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
