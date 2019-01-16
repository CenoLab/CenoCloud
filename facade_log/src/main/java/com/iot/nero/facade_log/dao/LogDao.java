package com.iot.nero.facade_log.dao;

import com.iot.nero.parent_log.entity.ClientLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/26
 * Time   上午10:16
 */
public interface LogDao {

    Integer insertClientLog(@Param("key") String productKey,
                            @Param("type") Integer type,
                            @Param("level") Integer level,
                            @Param("message") String message);

    Integer createClientLogTable(@Param("key") String productKey);


    List<ClientLog> getClientLog(@Param("key") String productKey,
                                 @Param("type") Integer type,
                                 @Param("level") Integer level,
                                 @Param("page") Integer page,
                                 @Param("num") Integer num);

    Integer getCount(@Param("key") String productKey,
                     @Param("type") Integer type,
                     @Param("level") Integer level);

    Integer insertSysLog(@Param("type") Long type,
                         @Param("content") String content);
}
