package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   上午10:15
 */
public class ClientNotInConnListException extends BaseException {
    public ClientNotInConnListException(String message) {
        super(message);
    }

    public ClientNotInConnListException(String message, Throwable cause) {
        super(message, cause);
    }
}
