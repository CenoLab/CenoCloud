package com.iot.nero.parent_facade.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   下午2:59
 */
public class QuestionDTO implements Serializable {
    private Integer authorId;
    private String title;
    private String content;
    private String tagsId;
    private Integer type;

    public QuestionDTO(Integer authorId, String title, String content, String tagsId, Integer type) {
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.tagsId = tagsId;
        this.type = type;
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


    @Override
    public String toString() {
        return "QuestionDTO{" +
                "authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tagsId='" + tagsId + '\'' +
                ", type=" + type +
                '}';
    }

    public boolean isComplete() {
        return !(
                authorId == null ||
                title    == null || "".equals(title)   ||
                content  == null || "".equals(content) ||
                tagsId   == null || "".equals(tagsId)  ||
                type     == null
        );
    }
}
