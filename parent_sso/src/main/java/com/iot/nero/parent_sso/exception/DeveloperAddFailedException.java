package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午1:43
 */
public class DeveloperAddFailedException extends BaseException {
    public DeveloperAddFailedException(String message) {
        super(message);
    }

    public DeveloperAddFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
