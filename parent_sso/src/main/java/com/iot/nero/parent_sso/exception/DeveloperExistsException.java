package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午12:38
 */
public class DeveloperExistsException extends BaseException {
    public DeveloperExistsException(String message) {
        super(message);
    }

    public DeveloperExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
