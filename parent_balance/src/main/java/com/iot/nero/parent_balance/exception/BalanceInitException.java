package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

public class BalanceInitException extends BaseException {
    public BalanceInitException(String message) {
        super(message);
    }

    public BalanceInitException(String message, Throwable cause) {
        super(message, cause);
    }
}
