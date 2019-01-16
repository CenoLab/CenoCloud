package com.iot.nero.service_sso.service.impl;

import com.iot.nero.constant.ClientType;
import com.iot.nero.dto.Result;
import com.iot.nero.facade.IApplicationFacade;
import com.iot.nero.facade.IBalanceFacade;
import com.iot.nero.parent_app.dto.ApplicationInfo;
import com.iot.nero.parent_app.entity.Application;
import com.iot.nero.parent_app.exception.AppNameExistsException;
import com.iot.nero.parent_app.exception.ApplicationCreateFailedException;
import com.iot.nero.parent_app.exception.ProductKeyExistsException;
import com.iot.nero.parent_balance.entity.Balance;
import com.iot.nero.parent_balance.exception.BalanceInitException;
import com.iot.nero.parent_sso.constant.CONSTANT;
import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.parent_sso.entity.Developer;
import com.iot.nero.parent_sso.entity.DeveloperAdds;
import com.iot.nero.parent_sso.entity.VerifyCode;
import com.iot.nero.parent_sso.exception.*;
import com.iot.nero.service.impl.BaseAuthService;
import com.iot.nero.service_sso.Consumer;
import com.iot.nero.facade.IDeveloperFacade;
import com.iot.nero.service.IAuthService;
import com.iot.nero.utils.rendom.RandomString;
import com.iot.nero.utils.token.TOKEN_TYPE;
import com.iot.nero.utils.token.Token;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import static com.iot.nero.constant.UserTokenType.ANDROID_TOKEN;
import static com.iot.nero.constant.UserTokenType.BROWSER_TOKEN;
import static com.iot.nero.constant.UserTokenType.IPHONE_TOKEN;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午5:20
 */
@Service
public class AuthService extends BaseAuthService implements IAuthService {


    private IDeveloperFacade developerFacade;
    private IBalanceFacade balanceFacade;
    private IApplicationFacade applicationFacade;

    public synchronized Result<DeveloperInfo> login(String phoneOrEmail, String pwd, ClientType clientType) {
        developerFacade = null;
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            boolean isDeveloperExists = developerFacade.isLoginDeveloperExists(phoneOrEmail);
            boolean isPwdCorrect = developerFacade.isPwdCorrect(phoneOrEmail, pwd);

            Developer developer = null;
            DeveloperInfo developerInfo = null;
            Token token = new Token(pwd, TOKEN_TYPE.MD5);
            switch (clientType) {
                case BROWSER:
                    developer = developerFacade.updateDeveloperToken(phoneOrEmail,token, BROWSER_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getToken(),
                            developer.getCreateTime());
                    break;
                case MOBILE_ANDROID:
                    developer = developerFacade.updateDeveloperToken(phoneOrEmail, token, ANDROID_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getAndroidToken(),
                            developer.getCreateTime());
                    break;
                case MOBILE_IPHONE:
                    developer = developerFacade.updateDeveloperToken(phoneOrEmail, token, IPHONE_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getIphoneToken(),
                            developer.getCreateTime());
                    break;
                default:
                    developer = developerFacade.updateDeveloperToken(phoneOrEmail, token, BROWSER_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getToken(),
                            developer.getCreateTime());
                    break;
            }
            return new Result<DeveloperInfo>(true, developerInfo);
        } catch (DeveloperNotExistsException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (PasswordIncorrectException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (UnsupportedEncodingException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (TokenUpdateException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (NotEmailOrPhoneException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        }
    }

    public Result<DeveloperInfo> auth(Integer did, String token, ClientType clientType) {

        developerFacade = null;
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            boolean auth;
            Developer developer = null;
            DeveloperInfo developerInfo = null;
            switch (clientType){
                case MOBILE_ANDROID:
                    auth = developerFacade.isTokenCorrect(did, token,ANDROID_TOKEN);
                    developer = developerFacade.getDeveloperByToken(token,ANDROID_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getAndroidToken(),
                            developer.getCreateTime());
                    break;
                case BROWSER:
                    auth = developerFacade.isTokenCorrect(did, token,BROWSER_TOKEN);
                    developer = developerFacade.getDeveloperByToken(token,BROWSER_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getToken(),
                            developer.getCreateTime());
                    break;
                case MOBILE_IPHONE:
                    auth = developerFacade.isTokenCorrect(did, token,IPHONE_TOKEN);
                    developer = developerFacade.getDeveloperByToken(token,IPHONE_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getIphoneToken(),
                            developer.getCreateTime());
                    break;
                default:
                    auth = developerFacade.isTokenCorrect(did, token,BROWSER_TOKEN);
                    developer = developerFacade.getDeveloperByToken(token,BROWSER_TOKEN);
                    developerInfo = new DeveloperInfo(developer.getId(),
                            developer.getName(),
                            developer.getCompany(),
                            developer.getEmail(),
                            developer.getPhone(),
                            developer.getToken(),
                            developer.getCreateTime());
                    break;
            }

            return new Result<DeveloperInfo>(true, developerInfo);

        } catch (DeveloperNotExistsException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        }
    }

    public Result<Balance> getBalance(Integer id, String token, ClientType clientType) {

        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
        } catch (IllegalStateException e) {
            return new Result<Balance>(false, CONSTANT.SSO_FACADE_EXCEPTION);
        }

        try {
            boolean auth = isTokenAccess(developerFacade,id,token,clientType);

        } catch (DeveloperNotExistsException e) {
            return new Result<Balance>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<Balance>(false, e.getMessage());
        }

        try {
            balanceFacade = (IBalanceFacade) Consumer.singleton().getBean("IBalanceFacade");
        } catch (IllegalStateException e) {
            return new Result<Balance>(false, CONSTANT.BALANCE_FACADE_EXCEPTION);
        }

        Balance balance = balanceFacade.getBalanceByDId(id);

        if (balance == null) {
            return new Result<Balance>(false, CONSTANT.BALANCE_NOT_FOUND);
        }
        return new Result<Balance>(true, balance);
    }

    public Result<DeveloperAdds> getDeveloperAdds(Integer id, String token,ClientType clientType) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
        } catch (IllegalStateException e) {
            return new Result<DeveloperAdds>(false, CONSTANT.SSO_FACADE_EXCEPTION);
        }

