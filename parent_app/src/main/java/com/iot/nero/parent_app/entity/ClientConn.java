package com.iot.nero.parent_app.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   上午11:01
 */
public class ClientConn implements Serializable {
    private Integer Id;
    private Integer AId;
    private String ClientId;
    private Integer IsOnline;
    private String LastOnlineTime;
    private String LastOfflineTime;
    private String CreateTime;
    private Integer ConnCount;

    public ClientConn() {
    }

    public ClientConn(Integer id, Integer AId, String clientId, Integer isOnline, String lastOnlineTime, String lastOfflineTime, String createTime, Integer connCount) {
        Id = id;
        this.AId = AId;
        ClientId = clientId;
        IsOnline = isOnline;
        LastOnlineTime = lastOnlineTime;
        LastOfflineTime = lastOfflineTime;
        CreateTime = createTime;
        ConnCount = connCount;
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

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    public Integer getIsOnline() {
        return IsOnline;
    }

    public void setIsOnline(Integer isOnline) {
        IsOnline = isOnline;
    }

    public String getLastOnlineTime() {
        return LastOnlineTime;
    }

    public void setLastOnlineTime(String lastOnlineTime) {
        LastOnlineTime = lastOnlineTime;
    }

    public String getLastOfflineTime() {
        return LastOfflineTime;
    }

    public void setLastOfflineTime(String lastOfflineTime) {
        LastOfflineTime = lastOfflineTime;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public Integer getConnCount() {
        return ConnCount;
    }

    public void setConnCount(Integer connCount) {
        ConnCount = connCount;
    }

    @Override
    public String toString() {
        return "ClientConn{" +
                "Id=" + Id +
                ", AId=" + AId +
                ", ClientId='" + ClientId + '\'' +
                ", IsOnline=" + IsOnline +
                ", LastOnlineTime='" + LastOnlineTime + '\'' +
                ", LastOfflineTime='" + LastOfflineTime + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", ConnCount=" + ConnCount +
                '}';
    }
}
