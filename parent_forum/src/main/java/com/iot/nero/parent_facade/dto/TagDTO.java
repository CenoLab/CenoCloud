package com.iot.nero.parent_facade.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/25
 * Time   上午11:35
 */
public class TagDTO implements Serializable {
    private Integer authorId;
    private String name;

    public TagDTO(Integer authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}
