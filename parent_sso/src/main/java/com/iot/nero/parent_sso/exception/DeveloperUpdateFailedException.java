package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午1:44
 */
public class DeveloperUpdateFailedException extends BaseException {
    public DeveloperUpdateFailedException(String message) {
        super(message);
    }

    public DeveloperUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
