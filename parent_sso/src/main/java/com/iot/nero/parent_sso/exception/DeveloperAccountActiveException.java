package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

public class DeveloperAccountActiveException extends BaseException {
    public DeveloperAccountActiveException(String message) {
        super(message);
    }

    public DeveloperAccountActiveException(String message, Throwable cause) {
        super(message, cause);
    }
}
