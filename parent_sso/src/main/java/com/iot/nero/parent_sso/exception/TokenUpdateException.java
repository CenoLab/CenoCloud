package com.iot.nero.parent_sso.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午9:31
 */
public class TokenUpdateException extends BaseException {
    public TokenUpdateException(String message) {
        super(message);
    }

    public TokenUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
