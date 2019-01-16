package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/6
 * Time   下午3:40
 */
public class ConsumeFailedException extends BaseException {
    public ConsumeFailedException(String message) {
        super(message);
    }

    public ConsumeFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
