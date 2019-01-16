package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/10
 * Time   下午8:27
 */
public class DataPointDeleteFailedException extends BaseException {
    public DataPointDeleteFailedException(String message) {
        super(message);
    }

    public DataPointDeleteFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
