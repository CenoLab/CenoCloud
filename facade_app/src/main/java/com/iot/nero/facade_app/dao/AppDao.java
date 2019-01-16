package com.iot.nero.facade_app.dao;


import com.iot.nero.parent_app.dto.ApplicationResult;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.parent_app.entity.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午9:36
 */
public interface AppDao {

    /**
     * 根据developID 查询App
     * @param uid
     * @return
     */
    List<ApplicationResult> findAppByUid(@Param("uid") Integer uid);

    /**
     * 根据findAppByProductKey查询app
     * @param key
     * @return
     */
    Application findAppByProductKey(@Param("key") String key);


    /**
     * 根据名称查
     * @param name
     * @return
     */
    Application findAppByName(@Param("name") String name);

    /**
     * 根据id查询application
     * @param id
     * @return
     */
    Application findAppById(@Param("id") Integer id);


    /**
     * 根据product key查询key，secret对
     * @param key
     * @return
     */
    KeySecret findKeySecretByKey(@Param("key") String key);



    Integer createApplication(@Param("did") Integer DId,
                              @Param("name") String name,
                              @Param("type") String type,
                              @Param("tech") String tech,
                              @Param("trans") Integer trans,
                              @Param("company") String company,
                              @Param("productKey") String productKey,
                              @Param("productSecret") String productSecret,
                              @Param("maxConnect") Integer maxConnect,
                              @Param("desc") String desc);

    /**
     * 查重
     * @param name
     * @param dId
     * @return
     */
    Application findAppByNameAndDeveloperID(@Param("name") String name,@Param("did") Integer dId);
}
