package com.iot.nero.parent_facade.dto;

import com.iot.nero.parent_facade.entity.Answer;
import com.iot.nero.parent_facade.entity.Author;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/23
 * Time   下午3:46
 */
public class AnswerInfo implements Serializable {
    private Answer answer;
    private Author author;

    public AnswerInfo() {
    }

    public AnswerInfo(Answer answer, Author author) {
        this.answer = answer;
        this.author = author;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AnswerInfo{" +
                "answer=" + answer +
                ", author=" + author +
                '}';
    }
}
