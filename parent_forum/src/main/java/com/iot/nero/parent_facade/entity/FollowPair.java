package com.iot.nero.parent_facade.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   上午8:54
 */
public class FollowPair implements Serializable {
    private Integer id;
    private Integer authorId;
    private Integer followId;
    private Integer del;
    private String modifyTime;
    private String reateTime;


    public FollowPair() {
    }

    public FollowPair(Integer id, Integer authorId, Integer followId, Integer del, String modifyTime, String reateTime) {
        this.id = id;
        this.authorId = authorId;
        this.followId = followId;
        this.del = del;
        this.modifyTime = modifyTime;
        this.reateTime = reateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getReateTime() {
        return reateTime;
    }

    public void setReateTime(String reateTime) {
        this.reateTime = reateTime;
    }

    @Override
    public String toString() {
        return "FollowPair{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", followId=" + followId +
                ", del=" + del +
                ", modifyTime='" + modifyTime + '\'' +
                ", reateTime='" + reateTime + '\'' +
                '}';
    }
}
