package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   下午1:21
 */
public class DataPointNotExistsException extends BaseException {
    public DataPointNotExistsException(String message) {
        super(message);
    }

    public DataPointNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
