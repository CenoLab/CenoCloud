package com.iot.nero.facade_app.dao;

import com.iot.nero.parent_app.entity.ClientConn;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   上午11:07
 */
public interface ClientDao {
    /**
     * 查找客户端
     * @param clientPoolTableName
     * @param clientID
     * @return
     */
    ClientConn findClientById(
            @Param("table") String clientPoolTableName,
            @Param("clientId") String clientID);

    /**
     *  客户端上限
     * @param clientPoolTableName
     * @param clientId
     * @return
     */
    Integer onLine(
            @Param("table") String clientPoolTableName,
            @Param("clientId") String clientId);


    /**
     * 初次连接登记
     * @param dId
     * @param id
     * @param clientId
     * @return
     */
    Integer checkIn(
            @Param("did") Integer dId,
            @Param("aid") Integer id,
            @Param("clientId") String clientId);

    /**
     * 查询应用当前连接数
     * @param id
     * @return
     */
    Integer getCurrentConnCount(
            @Param("table") String clientPoolTableName,
            @Param("aid") Integer id);

    /**
     * 查询应用当前在线连接数
     * @param clientPoolTableName
     * @param id
     * @return
     */
    Integer getCurrentOnlineCount(@Param("table") String clientPoolTableName,
                                  @Param("aid") Integer id);


    /**
     *  客户端下线
     * @param clientPoolTableName
     * @param clientId
     * @return
     */
    Integer offLine(@Param("table") String clientPoolTableName,
                    @Param("clientId") String clientId);


    /**
     * 获取连接信息
     * @param did
     * @param aid
     * @param page
     * @param num
     * @return
     */
    List<ClientConn> getConns(@Param("did") Integer did,
                              @Param("aid") Integer aid,
                              @Param("page") Integer page,
                              @Param("num") Integer num);

    /**
     * 创建数据表
     * @param clientPoolTableName
     * @return
     */
    Integer createTable(@Param("table") String clientPoolTableName);


}
