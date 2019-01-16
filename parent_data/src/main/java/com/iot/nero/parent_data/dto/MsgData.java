package com.iot.nero.parent_data.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/25
 * Time   上午12:02
 */
public class MsgData implements Serializable {

    private Map<String,List<Object>> d;
    private String ts;

    public MsgData() {
    }

    public MsgData(Map<String, List<Object>> d, String ts) {
        this.d = d;
        this.ts = ts;
    }

    public Map<String, List<Object>> getD() {
        return d;
    }

    public void setD(Map<String, List<Object>> d) {
        this.d = d;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "MsgData{" +
                "d=" + d +
                ", ts='" + ts + '\'' +
                '}';
    }
}
