package com.iot.nero.parent_facade.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   上午9:18
 */
public class Favorite implements Serializable {
    private Integer id;
    private Integer authorId;
    private Integer favoriteFor;
    private Integer forId;
    private Integer del;
    private String modifyTime;
    private String createTime;

    public Favorite() {
    }

    public Favorite(Integer id, Integer authorId, Integer favoriteFor, Integer forId, Integer del, String modifyTime, String createTime) {
        this.id = id;
        this.authorId = authorId;
        this.favoriteFor = favoriteFor;
        this.forId = forId;
        this.del = del;
        this.modifyTime = modifyTime;
        this.createTime = createTime;
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

    public Integer getFavoriteFor() {
        return favoriteFor;
    }

    public void setFavoriteFor(Integer favoriteFor) {
        this.favoriteFor = favoriteFor;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
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
        return "Favorite{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", favoriteFor=" + favoriteFor +
                ", forId=" + forId +
                ", del=" + del +
                ", modifyTime='" + modifyTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
