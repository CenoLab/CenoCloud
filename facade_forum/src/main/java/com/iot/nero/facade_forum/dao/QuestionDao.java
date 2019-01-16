package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午8:26
 */
public interface QuestionDao {

    Question findQuestionByID(@Param("id") Integer questionId);

    List<Question> listQuestionByAuthorID(@Param("aid") Integer authorId,
                                          @Param("page") Integer page,
                                          @Param("num") Integer num);


    Integer addQuestion(@Param("authorId") Integer authorId,
                        @Param("title") String title,
                        @Param("content") String content,
                        @Param("tagsId") String tagsId,
                        @Param("type") Integer type);

    Integer updateQuestionById(@Param("id") Integer id,
                               @Param("title") String title,
                               @Param("content") String content,
                               @Param("tagsId") String tagsId,
                               @Param("type") Integer type);

    Integer acceptQuestionById(@Param("questionId") Integer questionId,
                               @Param("answerId") Integer answerId);

    List<Question> listQuestionByTime(@Param("page") Integer page,
                                      @Param("num") Integer num);

    List<Question> listQuestionByStarCount(@Param("page") Integer page, @Param("num") Integer num);
}
