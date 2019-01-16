package com.iot.nero.parent_app.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   上午10:22
 */
public class MessageSaveException extends BaseException {
    public MessageSaveException(String message) {
        super(message);
    }

    public MessageSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
