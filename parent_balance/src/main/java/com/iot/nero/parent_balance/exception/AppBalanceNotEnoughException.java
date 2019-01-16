package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   下午12:24
 */
public class AppBalanceNotEnoughException extends BaseException {
    public AppBalanceNotEnoughException(String message) {
        super(message);
    }

    public AppBalanceNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }
}
