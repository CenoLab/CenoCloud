package com.iot.nero.parent_sso.entity;

import java.io.Serializable;

public class VerifyCode implements Serializable{
    private Integer id;
    private Integer developerId;
    private String  developerEmail;
    private String  developerPhone;
    private String  developerEmailCode;
    private String  developerPhoneCode;
    private String  developerEmailCodeSendTime;
    private String  developerPhoneCodeSendTime;
    private String  developerVerifyCreateTime;

    public VerifyCode() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    public String getDeveloperPhone() {
        return developerPhone;
    }

    public void setDeveloperPhone(String developerPhone) {
        this.developerPhone = developerPhone;
    }

    public String getDeveloperEmailCode() {
        return developerEmailCode;
    }

    public void setDeveloperEmailCode(String developerEmailCode) {
        this.developerEmailCode = developerEmailCode;
    }

    public String getDeveloperPhoneCode() {
        return developerPhoneCode;
    }

    public void setDeveloperPhoneCode(String developerPhoneCode) {
        this.developerPhoneCode = developerPhoneCode;
    }

    public String getDeveloperEmailCodeSendTime() {
        return developerEmailCodeSendTime;
    }

    public void setDeveloperEmailCodeSendTime(String developerEmailCodeSendTime) {
        this.developerEmailCodeSendTime = developerEmailCodeSendTime;
    }

    public String getDeveloperPhoneCodeSendTime() {
        return developerPhoneCodeSendTime;
    }

    public void setDeveloperPhoneCodeSendTime(String developerPhoneCodeSendTime) {
        this.developerPhoneCodeSendTime = developerPhoneCodeSendTime;
    }

    public String getDeveloperVerifyCreateTime() {
        return developerVerifyCreateTime;
    }

    public void setDeveloperVerifyCreateTime(String developerVerifyCreateTime) {
        this.developerVerifyCreateTime = developerVerifyCreateTime;
    }

    @Override
    public String toString() {
        return "VerifyCode{" +
                "id=" + id +
                ", developerId=" + developerId +
                ", developerEmail='" + developerEmail + '\'' +
                ", developerPhone='" + developerPhone + '\'' +
                ", developerEmailCode='" + developerEmailCode + '\'' +
                ", developerPhoneCode='" + developerPhoneCode + '\'' +
                ", developerEmailCodeSendTime='" + developerEmailCodeSendTime + '\'' +
                ", developerPhoneCodeSendTime='" + developerPhoneCodeSendTime + '\'' +
                ", developerVerifyCreateTime='" + developerVerifyCreateTime + '\'' +
                '}';
    }
}
