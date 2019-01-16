package com.iot.nero.parent_resources.entity;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/6/2
 * Time   下午4:42
 */
public class FileLimit {
    private Integer id;
    private String type;
    private String systemIdentification;
    private String del;
    private String createTime;
    private String modifyTime;


    public FileLimit() {
    }

    public FileLimit(Integer id, String type, String systemIdentification, String del, String createTime, String modifyTime) {
        this.id = id;
        this.type = type;
        this.systemIdentification = systemIdentification;
        this.del = del;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSystemIdentification() {
        return systemIdentification;
    }

    public void setSystemIdentification(String systemIdentification) {
        this.systemIdentification = systemIdentification;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "FileLimit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", systemIdentification='" + systemIdentification + '\'' +
                ", del='" + del + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
