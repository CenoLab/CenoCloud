package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/9
 * Time   下午4:49
 */
public class ConnDecreaseFailedException extends BaseException {
    public ConnDecreaseFailedException(String message) {
        super(message);
    }

    public ConnDecreaseFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
