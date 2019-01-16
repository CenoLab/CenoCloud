package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午5:24
 */
public class DeveloperNameChangeFailedException extends BaseException {
    public DeveloperNameChangeFailedException(String message) {
        super(message);
    }

    public DeveloperNameChangeFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
