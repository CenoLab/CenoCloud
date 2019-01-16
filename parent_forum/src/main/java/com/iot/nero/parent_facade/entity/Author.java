package com.iot.nero.parent_facade.entity;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午9:58
 */
public class Author implements Serializable {

    private Integer   authorId;
    private Integer   ssoId;
    private String nickName;
    private Integer   articleCount;
    private Integer   questionCount;
    private Integer   answerCount;
    private Integer   followCount;
    private Integer   starCount;
    private Integer   experience;
    private Integer   score;
    private Integer   del;
    private String modifyTime;


    public Author() {
    }

    public Author(Integer authorId, Integer ssoId, String nickName, Integer articleCount, Integer questionCount, Integer answerCount, Integer followCount, Integer starCount, Integer experience, Integer score, Integer del, String modifyTime) {
        this.authorId = authorId;
        this.ssoId = ssoId;
        this.nickName = nickName;
        this.articleCount = articleCount;
        this.questionCount = questionCount;
        this.answerCount = answerCount;
        this.followCount = followCount;
        this.starCount = starCount;
        this.experience = experience;
        this.score = score;
        this.del = del;
        this.modifyTime = modifyTime;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getSsoId() {
        return ssoId;
    }

    public void setSsoId(Integer ssoId) {
        this.ssoId = ssoId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Integer getstarCount() {
        return starCount;
    }

    public void setstarCount(Integer starCount) {
        this.starCount = starCount;
    }

    public Integer getexperience() {
        return experience;
    }

    public void setexperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", ssoId=" + ssoId +
                ", nickName='" + nickName + '\'' +
                ", articleCount=" + articleCount +
                ", questionCount=" + questionCount +
                ", answerCount=" + answerCount +
                ", followCount=" + followCount +
                ", starCount=" + starCount +
                ", experience=" + experience +
                ", score=" + score +
                ", del=" + del +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
