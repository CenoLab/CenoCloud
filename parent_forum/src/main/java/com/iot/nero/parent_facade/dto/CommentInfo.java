package com.iot.nero.parent_facade.dto;

import com.iot.nero.dto.AuthPair;
import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.Comment;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/23
 * Time   下午2:46
 */
public class CommentInfo implements Serializable {
    private Comment comment;
    private Author author;


    public CommentInfo() {
    }

    public CommentInfo(Comment comment, Author author) {
        this.comment = comment;
        this.author = author;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "comment=" + comment +
                ", author=" + author +
                '}';
    }
}
