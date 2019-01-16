package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/6
 * Time   下午4:59
 */
public class RechargeFailedException extends BaseException {
    public RechargeFailedException(String message) {
        super(message);
    }

    public RechargeFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
