package com.iot.nero.parent_facade.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午10:08
 */
public class Comment implements Serializable {

    private Integer id;
    private Integer authorId;
    private Integer forType;
    private Integer forId;
    private String  content;
    private Integer starCount;
    private Integer del;
    private String  modifyTime ;
    private String  createTime;

    public Comment() {
    }

    public Comment(Integer id, Integer authorId, Integer forType, Integer forId, String content, Integer starCount, Integer del, String modifyTime, String createTime) {
        this.id = id;
        this.authorId = authorId;
        this.forType = forType;
        this.forId = forId;
        this.content = content;
        this.starCount = starCount;
        this.del = del;
        this.modifyTime = modifyTime;
        this.createTime = createTime;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
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

    public Integer getForType() {
        return forType;
    }

    public void setForType(Integer forType) {
        this.forType = forType;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", forType=" + forType +
                ", forId=" + forId +
                ", content='" + content + '\'' +
                ", starCount=" + starCount +
                ", del=" + del +
                ", modifyTime='" + modifyTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
