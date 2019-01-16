package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午8:26
 */
public interface AnswerDao {
    List<Answer> listAnswerByQuestionId(
            @Param("id") Integer questionId,
            @Param("page") Integer page,
            @Param("num") Integer num);

    Integer addAnswerForQuestion(@Param("questionId") Integer questionId,
                                 @Param("authorId") Integer authorId,
                                 @Param("content") String content);

    Integer acceptAnswer(@Param("id") Integer id);

    Answer findAnswerById(@Param("answerId") Integer answerId);

    Integer starForAnswer(@Param("answerId") Integer answerId);
}