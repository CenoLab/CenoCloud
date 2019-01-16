package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

public class DeveloperEmailUpdateFailedException extends BaseException {
    public DeveloperEmailUpdateFailedException(String message) {
        super(message);
    }

    public DeveloperEmailUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
