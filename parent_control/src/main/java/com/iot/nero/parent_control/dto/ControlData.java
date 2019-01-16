package com.iot.nero.parent_control.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/1
 * Time   下午7:32
 */
public class ControlData implements Serializable {
    private Map<String,List<Object>> data;

    public ControlData(Map<String, List<Object>> data) {
        this.data = data;
    }

    public ControlData() {
    }

    public Map<String, List<Object>> getData() {
        return data;
    }

    public void setData(Map<String, List<Object>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ControlData{" +
                "data=" + data +
                '}';
    }
}
