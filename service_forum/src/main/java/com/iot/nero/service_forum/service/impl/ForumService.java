package com.iot.nero.service_forum.service.impl;
import com.iot.nero.Consumer;
import com.iot.nero.dto.AuthPair;
import com.iot.nero.dto.Result;
import com.iot.nero.facade.*;
import com.iot.nero.parent_facade.constant.CONSTANT;
import com.iot.nero.parent_facade.dto.*;
import com.iot.nero.parent_facade.entity.*;
import com.iot.nero.parent_facade.exception.*;
import com.iot.nero.parent_sso.exception.DeveloperNotExistsException;
import com.iot.nero.parent_sso.exception.TokenExpiredException;
import com.iot.nero.service.IForumService;
import com.iot.nero.service.impl.BaseAuthService;
import com.iot.nero.utils.time.DateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.iot.nero.parent_facade.constant.CONSTANT.*;
import static com.iot.nero.utils.time.DateUtil.timeStamp;


/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   下午1:59
 */
@Service
public class ForumService extends BaseAuthService implements IForumService {

    private static final String DEVELOPER_FACADE_BEAN = "IDeveloperFacade";
    private static final String AUTHOR_FACADE_BEAN    = "IAuthorFacade";
    private static final String QUESTION_FACADE_BEAN  = "IQuestionFacade";
    private static final String ARTICLE_FACADE_BEAN   = "IArticleFacade";
    private static final String FORUM_FACADE_BEAN   = "IForumFacade";

    private static final Long DAY_SECOND = 24L * 60L * 60L;
    private static final Long MONTH_SECOND = 30L * 24L * 60L * 60L;

    private IArticleFacade   articleFacade;
    private IAuthorFacade    authorFacade;
    private IQuestionFacade  questionFacade;
    private IDeveloperFacade developerFacade;
    private IForumFacade forumFacade;


