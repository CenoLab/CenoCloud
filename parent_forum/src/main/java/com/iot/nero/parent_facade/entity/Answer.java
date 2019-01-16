package com.iot.nero.parent_facade.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午9:58
 */
public class Answer implements Serializable {

    private Integer    id;
    private Integer    authorId;
    private Integer    questionId;
    private Integer    isAccept;
    private String  content;
    private Integer starCount;
    private Integer    del;
    private String  modifyTime;
    private String  createTime;


    public Answer() {
    }

    public Answer(Integer id, Integer authorId, Integer questionId, Integer isAccept, String content, Integer starCount, Integer del, String modifyTime, String createTime) {
        this.id = id;
        this.authorId = authorId;
        this.questionId = questionId;
        this.isAccept = isAccept;
        this.content = content;
        this.starCount = starCount;
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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(Integer isAccept) {
        this.isAccept = isAccept;
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

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", questionId=" + questionId +
                ", isAccept=" + isAccept +
                ", content='" + content + '\'' +
                ", starCount=" + starCount +
                ", del=" + del +
                ", modifyTime='" + modifyTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
