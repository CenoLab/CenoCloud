package com.iot.nero.parent_data.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/27
 * Time   下午4:59
 */
public class DataResult implements Serializable {
    private String appName;
    private String clientID;
    private String dataPointName;
    private Integer index;
    private String method;
    private String fromTime;
    private String toTime;
    private Object value;

    public DataResult() {
    }

    public DataResult(String appName, String clientID, String dataPointName, Integer index, String method, String fromTime, String toTime, Object value) {
        this.appName = appName;
        this.clientID = clientID;
        this.dataPointName = dataPointName;
        this.index = index;
        this.method = method;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.value = value;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getDataPointName() {
        return dataPointName;
    }

    public void setDataPointName(String dataPointName) {
        this.dataPointName = dataPointName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "appName='" + appName + '\'' +
                ", clientID='" + clientID + '\'' +
                ", dataPointName='" + dataPointName + '\'' +
                ", index=" + index +
                ", method='" + method + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", value=" + value +
                '}';
    }
}
