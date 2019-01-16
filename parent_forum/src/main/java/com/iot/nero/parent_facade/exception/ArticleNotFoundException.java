package com.iot.nero.parent_facade.exception;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/24
 * Time   下午1:53
 */
public class ArticleNotFoundException extends Exception {
    public ArticleNotFoundException() {
    }

    public ArticleNotFoundException(String message) {
        super(message);
    }
}
