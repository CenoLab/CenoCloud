package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午5:09
 */
public class DeveloperAddsAddFailedException extends BaseException {
    public DeveloperAddsAddFailedException(String message) {
        super(message);
    }

    public DeveloperAddsAddFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
