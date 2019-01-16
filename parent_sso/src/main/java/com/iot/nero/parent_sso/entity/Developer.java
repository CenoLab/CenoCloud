package com.iot.nero.parent_sso.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午4:18
 */
public class Developer  implements Serializable {
    private Integer Id;
    private String Name;
    private String Company;
    private String Email;
    private String Phone;
    private String Pwd;
    private String Token;
    private String AndroidToken;
    private String IphoneToken;
    private String AuthToken;
    private Integer IsAndroidOnline;
    private Integer IsIphoneOnline;
    private String CreateTime;
    private Integer IsActive;


    public Developer() {
    }

    public Developer(Integer id, String name, String company, String email, String phone, String pwd, String token, String androidToken, String iphoneToken, String authToken, Integer isAndroidOnline, Integer isIphoneOnline, String createTime, Integer isActive) {
        Id = id;
        Name = name;
        Company = company;
        Email = email;
        Phone = phone;
        Pwd = pwd;
        Token = token;
        AndroidToken = androidToken;
        IphoneToken = iphoneToken;
        AuthToken = authToken;
        IsAndroidOnline = isAndroidOnline;
        IsIphoneOnline = isIphoneOnline;
        CreateTime = createTime;
        IsActive = isActive;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getAndroidToken() {
        return AndroidToken;
    }

    public void setAndroidToken(String androidToken) {
        AndroidToken = androidToken;
    }

    public String getIphoneToken() {
        return IphoneToken;
    }

    public void setIphoneToken(String iphoneToken) {
        IphoneToken = iphoneToken;
    }

    public String getAuthToken() {
        return AuthToken;
    }

    public void setAuthToken(String authToken) {
        AuthToken = authToken;
    }

    public Integer getIsAndroidOnline() {
        return IsAndroidOnline;
    }

    public void setIsAndroidOnline(Integer isAndroidOnline) {
        IsAndroidOnline = isAndroidOnline;
    }

    public Integer getIsIphoneOnline() {
        return IsIphoneOnline;
    }

    public void setIsIphoneOnline(Integer isIphoneOnline) {
        IsIphoneOnline = isIphoneOnline;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public Integer getIsActive() {
        return IsActive;
    }

    public void setIsActive(Integer isActive) {
        IsActive = isActive;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Company='" + Company + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Pwd='" + Pwd + '\'' +
                ", Token='" + Token + '\'' +
                ", AndroidToken='" + AndroidToken + '\'' +
                ", IphoneToken='" + IphoneToken + '\'' +
                ", AuthToken='" + AuthToken + '\'' +
                ", IsAndroidOnline=" + IsAndroidOnline +
                ", IsIphoneOnline=" + IsIphoneOnline +
                ", CreateTime='" + CreateTime + '\'' +
                ", IsActive=" + IsActive +
                '}';
    }
}
