package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.FollowPair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午8:27
 */
public interface FollowDao {
    List<Author> listFollowByAuthor(@Param("aid") Integer authorId,
                                    @Param("page") Integer page,
                                    @Param("num") Integer num);

    Integer addFollow(@Param("authorId") Integer authorId,
                      @Param("targetAuthorId") Integer targetAuthorId);

    Integer delFollow(@Param("authorId") Integer authorId,
                      @Param("targetAuthorId") Integer targetAuthorId);

    FollowPair getFollowPairByAuthorId(@Param("authorId") Integer authorId,
                                       @Param("target") Integer target);

    List<Author> listFansByAuthor(@Param("authorId") Integer authorId,
                                  @Param("page") Integer page,
                                  @Param("num") Integer num);

    Integer updateFollow(@Param("authorId") Integer authorId, @Param("targetAuthorId") Integer authorId1);
}
