package com.iot.nero.facade_sso.facade.impl;

import com.iot.nero.constant.UserTokenType;
import com.iot.nero.facade.IDeveloperFacade;
import com.iot.nero.facade_sso.dao.DeveloperDao;
import com.iot.nero.facade_sso.dao.VerifyDao;
import com.iot.nero.parent_sso.constant.CONSTANT;
import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.parent_sso.entity.Developer;
import com.iot.nero.parent_sso.entity.DeveloperAdds;
import com.iot.nero.parent_sso.entity.VerifyCode;
import com.iot.nero.parent_sso.exception.*;
import com.iot.nero.utils.aliyun.mail.AliyunMail;
import com.iot.nero.utils.md5.MD5;
import com.iot.nero.utils.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.iot.nero.utils.regular.Regular.checkCellPhone;
import static com.iot.nero.utils.regular.Regular.checkEmail;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午4:51
 */
@Service
public class DeveloperFacade implements IDeveloperFacade {

    @Autowired
    private DeveloperDao developerDao;

    @Autowired
    private VerifyDao verifyDao;

    /**
     * 判断开发者是否存在
     *
     * @param phoneOrEmail
     * @return 开发者是否存在，否则抛出异常
     * @throws DeveloperNotExistsException
     */
    public boolean isLoginDeveloperExists(String phoneOrEmail) throws DeveloperNotExistsException {
        if (developerDao.getDeveloperByEmail(phoneOrEmail) == null && developerDao.getDeveloperByPhone(phoneOrEmail) == null) {
            throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
        }
        return true;
    }

