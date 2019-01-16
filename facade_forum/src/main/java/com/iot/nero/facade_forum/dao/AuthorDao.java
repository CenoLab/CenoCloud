package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午8:26
 */
public interface AuthorDao {

    Author findAuthorById(@Param("aid") Integer authorId);

    Author findAuthorByCloudId(@Param("sid") Integer ssoId);

    List<Author> descAuthorByArticleCount(@Param("page") Integer page,
                                          @Param("num") Integer num);

    Integer initAuthor(@Param("nickname") String nickname,
                       @Param("sid") Integer ssoId);

    Author findAuthorByName(@Param("nickname") String nickname);

    Integer increaseFavCount();

    Integer decreaseFavCount();
}
