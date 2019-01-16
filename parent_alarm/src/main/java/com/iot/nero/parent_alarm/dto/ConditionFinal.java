package com.iot.nero.parent_alarm.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/25
 * Time   下午4:03
 */
public class ConditionFinal implements Serializable {
    private Integer id;
    private Integer DId;
    private Integer DIndex;
    private String  Dname;
    private String  Express;
    private Integer RightValueType;
    private String  RightValue;
    private String  CreateTime;

    public ConditionFinal() {
    }

    public ConditionFinal(Integer id, Integer DId, Integer DIndex, String dname, String express, Integer rightValueType, String rightValue, String createTime) {
        this.id = id;
        this.DId = DId;
        this.DIndex = DIndex;
        Dname = dname;
        Express = express;
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

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getExpress() {
        return Express;
    }

    public void setExpress(String express) {
        Express = express;
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
        return "ConditionFinal{" +
                "id=" + id +
                ", DId=" + DId +
                ", DIndex=" + DIndex +
                ", Dname='" + Dname + '\'' +
                ", Express='" + Express + '\'' +
                ", RightValueType=" + RightValueType +
                ", RightValue='" + RightValue + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
