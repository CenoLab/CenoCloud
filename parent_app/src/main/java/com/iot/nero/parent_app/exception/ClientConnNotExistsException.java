package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/4
 * Time   上午10:27
 */
public class ClientConnNotExistsException extends BaseException {
    public ClientConnNotExistsException(String message) {
        super(message);
    }

    public ClientConnNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
