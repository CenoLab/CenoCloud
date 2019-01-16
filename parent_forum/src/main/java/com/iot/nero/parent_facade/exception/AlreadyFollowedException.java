package com.iot.nero.parent_facade.exception;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   上午8:57
 */
public class AlreadyFollowedException extends Exception {
    public AlreadyFollowedException() {
    }

    public AlreadyFollowedException(String message) {
        super(message);
    }
}
