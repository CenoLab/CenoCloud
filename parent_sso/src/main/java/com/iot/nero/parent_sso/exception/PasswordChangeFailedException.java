package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午5:27
 */
public class PasswordChangeFailedException extends BaseException {
    public PasswordChangeFailedException(String message) {
        super(message);
    }

    public PasswordChangeFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
