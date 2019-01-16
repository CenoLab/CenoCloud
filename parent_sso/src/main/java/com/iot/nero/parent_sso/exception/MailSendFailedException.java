package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   上午9:48
 */
public class MailSendFailedException extends BaseException {
    public MailSendFailedException(String message) {
        super(message);
    }

    public MailSendFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
