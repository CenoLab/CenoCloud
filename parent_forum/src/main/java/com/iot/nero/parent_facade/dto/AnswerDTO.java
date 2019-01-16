package com.iot.nero.parent_facade.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/24
 * Time   下午3:39
 */
public class AnswerDTO implements Serializable {
    private Integer    authorId;
    private Integer    questionId;
    private String  content;

    public AnswerDTO(Integer authorId, Integer questionId, String content) {
        this.authorId = authorId;
        this.questionId = questionId;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "authorId=" + authorId +
                ", questionId=" + questionId +
                ", content='" + content + '\'' +
                '}';
    }
}
