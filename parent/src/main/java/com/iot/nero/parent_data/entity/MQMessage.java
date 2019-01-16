package com.iot.nero.parent_data.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   上午10:13
 */
public class MQMessage implements Serializable {
    private Integer  Id;
    private Integer AId;
    private String MFrom;
    private String MTo;
    private String MQos;
    private String MMessage;
    private String MCreateTime;


    public MQMessage() {
    }

    public MQMessage(Integer id, Integer AId, String MFrom, String MTo, String MQos, String MMessage, String MCreateTime) {
        Id = id;
        this.AId = AId;
        this.MFrom = MFrom;
        this.MTo = MTo;
        this.MQos = MQos;
        this.MMessage = MMessage;
        this.MCreateTime = MCreateTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getAId() {
        return AId;
    }

    public void setAId(Integer AId) {
        this.AId = AId;
    }

    public String getMFrom() {
        return MFrom;
    }

    public void setMFrom(String MFrom) {
        this.MFrom = MFrom;
    }

    public String getMTo() {
        return MTo;
    }

    public void setMTo(String MTo) {
        this.MTo = MTo;
    }

    public String getMQos() {
        return MQos;
    }

    public void setMQos(String MQos) {
        this.MQos = MQos;
    }

    public String getMMessage() {
        return MMessage;
    }

    public void setMMessage(String MMessage) {
        this.MMessage = MMessage;
    }

    public String getMCreateTime() {
        return MCreateTime;
    }

    public void setMCreateTime(String MCreateTime) {
        this.MCreateTime = MCreateTime;
    }

    @Override
    public String toString() {
        return "MQMessage{" +
                "Id=" + Id +
                ", AId=" + AId +
                ", MFrom='" + MFrom + '\'' +
                ", MTo='" + MTo + '\'' +
                ", MQos='" + MQos + '\'' +
                ", MMessage='" + MMessage + '\'' +
                ", MCreateTime='" + MCreateTime + '\'' +
                '}';
    }
}
