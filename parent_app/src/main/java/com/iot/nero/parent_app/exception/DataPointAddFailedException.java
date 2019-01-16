package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   下午1:03
 */
public class DataPointAddFailedException extends BaseException{
    public DataPointAddFailedException(String message) {
        super(message);
    }

    public DataPointAddFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
