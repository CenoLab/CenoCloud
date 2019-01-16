package com.iot.nero.utils.sha;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午9:53
 */
public class SHA {

    public static String EncoderBySha(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(str.getBytes());
        return sha.digest().toString();
    }

}