    @Override
    public Result<Author> initAuthor(AuthPair authPair, String nickname) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.initAuthor(authPair.getId(), nickname);
            return (new Result<>(true, author));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorAlreadyFoundException | AuthorInitFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<Author> getAuthor(AuthPair authPair) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            return (new Result<>(true, author));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<Author> followAuthor(AuthPair authPair, Integer authorId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            authorFacade.followAuthor(author,authorId);
            return (new Result<>(true, author));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | FollowFailedException | AlreadyFollowedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<Author> unFollowAuthor(AuthPair authPair, Integer authorId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            authorFacade.unFollowAuthor(author,authorId);
            return (new Result<>(true, author));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | FollowFailedException | UnFollowedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<Author>> bestAuthor(Integer page,Integer num) {
        return (null); //todo
    }


    @Override
    public Result<List<Author>> mostArticleAuthor(Integer page,Integer num) {
        return (null); //todo
    }


    @Override
    public Result<List<Author>> myFollowAuthor(AuthPair authPair, Integer page, Integer num) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            return (new Result<>(true,  authorFacade.listMyFollow(author,page,num)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<Author>> myFansAuthor(AuthPair authPair, Integer page, Integer num) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            return (new Result<>(true,  authorFacade.listMyFans(author,page,num)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<ArticleInfo> getArticle(Integer articleId) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Article article = articleFacade.getArticleById(articleId);
            if(article==null){
                return new Result<>(false,ARTICLE_NOT_FOUND);
            }
            Author author = authorFacade.getAuthorByID(article.getAuthorId());

            List<Comment> comments = articleFacade.getCommentForArticle(article,0,8);
            List<CommentInfo> commentInfos = new ArrayList<>();
            for(Comment comment:comments) {
                commentInfos.add(new CommentInfo(comment,authorFacade.getAuthorByID(comment.getAuthorId())));
            }

            ArticleInfo articleInfo = new ArticleInfo(article, author, commentInfos);


            return (new Result<>(true,articleInfo));
        } catch (IllegalStateException e) {
            return (new Result<>(false, ARTICLE_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<ArticleDTO> publishArticle(AuthPair authPair, ArticleDTO articleDTO) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            if (!articleDTO.isComplete()) {
                return (new Result<>(false, ARTICLE_NOT_COMPLETE));
            }

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            if (author == null || (!Objects.equals(author.getAuthorId(), articleDTO.getAuthorId()))) {
                return (new Result<>(false, AUTHOR_NOT_FOUND));
            }

            return (new Result<>(true, articleFacade.addArticle(articleDTO)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | ArticleAddFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<Article> startArticle(Integer articleId) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            return (new Result<>(true, articleFacade.starArticle(articleId)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        }
    }


    @Override
    public Result<Article> favoriteArticle(AuthPair authPair, Integer articleId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            return (new Result<>(true, articleFacade.favoriteArticle(author,articleId)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | ArticleFavoriteFailedException | AlreadyFavoritedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<Article> unFavoriteArticle(AuthPair authPair, Integer articleId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            return (new Result<>(true, articleFacade.unFavoriteArticle(author,articleId)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | ArticleFavoriteFailedException | NotFavoritedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<CommentInfo> commentArticle(AuthPair authPair, Integer articleId, String comment) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            CommentDTO commentDTO = articleFacade.commentForArticle(articleId, comment, authPair.getId());
            Comment comment1 = new Comment(
                    1,
                    commentDTO.getAuthorId(),
                    commentDTO.getForType(),
                    commentDTO.getForId(),
                    commentDTO.getContent(),
                    1,
                    0,
                    DateUtil.timeStamp2Date(timeStamp(),"yyyy-MM-dd HH:mm:ss"),
                    DateUtil.timeStamp2Date(timeStamp(),"yyyy-MM-dd HH:mm:ss")
            );
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            CommentInfo commentInfo = new CommentInfo(comment1,author);


            return (new Result<>(true, commentInfo));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (CommentFailedException | ArticleNotFoundException | AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<ArticleInfo>> allArticle(Integer page, Integer num) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            List<Article> articles = articleFacade.listArticleByTime(page, num);
            List<ArticleInfo> articleInfos = new ArrayList<>();
            for (Article article : articles) {
                Author author = authorFacade.getAuthorByID(article.getAuthorId());
                List<Comment> comments = articleFacade.getCommentForArticle(article, 0, num);
                List<CommentInfo> commentInfos = new ArrayList<>();
                for(Comment comment:comments) {
                    commentInfos.add(new CommentInfo(comment,authorFacade.getAuthorByID(comment.getAuthorId())));
                }

                ArticleInfo articleInfo = new ArticleInfo(article, author, commentInfos);
                articleInfos.add(articleInfo);
            }
            return (new Result<>(true, articleInfos));
        } catch (IllegalStateException e) {
            return (new Result<>(false, CONSTANT.AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<CommentInfo> starComment(Integer commentId) {
        return null;//todo
    }


    @Override
    public Result<List<CommentInfo>> listComment(Integer articleId, Integer page, Integer num) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Article article = articleFacade.getArticleById(articleId);
            if(article==null){
                return new Result<>(false,ARTICLE_NOT_FOUND);
            }
            List<Comment> comments = articleFacade.getCommentForArticle(article,page, num);
            List<CommentInfo> commentInfos = new ArrayList<>();
            if(!comments.isEmpty()){
                for(Comment comment:comments){
                    commentInfos.add(new CommentInfo(comment,authorFacade.getAuthorByID(comment.getAuthorId())));
                }
            }
            return (new Result<>(true, commentInfos));
        } catch (IllegalStateException e) {
            return (new Result<>(false, CONSTANT.AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }




    @Override
    public Result<List<ArticleInfo>> dayBestArticle(Integer page, Integer num) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            List<Article> articles = articleFacade.listArticleByStarCount(DAY_SECOND,page,num);
            List<ArticleInfo> articleInfos = new ArrayList<>();

            for(Article article:articles){
                Author author = authorFacade.getAuthorByID(article.getAuthorId());
                List<Comment> comments = articleFacade.getCommentForArticle(article,0,num);
                List<CommentInfo> commentInfos = new ArrayList<>();
                for(Comment comment:comments) {
                    commentInfos.add(new CommentInfo(comment,authorFacade.getAuthorByID(comment.getAuthorId())));
                }

                ArticleInfo articleInfo = new ArticleInfo(article, author, commentInfos);
                articleInfos.add(articleInfo);
            }
            return (new Result<>(true, articleInfos));
        } catch (IllegalStateException e) {
            return (new Result<>(false, CONSTANT.AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false,e.getMessage()));
        }
    }


    @Override
    public Result<List<ArticleInfo>> monthBestArticle(Integer page, Integer num) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            List<Article> articles = articleFacade.listArticleByStarCount(MONTH_SECOND,page,num);
            List<ArticleInfo> articleInfos = new ArrayList<>();

            for(Article article:articles){
                Author author = authorFacade.getAuthorByID(article.getAuthorId());
                List<Comment> comments = articleFacade.getCommentForArticle(article,0,num);
                List<CommentInfo> commentInfos = new ArrayList<>();
                for(Comment comment:comments) {
                    commentInfos.add(new CommentInfo(comment,authorFacade.getAuthorByID(comment.getAuthorId())));
                }

                ArticleInfo articleInfo = new ArticleInfo(article, author, commentInfos);
                articleInfos.add(articleInfo);
            }
            return (new Result<>(true, articleInfos));
        } catch (IllegalStateException e) {
            return (new Result<>(false, CONSTANT.AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false,e.getMessage()));
        }
    }


    @Override
    public Result<List<ArticleInfo>> allBestArticle(Integer page, Integer num) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            List<Article> articles = articleFacade.listArticleByStarCount(page,num);
            List<ArticleInfo> articleInfos = new ArrayList<>();

            for(Article article:articles){
                Author author = authorFacade.getAuthorByID(article.getAuthorId());
                List<Comment> comments = articleFacade.getCommentForArticle(article,0,num);
                List<CommentInfo> commentInfos = new ArrayList<>();
                for(Comment comment:comments) {
                    commentInfos.add(new CommentInfo(comment,authorFacade.getAuthorByID(comment.getAuthorId())));
                }

                ArticleInfo articleInfo = new ArticleInfo(article, author, commentInfos);
                articleInfos.add(articleInfo);
            }
            return (new Result<>(true, articleInfos));
        } catch (IllegalStateException e) {
            return (new Result<>(false, CONSTANT.AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false,e.getMessage()));
        }
    }


    @Override
    public Result<List<ArticleInfo>> tagArticle(String tag, Integer page, Integer num) {
        return (null); //todo
    }


    @Override
    public Result<List<Article>> userArticle(Integer authorId,Integer page, Integer num) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);

            List<Article> articles = articleFacade.listArticleByAuthorId(authorId,page,num);
            return (new Result<>(true, articles));
        } catch (IllegalStateException e) {
            return (new Result<>(false, CONSTANT.AUTHOR_FACADE_EXCEPTION));
        }
    }


    @Override
    public Result<List<Article>> favoriteArticles(AuthPair authPair, Integer page, Integer num) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            List<Article> articles = articleFacade.listFavoriteArticles(author,page,num);

            return new Result<List<Article>>(true,articles);
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }

    }


    @Override
    public Result<QuestionDTO> askQuestion(AuthPair authPair, QuestionDTO questionDTO) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            if (!questionDTO.isComplete()) {
                return (new Result<>(false, QUESTION_NOT_COMPLETE));
            }

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            if (author == null || (author.getAuthorId() != questionDTO.getAuthorId())) {
                return (new Result<>(false, AUTHOR_NOT_FOUND));
            }

            return (new Result<>(true, questionFacade.askQuestion(author, questionDTO)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | QuestionAddFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<QuestionInfo>> tagQuestions(String tag, Integer page, Integer num) {
        return (null); //todo
    }


    @Override
    public Result<List<QuestionInfo>> allQuestions(Integer page, Integer num) {
        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            List<Question> questions = questionFacade.getQuestionByTime(page, num);
            List<QuestionInfo> questionInfos = new ArrayList<>();
            if (!questions.isEmpty()) {
                for (Question question : questions) {
                    Author author = authorFacade.getAuthorByID(question.getAuthorId());
                    List<Answer> answers = questionFacade.getAnswerByQuestion(question, 0, num);
                    List<AnswerInfo> answerInfos = new ArrayList<>();
                    for(Answer answer:answers){
                        answerInfos.add(new AnswerInfo(answer,authorFacade.getAuthorByID(answer.getAuthorId())));
                    }
                    questionInfos.add(new QuestionInfo(question, author, answerInfos));
                }
            }
            return (new Result<>(true, questionInfos));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<Question>> userQuestions(Integer authorId,Integer page, Integer num) {
        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorByID(authorId);

            List<Question> questions = questionFacade.getQuestionByAuthorId(author,page, num);

            return (new Result<>(true, questions));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<Question>> favoriteQuestions(AuthPair authPair, Integer page, Integer num) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            List<Question> questions = questionFacade.listFavoriteQuestions(author,page,num);

            return (new Result<>(true, questions));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }

    }


    @Override
    public Result<AnswerInfo> answerQuestion(AuthPair authPair, String answer, Integer questionId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            AnswerDTO ans = questionFacade.answerQuestion(author, answer, questionId);

            AnswerInfo answerInfo = new AnswerInfo(new Answer(
                    0,
                    author.getAuthorId(),
                    questionId,
                    0, ans.getContent(),
                    0,
                    0,
                    DateUtil.timeStamp2Date(timeStamp(),"yyyy-MM-dd HH:mm:ss"),
                    DateUtil.timeStamp2Date(timeStamp(),"yyyy-MM-dd HH:mm:ss")
            ),author);

            return (new Result<>(true, answerInfo));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | AnswerFailedException | QuestionNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<AnswerInfo>> listAnswer(Integer questionId, Integer page, Integer num) {
        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            Question question = questionFacade.getQuestionById(questionId);

            List<Answer> answers = questionFacade.getAnswerByQuestion(question,page,num);
            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            List<AnswerInfo> answerInfos = new ArrayList<>();
            for(Answer answer:answers){
                Author author = authorFacade.getAuthorByID(answer.getAuthorId());
                answerInfos.add(new AnswerInfo(answer,author));
            }
            return (new Result<>(true,answerInfos));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return new Result<>(false, e.getMessage());
        }
    }


    @Override
    public Result<Answer> acceptAnswer(AuthPair authPair, Integer questionId, Integer answerId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            Answer ans = questionFacade.acceptAnswer(author, questionId, answerId);

            return (new Result<>(true, ans));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | AnswerAcceptFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<Answer> starAnswer(AuthPair authPair,Integer answerId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);

            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            Answer ans = questionFacade.starForAnswer(author, answerId);

            return (new Result<>(true, ans));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | AnswerStaredFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<Question> favoriteQuestion(AuthPair authPair, Integer questionId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);
            authorFacade  = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            Question question = questionFacade.favoriteQuestion(author,questionId);

            return (new Result<>(true, question));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | AlreadyFavoritedException | QuestionFavFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }

    }


    @Override
    public Result<Question> unFavoriteQuestion(AuthPair authPair, Integer questionId) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);
            authorFacade  = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());

            Question question = questionFacade.unFavoriteQuestion(author,questionId);

            return (new Result<>(true, question));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | NotFavoritedException | QuestionUnFavoriteFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }


    @Override
    public Result<List<Tag>> getTags(String tag) {
        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);

            List<Tag> tags = articleFacade.getTag(tag);

            return (new Result<>(true, tags));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        }
    }


    @Override
    public Result<TagDTO> addTag(AuthPair authPair, String tag) {
        try {
            developerFacade = (IDeveloperFacade) Consumer.singleton().getBean(DEVELOPER_FACADE_BEAN);
            isTokenAccess(developerFacade, authPair);
        } catch (IllegalStateException e) {
            return (new Result<>(false, com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION));
        } catch (DeveloperNotExistsException | TokenExpiredException e) {
            return (new Result<>(false, e.getMessage()));
        }

        try {
            articleFacade = (IArticleFacade) Consumer.singleton().getBean(ARTICLE_FACADE_BEAN);
            authorFacade  = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);
            Author author = authorFacade.getAuthorBySsoID(authPair.getId());
            articleFacade.addTag(tag,author.getAuthorId());

            return (new Result<>(true, new TagDTO(author.getAuthorId(),tag)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, AUTHOR_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException | TagAddFailedException e) {
            return (new Result<>(false, e.getMessage()));
        }

    }

    @Override
    public Result<List<Entry>> getEntry() {
        try {
            forumFacade = (IForumFacade) Consumer.singleton().getBean(FORUM_FACADE_BEAN);
            return (new Result<>(true, forumFacade.getEntry()));
        } catch (IllegalStateException e) {
            return (new Result<>(false, FORUM_FACADE_EXCEPTION));
        }
    }

    @Override
    public Result<List<Activity>> getActivities(Integer page, Integer num) {
        try {
            forumFacade = (IForumFacade) Consumer.singleton().getBean(FORUM_FACADE_BEAN);
            return (new Result<>(true, forumFacade.getActivities(page,num)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, FORUM_FACADE_EXCEPTION));
        }
    }

    @Override
    public Result<List<Attention>> getAttentions(Integer page, Integer num) {
        try {
            forumFacade = (IForumFacade) Consumer.singleton().getBean(FORUM_FACADE_BEAN);
            return (new Result<>(true, forumFacade.getAttentions(page,num)));
        } catch (IllegalStateException e) {
            return (new Result<>(false, FORUM_FACADE_EXCEPTION));
        }
    }

    @Override
    public Result<QuestionInfo> getQuestion(Integer questionId){
        try {
            questionFacade = (IQuestionFacade) Consumer.singleton().getBean(QUESTION_FACADE_BEAN);

            authorFacade = (IAuthorFacade) Consumer.singleton().getBean(AUTHOR_FACADE_BEAN);


            Question question = questionFacade.getQuestionById(questionId);

            List<AnswerInfo> answerInfos = new ArrayList<>();
            List<Answer> answerList = questionFacade.getAnswerByQuestion(question,0,8);
            for(Answer answer:answerList){
                answerInfos.add(new AnswerInfo(
                        answer,
                        authorFacade.getAuthorByID(answer.getAuthorId())
                ));
            }

            QuestionInfo questionInfo = new QuestionInfo(
                    question,
                    authorFacade.getAuthorByID(question.getAuthorId()),
                    answerInfos
                    );

            return (new Result<>(true, questionInfo));
        } catch (IllegalStateException e) {
            return (new Result<>(false, FORUM_FACADE_EXCEPTION));
        } catch (AuthorNotFoundException e) {
            return (new Result<>(false, e.getMessage()));
        }
    }
}


