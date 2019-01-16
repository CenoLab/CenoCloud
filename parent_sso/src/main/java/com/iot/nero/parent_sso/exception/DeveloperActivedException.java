package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午1:25
 */
public class DeveloperActivedException extends BaseException {
    public DeveloperActivedException(String message) {
        super(message);
    }

    public DeveloperActivedException(String message, Throwable cause) {
        super(message, cause);
    }
}
