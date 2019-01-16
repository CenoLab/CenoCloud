package com.iot.nero.parent_facade.dto;

import com.iot.nero.parent_facade.entity.Answer;
import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.Question;

import java.io.Serializable;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   下午3:05
 */
public class QuestionInfo implements Serializable {
    private Question question;
    private Author author;
    private List<AnswerInfo> answers;

    public QuestionInfo() {
    }

    public QuestionInfo(Question question, Author author, List<AnswerInfo> answers) {
        this.question = question;
        this.author = author;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<AnswerInfo> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerInfo> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuestionInfo{" +
                "question=" + question +
                ", author=" + author +
                ", answers=" + answers +
                '}';
    }
}
