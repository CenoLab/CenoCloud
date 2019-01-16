package com.iot.nero.service;

import com.iot.nero.dto.AuthPair;
import com.iot.nero.dto.Result;
import com.iot.nero.parent_facade.dto.*;
import com.iot.nero.parent_facade.entity.*;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   下午2:44
 */
public interface IForumService {

    //用户相关
    Result<Author> initAuthor(AuthPair authPair, String nickname);

    Result<Author> getAuthor(AuthPair authPair);

    Result<Author> followAuthor(AuthPair authPair, Integer authorId);

    Result<Author> unFollowAuthor(AuthPair authPair, Integer authorId);

    Result<List<Author>> bestAuthor(Integer page,Integer num);

    Result<List<Author>> mostArticleAuthor(Integer page,Integer num);

    Result<List<Author>> myFollowAuthor(AuthPair authPair, Integer page, Integer num);

    Result<List<Author>> myFansAuthor(AuthPair authPair, Integer page, Integer num);

    //文章相关
    Result<ArticleInfo> getArticle(Integer articleId);

    Result<ArticleDTO> publishArticle(AuthPair authPair,ArticleDTO articleDTO);

    Result<Article> startArticle(Integer articleId);


    Result<Article> favoriteArticle(AuthPair authPair, Integer articleId);

    Result<Article> unFavoriteArticle(AuthPair authPair, Integer articleId);

    Result<CommentInfo> commentArticle(AuthPair authPair, Integer articleId, String comment);

    Result<List<ArticleInfo>> allArticle(Integer page, Integer num);

    Result<List<ArticleInfo>> dayBestArticle(Integer page, Integer num);

    Result<List<ArticleInfo>> monthBestArticle(Integer page, Integer num);

    Result<List<ArticleInfo>> allBestArticle(Integer page, Integer num);

    Result<List<ArticleInfo>> tagArticle(String tag, Integer page, Integer num);

    Result<List<Article>> userArticle(Integer authorId,Integer page, Integer num);

    Result<List<Article>> favoriteArticles(AuthPair authPair, Integer page, Integer num);

    //问题相关
    Result<QuestionDTO> askQuestion(AuthPair authPair, QuestionDTO questionDTO);

    Result<AnswerInfo> answerQuestion(AuthPair authPair, String answer, Integer questionId);

    Result<List<AnswerInfo>> listAnswer(Integer questionId, Integer page, Integer num);

    Result<Answer> acceptAnswer(AuthPair authPair, Integer questionId, Integer answerId);


    Result<Answer> starAnswer(AuthPair authPair,Integer answerId);

    Result<Question> favoriteQuestion(AuthPair authPair, Integer questionId);

    Result<Question> unFavoriteQuestion(AuthPair authPair, Integer questionId);

    Result<List<QuestionInfo>> allQuestions(Integer page, Integer num);

    Result<List<Question>> userQuestions(Integer authorId,Integer page, Integer num);

    Result<List<Question>> favoriteQuestions(AuthPair authPair, Integer page, Integer num);

    Result<List<Tag>> getTags(String tag);

    Result<TagDTO> addTag(AuthPair authPair, String tag);

    Result<List<QuestionInfo>> tagQuestions(String tag, Integer page, Integer num);

    Result<CommentInfo> starComment(Integer commentId);

    Result<List<CommentInfo>> listComment(Integer articleId, Integer page, Integer num);

    Result<List<Entry>> getEntry();

    Result<List<Activity>> getActivities(Integer page, Integer num);

    Result<List<Attention>> getAttentions(Integer page, Integer num);

    Result<QuestionInfo> getQuestion(Integer questionId);
}
