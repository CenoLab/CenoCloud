package com.iot.nero.parent_facade.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午10:08
 */
public class Question implements Serializable {

    private Integer    id;
    private Integer    authorId;
    private String  title;
    private String  content;
    private String  tagsId;
    private Integer  type;
    private String  accept;
    private Integer    answerCount;
    private Integer starCount;
    private Integer favCount;
    private Integer    del;
    private String  modifyTime;
    private String  createTime;

    public Question() {
    }

    public Question(Integer id, Integer authorId, String title, String content, String tagsId, Integer type, String accept, Integer answerCount, Integer starCount, Integer favCount, Integer del, String modifyTime, String createTime) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.tagsId = tagsId;
        this.type = type;
        this.accept = accept;
        this.answerCount = answerCount;
        this.starCount = starCount;
        this.favCount = favCount;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTagsId() {
        return tagsId;
    }

    public void setTagsId(String tagsId) {
        this.tagsId = tagsId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
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

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }


    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tagsId='" + tagsId + '\'' +
                ", type=" + type +
                ", accept='" + accept + '\'' +
                ", answerCount=" + answerCount +
                ", starCount=" + starCount +
                ", favCount=" + favCount +
                ", del=" + del +
                ", modifyTime='" + modifyTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
