package com.iot.nero.parent_alarm.exception;

import com.iot.nero.exception.BaseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/26
 * Time   下午7:19
 */
public class AlarmLogCreateFailedException extends BaseException
{
    public AlarmLogCreateFailedException(String message) {
        super(message);
    }

    public AlarmLogCreateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
