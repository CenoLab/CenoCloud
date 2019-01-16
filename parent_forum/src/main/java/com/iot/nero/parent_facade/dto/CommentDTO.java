package com.iot.nero.parent_facade.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/24
 * Time   下午2:15
 */
public class CommentDTO implements Serializable {
    private Integer authorId;
    private Integer forType;
    private Integer forId;
    private String  content;

    public CommentDTO(Integer authorId, Integer forType, Integer forId, String content) {
        this.authorId = authorId;
        this.forType = forType;
        this.forId = forId;
        this.content = content;
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

    @Override
    public String toString() {
        return "CommentDTO{" +
                "authorId=" + authorId +
                ", forType=" + forType +
                ", forId=" + forId +
                ", content='" + content + '\'' +
                '}';
    }
}
