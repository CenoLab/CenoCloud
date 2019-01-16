package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/19
 * Time   下午7:56
 */
public class NotEmailOrPhoneException extends BaseException {
    public NotEmailOrPhoneException(String message) {
        super(message);
    }

    public NotEmailOrPhoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
