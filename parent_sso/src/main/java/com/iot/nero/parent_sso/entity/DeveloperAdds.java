package com.iot.nero.parent_sso.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午3:42
 */
public class DeveloperAdds implements Serializable {


    private Integer  Id;
    private  Integer DId;
    private String DProfession;
    private String DBussiness;
    private String DWebsite;
    private String DCountry;
    private String DAddress;
    private String DStreet;
    private String DTel;
    private String DFax;
    private String DAddsCreateTime;

    public DeveloperAdds() {
    }

    public DeveloperAdds(Integer id, Integer DId, String DProfession, String DBussiness, String DWebsite, String DCountry, String DAddress, String DStreet, String DTel, String DFax, String DAddsCreateTime) {
        Id = id;
        this.DId = DId;
        this.DProfession = DProfession;
        this.DBussiness = DBussiness;
        this.DWebsite = DWebsite;
        this.DCountry = DCountry;
        this.DAddress = DAddress;
        this.DStreet = DStreet;
        this.DTel = DTel;
        this.DFax = DFax;
        this.DAddsCreateTime = DAddsCreateTime;
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

    public String getDProfession() {
        return DProfession;
    }

    public void setDProfession(String DProfession) {
        this.DProfession = DProfession;
    }

    public String getDBussiness() {
        return DBussiness;
    }

    public void setDBussiness(String DBussiness) {
        this.DBussiness = DBussiness;
    }

    public String getDWebsite() {
        return DWebsite;
    }

    public void setDWebsite(String DWebsite) {
        this.DWebsite = DWebsite;
    }

    public String getDCountry() {
        return DCountry;
    }

    public void setDCountry(String DCountry) {
        this.DCountry = DCountry;
    }

    public String getDAddress() {
        return DAddress;
    }

    public void setDAddress(String DAddress) {
        this.DAddress = DAddress;
    }

    public String getDStreet() {
        return DStreet;
    }

    public void setDStreet(String DStreet) {
        this.DStreet = DStreet;
    }

    public String getDTel() {
        return DTel;
    }

    public void setDTel(String DTel) {
        this.DTel = DTel;
    }

    public String getDFax() {
        return DFax;
    }

    public void setDFax(String DFax) {
        this.DFax = DFax;
    }

    public String getDAddsCreateTime() {
        return DAddsCreateTime;
    }

    public void setDAddsCreateTime(String DAddsCreateTime) {
        this.DAddsCreateTime = DAddsCreateTime;
    }

    @Override
    public String toString() {
        return "DeveloperAdds{" +
                "Id=" + Id +
                ", DId=" + DId +
                ", DProfession='" + DProfession + '\'' +
                ", DBussiness='" + DBussiness + '\'' +
                ", DWebsite='" + DWebsite + '\'' +
                ", DCountry='" + DCountry + '\'' +
                ", DAddress='" + DAddress + '\'' +
                ", DStreet='" + DStreet + '\'' +
                ", DTel='" + DTel + '\'' +
                ", DFax='" + DFax + '\'' +
                ", DAddsCreateTime='" + DAddsCreateTime + '\'' +
                '}';
    }
}
