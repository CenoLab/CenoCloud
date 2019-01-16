package com.iot.nero.parent_app.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   下午5:26
 */
public class ApplicationResult implements Serializable {
    private Integer Id;
    private Integer DId;
    private String Name;
    private String Type;
    private String Tech;
    private Integer Trans;
    private String Company;
    private String ProductKey;
    private Integer MaxConnect;
    private String CreateTime;
    private String Description;
    private Integer CurrentConn;
    private Integer CurrentOnline;
    private Integer MessageCount;

    public ApplicationResult() {
    }

    public ApplicationResult(Integer id, Integer DId, String name, String type, String tech, Integer trans, String company, String productKey, Integer maxConnect, String createTime, String description, Integer currentConn, Integer currentOnline, Integer messageCount) {
        Id = id;
        this.DId = DId;
        Name = name;
        Type = type;
        Tech = tech;
        Trans = trans;
        Company = company;
        ProductKey = productKey;
        MaxConnect = maxConnect;
        CreateTime = createTime;
        Description = description;
        CurrentConn = currentConn;
        CurrentOnline = currentOnline;
        MessageCount = messageCount;
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

    public String getProductKey() {
        return ProductKey;
    }

    public void setProductKey(String productKey) {
        ProductKey = productKey;
    }

    public Integer getMaxConnect() {
        return MaxConnect;
    }

    public void setMaxConnect(Integer maxConnect) {
        MaxConnect = maxConnect;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getCurrentConn() {
        return CurrentConn;
    }

    public void setCurrentConn(Integer currentConn) {
        CurrentConn = currentConn;
    }

    public Integer getCurrentOnline() {
        return CurrentOnline;
    }

    public void setCurrentOnline(Integer currentOnline) {
        CurrentOnline = currentOnline;
    }

    public Integer getMessageCount() {
        return MessageCount;
    }

    public void setMessageCount(Integer messageCount) {
        MessageCount = messageCount;
    }

    @Override
    public String toString() {
        return "ApplicationResult{" +
                "Id=" + Id +
                ", DId=" + DId +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Tech='" + Tech + '\'' +
                ", Trans=" + Trans +
                ", Company='" + Company + '\'' +
                ", ProductKey='" + ProductKey + '\'' +
                ", MaxConnect=" + MaxConnect +
                ", CreateTime='" + CreateTime + '\'' +
                ", Description='" + Description + '\'' +
                ", CurrentConn=" + CurrentConn +
                ", CurrentOnline=" + CurrentOnline +
                ", MessageCount=" + MessageCount +
                '}';
    }
}