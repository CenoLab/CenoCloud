package com.iot.nero.parent_data.entity;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/6
 * Time   下午3:15
 */
public class SysConfig {
    private Integer id;
    private String key;
    private String value;

    public SysConfig(Integer id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public SysConfig() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SysConfig{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
