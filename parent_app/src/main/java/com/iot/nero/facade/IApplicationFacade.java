package com.iot.nero.facade;

import com.iot.nero.parent_app.dto.ApplicationInfo;
import com.iot.nero.parent_app.dto.ApplicationResult;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.parent_app.entity.Application;
import com.iot.nero.parent_app.entity.DataPoint;
import com.iot.nero.parent_app.entity.DataPointInfo;
import com.iot.nero.parent_app.exception.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午9:51
 */
public interface IApplicationFacade {

    /**
     * 创建应用
     * @param app
     * @return
     */
    Application createApplication(ApplicationInfo app) throws UnsupportedEncodingException, NoSuchAlgorithmException, ApplicationCreateFailedException, ProductKeyExistsException, AppNameExistsException;

    /**
     * 获取应用程序数据点
     * @param AppId
     * @return
     */
    List<DataPoint> getDataPoint(Integer AppId) throws AppNotExistsException;

    /**
     * 获取应用列表
     * @param uid
     * @return
     */
    List<ApplicationResult> getApplications(Integer uid) throws AppNotExistsException;

    /**
     * 获取应用程序 完整
     * @param id
     * @return
     */
    Application getApplication(Integer id) throws AppNotExistsException;

    /**
     * 认证应用
     * @param aid
     * @param uid
     * @return
     */
    Application authApplication(Integer aid,Integer uid) throws AppNotExistsException, AccessWithoutPermissionException;


    /**
     * 添加数据点
     * @param aid
     * @param dataPointInfo
     * @return
     */
    DataPoint addDataPoint(Integer aid, DataPointInfo dataPointInfo) throws AppNotExistsException, DataPointAddFailedException, DataPointExistsException, DataPointNotExistsException;


    /**
     * 根据productKey查询app信息
     *
     * @param productKey
     * @return
     */
    Application findAppByProductKey(String productKey) throws AppNotExistsException;

    /**
     * 删除数据点
     * @param aid
     * @param pid
     * @return
     */
    DataPoint deleteDataPoint(Integer aid, Integer pid) throws DataPointNotExistsException, DataPointWithoutPermissionException, DataPointDeleteFailedException;


    Application auth(Integer appId, KeySecret keySecret) throws AppNotExistsException, AppAuthFailedException;

    /**
     * 获取数据点信息
     * @param dataPoint
     * @return
     */
    DataPoint getDataPointById(Integer dataPoint) throws DataPointNotExistsException;
}
