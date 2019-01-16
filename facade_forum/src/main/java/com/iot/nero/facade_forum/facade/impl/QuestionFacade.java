package com.iot.nero.facade_forum.facade.impl;

import com.iot.nero.facade.IQuestionFacade;
import com.iot.nero.facade_forum.dao.AnswerDao;
import com.iot.nero.facade_forum.dao.FavoriteDao;
import com.iot.nero.facade_forum.dao.QuestionDao;
import com.iot.nero.parent_facade.dto.AnswerDTO;
import com.iot.nero.parent_facade.dto.QuestionDTO;
import com.iot.nero.parent_facade.entity.Answer;
import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.Favorite;
import com.iot.nero.parent_facade.entity.Question;
import com.iot.nero.parent_facade.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.iot.nero.parent_facade.constant.CONSTANT.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   下午7:46
 */
@Service
public class QuestionFacade implements IQuestionFacade{

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private FavoriteDao favoriteDao;

    public Question getQuestionById(Integer questionId) {

        return questionDao.findQuestionByID(questionId);
    }

    public List<Question> getQuestionByStarCount(Integer page, Integer num) {
        return questionDao.listQuestionByStarCount(page,num);
    }

    public List<Question> getQuestionByTime(Integer page, Integer num) {
        return questionDao.listQuestionByTime(page,num);
    }

    public List<Question> getQuestionByAuthorId(Author author,Integer page,Integer num) throws AuthorNotFoundException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);

        }
        return questionDao.listQuestionByAuthorID(author.getAuthorId(),page,num);
    }

    public List<Answer> getAnswerByQuestion(Question question, Integer page, Integer num) {
        return answerDao.listAnswerByQuestionId(question.getId(),page,num);
    }

    public QuestionDTO askQuestion(Author author, QuestionDTO question) throws QuestionAddFailedException {
        if(questionDao.addQuestion(author.getAuthorId(),question.getTitle(),
                question.getContent(),
                question.getTagsId(),
                question.getType())<1){
            throw new QuestionAddFailedException(QUESTION_ADD_FAILED);
        }
        return question;
    }

    public AnswerDTO answerQuestion(Author author, String answer, Integer questionId) throws AnswerFailedException, QuestionNotFoundException, AuthorNotFoundException {

        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }

        if(questionDao.findQuestionByID(questionId)==null){
            throw new QuestionNotFoundException(QUESTION_NOT_FOUND);
        }

        if(answerDao.addAnswerForQuestion(questionId,author.getAuthorId(),answer)<1){
            throw new AnswerFailedException(ANSWER_FAILED);
        }
        return new AnswerDTO(author.getAuthorId(),questionId,answer);
    }

    public Answer acceptAnswer(Author author,Integer questionId, Integer answerId) throws AuthorNotFoundException, AnswerAcceptFailedException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }

        Integer isAccept = questionDao.acceptQuestionById(questionId,answerId);
        if(isAccept<1){
            throw new AnswerAcceptFailedException(ANSWER_ACCEPT_FAILED);
        }
        // todo 作者回答采纳数量统计

        // todo 其他答案取消采纳

        return answerDao.findAnswerById(answerId);
    }

    public Answer starForAnswer(Author author, Integer answerId) throws AuthorNotFoundException, AnswerStaredFailedException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }
        Integer starAnswer = answerDao.starForAnswer(answerId);
        if(starAnswer<1){
            throw new AnswerStaredFailedException(ANSWER_STARED_FAILED);
        }

        return answerDao.findAnswerById(answerId);
    }

    public Question favoriteQuestion(Author author, Integer questionId) throws AuthorNotFoundException, QuestionFavFailedException, AlreadyFavoritedException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }


        Favorite favorite = favoriteDao.findFavoriteByTypeAndId(2,author.getAuthorId(),questionId);
        if(favorite!=null && favorite.getDel().equals(0)){
            throw new AlreadyFavoritedException(ALREADY_FAVORITED);
        }

        if(favorite.getDel().equals(1)){
            Integer isFav = favoriteDao.updateFavoriteQuestion(author.getAuthorId(),questionId);
            if(isFav<1){
                throw new QuestionFavFailedException(QUESTION_FAVORITE_FAILED);
            }
        }else{
            Integer isFav = favoriteDao.addFavoriteQuestion(author.getAuthorId(),questionId);
            if(isFav<1){
                throw new QuestionFavFailedException(QUESTION_FAVORITE_FAILED);
            }
        }

        return questionDao.findQuestionByID(questionId);

    }

    public List<Question> listFavoriteQuestions(Author author, Integer page, Integer num) throws AuthorNotFoundException {

        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }
        return favoriteDao.listFavoriteQuestion(author.getAuthorId(),page,num);
    }

    public Question unFavoriteQuestion(Author author, Integer questionId) throws AuthorNotFoundException, NotFavoritedException, QuestionUnFavoriteFailedException {

        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }


        Favorite favorite = favoriteDao.findFavoriteByTypeAndId(2,author.getAuthorId(),questionId);
        if(favorite==null){
            throw new NotFavoritedException(UN_FAVORITED);
        }

        Integer isFav = favoriteDao.delFavoriteQuestion(author.getAuthorId(),questionId);
        if(isFav<1){
            throw new QuestionUnFavoriteFailedException(QUESTION_UN_FAVORITE_FAILED);
        }

        return questionDao.findQuestionByID(questionId);
    }
}
