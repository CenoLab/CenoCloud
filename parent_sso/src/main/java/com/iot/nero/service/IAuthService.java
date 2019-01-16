package com.iot.nero.service;

import com.iot.nero.constant.ClientType;
import com.iot.nero.dto.Result;
import com.iot.nero.parent_balance.entity.Balance;
import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.parent_sso.entity.DeveloperAdds;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午4:15
 */
public interface IAuthService {

    /**
     * 开发者登录
     * @param phoneOrEmail
     * @param pwd
     * @param clientType
     * @return
     */
    Result<DeveloperInfo> login(String phoneOrEmail, String pwd, ClientType clientType);

    /**
     * 认证token是否正确
     * @param did
     * @param token
     * @param clientType
     * @return
     */
    Result<DeveloperInfo> auth(Integer did, String token, ClientType clientType);

    /**
     * 获取用户消费信息
     * @param id
     * @param token
     * @param clientType
     * @return
     */
    Result<Balance> getBalance(Integer id, String token, ClientType clientType);


    /**
     * 获取开发者附加信息
     * @param id
     * @param token
     * @param clientType
     * @return
     */
    Result<DeveloperAdds> getDeveloperAdds(Integer id, String token, ClientType clientType);

    /**
     * 设置开发者附加信息
     * @param id
     * @param token
     * @param dProfession
     * @param dBussiness
     * @param dWebsite
     * @param dCountry
     * @param dAddress
     * @param dStreet
     * @param dTel
     * @param dFax
     * @param clientType
     * @return
     */
    Result<DeveloperAdds> setDeveloperAdds(Integer id, String token, String dProfession, String dBussiness, String dWebsite, String dCountry, String dAddress, String dStreet, String dTel, String dFax, ClientType clientType);

    /**
     * 修改开发者昵称
     * @param id
     * @param token
     * @param name
     * @param company
     * @param clientType
     * @return
     */
    Result<DeveloperInfo> changeName(Integer id, String token, String name, String company, ClientType clientType);

    /**
     * 修改头像
     * @param id
     * @param token
     * @param filename
     * @param avatar
     * @param clientType
     * @return
     */
    Result<DeveloperInfo> changeAvatar(Integer id, String token, String filename, MultipartFile avatar, ClientType clientType);

    /**
     * 修改密码
     * @param id
     * @param token
     * @param oldPwd
     * @param newPwd
     * @param clientType
     * @return
     */
    Result<DeveloperInfo> changePwd(Integer id, String token, String oldPwd, String newPwd, ClientType clientType);


    /**
     * 通过邮箱验证码激活用户
     * @param email
     * @param code
     * @return
     */
    Result<DeveloperInfo> activeByEmailCode(String email, String code);

    /**
     * 通过手机验证码激活用户
     * @param phone
     * @param code
     * @return
     */
    Result<DeveloperInfo> activeByPhoneCode(String phone, String code);

    /**
     * 通过邮箱注册
     * @param name
     * @param email
     * @param password
     * @return
     */
    Result<DeveloperInfo> registerByEmail(String name, String email, String password);


    /**
     * 通过手机注册
     * @param name
     * @param phone
     * @param password
     * @return
     */
    Result<DeveloperInfo> registerByPhone(String name, String phone, String password);
}