    /**
     * 判断密码是否正确
     * 加密方式 Md5(邮件地址+Md5(密码))
     *
     * @param phoneOrEmail
     * @param pwd
     * @return
     * @throws PasswordIncorrectException
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws DeveloperNotExistsException
     */
    public boolean isPwdCorrect(String phoneOrEmail, String pwd) throws PasswordIncorrectException, NoSuchAlgorithmException, UnsupportedEncodingException, DeveloperNotExistsException {

        Developer developerEmail = developerDao.getDeveloperByEmail(phoneOrEmail);

        try {
            if (developerEmail == null) {
                Developer developerPhone = developerDao.getDeveloperByPhone(phoneOrEmail);
                if (developerPhone == null) {
                    throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
                } else {
                    if (!developerEmail.getPwd().equals(MD5.EncoderByMd5(MD5.EncoderByMd5(pwd)))) {
                        throw new PasswordIncorrectException(CONSTANT.PASSWORD_INCORRECT);
                    }
                    return true;
                }

            } else {
                if (!developerEmail.getPwd().equals(MD5.EncoderByMd5(MD5.EncoderByMd5(pwd)))) {
                    throw new PasswordIncorrectException(CONSTANT.PASSWORD_INCORRECT);
                }
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (DeveloperNotExistsException e) {
            throw e;
        }
    }

    /**
     * 获取开发者完整信息
     *
     * @param email
     * @return
     * @throws DeveloperNotExistsException
     */
    public Developer getDeveloperByEmail(String email) throws DeveloperNotExistsException {

        Developer developer = developerDao.getDeveloperByEmail(email);

        if (developer == null) {
            throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
        } else {
            return developer;
        }
    }

    public Developer getDeveloperByToken(String token, UserTokenType userTokenType) throws DeveloperNotExistsException {

        Developer developer = null;
        switch (userTokenType) {
            case BROWSER_TOKEN:
                developer= developerDao.getDeveloperByToken(token,"d_token");
                break;
            case ANDROID_TOKEN:
                developer= developerDao.getDeveloperByToken(token,"d_android_token");
                break;
            case IPHONE_TOKEN:
                developer= developerDao.getDeveloperByToken(token,"d_iphone_token");
                break;
            case AUTH_INVOKE_TOKEN:
                developer= developerDao.getDeveloperByToken(token,"d_auth_token");
                break;
            default:
                developer= developerDao.getDeveloperByToken(token,"d_token");
                break;
        }


        if (developer == null) {
            throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
        } else {
            return developer;
        }
    }

    /**
     * 认证token
     *
     * @param did
     * @param token
     * @param userTokenType
     * @return
     */
    public boolean isTokenCorrect(Integer did, String token, UserTokenType userTokenType) throws DeveloperNotExistsException, TokenExpiredException {
        Developer developer = null;
        switch (userTokenType){
            case BROWSER_TOKEN:
                developer = developerDao.getDeveloperByToken(token,"d_token");
                break;
            case ANDROID_TOKEN:
                developer = developerDao.getDeveloperByToken(token,"d_android_token");
                break;
            case IPHONE_TOKEN:
                developer = developerDao.getDeveloperByToken(token,"d_iphone_token");
                break;
            case AUTH_INVOKE_TOKEN:
                developer = developerDao.getDeveloperByToken(token,"d_auth_token");
                break;
            default:
                developer = developerDao.getDeveloperByToken(token,"d_token");
                break;
        }

        if (developer == null) {
            throw new TokenExpiredException(CONSTANT.TOKEN_EXPIRED);
        } else {
            if (developer.getId() != did) {
                throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
            }
            return true;
        }
    }

    /**
     * 更新开发者Token信息
     * Token = Md5(32位随即串+Md5(当前Linux时间戳)+semail)
     *
     * @param phoneOrEmail
     * @param token
     * @param userTokenType
     * @return
     * @throws DeveloperNotExistsException
     * @throws TokenUpdateException
     */
    public synchronized Developer updateDeveloperToken(String phoneOrEmail, Token token, UserTokenType userTokenType) throws DeveloperNotExistsException, TokenUpdateException, UnsupportedEncodingException, NoSuchAlgorithmException, NotEmailOrPhoneException {
        String tokenString = token.genCode();
        if(checkCellPhone(phoneOrEmail)){
            Developer developerPhone = developerDao.getDeveloperByPhone(phoneOrEmail);
            if (developerPhone == null) {
                throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
            }
            switch (userTokenType) {
                case ANDROID_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_android_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerPhone.setAndroidToken(tokenString);
                    break;
                case IPHONE_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_iphone_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerPhone.setIphoneToken(tokenString);
                    break;
                case BROWSER_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerPhone.setToken(tokenString);

                    break;
                case AUTH_INVOKE_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_auth_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerPhone.setAuthToken(tokenString);
                    break;
                default:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerPhone.setToken(tokenString);
                    break;
            }
            return developerPhone;
        }else if(checkEmail(phoneOrEmail)){
            Developer developerEmail = developerDao.getDeveloperByEmail(phoneOrEmail);
            if (developerEmail == null) {
                throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
            }
            switch (userTokenType) {
                case ANDROID_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_android_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerEmail.setAndroidToken(tokenString);
                    break;
                case IPHONE_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_iphone_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerEmail.setIphoneToken(tokenString);
                    break;
                case BROWSER_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerEmail.setToken(tokenString);
                    break;
                case AUTH_INVOKE_TOKEN:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_auth_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerEmail.setAuthToken(tokenString);
                    break;
                default:
                    if (developerDao.updateDeveloperToken(phoneOrEmail, tokenString,"d_token") < 1) {
                        throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
                    }
                    developerEmail.setToken(tokenString);
                    break;
            }
            return developerEmail;
        }else{
            throw new NotEmailOrPhoneException(CONSTANT.NOT_EMAIL_OR_PHONE);
        }
    }

    public synchronized Developer updateDeveloperTokenById(Integer id, String to) throws DeveloperNotExistsException, UnsupportedEncodingException, NoSuchAlgorithmException, TokenUpdateException {
        Developer developer = developerDao.getDeveloperByToken(to, "d_token");

        if (developer == null) {
            throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
        } else {
            Token token = new Token(to);
            String tokenString = token.genCode();
            if (developerDao.updateDeveloperToken(developer.getEmail(), tokenString, "d_iphone_token") < 1) {
                throw new TokenUpdateException(CONSTANT.TOKEN_UPDATE_EXCEPTION);
            }
            developer.setToken(tokenString);
            return developer;
        }
    }

    public boolean isUPwdCorrect(Integer uid, String pwd) throws DeveloperNotExistsException, UnsupportedEncodingException, NoSuchAlgorithmException, PasswordIncorrectException {
        Developer developer = developerDao.getDeveloperById(uid);
        if (developer == null) {
            throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
        } else {
            if (!developer.getPwd().equals(MD5.EncoderByMd5(MD5.EncoderByMd5(pwd)))) {
                throw new PasswordIncorrectException(CONSTANT.PASSWORD_INCORRECT);
            }
            return true;
        }
    }


    public Developer isRegisterDeveloperExists(String email) throws DeveloperExistsException, DeveloperActivedException {
        Developer developer = developerDao.getDeveloperByEmail(email);
        if (developer != null) {
            if (developer.getIsActive() == 1) {
                throw new DeveloperActivedException(CONSTANT.DEVELOPER_ALREADY_ACTIVED);
            } else {
                throw new DeveloperExistsException(CONSTANT.DEVELOPER_ALREADY_EXISTS);
            }
        }
        return developer;
    }


    public Developer addDeveloper(String name, String email, String password, String token) throws UnsupportedEncodingException, NoSuchAlgorithmException, DeveloperAddFailedException {

        String pwd = MD5.EncoderByMd5(MD5.EncoderByMd5(password));
        if (developerDao.addDeveloperBase(name, email, pwd, token) < 1) {
            throw new DeveloperAddFailedException(CONSTANT.DEVELOPER_ADD_FAILED);
        }
        return developerDao.getDeveloperByToken(token, "d_token");
    }


    public Developer updateDeveloper(String name, String email, String password, String token) throws UnsupportedEncodingException, NoSuchAlgorithmException, DeveloperUpdateFailedException {
        String pwd = MD5.EncoderByMd5(MD5.EncoderByMd5(password));

        if (developerDao.updateDeveloperBase(name, email, pwd, token) < 1) {
            throw new DeveloperUpdateFailedException(CONSTANT.DEVELOPER_UPDATE_FAILED);
        }
        return developerDao.getDeveloperByToken(token, "d_token");
    }

    public synchronized Boolean sendActiveEmail(String name, String email, String code) {
        //此处发邮件
        return AliyunMail.sendRegisterMail(name, email, code);
    }

    public DeveloperAdds getDeveloperAdds(Integer did) throws DeveloperAddNotFoundException {
        DeveloperAdds developerAdds = developerDao.getDeveloperAdds(did);
        if (developerAdds == null) {
            throw new DeveloperAddNotFoundException(CONSTANT.ADDS_NOT_FOUND);
        }
        return developerAdds;
    }

    public DeveloperAdds setDeveloperAdds(Integer did, String dProfession, String dBussiness, String dWebsite, String dCountry, String dAddress, String dStreet, String dTel, String dFax) throws DeveloperAddsAddFailedException, DeveloperAddsUpdateFailedException {
        DeveloperAdds developerAdds = developerDao.getDeveloperAdds(did);
        if (developerAdds == null) {
            if (developerDao.insertDeveloperAdds(did, dProfession, dBussiness, dWebsite, dCountry, dAddress, dStreet, dTel, dFax) < 1) {
                throw new DeveloperAddsAddFailedException(CONSTANT.ADDS_ADD_FAILED);
            }
        } else {
            if (developerDao.updateDeveloperAdds(did, dProfession, dBussiness, dWebsite, dCountry, dAddress, dStreet, dTel, dFax) < 1) {
                throw new DeveloperAddsUpdateFailedException(CONSTANT.ADDS_UPDATE_FAILED);
            }
        }
        return developerDao.getDeveloperAdds(did);
    }

    public DeveloperInfo changeName(Integer did, String name, String company) throws DeveloperNameChangeFailedException {
        if (developerDao.changeName(did, name, company) < 1) {
            throw new DeveloperNameChangeFailedException(CONSTANT.NAME_CHANGE_FAILED);
        }
        return developerDao.getDeveloperInfoByEmail(developerDao.getDeveloperById(did).getEmail());
    }

    public DeveloperInfo changePwd(Integer did, String oldPwd, String newPwd) throws PasswordChangeFailedException, DeveloperNotExistsException, UnsupportedEncodingException, NoSuchAlgorithmException, PasswordIncorrectException {
        Developer developer = developerDao.getDeveloperById(did);
        if (developer == null) {
            throw new DeveloperNotExistsException(CONSTANT.DEVELOPER_NOT_EXISTS);
        }
        if (developer.getPwd().equals(MD5.EncoderByMd5(developer.getEmail() + MD5.EncoderByMd5(oldPwd)))) {
            throw new PasswordIncorrectException(CONSTANT.PASSWORD_INCORRECT);
        }
        if (developerDao.changePwd(did, newPwd) < 1) {
            throw new PasswordChangeFailedException(CONSTANT.PASSWORD_CHANGE_FAILED);
        }
        return developerDao.getDeveloperInfoByEmail(developerDao.getDeveloperById(did).getEmail());
    }

    public VerifyCode updateVerifyCodeByUidAndEmail(Integer id, String email, String verifyCode) throws VerifyCodeException {

        VerifyCode verify = verifyDao.getVerifyCodeByDeveloperIdAndEmail(id, email);
        if (verify == null) {
            Integer insertVerify = verifyDao.insertIntoEmailVerifyCode(id, email, verifyCode);
            if (insertVerify < 1) {
                throw new VerifyCodeException(CONSTANT.EMAIL_VERIFY_CODE_INSERT_FAILED);
            }
            return verifyDao.getVerifyCodeByDeveloperIdAndEmail(id, email);
        } else {
            Integer updateVerify = verifyDao.updateEmailCodeByDeveloperIdAndEmail(id, email, verifyCode);
            if (updateVerify < 1) {
                throw new VerifyCodeException(CONSTANT.EMAIL_VERIFY_CODE_UPDATE_FAILED);
            }
            return verifyDao.getVerifyCodeByDeveloperIdAndEmail(id, email);
        }
    }

    public DeveloperInfo activeDeveloperByEmailCode(String email, String code) throws VerifyCodeException, ParseException, DeveloperAccountActiveException {
        VerifyCode verifyCode = verifyDao.getVerifyCodeByEmail(email);
        if (verifyCode == null) {
            throw new VerifyCodeException(CONSTANT.EMAIL_VERIFY_CODE_NOT_EXISTS);
        }
        if ("".equals(verifyCode.getDeveloperEmailCode())) {
            throw new VerifyCodeException(CONSTANT.EMAIL_VERIFY_CODE_NOT_EXISTS);
        }
        if (!verifyCode.getDeveloperEmailCode().equals(code.toUpperCase())) {
            throw new VerifyCodeException(CONSTANT.VERIFY_CODE_INCORRECT);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(verifyCode.getDeveloperEmailCodeSendTime());
        long ts = date.getTime();
        if (System.currentTimeMillis() - ts >= 30 * 60 * 1000) {
            throw new VerifyCodeException(CONSTANT.VERIFY_CODE_TIMEOUT);
        }
        Integer isactive = developerDao.updateDeveloperIsActiveByEmail(email);
        if (isactive < 1) {
            throw new DeveloperAccountActiveException(CONSTANT.DEVELOPER_ACTIVE_FAILED);
        }
        return developerDao.getDeveloperInfoByEmail(email);
    }

    public Developer updateDeveloperPasswordAndName(String name, String email, String password, String tokenStr) throws UnsupportedEncodingException, NoSuchAlgorithmException, DeveloperUpdateFailedException {
        String pwd = MD5.EncoderByMd5(MD5.EncoderByMd5(password));
        if (developerDao.updateDeveloperPasswordAndName(name, email, pwd, tokenStr) < 1) {
            throw new DeveloperUpdateFailedException(CONSTANT.DEVELOPER_PASSWORD_NAME_UPDATE_FAILED);
        }
        return developerDao.getDeveloperByToken(tokenStr, "d_token");
    }

}
