package com.iot.nero.facade_app.dao;


import com.iot.nero.parent_app.entity.DataPoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   上午9:52
 */
public interface DataPointDao {


    /**
     * 获取数据点
     * @param appId
     * @return
     */
    List<DataPoint> getDataPoint(@Param("appid") Integer appId);

    /**
     * 获取数据点
     * @param name
     * @return
     */
    DataPoint getDataPointByName(@Param("name") String name);


    /**
     * 查询应用下的数据点
     * @param name
     * @param aid
     * @return
     */
    DataPoint getDataPointByNameAndAid(@Param("name") String name,
                                       @Param("id") Integer aid);
    /**
     * 添加数据点
     * @param pointName 数据点名称
     * @param pointType 数据点类型
     * @param access 只读或只写
     * @return
     */
    Integer addDataPoint(@Param("id") Integer appId,
            @Param("name") String pointName,
            @Param("type") String pointType,
            @Param("access") Integer access);

    /**
     * 删除数据点
     * @param pointId 数据点Id
     * @return
     */
    Integer delDataPoint(@Param("id") Integer pointId);

    /**
     * 通过id获取数据点
     * @param pid
     * @return
     */
    DataPoint getDataPointById(@Param("pid") Integer pid);
}
