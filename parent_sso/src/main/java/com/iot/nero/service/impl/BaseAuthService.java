package com.iot.nero.service.impl;

import com.iot.nero.constant.ClientType;
import com.iot.nero.dto.AuthPair;
import com.iot.nero.facade.IDeveloperFacade;
import com.iot.nero.parent_sso.exception.DeveloperNotExistsException;
import com.iot.nero.parent_sso.exception.TokenExpiredException;

import static com.iot.nero.constant.UserTokenType.ANDROID_TOKEN;
import static com.iot.nero.constant.UserTokenType.BROWSER_TOKEN;
import static com.iot.nero.constant.UserTokenType.IPHONE_TOKEN;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/4
 * Time   下午10:56
 */
public class BaseAuthService {
    protected boolean isTokenAccess(IDeveloperFacade developerFacade, Integer id, String token, ClientType clientType) throws DeveloperNotExistsException, TokenExpiredException {
        boolean auth;
        switch (clientType){
            case MOBILE_IPHONE:
                auth = developerFacade.isTokenCorrect(id, token, IPHONE_TOKEN);
                break;
            case MOBILE_ANDROID:
                auth = developerFacade.isTokenCorrect(id, token, ANDROID_TOKEN);
                break;
            default:
                auth = developerFacade.isTokenCorrect(id, token, BROWSER_TOKEN);
                break;
        }
        return auth;
    }
    protected boolean isTokenAccess(IDeveloperFacade developerFacade, AuthPair authPair) throws DeveloperNotExistsException, TokenExpiredException {
        boolean auth;
        switch (authPair.getClientType()){
            case MOBILE_IPHONE:
                auth = developerFacade.isTokenCorrect(authPair.getId(), authPair.getToken(),IPHONE_TOKEN);
                break;
            case MOBILE_ANDROID:
                auth = developerFacade.isTokenCorrect(authPair.getId(), authPair.getToken(),ANDROID_TOKEN);
                break;
            default:
                auth = developerFacade.isTokenCorrect(authPair.getId(), authPair.getToken(),BROWSER_TOKEN);
                break;
        }
        return auth;
    }
}
