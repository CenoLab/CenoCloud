package com.iot.nero.exception;

import com.iot.nero.CONSTANT;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午4:21
 */
public class BaseException extends Exception {
    public BaseException(String message) {
        super(CONSTANT.IOT_PLATFORM+" Exception:"+message);
    }

    public BaseException(String message, Throwable cause) {
        super(CONSTANT.IOT_PLATFORM+" Exception:"+message, cause);
    }
}
