package com.iot.nero.parent_facade.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   上午10:50
 */
public class ArticleDTO implements Serializable {
    private Integer authorId;
    private String title;
    private String content;
    private String tagsId;
    private Integer canComment;
    private String abstractContent;
    private Integer type;
    private String fromWhere;
    private String fromUrl;

    public ArticleDTO(Integer authorId, String title, String content, String tagsId, Integer canComment, String abstractContent, Integer type, String fromWhere, String fromUrl) {
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.tagsId = tagsId;
        this.canComment = canComment;
        this.abstractContent = abstractContent;
        this.type = type;
        this.fromWhere = fromWhere;
        this.fromUrl = fromUrl;
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

    public Integer getCanComment() {
        return canComment;
    }

    public void setCanComment(Integer canComment) {
        this.canComment = canComment;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public Boolean isComplete() {
        return !(title          == null || "".equals(title)           ||
                content         == null || "".equals(content)         ||
                tagsId          == null || "".equals(tagsId)          ||
                canComment      == null ||
                abstractContent == null || "".equals(abstractContent) ||
                type            == null ||
                fromWhere       == null || "".equals(fromWhere)       ||
                fromUrl         == null || "".equals(fromUrl));
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tagsId='" + tagsId + '\'' +
                ", canComment='" + canComment + '\'' +
                ", abstractContent='" + abstractContent + '\'' +
                ", type='" + type + '\'' +
                ", fromWhere='" + fromWhere + '\'' +
                ", fromUrl='" + fromUrl + '\'' +
                '}';
    }
}
