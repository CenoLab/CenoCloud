package com.iot.nero.parent_facade.dto;

import com.iot.nero.parent_facade.entity.Article;
import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.Comment;

import java.io.Serializable;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   下午2:46
 */
public class ArticleInfo  implements Serializable{
    private Article article;
    private Author author;
    private List<CommentInfo> comments;

    public ArticleInfo() {
    }

    public ArticleInfo(Article article, Author author, List<CommentInfo> comments) {
        this.article = article;
        this.author = author;
        this.comments = comments;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<CommentInfo> getComments() {
        return comments;
    }

    public void setComments(List<CommentInfo> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "article=" + article +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}
