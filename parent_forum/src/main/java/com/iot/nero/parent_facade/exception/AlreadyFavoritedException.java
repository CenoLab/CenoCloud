package com.iot.nero.parent_facade.exception;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   上午9:22
 */
public class AlreadyFavoritedException extends Exception {
    public AlreadyFavoritedException() {
    }

    public AlreadyFavoritedException(String message) {
        super(message);
    }
}
