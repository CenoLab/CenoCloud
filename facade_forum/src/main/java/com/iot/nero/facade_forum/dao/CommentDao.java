package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午8:29
 */
public interface CommentDao {

    List<Comment> listCommentByArticleID(@Param("aid") Integer articleId,
                                         @Param("page") Integer page,
                                         @Param("num") Integer num);

    List<Comment> listComment(@Param("forType") Integer forType,
                              @Param("aid") Integer forId,
                              @Param("page") Integer page,
                              @Param("num") Integer num);

    Integer addComment(@Param("forType") Integer forType,
                       @Param("forId") Integer forId,
                       @Param("authorId") Integer authorId,
                       @Param("content") String content);
}
