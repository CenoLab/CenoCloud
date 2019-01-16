package com.iot.nero.parent_log.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/26
 * Time   下午11:57
 */
public class ClientLog implements Serializable {
    private Integer Id;
    private Integer Type;
    private Integer Level;
    private String Log;
    private String CreateTime;

    public ClientLog() {
    }


    public ClientLog(Integer id, Integer type, Integer level, String log, String createTime) {
        Id = id;
        Type = type;
        Level = level;
        Log = log;
        CreateTime = createTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public String getLog() {
        return Log;
    }

    public void setLog(String log) {
        Log = log;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }


    @Override
    public String toString() {
        return "ClientLog{" +
                "Id=" + Id +
                ", Type=" + Type +
                ", Level=" + Level +
                ", Log='" + Log + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
