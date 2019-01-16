package com.iot.nero.parent_alarm.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/4
 * Time   下午10:06
 */
public class OperatorNotFoundException extends BaseException {
    public OperatorNotFoundException(String message) {
        super(message);
    }

    public OperatorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
