package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

public class VerifyCodeException extends BaseException{
    public VerifyCodeException(String message) {
        super(message);
    }

    public VerifyCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
