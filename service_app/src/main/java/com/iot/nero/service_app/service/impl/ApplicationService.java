package com.iot.nero.service_app.service.impl;

import com.iot.nero.constant.ClientType;
import com.iot.nero.facade.*;
import com.iot.nero.parent_app.entity.*;
import com.iot.nero.parent_balance.entity.Balance;
import com.iot.nero.parent_balance.exception.BalanceNotEnoughException;
import com.iot.nero.parent_balance.exception.BalanceNotFoundException;
import com.iot.nero.parent_balance.exception.ConnDecreaseFailedException;
import com.iot.nero.parent_data.entity.MQMessage;
import com.iot.nero.parent_sso.exception.PasswordIncorrectException;
import com.iot.nero.parent_sso.exception.TokenExpiredException;
import com.iot.nero.service.impl.BaseAuthService;
import com.iot.nero.service_app.Consumer;
import com.iot.nero.dto.Result;
import com.iot.nero.parent_app.dto.ApplicationInfo;
import com.iot.nero.parent_app.dto.ApplicationResult;
import com.iot.nero.parent_app.exception.*;
import com.iot.nero.parent_sso.constant.CONSTANT;
import com.iot.nero.parent_sso.exception.DeveloperNotExistsException;
import com.iot.nero.service.IApplicationService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static com.iot.nero.constant.UserTokenType.ANDROID_TOKEN;
import static com.iot.nero.constant.UserTokenType.BROWSER_TOKEN;
import static com.iot.nero.constant.UserTokenType.IPHONE_TOKEN;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午11:15
 */
@Service
public class ApplicationService extends BaseAuthService implements IApplicationService {

    private IDeveloperFacade developerFacade;
    private IApplicationFacade applicationFacade;
    private IClientFacade clientFacade;
    private IBalanceFacade balanceFacade;
    private IDataFacade dataFacade;

    /**
     * 创建应用程序
     * Did token 用来认证
     * @param DId
     * @param token
     * @param name
     * @param type
     * @param tech
     * @param trans
     * @param company
     * @param maxConnect
     * @param desc
     * @param clientType
     * @return
     */
    public synchronized Result<Application> createApplication(Integer DId, String token, String name, String type, String tech, Integer trans, String company, Integer maxConnect, String desc, ClientType clientType) {

        applicationFacade = null;
        developerFacade = null;
        balanceFacade = null;

        try {
            try {
                developerFacade = (IDeveloperFacade)Consumer.singleton().getBean("IDeveloperFacade");
                boolean auth = isTokenAccess(developerFacade,DId,token,clientType);
            }catch (IllegalStateException e){
                return new Result<Application>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION);
            }

            try {
                balanceFacade = (IBalanceFacade) Consumer.singleton().getBean("IBalanceFacade");
                /**
                 * 检查余额
                 */
                Balance balance = balanceFacade.checkBalance(DId,maxConnect);
            }catch (IllegalStateException e){
                return new Result<Application>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION);
            }

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
                /**
                 * 创建应用
                 */
                Application application = applicationFacade.createApplication(new ApplicationInfo(DId, name, type, tech, trans, company, maxConnect, desc));

                if(application!=null){
                    balanceFacade.consumeConn(DId,maxConnect);
                }

