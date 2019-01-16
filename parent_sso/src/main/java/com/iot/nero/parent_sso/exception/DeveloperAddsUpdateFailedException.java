package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午5:09
 */
public class DeveloperAddsUpdateFailedException extends BaseException {
    public DeveloperAddsUpdateFailedException(String message) {
        super(message);
    }

    public DeveloperAddsUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
