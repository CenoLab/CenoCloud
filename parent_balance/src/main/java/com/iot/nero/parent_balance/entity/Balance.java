package com.iot.nero.parent_balance.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   下午12:16
 */
public class Balance implements Serializable {
    private Integer Id;
    private Integer DId;
    private Integer TotalConnCount;
    private Integer RestConnCount;
    private Integer TotalMoney;
    private Integer RestMoney;
    private String CreateTime;

    public Balance() {
    }

    public Balance(Integer id, Integer AId, Integer totalConnCount, Integer restConnCount, Integer totalMoney, Integer restMoney, String createTime) {
        Id = id;
        this.DId = AId;
        TotalConnCount = totalConnCount;
        RestConnCount = restConnCount;
        TotalMoney = totalMoney;
        RestMoney = restMoney;
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

    public void setDId(Integer AId) {
        this.DId = AId;
    }

    public Integer getTotalConnCount() {
        return TotalConnCount;
    }

    public void setTotalConnCount(Integer totalConnCount) {
        TotalConnCount = totalConnCount;
    }

    public Integer getRestConnCount() {
        return RestConnCount;
    }

    public void setRestConnCount(Integer restConnCount) {
        RestConnCount = restConnCount;
    }

    public Integer getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        TotalMoney = totalMoney;
    }

    public Integer getRestMoney() {
        return RestMoney;
    }

    public void setRestMoney(Integer restMoney) {
        RestMoney = restMoney;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "Id=" + Id +
                ", DId=" + DId +
                ", TotalConnCount=" + TotalConnCount +
                ", RestConnCount=" + RestConnCount +
                ", TotalMoney=" + TotalMoney +
                ", RestMoney=" + RestMoney +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
