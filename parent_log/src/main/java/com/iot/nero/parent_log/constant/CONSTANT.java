package com.iot.nero.parent_log.constant;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/27
 * Time   下午1:46
 */
public class CONSTANT {
    /**
     * 日志相关
     */
    public static final  Integer LOG_ERROR = 1;
    public static final  Integer LOG_INFO = 2;
    public static final  Integer LOG_WARNING = 3;
    public static final  Integer LOG_DEBUG = 4;

    public static final Integer LOG_CLIENT_AUTH = 1;
    public static final Integer LOG_CLIENT_ONLINE = 2;
    public static final Integer LOG_CLIENT_MESSAGE = 3;
    public static final Integer LOG_CLIENT_OFFLINE =4;

    public static final  String CLIENT_ONLINE="设备上线";
    public static final  String CLIENT="设备";
    public static final  String NO_DATA_POINT = "没有数据点";
    public static final  String NO_CONDITION_RULE = "没有告警规则";
    public static final  String UN_NORMAL_DATA = "数据异常";
    public static final  String NORMAL_DATA = "数据正常";
    public static final  String MESSAGE_SEND_SUCCESS="消息发送成功";
    public static final  String CLIENT_OFFLINE_SUCCESS="设备下线成功";

    public static final String SYSTEM_LOG_INSERT_TO_DB_FAILED = "系统日志存入数据库失败";

}
