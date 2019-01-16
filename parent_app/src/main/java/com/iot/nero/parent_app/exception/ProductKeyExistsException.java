package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;
import com.iot.nero.exception.BaseRuntimeException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午10:33
 */
public class ProductKeyExistsException extends BaseException {
    public ProductKeyExistsException(String message) {
        super(message);
    }

    public ProductKeyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
