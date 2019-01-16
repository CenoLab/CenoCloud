package com.iot.nero.facade;

import com.iot.nero.parent_facade.dto.AnswerDTO;
import com.iot.nero.parent_facade.dto.QuestionDTO;
import com.iot.nero.parent_facade.entity.Answer;
import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.Question;
import com.iot.nero.parent_facade.exception.*;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   下午7:44
 */
public interface IQuestionFacade {



    Question getQuestionById(Integer questionId);

    List<Question> getQuestionByStarCount(Integer page,Integer num);
    List<Question> getQuestionByTime(Integer page,Integer num);
    List<Question> getQuestionByAuthorId(Author author,Integer page,Integer num) throws AuthorNotFoundException;


    List<Answer> getAnswerByQuestion(Question question,Integer page,Integer num);

    QuestionDTO askQuestion(Author author,QuestionDTO question) throws QuestionAddFailedException;

    AnswerDTO answerQuestion(Author author, String answer, Integer questionId) throws AnswerFailedException, QuestionNotFoundException, AuthorNotFoundException;

    Answer acceptAnswer(Author author,Integer questionId,Integer answerId) throws AuthorNotFoundException, AnswerAcceptFailedException;

    Answer starForAnswer(Author author,Integer answerId) throws AuthorNotFoundException, AnswerStaredFailedException;

    Question favoriteQuestion(Author author,Integer questionId) throws AuthorNotFoundException, QuestionFavFailedException, AlreadyFavoritedException;

    List<Question> listFavoriteQuestions(Author author, Integer page, Integer num) throws AuthorNotFoundException;

    Question unFavoriteQuestion(Author author, Integer questionId) throws AuthorNotFoundException, NotFavoritedException, QuestionUnFavoriteFailedException;
}
