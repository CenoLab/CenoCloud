package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/6
 * Time   上午11:34
 */
public class BalanceNotFoundException extends BaseException {
    public BalanceNotFoundException(String message) {
        super(message);
    }

    public BalanceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
