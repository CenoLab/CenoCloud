package com.iot.nero.facade_alarm.dao;

import com.iot.nero.parent_alarm.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/21
 * Time   下午4:14
 */
public interface AlarmLogDao {

    /**
     * 插入告警日志
     * @param messageId
     * @param conditionID
     * @return
     */
    Integer insertAlarmLog(
                            @Param("aid") Integer appId,
                            @Param("did") Integer dataPointId,
                            @Param("mid") Integer messageId,
                            @Param("cid") Integer conditionID);

    /**
     * 创建告警日志表
     * @param appId
     * @return
     */
    Integer createAlarmLogTable(@Param("aid") Integer appId);

    /**
     * 分页获取数据点告警日志
     * @param dataPointId
     * @param from
     * @param num
     * @return
     */
    List<Log> getAlarmLogByDataPointId(
            @Param("aid") Integer appId,
            @Param("did") Integer dataPointId,
            @Param("from") Integer from,
            @Param("num") Integer num);

    /**
     * 通过数据点id和时间获取告警日志
     * @param dataPointId
     * @param fromPage
     * @param num
     * @param from
     * @param to
     * @return
     */
    List<Log> getAlarmLogByDataPointIdAndTimeStamp(
            @Param("aid") Integer appId,
            @Param("did") Integer dataPointId,
            @Param("page") Integer fromPage,
            @Param("num") Integer num,
            @Param("start") Long from,
            @Param("to") Long to);

}
