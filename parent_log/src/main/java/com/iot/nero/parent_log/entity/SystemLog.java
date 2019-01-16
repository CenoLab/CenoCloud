package com.iot.nero.parent_log.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/9/1
 * Time   下午7:19
 */
public class SystemLog implements Serializable {
    private Long type;
    private String content;

    public SystemLog() {
    }

    public SystemLog(Long type, String content) {
        this.type = type;
        this.content = content;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "SystemLog{" +
                "type=" + type +
                ", content='" + content + '\'' +
                '}';
    }
}