        try {
            boolean auth = isTokenAccess(developerFacade,id,token,clientType);

            return new Result<DeveloperAdds>(true, developerFacade.getDeveloperAdds(id));

        } catch (DeveloperNotExistsException e) {
            return new Result<DeveloperAdds>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<DeveloperAdds>(false, e.getMessage());
        } catch (DeveloperAddNotFoundException e) {
            return new Result<DeveloperAdds>(false, e.getMessage());
        }

    }

    public Result<DeveloperAdds> setDeveloperAdds(Integer id, String token, String dProfession, String dBussiness, String dWebsite, String dCountry, String dAddress, String dStreet, String dTel, String dFax,ClientType clientType) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
        } catch (IllegalStateException e) {
            return new Result<DeveloperAdds>(false, CONSTANT.SSO_FACADE_EXCEPTION);
        }

        try {
            boolean auth = isTokenAccess(developerFacade,id,token,clientType);

            return new Result<DeveloperAdds>(true, developerFacade.setDeveloperAdds(id,
                    dProfession,
                    dBussiness,
                    dWebsite,
                    dCountry,
                    dAddress,
                    dStreet,
                    dTel,
                    dFax));

        } catch (DeveloperNotExistsException e) {
            return new Result<DeveloperAdds>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<DeveloperAdds>(false, e.getMessage());
        } catch (DeveloperAddsAddFailedException e) {
            return new Result<DeveloperAdds>(false, e.getMessage());
        } catch (DeveloperAddsUpdateFailedException e) {
            return new Result<DeveloperAdds>(false, e.getMessage());
        }
    }

    public Result<DeveloperInfo> changeName(Integer id, String token, String name, String company,ClientType clientType) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_FACADE_EXCEPTION);
        }

        try {
            boolean auth = isTokenAccess(developerFacade,id,token,clientType);

            return new Result<DeveloperInfo>(true, developerFacade.changeName(id, name, company));

        } catch (DeveloperNotExistsException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (DeveloperNameChangeFailedException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        }
    }

    public Result<DeveloperInfo> changeAvatar(Integer id, String token, String filename, MultipartFile avatar,ClientType clientType) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_FACADE_EXCEPTION);
        }

        try {
            boolean auth = isTokenAccess(developerFacade,id,token,clientType);

            return null;/////////////////////////////////////////////////////

        } catch (DeveloperNotExistsException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        }
    }

    public Result<DeveloperInfo> changePwd(Integer id, String token, String oldPwd, String newPwd,ClientType clientType) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_FACADE_EXCEPTION);
        }

        try {
            boolean auth = isTokenAccess(developerFacade,id,token,clientType);

            return new Result<DeveloperInfo>(true, developerFacade.changePwd(id, oldPwd, newPwd));

        } catch (DeveloperNotExistsException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (TokenExpiredException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (PasswordIncorrectException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (UnsupportedEncodingException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (PasswordChangeFailedException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        }
    }

    public Result<DeveloperInfo> activeByEmailCode(String email, String code) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
            DeveloperInfo developerInfo = developerFacade.activeDeveloperByEmailCode(email, code);
            return new Result<DeveloperInfo>(true, developerInfo);
        } catch (ParseException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.DATE_PARSR_ERROR);
        } catch (DeveloperAccountActiveException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (VerifyCodeException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_FACADE_EXCEPTION);
        }
    }

    public Result<DeveloperInfo> activeByPhoneCode(String phone, String code) {
        return null;
    }

    public Result<DeveloperInfo> registerByEmail(String name, String email, String password) {
        developerFacade = null;
        Token token = new Token();
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");

            Developer isDeveloperExists = developerFacade.isRegisterDeveloperExists(email);

            String tokenStr = token.genCode();
            String verifyCode = RandomString.getRandomString(6).toUpperCase();

            Developer developer = developerFacade.addDeveloper(name, email, password, tokenStr);

            //初始化开发者------------------此处有分布式事务问题

            //1. 初始化消费余额
            balanceFacade = (IBalanceFacade) Consumer.singleton().getBean("IBalanceFacade");
            Balance balance = balanceFacade.initDeveloperBanance(developer.getId());

            //2. 初始化默认应用demo
            applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            Application application = applicationFacade.createApplication(new ApplicationInfo(
                    developer.getId(), "Demo", "Demo", "Wi-Fi", 1, developer.getName(), 20, "this app is create by system."
            ));

            VerifyCode verifyCodeResponse = developerFacade.updateVerifyCodeByUidAndEmail(developer.getId(), email, verifyCode);
            Boolean mail = developerFacade.sendActiveEmail(developer.getName(), developer.getEmail(), verifyCode);
            return new Result<DeveloperInfo>(true, new DeveloperInfo(developer.getId(),
                    developer.getName(),
                    developer.getCompany(),
                    developer.getEmail(),
                    developer.getPhone(),
                    developer.getToken(),
                    developer.getCreateTime()));
        } catch (DeveloperActivedException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (DeveloperExistsException e) {  //存在注册信息  需要判断是否激活
            String tokenStr = null;
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
                tokenStr = token.genCode();
                String verifyCode = RandomString.getRandomString(6).toUpperCase();
                Developer developer = developerFacade.updateDeveloperPasswordAndName(name, email, password, tokenStr);
                VerifyCode verifyCodeResponse = developerFacade.updateVerifyCodeByUidAndEmail(developer.getId(), email, verifyCode);
                Boolean mail = developerFacade.sendActiveEmail(developer.getName(), developer.getEmail(), verifyCode);
                return new Result<DeveloperInfo>(true, new DeveloperInfo(developer.getId(),
                        developer.getName(),
                        developer.getCompany(),
                        developer.getEmail(),
                        developer.getPhone(),
                        developer.getToken(),
                        developer.getCreateTime()));
            } catch (NoSuchAlgorithmException e1) {
                return new Result<DeveloperInfo>(false, e.getMessage());
            } catch (UnsupportedEncodingException e1) {
                return new Result<DeveloperInfo>(false, e.getMessage());
            } catch (VerifyCodeException e1) {
                return new Result<DeveloperInfo>(false, e.getMessage());
            } catch (DeveloperUpdateFailedException e1) {
                return new Result<DeveloperInfo>(false, e.getMessage());
            }
        } catch (DeveloperAddFailedException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (UnsupportedEncodingException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (VerifyCodeException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (ApplicationCreateFailedException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (AppNameExistsException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (ProductKeyExistsException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        } catch (BalanceInitException e) {
            return new Result<DeveloperInfo>(false, e.getMessage());
        }
    }

    public Result<DeveloperInfo> registerByPhone(String name, String phone, String password) {
        return null;
    }
}
