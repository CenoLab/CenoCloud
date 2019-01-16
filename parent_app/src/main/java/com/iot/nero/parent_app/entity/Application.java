package com.iot.nero.parent_app.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/27
 * Time   下午1:46
 */
public class Application implements Serializable {

    private Integer Id;
    private Integer DId;
    private String Name;
    private String Type;
    private String Tech;
    private Integer Trans;
    private String Company;
    private String ProductKey;
    private String ProductSecret;
    private Integer MaxConnect;
    private String CreateTime;
    private String Description;

    public Application() {
    }

    public Application(Integer id, Integer DId, String name, String type, String tech, Integer trans, String company, String productKey, String productSecret, Integer maxConnect, String createTime, String Description) {
        Id = id;
        this.DId = DId;
        Name = name;
        Type = type;
        Tech = tech;
        Trans = trans;
        Company = company;
        ProductKey = productKey;
        ProductSecret = productSecret;
        MaxConnect = maxConnect;
        CreateTime = createTime;
        Description = Description;
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

    public String getProductSecret() {
        return ProductSecret;
    }

    public void setProductSecret(String productSecret) {
        ProductSecret = productSecret;
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

    public void setDescription(String Description) {
        Description = Description;
    }

    @Override
    public String toString() {
        return "Application{" +
                "Id=" + Id +
                ", DId=" + DId +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Tech='" + Tech + '\'' +
                ", Trans='" + Trans + '\'' +
                ", Company='" + Company + '\'' +
                ", ProductKey='" + ProductKey + '\'' +
                ", ProductSecret='" + ProductSecret + '\'' +
                ", MaxConnect='" + MaxConnect + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
