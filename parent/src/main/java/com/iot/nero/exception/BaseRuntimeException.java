package com.iot.nero.exception;

import com.iot.nero.CONSTANT;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午10:35
 */
public class BaseRuntimeException extends RuntimeException {

    public BaseRuntimeException() {
    }

    public BaseRuntimeException(String message) {
        super(CONSTANT.IOT_PLATFORM +" exception: "+ message);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(CONSTANT.IOT_PLATFORM +" exception: "+ message, cause);
    }
}
