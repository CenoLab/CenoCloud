package com.iot.nero.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午9:46
 */
public class KeySecret implements Serializable {
    private String SecretKey;
    private String Secret;

    public KeySecret() {
    }

    public KeySecret(String secretKey, String secret) {
        SecretKey = secretKey;
        Secret = secret;
    }

    public String getSecretKey() {
        return SecretKey;
    }

    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    public String getSecret() {
        return Secret;
    }

    public void setSecret(String secret) {
        Secret = secret;
    }


    @Override
    public String toString() {
        return "KeySecret{" +
                "SecretKey='" + SecretKey + '\'' +
                ", Secret='" + Secret + '\'' +
                '}';
    }
}
