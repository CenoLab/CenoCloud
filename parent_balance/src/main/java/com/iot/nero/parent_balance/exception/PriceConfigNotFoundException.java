package com.iot.nero.parent_balance.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/6
 * Time   下午3:21
 */
public class PriceConfigNotFoundException extends BaseException {
    public PriceConfigNotFoundException(String message) {
        super(message);
    }

    public PriceConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
