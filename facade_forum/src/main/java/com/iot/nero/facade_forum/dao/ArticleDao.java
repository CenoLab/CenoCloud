package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午8:26
 */
public interface ArticleDao {

    Article findArticleById(@Param("id") Integer articleId);


    List<Article> listArticlesByAuthorId(@Param("aid") Integer authorId,
                                         @Param("page") Integer page,
                                         @Param("num") Integer num);

    List<Article> descArticleByStarCount(@Param("page") Integer page,
                                         @Param("num") Integer num);

    Integer addArticle(@Param("authorId") Integer authorId,
                       @Param("title")              String  title,
                       @Param("content")            String  content,
                       @Param("tagsId")             String  tagsId,
                       @Param("canComment")         Integer canComment,
                       @Param("abstractContent")    String  abstractContent,
                       @Param("type")               Integer type,
                       @Param("fromWhere")          String  fromWhere,
                       @Param("fromUrl")            String  fromUrl);

    List<Article> descArticleByTime(@Param("page") Integer page, @Param("num") Integer num);


    List<Article> descArticleByStarCountDay(@Param("daySecond") Long daySecond,
                                            @Param("page") Integer page,
                                            @Param("num") Integer snum);

    Integer increaseFavCount(@Param("articleId") Integer articleId);

    Integer decreaseFavCount(@Param("articleId") Integer articleId);

    Integer increaseStarCount(@Param("articleId") Integer articleId);
}
