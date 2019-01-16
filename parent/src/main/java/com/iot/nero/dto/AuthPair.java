package com.iot.nero.dto;

import com.iot.nero.constant.ClientType;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/23
 * Time   上午10:05
 */
public class AuthPair implements Serializable {
    private Integer id;
    private String token;
    private ClientType clientType;

    public AuthPair() {
    }

    public AuthPair(Integer id, String token, ClientType clientType) {
        this.id = id;
        this.token = token;
        this.clientType = clientType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "AuthPair{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", clientType=" + clientType +
                '}';
    }
}
