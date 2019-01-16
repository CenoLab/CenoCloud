package com.iot.nero.parent_alarm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/17
 * Time   下午4:56
 */
public class Condition implements Serializable {

    private Integer id;
    private Integer DId;
    private Integer  DIndex;
    private Integer ExpressId;
    private Integer RightValueType;
    private String RightValue;
    private String CreateTime;

    public Condition() {
    }

    public Condition(Integer id, Integer DId, Integer DIndex, Integer expressId, Integer rightValueType, String rightValue, String createTime) {
        this.id = id;
        this.DId = DId;
        this.DIndex = DIndex;
        ExpressId = expressId;
        RightValueType = rightValueType;
        RightValue = rightValue;
        CreateTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDId() {
        return DId;
    }

    public void setDId(Integer DId) {
        this.DId = DId;
    }

    public Integer getDIndex() {
        return DIndex;
    }

    public void setDIndex(Integer DIndex) {
        this.DIndex = DIndex;
    }

    public Integer getExpressId() {
        return ExpressId;
    }

    public void setExpressId(Integer expressId) {
        ExpressId = expressId;
    }

    public Integer getRightValueType() {
        return RightValueType;
    }

    public void setRightValueType(Integer rightValueType) {
        RightValueType = rightValueType;
    }

    public String getRightValue() {
        return RightValue;
    }

    public void setRightValue(String rightValue) {
        RightValue = rightValue;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", DId=" + DId +
                ", DIndex=" + DIndex +
                ", ExpressId=" + ExpressId +
                ", RightValueType=" + RightValueType +
                ", RightValue='" + RightValue + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
