package com.iot.nero.facade_forum.facade.impl;

import com.iot.nero.facade_forum.dao.*;
import com.iot.nero.facade.IArticleFacade;
import com.iot.nero.parent_facade.dto.ArticleDTO;
import com.iot.nero.parent_facade.dto.CommentDTO;
import com.iot.nero.parent_facade.entity.*;
import com.iot.nero.parent_facade.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.iot.nero.parent_facade.constant.CONSTANT.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   下午7:45
 */
@Service
public class ArticleFacade implements IArticleFacade {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private FavoriteDao favoriteDao;

    @Autowired
    private TagDao tagDao;


    public ArticleDTO addArticle(ArticleDTO article) throws ArticleAddFailedException {
        Integer isAdd = articleDao.addArticle(
                article.getAuthorId(),
                article.getTitle(),
                article.getContent(),
                article.getTagsId(),
                article.getCanComment(),
                article.getAbstractContent(),
                article.getType(),
                article.getFromWhere(),
                article.getFromUrl()
                );
        if(isAdd<1){
            throw new ArticleAddFailedException(ARTICLE_ADD_FAILED);
        }
        return article;
    }

    public List<Article> listArticleByStarCount(Integer page, Integer num) {
        List<Article> articles = articleDao.descArticleByStarCount(page,num);
        if(!articles.isEmpty()){
            for(Article article:articles){
                article.toArticleBase();
            }
        }
        return articles;
    }

    public List<Article> listArticleByAuthorId(Integer authorId, Integer page, Integer num) {
        List<Article> articles = articleDao.listArticlesByAuthorId(authorId,page,num);
        if(!articles.isEmpty()){
            for(Article article:articles){
                article.toArticleBase();
            }
        }
        return articles;
    }

    public Article favoriteArticle(Author author, Integer articleId) throws ArticleFavoriteFailedException, AlreadyFavoritedException, AuthorNotFoundException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }

        Favorite favorite = favoriteDao.findFavoriteByTypeAndId(1,author.getAuthorId(),articleId);
        if(favorite!=null && favorite.getDel().equals(0)){
            throw new AlreadyFavoritedException(ALREADY_FAVORITED);
        }

        if(favorite.getDel().equals(1)){
            Integer isFavorite = favoriteDao.updateFavoriteArticle(author.getAuthorId(),articleId);
            if(isFavorite<1){
                throw new ArticleFavoriteFailedException(ARTICLE_FAVORITE_FAILED);
            }
        }else {
            Integer isFavorite = favoriteDao.addFavoriteArticle(author.getAuthorId(), articleId);
            if (isFavorite < 1) {
                throw new ArticleFavoriteFailedException(ARTICLE_FAVORITE_FAILED);
            }
        }

        Integer addFavoriteCount = articleDao.increaseFavCount(articleId);
        if(addFavoriteCount<1){
            throw new RuntimeException(ARTICLE_FAVORITE_COUNT_ADD_FAILED);
        }
        return articleDao.findArticleById(articleId);
    }

    public Article unFavoriteArticle(Author author, Integer articleId) throws ArticleFavoriteFailedException, NotFavoritedException, AuthorNotFoundException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }

        Integer isFavorite = favoriteDao.delFavoriteArticle(author.getAuthorId(),articleId);
        if(isFavorite<1){
            throw new ArticleFavoriteFailedException(ARTICLE_UN_FAVORITE_FAILED);
        }

        Integer addFavoriteCount = articleDao.decreaseFavCount(articleId);
        if(addFavoriteCount<1){
            throw new RuntimeException(ARTICLE_FAVORITE_COUNT_DECREASE_FAILED);
        }

        return articleDao.findArticleById(articleId);
    }

    public Article starArticle(Integer articleId) {
        Integer isStar = articleDao.increaseStarCount(articleId);
        return articleDao.findArticleById(articleId);
    }

    public List<Comment> getCommentForArticle(Article article, Integer page, Integer num) {
        return commentDao.listComment(1,article.getId(),page,num);
    }

    public CommentDTO commentForArticle(Integer articleId, String comment, Integer ssoId) throws ArticleNotFoundException, AuthorNotFoundException, CommentFailedException {
        Article article = articleDao.findArticleById(articleId);
        if(article==null){
            throw new ArticleNotFoundException(ARTICLE_NOT_FOUND);
        }
        Author author = authorDao.findAuthorByCloudId(ssoId);
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }
        if(commentDao.addComment(1,articleId,author.getAuthorId(),comment)<1){
            throw new CommentFailedException(COMMENT_FAILED);
        }
        return new CommentDTO(author.getAuthorId(),1,articleId,comment);
    }

    public Integer addTag(String tag, Integer authorId) throws TagAddFailedException {
        Integer addTag =  tagDao.addTag(tag,authorId);
        if(addTag<1){
            throw new TagAddFailedException(TAG_ADD_FAILED);
        }
        return  addTag;
    }

    public Article getArticleById(Integer articleId) {
        return articleDao.findArticleById(articleId);
    }

    public List<Article> listFavoriteArticles(Author author, Integer page, Integer num) throws AuthorNotFoundException {
        if(author==null){
            throw new AuthorNotFoundException(AUTHOR_NOT_FOUND);
        }

        List<Article> articles  = favoriteDao.listFavoriteArticle(author.getAuthorId(),page,num);
        if(!articles.isEmpty()){
            for(Article article:articles){
                article.toArticleBase();
            }
        }
        return articles;

    }

    public List<Article> listArticleByStarCount(Long daySecond, Integer page, Integer num) {
        List<Article> articles = articleDao.descArticleByStarCountDay(daySecond,page,num);
        if(!articles.isEmpty()){
            for(Article article:articles){
                article.toArticleBase();
            }
        }
        return articles;
    }

    public List<Tag> getTag(String tag) {
        return tagDao.listTags(tag);
    }

    public List<Article> listArticleByTime(Integer page, Integer num) {
        List<Article> articles =  articleDao.descArticleByTime(page,num);
        if(!articles.isEmpty()){
            for(Article article:articles){
                article.toArticleBase();
            }
        }
        return articles;
    }
}
