package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Article;
import com.iot.nero.parent_facade.entity.Favorite;
import com.iot.nero.parent_facade.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午8:55
 */
public interface FavoriteDao {

    List<Article> listFavoriteArticle(@Param("authorId") Integer authorId,
                                      @Param("page") Integer page,
                                      @Param("num") Integer num);

    Integer addFavoriteArticle(@Param("authorId") Integer authorId,
                               @Param("favId") Integer favId);
    Integer delFavoriteArticle(@Param("authorId") Integer authorId,
                               @Param("favId") Integer favId);


    List<Question> listFavoriteQuestion(@Param("authorId") Integer authorId,
                                        @Param("page") Integer page,
                                        @Param("num") Integer num);

    Integer addFavoriteQuestion(@Param("authorId") Integer authorId,
                                @Param("favId") Integer favId);
    Integer delFavoriteQuestion(@Param("authorId") Integer authorId,
                                @Param("favId") Integer favId);

    Favorite findFavoriteByTypeAndId(@Param("forType") Integer forType,
                                     @Param("authorId") Integer authorId,
                                     @Param("forId") Integer forId);

    Integer updateFavoriteArticle(@Param("authorId") Integer authorId, @Param("articleId") Integer articleId);

    Integer updateFavoriteQuestion(@Param("authorId") Integer authorId, @Param("questionId") Integer questionId);
}
