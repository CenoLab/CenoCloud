package com.iot.nero.facade_alarm.dao;

import com.iot.nero.parent_alarm.dto.ConditionFinal;
import com.iot.nero.parent_alarm.entity.Condition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/21
 * Time   下午4:13
 */
public interface ConditionDao {



    /**
     * 通过数据点获取告警条件
     * @param dataPointId
     * @return
     */
    List<Condition> getConditionsByDataPointId(@Param("did") Integer dataPointId);

    /**
     * 添加告警条件
     * @param dataPointID
     * @param Index
     * @param expressId
     * @param rightType
     * @param right
     * @return
     */
    Integer insertCondition(
            @Param("did") Integer dataPointID,
            @Param("index") Integer Index,
            @Param("eid") Integer expressId,
            @Param("rt") Integer rightType,
            @Param("rv") String right);

}
