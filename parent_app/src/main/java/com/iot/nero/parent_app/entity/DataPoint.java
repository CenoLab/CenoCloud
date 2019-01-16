package com.iot.nero.parent_app.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   上午10:01
 */
public class DataPoint implements Serializable {

    private Integer Id;
    private Integer AppId;
    private String Name;
    private String Type;
    private Integer Access;
    private String CreateTime;

    public DataPoint() {
    }

    public DataPoint(Integer id, Integer appId, String name, String type, Integer access, String createTime) {
        Id = id;
        AppId = appId;
        Name = name;
        Type = type;
        Access = access;
        CreateTime = createTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "Id=" + Id +
                ", AppId=" + AppId +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Access=" + Access +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
