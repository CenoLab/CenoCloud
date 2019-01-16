package com.iot.nero.utils.verifycode.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/8/16
 * Time   7:47 PM
 */
public class ImgVerify  implements Serializable {
    private String imgBase64;
    private String jsession;


    public ImgVerify() {
    }


    public ImgVerify(String imgBase64, String jsession) {
        this.imgBase64 = imgBase64;
        this.jsession = jsession;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public String getJsession() {
        return jsession;
    }

    public void setJsession(String jsession) {
        this.jsession = jsession;
    }

    @Override
    public String toString() {
        return "ImgVerify{" +
                "imgBase64='" + imgBase64 + '\'' +
                ", jsession='" + jsession + '\'' +
                '}';
    }
}
