package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/6
 * Time   下午1:08
 */
public class MoneyNotEnoughException extends BaseException {
    public MoneyNotEnoughException(String message) {
        super(message);
    }

    public MoneyNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }
}
