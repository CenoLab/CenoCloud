package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午5:00
 */
public class DeveloperAddNotFoundException extends BaseException {
    public DeveloperAddNotFoundException(String message) {
        super(message);
    }

    public DeveloperAddNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
