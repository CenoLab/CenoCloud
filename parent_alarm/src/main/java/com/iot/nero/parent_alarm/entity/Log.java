package com.iot.nero.parent_alarm.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/17
 * Time   下午5:14
 */
public class Log implements Serializable {
    private Integer Id;
    private Integer DId;
    private Integer CId;
    private String CreateTime;


    public Log() {
    }

    public Log(Integer id, Integer DId, Integer CId, String createTime) {
        Id = id;
        this.DId = DId;
        this.CId = CId;
        CreateTime = createTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getDId() {
        return DId;
    }

    public void setDId(Integer DId) {
        this.DId = DId;
    }

    public Integer getCId() {
        return CId;
    }

    public void setCId(Integer CId) {
        this.CId = CId;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "Id=" + Id +
                ", DId=" + DId +
                ", CId=" + CId +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
