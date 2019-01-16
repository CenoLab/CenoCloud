package com.iot.nero.facade_app.facade.impl;

import com.iot.nero.facade_app.dao.DataPointDao;
import com.iot.nero.parent_app.constant.CONSTANT;
import com.iot.nero.facade.IApplicationFacade;
import com.iot.nero.facade_app.dao.AppDao;
import com.iot.nero.parent_app.dto.ApplicationInfo;
import com.iot.nero.parent_app.dto.ApplicationResult;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.parent_app.entity.Application;
import com.iot.nero.parent_app.entity.DataPoint;
import com.iot.nero.parent_app.entity.DataPointInfo;
import com.iot.nero.parent_app.exception.*;
import com.iot.nero.utils.rendom.RandomString;
import com.iot.nero.utils.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午9:51
 */
@Service
public class ApplicationFacade implements IApplicationFacade {


    @Autowired
    private AppDao appDao;
    @Autowired
    private DataPointDao dataPointDao;

    /**
     * 创建App
     * @param app
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws ApplicationCreateFailedException
     * @throws ProductKeyExistsException
     */
    public Application createApplication(ApplicationInfo app) throws UnsupportedEncodingException, NoSuchAlgorithmException, ApplicationCreateFailedException, ProductKeyExistsException, AppNameExistsException {

        Token key = new Token(RandomString.getRandomString(64));
        String productKey = key.genCode();
        Application n_application = appDao.findAppByNameAndDeveloperID(app.getName(),app.getDId());
        if(n_application!=null){
            throw new AppNameExistsException(CONSTANT.APPLICATION_ALREADY_EXISTS);
        }
        Application k_application = appDao.findAppByProductKey(productKey);
        if(k_application!=null){
            throw new ProductKeyExistsException(CONSTANT.APPLICATION_ALREADY_EXISTS);
        }else{
            Token secret = new Token(productKey);
            Integer applicationId = appDao.createApplication(app.getDId(),
                    app.getName(),
                    app.getType(),
                    app.getTech(),
                    app.getTrans(),
                    app.getCompany(),
                    productKey,
                    secret.genCode(),
                    app.getMaxConnect(),
                    app.getDesc());
            if(applicationId<1){
                throw new ApplicationCreateFailedException(CONSTANT.APPLICATION_CREATE_FAILED);
            }else{
                Application application = appDao.findAppByProductKey(productKey);
                if(application == null){
                    throw new ApplicationCreateFailedException(CONSTANT.APPLICATION_CREATE_FAILED);
                }else{
                    return application;
                }
            }
        }

    }

    /**
     * 获取应用程序数据点
     * @param AppId
     * @return
     * @throws AppNotExistsException
     */
    public List<DataPoint> getDataPoint(Integer AppId) throws AppNotExistsException {
        Application  application =  appDao.findAppById(AppId);
        if(application==null){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }
        return dataPointDao.getDataPoint(AppId);
    }


    /**
     * 获取应用程序
     * @param uid
     * @return
     * @throws AppNotExistsException
     */
    public List<ApplicationResult> getApplications(Integer uid) throws AppNotExistsException {
        List<ApplicationResult>  application =  appDao.findAppByUid(uid);
        if(application==null){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }else if(application.size() == 0){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }
        return application;
    }

    /**
     * 获取完整应用程序信息
     * @param id
     * @return
     */
    public Application getApplication(Integer id) throws AppNotExistsException {
        Application  application =  appDao.findAppById(id);
        if(application==null ){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }
        return application;
    }

    public Application authApplication(Integer aid, Integer uid) throws AppNotExistsException, AccessWithoutPermissionException {
        Application  application =  appDao.findAppById(aid);
        if(application==null ){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }
        if(application.getDId()!=uid){
            throw new AccessWithoutPermissionException(CONSTANT.ACCESS_WITHOUT_PERMISSION);
        }
        return application;
    }

    public DataPoint addDataPoint(Integer aid, DataPointInfo dataPointInfo) throws AppNotExistsException, DataPointAddFailedException, DataPointExistsException, DataPointNotExistsException {
        Application application = appDao.findAppById(aid);
        if(application==null ){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }
        DataPoint dataPoint = dataPointDao.getDataPointByNameAndAid(dataPointInfo.getName(),aid);
        if(dataPoint!=null){
            throw new DataPointExistsException(CONSTANT.DATAPOINT_ALREADY_EXISTS);
        }
        Integer addDataPoint = dataPointDao.addDataPoint(aid,
                dataPointInfo.getName(),
                dataPointInfo.getType(),
                dataPointInfo.getAccess());
        if(addDataPoint<1){
            throw new DataPointAddFailedException(CONSTANT.DATAPOINT_ADD_FAILED);
        }
        DataPoint d = dataPointDao.getDataPointByNameAndAid(dataPointInfo.getName(),aid);
        if(d == null){
            throw new DataPointNotExistsException(CONSTANT.DATAPOINT_NOT_EXISTS);
        }
        return d;
    }

    public Application findAppByProductKey(String productKey) throws AppNotExistsException {
        Application application = appDao.findAppByProductKey(productKey);
        if(application==null ){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }
        return application;
    }

    public DataPoint deleteDataPoint(Integer aid, Integer pid) throws DataPointNotExistsException, DataPointWithoutPermissionException, DataPointDeleteFailedException {
        DataPoint dataPoint = dataPointDao.getDataPointById(pid);
        if(dataPoint==null){
                throw new DataPointNotExistsException(CONSTANT.DATAPOINT_NOT_EXISTS);
        }
        if(dataPoint.getAppId()!=aid){
                throw new DataPointWithoutPermissionException(CONSTANT.DATAPOINT_WITHOUT_PERMISSION);
        }
        if(dataPointDao.delDataPoint(pid)<1){
            throw new DataPointDeleteFailedException(CONSTANT.DATAPOINT_DELETE_FAILED);
        }
        return dataPoint;
    }

    public Application auth(Integer appId, KeySecret keySecret) throws AppNotExistsException, AppAuthFailedException {
        Application application = appDao.findAppById(appId);
        if(application==null){
            throw new AppNotExistsException(CONSTANT.APPLICATION_NOT_EXISTS);
        }
        if(!application.getProductKey().equals(keySecret.getSecretKey())){
            throw new AppAuthFailedException(CONSTANT.ACCESS_WITHOUT_PRODUCT_KEY);
        }
        if(!application.getProductSecret().equals(keySecret.getSecret())){
            throw new AppAuthFailedException(CONSTANT.ACCESS_WITHOUT_PERMISSION);
        }
        return application;
    }

    public DataPoint getDataPointById(Integer dataPointId) throws DataPointNotExistsException {
        DataPoint dataPoint = dataPointDao.getDataPointById(dataPointId);
        if(dataPoint==null){
            throw new DataPointNotExistsException(CONSTANT.DATAPOINT_NOT_EXISTS);
        }
        return dataPoint;
    }
}
