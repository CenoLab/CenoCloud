package com.iot.nero.parent_alarm.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/17
 * Time   下午4:50
 */
public class Express implements Serializable {
    private Integer Id;
    private String Operator;
    private String CreateTime;


    public Express() {
    }

    public Express(Integer id, String operator, String createTime) {
        Id = id;
        Operator = operator;
        CreateTime = createTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOpeator() {
        return Operator;
    }

    public void setOpeator(String opeator) {
        Operator = opeator;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Express{" +
                "Id=" + Id +
                ", Operator='" + Operator + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
