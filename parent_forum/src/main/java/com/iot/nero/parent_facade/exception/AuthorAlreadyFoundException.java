package com.iot.nero.parent_facade.exception;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/22
 * Time   下午3:00
 */
public class AuthorAlreadyFoundException extends Exception {
    public AuthorAlreadyFoundException() {
    }

    public AuthorAlreadyFoundException(String message) {
        super(message);
    }
}
