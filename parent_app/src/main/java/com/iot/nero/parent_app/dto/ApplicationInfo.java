package com.iot.nero.parent_app.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   上午10:50
 */
public class ApplicationInfo implements Serializable {

    private Integer DId;
    private String Name;
    private String Type;
    private String Tech;
    private Integer Trans;
    private String Company;
    private Integer MaxConnect;
    private String Description;

    public ApplicationInfo() {
    }

    public ApplicationInfo(Integer DId, String name, String type, String tech, Integer trans, String company, Integer maxConnect, String desc) {
        this.DId = DId;
        Name = name;
        Type = type;
        Tech = tech;
        Trans = trans;
        Company = company;
        MaxConnect = maxConnect;
        Description = desc;
    }

    public Integer getDId() {
        return DId;
    }

    public void setDId(Integer DId) {
        this.DId = DId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTech() {
        return Tech;
    }

    public void setTech(String tech) {
        Tech = tech;
    }

    public Integer getTrans() {
        return Trans;
    }

    public void setTrans(Integer trans) {
        Trans = trans;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public Integer getMaxConnect() {
        return MaxConnect;
    }

    public void setMaxConnect(Integer maxConnect) {
        MaxConnect = maxConnect;
    }

    public String getDesc() {
        return Description;
    }

    public void setDesc(String desc) {
        Description = desc;
    }

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "DId=" + DId +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Tech='" + Tech + '\'' +
                ", Trans='" + Trans + '\'' +
                ", Company='" + Company + '\'' +
                ", MaxConnect='" + MaxConnect + '\'' +
                ", Desc='" + Description + '\'' +
                '}';
    }
}
