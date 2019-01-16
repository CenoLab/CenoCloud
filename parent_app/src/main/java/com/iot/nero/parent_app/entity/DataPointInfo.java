package com.iot.nero.parent_app.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   上午11:59
 */
public class DataPointInfo implements Serializable {


    private Integer AppId;
    private String Name;
    private String Type;
    private Integer Access;

    public DataPointInfo() {
    }

    public DataPointInfo(Integer appId, String name, String type, Integer access) {
        AppId = appId;
        Name = name;
        Type = type;
        Access = access;
    }

    public Integer getAppId() {
        return AppId;
    }

    public void setAppId(Integer appId) {
        AppId = appId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Integer getAccess() {
        return Access;
    }

    public void setAccess(Integer access) {
        Access = access;
    }

    @Override
    public String toString() {
        return "DataPointInfo{" +
                "AppId=" + AppId +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Access=" + Access +
                '}';
    }
}
