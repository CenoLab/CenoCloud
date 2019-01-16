package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   上午10:21
 */
public class ProductSecretIncorrectException extends BaseException {
    public ProductSecretIncorrectException(String message) {
        super(message);
    }

    public ProductSecretIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }
}
