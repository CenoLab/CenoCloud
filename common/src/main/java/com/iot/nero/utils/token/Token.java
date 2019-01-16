package com.iot.nero.utils.token;

import com.iot.nero.utils.md5.MD5;
import com.iot.nero.utils.rendom.RandomString;
import com.iot.nero.utils.sha.SHA;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午9:41
 */
public class Token implements Serializable {
    private String key;
    private TOKEN_TYPE type;

    public Token(String key, TOKEN_TYPE type) {
        this.key = key;
        this.type = type;
    }

    public Token() {
        this.type = TOKEN_TYPE.MD5;
    }

    public Token(String key) {
        this.key = key;
        this.type = TOKEN_TYPE.MD5;
    }

    public String genCode() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Date date = new Date();

        switch (this.type){
            case MD5:
                return MD5.EncoderByMd5(MD5.EncoderByMd5(String.valueOf(date.getTime()))+ RandomString.getRandomString(64));
            case SHA:
                return SHA.EncoderBySha(SHA.EncoderBySha(String.valueOf(date.getTime()))+ RandomString.getRandomString(64));
            default:
                return MD5.EncoderByMd5(MD5.EncoderByMd5(String.valueOf(date.getTime()))+ RandomString.getRandomString(64));
        }
    }
}
