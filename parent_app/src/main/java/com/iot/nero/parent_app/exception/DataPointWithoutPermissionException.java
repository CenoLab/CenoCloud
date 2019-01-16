package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/10
 * Time   下午8:26
 */
public class DataPointWithoutPermissionException extends BaseException {
    public DataPointWithoutPermissionException(String message) {
        super(message);
    }

    public DataPointWithoutPermissionException(String message, Throwable cause) {
        super(message, cause);
    }
}
