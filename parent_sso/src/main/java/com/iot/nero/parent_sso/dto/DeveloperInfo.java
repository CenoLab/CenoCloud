package com.iot.nero.parent_sso.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午4:33
 */
public class DeveloperInfo  implements Serializable{
    private Integer Id;
    private String Name;
    private String Company;
    private String Email;
    private String Phone;
    private String Token;
    private String CreateTime;

    public DeveloperInfo() {
    }

    public DeveloperInfo(Integer id, String name, String company, String email, String phone, String token, String createTime) {
        this.Id = id;
        Name = name;
        Company = company;
        Email = email;
        Phone = phone;
        Token = token;
        CreateTime = createTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "DeveloperInfo{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Company='" + Company + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Token='" + Token + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }
}
