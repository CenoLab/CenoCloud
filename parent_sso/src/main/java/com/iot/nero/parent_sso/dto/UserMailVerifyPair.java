package com.iot.nero.parent_sso.dto;

import java.io.Serializable;

public class UserMailVerifyPair implements Serializable {

    private String name;
    private String email;
    private String code;

    public UserMailVerifyPair() {
    }

    public UserMailVerifyPair(String name, String email, String code) {
        this.name = name;
        this.email = email;
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserMailVerifyPair{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