                return new Result<Application>(true,application);
            }catch (IllegalStateException e){
                return new Result<Application>(false, com.iot.nero.parent_sso.constant.CONSTANT.APP_FACADE_EXCEPTION);
            }

        } catch (UnsupportedEncodingException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (ApplicationCreateFailedException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (DeveloperNotExistsException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (ProductKeyExistsException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (AppNameExistsException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (BalanceNotEnoughException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (BalanceNotFoundException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (ConnDecreaseFailedException e) {
            return new Result<Application>(false,e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<Application>(false,e.getMessage());
        }
    }

    /**
     * 获取应用列表
     * @param Uid
     * @param token
     * @param clientType
     * @return
     */
    public Result<List<ApplicationResult>> getApplications(Integer Uid, String token, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;
        dataFacade = null;
        clientFacade  = null;

        try {
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
                boolean auth = isTokenAccess(developerFacade,Uid,token,clientType);
            } catch (IllegalStateException e) {
                return new Result<List<ApplicationResult>>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
                List<ApplicationResult> applicationInfos = applicationFacade.getApplications(Uid);

                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");

                clientFacade = (IClientFacade) Consumer.singleton().getBean("IClientFacade");

                for(ApplicationResult applicationResult:applicationInfos) {
                    String clientPoolTableName = "developer_" + applicationResult.getDId() + "_client";
                    Integer currentConn = clientFacade.getCurrentConnCount(clientPoolTableName, applicationResult.getId());
                    Integer currentOnline = clientFacade.getCurrentOnlineCount(clientPoolTableName, applicationResult.getId());
                    Integer messageCount = dataFacade.getSendMessageCount(Uid, applicationResult.getId());
                    applicationResult.setCurrentConn(currentConn);
                    applicationResult.setCurrentOnline(currentOnline);
                    applicationResult.setMessageCount(messageCount);
                }
                return new Result<List<ApplicationResult>>(true,applicationInfos);
            } catch (IllegalStateException e) {
                return new Result<List<ApplicationResult>>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
        } catch (DeveloperNotExistsException e) {
            return new Result<List<ApplicationResult>>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<List<ApplicationResult>>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<List<ApplicationResult>>(false, e.getMessage());
        }
    }

    /**
     * 获取真实应用信息 ，含 productSecret
     * @param uid
     * @param aid
     * @param token
     * @param pwd
     * @param clientType
     * @return
     */
    public Result<Application> getApplication(Integer uid, Integer aid, String token, String pwd, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;
        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalStateException e) {
                return new Result<Application>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            } catch (IllegalStateException e) {
                return new Result<Application>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }

            boolean auth = isTokenAccess(developerFacade,uid,token,clientType);
            boolean auth_p = developerFacade.isUPwdCorrect(uid,pwd);
            Application application = applicationFacade.authApplication(aid,uid);

            return new Result<Application>(true,application);
        } catch (DeveloperNotExistsException e) {
            return new Result<Application>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<Application>(false, e.getMessage());
        } catch (AccessWithoutPermissionException e) {
            return new Result<Application>(false, e.getMessage());
        } catch (PasswordIncorrectException e) {
            return new Result<Application>(false, e.getMessage());
        } catch (UnsupportedEncodingException e) {
            return new Result<Application>(false, e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            return new Result<Application>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<Application>(false, e.getMessage());
        }
    }

    /**
     * 获取应用信息
     * @param uid
     * @param aid
     * @param token
     * @param clientType
     * @return
     */
    public Result<ApplicationResult> getApplicationInfo(Integer uid, Integer aid, String token, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;
        clientFacade  = null;

        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalStateException e) {
                return new Result<ApplicationResult>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            } catch (IllegalStateException e) {
                return new Result<ApplicationResult>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }

            try {
                clientFacade = (IClientFacade) Consumer.singleton().getBean("IClientFacade");
            } catch (IllegalStateException e) {
                return new Result<ApplicationResult>(false, CONSTANT.CLIENT_FACADE_EXCEPTION);
            }

            boolean auth = isTokenAccess(developerFacade,uid,token,clientType);

            Application application = applicationFacade.authApplication(aid,uid);

            String clientPoolTableName = "developer_"+application.getDId()+"_client";
            Integer currentConn = clientFacade.getCurrentConnCount(clientPoolTableName,application.getId());
            Integer currentOnline = clientFacade.getCurrentOnlineCount(clientPoolTableName,application.getId());


            try {
                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");
            } catch (IllegalStateException e) {
                return new Result<ApplicationResult>(false, CONSTANT.DATA_FACADE_EXCEPTION);
            }
            Integer messageCount = dataFacade.getSendMessageCount(uid,application.getId());

            return new Result<ApplicationResult>(true,new ApplicationResult(application.getId(),
                    application.getDId(),
                    application.getName(),
                    application.getType(),
                    application.getTech(),
                    application.getTrans(),
                    application.getCompany(),
                    application.getProductKey(),
                    application.getMaxConnect(),
                    application.getCreateTime(),
                    application.getDescription(),
                    currentConn,
                    currentOnline,
                    messageCount));
        } catch (DeveloperNotExistsException e) {
            return new Result<ApplicationResult>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<ApplicationResult>(false, e.getMessage());
        } catch (AccessWithoutPermissionException e) {
            return new Result<ApplicationResult>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<ApplicationResult>(false, e.getMessage());
        }
    }

    /**
     * 获取应用数据点
     * @param uid
     * @param aid
     * @param token
     * @param clientType
     * @return
     */
    public Result<List<DataPoint>> getDataPoints(Integer uid, Integer aid, String token, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;

        try {

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalStateException e) {
                return new Result<List<DataPoint>>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }

            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            } catch (IllegalStateException e) {
                return new Result<List<DataPoint>>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }

            boolean auth = isTokenAccess(developerFacade,uid,token,clientType);

            Application application = applicationFacade.authApplication(aid,uid);

            List<DataPoint> dataPoints = applicationFacade.getDataPoint(aid);

            return new Result<List<DataPoint>>(true,dataPoints);
        } catch (DeveloperNotExistsException e) {
            return new Result<List<DataPoint>>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<List<DataPoint>>(false, e.getMessage());
        } catch (AccessWithoutPermissionException e) {
            return new Result<List<DataPoint>>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<List<DataPoint>>(false, e.getMessage());
        }
    }

    /**
     * 添加数据点
     * @param uid
     * @param aid
     * @param data
     * @param token
     * @param clientType
     * @return
     */
    public Result<DataPoint> addDataPoints(Integer uid, Integer aid, DataPointInfo data, String token, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;

        try {

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalStateException e) {
                return new Result<DataPoint>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }

            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            } catch (IllegalStateException e) {
                return new Result<DataPoint>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }

            boolean auth = isTokenAccess(developerFacade,uid,token,clientType);

            Application application = applicationFacade.authApplication(aid,uid);

            DataPoint dataPoint = applicationFacade.addDataPoint(aid,data);

            return new Result<DataPoint>(true,dataPoint);
        } catch (DeveloperNotExistsException | AccessWithoutPermissionException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (DataPointAddFailedException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (DataPointNotExistsException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (DataPointExistsException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<DataPoint>(false, e.getMessage());
        }
    }

    /**
     * 获取应用当前连接信息
     * @param aid
     * @param did
     * @param token
     * @param clientType
     * @return
     */
    public Result<List<ClientConnResult>> getAppCurrentConn(Integer aid, Integer did, String token, Integer page, Integer num, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;
        clientFacade = null;
        dataFacade = null;

        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalStateException e) {
                return new Result<List<ClientConnResult>>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            Application application = applicationFacade.authApplication(aid,did);

            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            } catch (IllegalStateException e) {
                return new Result<List<ClientConnResult>>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }
            boolean auth = isTokenAccess(developerFacade,did,token,clientType);

            try {
                clientFacade = (IClientFacade) Consumer.singleton().getBean("IClientFacade");
            } catch (IllegalStateException e) {
                return new Result<List<ClientConnResult>>(false, CONSTANT.CLIENT_FACADE_EXCEPTION);
            }


            List<ClientConn> clientConns = clientFacade.getAppConn(did,aid,page,num);


            try {
                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");
            } catch (IllegalStateException e) {
                return new Result<List<ClientConnResult>>(false, CONSTANT.DATA_FACADE_EXCEPTION);
            }

            List<ClientConnResult> clientConnResults = new ArrayList<ClientConnResult>();
            for(ClientConn clientConn:clientConns){
                clientConnResults.add(new ClientConnResult(clientConn.getId(),
                        clientConn.getAId(),
                        clientConn.getClientId(),
                        clientConn.getIsOnline(),
                        clientConn.getLastOnlineTime(),
                        clientConn.getLastOfflineTime(),
                        clientConn.getCreateTime(),
                        clientConn.getConnCount(),
                        dataFacade.getClientSendMessageCount(clientConn.getAId(),
                                clientConn.getClientId())
                        ));
            }

            return new Result<List<ClientConnResult>>(true,clientConnResults);
        } catch (DeveloperNotExistsException e) {
            return new Result<List<ClientConnResult>>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<List<ClientConnResult>>(false, e.getMessage());
        } catch (AccessWithoutPermissionException e) {
            return new Result<List<ClientConnResult>>(false, e.getMessage());
        } catch (ClientConnNotExistsException e) {
            return new Result<List<ClientConnResult>>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<List<ClientConnResult>>(false, e.getMessage());
        }

    }

    /**
     *
     * @param uid
     * @param token
     * @param aid
     * @param pid
     * @param clientType
     * @return
     */
    public Result<DataPoint> deleteDataPoint(Integer uid, String token, Integer aid, Integer pid, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;

        try {
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
                boolean auth = isTokenAccess(developerFacade,uid,token,clientType);
            } catch (IllegalStateException e) {
                return new Result<DataPoint>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            } catch (TokenExpiredException e) {
                return new Result<DataPoint>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }


            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalStateException e) {
                return new Result<DataPoint>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }




            Application application = applicationFacade.authApplication(aid,uid);

            DataPoint dataPoint = applicationFacade.deleteDataPoint(aid,pid);

            return new Result<DataPoint>(true,dataPoint);
        } catch (AccessWithoutPermissionException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (DataPointNotExistsException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (DeveloperNotExistsException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (DataPointDeleteFailedException e) {
            return new Result<DataPoint>(false, e.getMessage());
        } catch (DataPointWithoutPermissionException e) {
            return new Result<DataPoint>(false, e.getMessage());
        }
    }

    /**
     *
     * @param uid
     * @param token
     * @param aid
     * @param page
     * @param num
     * @param clientType
     * @return
     */
    public Result<List<MQMessage>> getMessage(Integer uid, String token, Integer aid, Integer page, Integer num, ClientType clientType) {
        applicationFacade = null;
        developerFacade = null;
        dataFacade = null;
        try {

            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            } catch (IllegalStateException e) {
                return new Result<List<MQMessage>>(false, CONSTANT.SSO_FACADE_EXCEPTION);
            }
            boolean auth = isTokenAccess(developerFacade,uid,token,clientType);

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalStateException e) {
                return new Result<List<MQMessage>>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            Application application = applicationFacade.authApplication(aid,uid);

            try {
                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");
            } catch (IllegalStateException e) {
                return new Result<List<MQMessage>>(false, CONSTANT.DATA_FACADE_EXCEPTION);
            }
            List<MQMessage> messageResult = dataFacade.getMessageByPage(aid,page,num);

            return new Result<List<MQMessage>>(true,messageResult);
        } catch (AccessWithoutPermissionException e) {
            return new Result<List<MQMessage>>(false, e.getMessage());
        } catch (DeveloperNotExistsException e) {
            return new Result<List<MQMessage>>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<List<MQMessage>>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<List<MQMessage>>(false, e.getMessage());
        }
    }
}
