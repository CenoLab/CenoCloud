package com.iot.nero.facade_sso.dao;

import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.parent_sso.entity.Developer;
import com.iot.nero.parent_sso.entity.DeveloperAdds;
import org.apache.ibatis.annotations.Param;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午4:16
 */
public interface DeveloperDao {
    /**
     * 查询开发者详细信息从数据库
     * @param email
     * @return DeveloperInfo
     */
    Developer getDeveloperByEmail(@Param("email") String email);

    Developer getDeveloperByPhone(@Param("phone")String phone);
    /**
     *  查询用户常规信息
     * @param email
     * @return
     */
    DeveloperInfo getDeveloperInfoByEmail(@Param("email") String email);

    /**
     * 通过token查询用户信息
     * @param token
     * @param whichToken
     * @return
     */
    Developer getDeveloperByToken(@Param("tt") String token, @Param("which_token") String whichToken);

    /**
     * 更新开发者token
     * @param email
     * @param token
     * @param whichToken
     * @return
     */
    Integer updateDeveloperToken(@Param("phoneoremail") String email,
                                 @Param("token") String token, @Param("which_token") String whichToken);


    /**
     * 通过uid获取用户信息
     * @param uid
     * @return
     */
    Developer getDeveloperById(@Param("uid") Integer uid);

    /**
     * 用户注册添加
     * @param email
     * @param pwd
     * @param token
     * @return
     */
    Integer addDeveloperBase(@Param("name") String name,
                             @Param("email") String email,
                             @Param("pwd") String pwd,
                             @Param("token") String token);

    /**
     * 已存在未激活邮箱更新
     * @param email
     * @param pwd
     * @param token
     * @return
     */
    Integer updateDeveloperBase(@Param("name") String name,
                                @Param("email") String email,
                                @Param("pwd") String pwd,
                                @Param("token") String token);


    /**
     * 获取开发者附加信息
     * @param did
     * @return
     */
    DeveloperAdds getDeveloperAdds(@Param("did") Integer did);

    /**
     * 插入附加信息
     * @param did
     * @param dProfession
     * @param dBussiness
     * @param dWebsite
     * @param dCountry
     * @param dAddress
     * @param dStreet
     * @param dTel
     * @param dFax
     * @return
     */
    Integer insertDeveloperAdds(@Param("did") Integer did,
                                @Param("dprofession") String dProfession,
                                @Param("dbussiness") String dBussiness,
                                @Param("dwebsite") String dWebsite,
                                @Param("dcountry") String dCountry,
                                @Param("daddress") String dAddress,
                                @Param("dstreet") String dStreet,
                                @Param("dtel") String dTel,
                                @Param("dfax") String dFax);

    /**
     * 更新附加信息
     * @param did
     * @param dProfession
     * @param dBussiness
     * @param dWebsite
     * @param dCountry
     * @param dAddress
     * @param dStreet
     * @param dTel
     * @param dFax
     * @return
     */
    Integer updateDeveloperAdds(@Param("did") Integer did,
                                @Param("dprofession") String dProfession,
                                @Param("dbussiness") String dBussiness,
                                @Param("dwebsite") String dWebsite,
                                @Param("dcompany") String dCountry,
                                @Param("daddress") String dAddress,
                                @Param("dstreet") String dStreet,
                                @Param("dtel") String dTel,
                                @Param("dfax") String dFax);
    /**
     * 修改开发者信息
     * @param did
     * @param name
     * @param company
     * @return
     */
    Integer changeName(@Param("did") Integer did,
                       @Param("name") String name,
                       @Param("company") String company);

    /**
     * 修改密码
     * @param did
     * @param newPwd
     * @return
     */
    Integer changePwd(
            @Param("did") Integer did,
            @Param("pwd") String newPwd);

    /**
     * 激活
     * @return
     */
    Integer updateDeveloperIsActiveByEmail(@Param("email") String email);

    /**
     * 更新密码，延迟注册
     * @param name
     * @param email
     * @param pwd
     * @param tokenStr
     * @return
     */
    Integer updateDeveloperPasswordAndName(@Param("name") String name, @Param("email") String email, @Param("pwd") String pwd, @Param("token") String tokenStr);
}
