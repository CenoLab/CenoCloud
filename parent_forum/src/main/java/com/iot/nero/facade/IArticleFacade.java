package com.iot.nero.facade;

import com.iot.nero.parent_facade.dto.ArticleDTO;
import com.iot.nero.parent_facade.dto.CommentDTO;
import com.iot.nero.parent_facade.entity.Article;
import com.iot.nero.parent_facade.entity.Author;
import com.iot.nero.parent_facade.entity.Comment;
import com.iot.nero.parent_facade.entity.Tag;
import com.iot.nero.parent_facade.exception.*;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   下午7:44
 */
public interface IArticleFacade {

    ArticleDTO addArticle(ArticleDTO article) throws ArticleAddFailedException;

    List<Article> listArticleByStarCount(Integer page, Integer num);
    List<Article> listArticleByAuthorId(Integer authorId,Integer page,Integer num);

    Article favoriteArticle(Author author,Integer articleId) throws ArticleFavoriteFailedException, AlreadyFavoritedException, AuthorNotFoundException;
    Article unFavoriteArticle(Author author, Integer articleId) throws ArticleFavoriteFailedException, NotFavoritedException, AuthorNotFoundException;
    Article starArticle(Integer articleId);

    List<Comment> getCommentForArticle(Article article,Integer page,Integer num);
    CommentDTO commentForArticle(Integer articleId, String comment, Integer ssoId) throws ArticleNotFoundException, AuthorNotFoundException, CommentFailedException;

    List<Article> listArticleByTime(Integer page, Integer num);

    Integer addTag(String tag, Integer authorId) throws TagAddFailedException;

    Article getArticleById(Integer articleId);

    List<Article> listFavoriteArticles(Author author, Integer page, Integer num) throws AuthorNotFoundException;

    List<Article> listArticleByStarCount(Long daySecond, Integer page, Integer num);

    List<Tag> getTag(String tag);
}
