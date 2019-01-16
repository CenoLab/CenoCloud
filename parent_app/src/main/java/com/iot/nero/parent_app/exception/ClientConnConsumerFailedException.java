package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   上午10:01
 */
public class ClientConnConsumerFailedException extends BaseException {
    public ClientConnConsumerFailedException(String message) {
        super(message);
    }

    public ClientConnConsumerFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
