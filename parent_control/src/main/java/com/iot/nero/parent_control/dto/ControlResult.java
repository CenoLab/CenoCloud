package com.iot.nero.parent_control.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/1
 * Time   下午4:49
 */
public class ControlResult implements Serializable {
    private Map<String,List<Object>> control;

    public ControlResult() {
    }

    public ControlResult(Map<String, List<Object>> control) {
        this.control = control;
    }

    public Map<String, List<Object>> getControl() {
        return control;
    }

    public void setControl(Map<String, List<Object>> control) {
        this.control = control;
    }

    @Override
    public String toString() {
        return "ControlResult{" +
                "control=" + control +
                '}';
    }
}
