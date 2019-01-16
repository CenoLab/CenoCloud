package com.iot.nero.web_forum.controller;

import com.iot.nero.dto.AuthPair;
import com.iot.nero.dto.Result;
import com.iot.nero.parent_facade.constant.CONSTANT;
import com.iot.nero.parent_facade.dto.*;
import com.iot.nero.parent_facade.entity.*;
import com.iot.nero.service.IForumService;
import com.iot.nero.utils.verifycode.Verify;
import com.iot.nero.utils.verifycode.exception.VerifyFailedException;
import com.iot.nero.web_forum.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.iot.nero.constant.ClientType.BROWSER;
import static com.iot.nero.constant.ClientType.MOBILE_ANDROID;
import static com.iot.nero.constant.ClientType.MOBILE_IPHONE;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/26
 * Time   下午9:42
 */
@Controller
@RequestMapping("/api/v1/")
public class ApiForum {
    private static final String AGENT = "FromAgent";
    private static final String ANDROID = "android";
    private static final String IOS = "ios";
    private static final String FORUM_SERVICE_BEAN = "IForumService";

    private static final String SSO_ID = "SSO-ID";
    private static final String SSO_TOKEN = "SSO-TOKEN";

    private IForumService forumService;



    /**
     * 获取验证码
     */
    @RequestMapping(value = "{random}/create",
            method = RequestMethod.POST)
    public void getVerify(@PathVariable("random") String random,
                          HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //表明生成的响应是图片
        response.setContentType("image/png");
        Verify verify = new Verify(request);
        BufferedImage image = verify.createImage(60, 200, 80, true);
        ImageIO.write(image, "png", response.getOutputStream());
    }


    /**
     * 检查是否加入社区
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "author/me",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<Author> getAuthorBySsoID(
            HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            request.setCharacterEncoding("utf-8");


            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID)).intValue();
            String ssoToken = request.getHeader(SSO_TOKEN);

            AuthPair authPair = new AuthPair();
            authPair.setId(ssoId);
            authPair.setToken(ssoToken);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.getAuthor(authPair));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.getAuthor(authPair));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.getAuthor(authPair));
            }
        } catch (IllegalStateException e) {
            return (new Result<Author>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<Author>(false, e.getMessage()));
        }
    }


    /**
     * 加入社区并设置昵称
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "author/me/init",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<Author> initialUser(HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            request.setCharacterEncoding("utf-8");
            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);
            String nickname = request.getParameter("nickname");

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.initAuthor(authPair, nickname));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.initAuthor(authPair, nickname));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.initAuthor(authPair, nickname));
            }
        } catch (IllegalStateException e) {
            return (new Result<Author>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<Author>(false, e.getMessage()));
        }
    }


    /**
     * 分页获取文章，时间排序
     *
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "article/all/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<ArticleInfo>> getArticleList(@PathVariable("page") Integer page,
                                                    @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.allArticle(page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<ArticleInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 获取文章像详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "article/detail/{id}",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<ArticleInfo> getArticle(@PathVariable("id") Integer id) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.getArticle(id));
        } catch (IllegalStateException e) {
            return (new Result<ArticleInfo>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 分类分页获取文章
     *
     * @param tag
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "article/tag/{tag}/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<ArticleInfo>> getArticleListByTag(@PathVariable("tag") String tag,
                                                         @PathVariable("page") Integer page,
                                                         @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.tagArticle(tag, page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<ArticleInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 24小时优秀文章分页
     *
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "article/day/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<ArticleInfo>> getArticleListByDay(@PathVariable("page") Integer page,
                                                         @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.dayBestArticle(page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<ArticleInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 本月优秀文章，分页
     *
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "article/month/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<ArticleInfo>> getArticleListByMonth(@PathVariable("page") Integer page,
                                                           @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.monthBestArticle(page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<ArticleInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 所有优秀文章，分页
     *
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "article/best/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<ArticleInfo>> getArticleListByBest(@PathVariable("page") Integer page,
                                                          @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.allBestArticle(page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<ArticleInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 发表文章
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "article/{code}/pub",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<ArticleDTO> publishArticle(@PathVariable("code") String code,
                                             HttpServletRequest request,
                                             HttpServletResponse response) {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);

        try {
            //verify.checkVerify(code);

            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            request.setCharacterEncoding("utf-8");
            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);

            Integer authorId = Integer.valueOf(request.getParameter("authorId"));

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String canComment = request.getParameter("canComment");
            String tags = request.getParameter("tags");
            String abstractContent = request.getParameter("abstractContent");
            String type = request.getParameter("type");
            String fromWhere = request.getParameter("fromWhere");
            String fromUrl = request.getParameter("fromUrl");

            ArticleDTO articleDTO = new ArticleDTO(authorId,
                    title,
                    content,
                    tags,
                    Integer.valueOf(canComment),
                    abstractContent,
                    Integer.valueOf(type),
                    fromWhere,
                    fromUrl
            );
            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.publishArticle(authPair, articleDTO));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.publishArticle(authPair, articleDTO));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.publishArticle(authPair, articleDTO));
            }
        } catch (IllegalStateException e) {
            return (new Result<ArticleDTO>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<ArticleDTO>(false, e.getMessage()));
        } catch (VerifyFailedException e) {
            return (new Result<ArticleDTO>(false, e.getMessage()));
        }
    }


    /**
     * 获取标签，模糊
     *
     * @param tag
     * @return
     */
    @RequestMapping(value = "article/{tag}/tags",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Tag>> getTags(@PathVariable("tag") String tag) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.getTags(tag));
        } catch (IllegalStateException e) {
            return (new Result<List<Tag>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 添加标签
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "article/tags/add",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<TagDTO> addTag(HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            request.setCharacterEncoding("utf-8");
            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);

            String tag = request.getParameter("tag");

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.addTag(authPair, tag));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.addTag(authPair, tag));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.addTag(authPair, tag));
            }
        } catch (IllegalStateException e) {
            return (new Result<TagDTO>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<TagDTO>(false, e.getMessage()));
        }
    }


    /**
     * 文章点赞
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "article/{articleId}/star",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Article> starArticle(@PathVariable("articleId") Integer articleId) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.startArticle(articleId));
        } catch (IllegalStateException e) {
            return (new Result<Article>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 文章收藏
     *
     * @return
     */
    @RequestMapping(value = "article/{articleId}/favorite",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Article> favoriteArticle(@PathVariable("articleId")Integer articleId,
                                           HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            request.setCharacterEncoding("utf-8");
            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.favoriteArticle(authPair, articleId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.favoriteArticle(authPair, articleId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.favoriteArticle(authPair, articleId));
            }
        } catch (IllegalStateException e) {
            return (new Result<Article>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<Article>(false, e.getMessage()));
        }
    }


    /**
     * 取消文章收藏
     *
     * @return
     */
    @RequestMapping(value = "article/{articleId}/unFavorite",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Article> unFavoriteArticle(@PathVariable("articleId")Integer articleId,
                                             HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            request.setCharacterEncoding("utf-8");
            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.unFavoriteArticle(authPair, articleId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.unFavoriteArticle(authPair, articleId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.unFavoriteArticle(authPair, articleId));
            }
        } catch (IllegalStateException e) {
            return (new Result<Article>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<Article>(false, e.getMessage()));
        }
    }


    /**
     * 文章评论
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "article/{code}/comment",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<CommentInfo> commentForArticle(@PathVariable("code")String code,
                                                HttpServletRequest request,
                                                HttpServletResponse response) {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);

        try {
            //verify.checkVerify(code);

            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            request.setCharacterEncoding("utf-8");

            Integer articleId = Integer.valueOf(request.getParameter("articleId"));
            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);
            String comment = request.getParameter("comment");

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.commentArticle(authPair, articleId, comment));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.commentArticle(authPair, articleId, comment));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.commentArticle(authPair, articleId, comment));
            }
        } catch (IllegalStateException e) {
            return (new Result<CommentInfo>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<CommentInfo>(false, e.getMessage()));
        } catch (VerifyFailedException e){
            return (new Result<CommentInfo>(false, e.getMessage()));
        }
    }


    /**
     * 评论点赞
     *
     * @param commentId
     * @return
     */
    @RequestMapping(value = "comment/{commentId}/star",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<CommentInfo> startComment(@PathVariable("commentId") Integer commentId) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.starComment(commentId));
        } catch (IllegalStateException e) {
            return (new Result<CommentInfo>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 分页获取文章评论
     *
     * @param articleId
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "article/{articleId}/{page}/{num}/listComment",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<CommentInfo>> commentList(@PathVariable("articleId") Integer articleId,
                                                 @PathVariable("page") Integer page,
                                                 @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.listComment(articleId, page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<CommentInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 分页获取提问，默认序
     *
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "question/all/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<QuestionInfo>> getQuestionList(@PathVariable("page") Integer page,
                                                      @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.allQuestions(page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<QuestionInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 分页获取提问，时间序
     *
     * @param page
     * @param num
     * @param tag
     * @return
     */
    @RequestMapping(value = "question/all/{tag}/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<QuestionInfo>> getQuestionList(@PathVariable("page") Integer page,
                                                      @PathVariable("num") Integer num,
                                                      @PathVariable("tag") String tag) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.tagQuestions(tag, page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<QuestionInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 获取问题详情
     *
     * @param questionId
     * @return
     */
    @RequestMapping(value = "question/{questionId}/get",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<QuestionInfo> getQuestionList(@PathVariable("questionId") Integer questionId) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.getQuestion(questionId));
        } catch (IllegalStateException e) {
            return (new Result<QuestionInfo>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 提问
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "question/{code}/ask",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<QuestionDTO> askQuestion(@PathVariable("code") String code,
                                           HttpServletRequest request,
                                           HttpServletResponse response) {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);

        try {
            //verify.checkVerify(code);
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            request.setCharacterEncoding("utf-8");

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);

            Integer authorId = Integer.valueOf(request.getParameter("authorId"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String tags = request.getParameter("tags");
            String type = request.getParameter("type");

            QuestionDTO questionDTO = new QuestionDTO(
                    authorId,
                    title,
                    content,
                    tags,
                    Integer.valueOf(type));

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.askQuestion(authPair, questionDTO));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.askQuestion(authPair, questionDTO));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.askQuestion(authPair, questionDTO));
            }
        } catch (IllegalStateException e) {
            return (new Result<QuestionDTO>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<QuestionDTO>(false, e.getMessage()));
        }catch (VerifyFailedException e){
            return (new Result<QuestionDTO>(false, e.getMessage()));
        }
    }


    /**
     * 回答问题
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "question/{code}/answer",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<AnswerInfo> answerQuestion(@PathVariable("code") String code,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);

        try {
            //verify.checkVerify(code);
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            request.setCharacterEncoding("utf-8");

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);
            Integer questionId = Integer.valueOf(request.getParameter("questionId"));

            String answer = request.getParameter("answer");

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.answerQuestion(authPair, answer, questionId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.answerQuestion(authPair, answer, questionId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.answerQuestion(authPair, answer, questionId));
            }

        } catch (IllegalStateException e) {
            return (new Result<AnswerInfo>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<AnswerInfo>(false, e.getMessage()));
        }catch (VerifyFailedException e){
            return (new Result<AnswerInfo>(false, e.getMessage()));
        }
    }


    /**
     * 分页获取问题回答
     *
     * @param questionId
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "question/{questionId}/answer/{page}/{num}/list",
            method = RequestMethod.POST
    )
    @ResponseBody
    public Result<List<AnswerInfo>> listAnswerForQuestion(@PathVariable("questionId") Integer questionId,
                                                          @PathVariable("page") Integer page,
                                                          @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.listAnswer(questionId, page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<AnswerInfo>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 回答点赞
     *
     * @return
     */
    @RequestMapping(value = "/answer/{answerId}/star",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Answer> starAnswer(@PathVariable("answerId")Integer answerId,
                                     HttpServletRequest request) {

        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            request.setCharacterEncoding("utf-8");

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.starAnswer(authPair, answerId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.starAnswer(authPair, answerId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.starAnswer(authPair, answerId));
            }

        } catch (IllegalStateException e) {
            return (new Result<Answer>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<Answer>(false, e.getMessage()));
        }
    }


    /**
     * 问题收藏
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/question/{questionId}/favorite",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Question> favoriteQuestion(@PathVariable("questionId") Integer questionId,
                                             HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            request.setCharacterEncoding("utf-8");

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.favoriteQuestion(authPair, questionId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.favoriteQuestion(authPair, questionId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.favoriteQuestion(authPair, questionId));
            }
        } catch (IllegalStateException e) {
            return (new Result<Question>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        } catch (UnsupportedEncodingException e) {
            return (new Result<Question>(false, e.getMessage()));
        }
    }


    /**
     * 取消文章收藏
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/question/{questionId}/unFavorite",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Question> unFavoriteQuestion(@PathVariable("questionId")Integer questionId,
                                               HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.unFavoriteQuestion(authPair, questionId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.unFavoriteQuestion(authPair, questionId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.unFavoriteQuestion(authPair, questionId));
            }
        } catch (IllegalStateException e) {
            return (new Result<Question>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 回答采纳
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/question/{questionId}/answer/{answerId}/accept",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Answer> acceptAnswer(@PathVariable("questionId") Integer questionId,
                                       @PathVariable("answerId") Integer answerId,
                                       HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.acceptAnswer(authPair, questionId, answerId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.acceptAnswer(authPair, questionId, answerId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.acceptAnswer(authPair, questionId, answerId));
            }
        } catch (IllegalStateException e) {
            return (new Result<Answer>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 我的文章
     *
     * @param page
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/article/{authorId}/{page}/{num}/myArticle",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Article>> getUserArticle(@PathVariable("authorId") Integer authorId,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("num") Integer num,
                                                HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.userArticle(authorId, page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<Article>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 我的问题
     *
     * @param page
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/question/{authorId}/{page}/{num}/myQuestion",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Question>> getUserQuestion(@PathVariable("authorId") Integer authorId,
                                                  @PathVariable("page") Integer page,
                                                  @PathVariable("num") Integer num,
                                                  HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.userQuestions(authorId, page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<Question>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 我的文章收藏
     *
     * @param page
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/article/{page}/{num}/myFavorite",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Article>> getMyFavArticle(@PathVariable("page") Integer page,
                                                 @PathVariable("num") Integer num,
                                                 HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.favoriteArticles(authPair, page, num));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.favoriteArticles(authPair, page, num));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.favoriteArticles(authPair, page, num));
            }
        } catch (IllegalStateException e) {
            return (new Result<List<Article>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 我的问题收藏
     *
     * @param page
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/question/{page}/{num}/myFavorite",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Question>> getMyFavQuestion(@PathVariable("page") Integer page,
                                                   @PathVariable("num") Integer num,
                                                   HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.favoriteQuestions(authPair, page, num));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.favoriteQuestions(authPair, page, num));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.favoriteQuestions(authPair, page, num));
            }
        } catch (IllegalStateException e) {
            return (new Result<List<Question>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 关注
     *
     * @param authorId
     * @param request
     * @return
     */
    @RequestMapping(value = "/follow/{authorId}/follow",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Author> follow(@PathVariable("authorId") Integer authorId,
                                 HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);

            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.followAuthor(authPair, authorId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.followAuthor(authPair, authorId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.followAuthor(authPair, authorId));
            }
        } catch (IllegalStateException e) {
            return (new Result<Author>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 取消关注
     *
     * @param authorId
     * @param request
     * @return
     */
    @RequestMapping(value = "/follow/{authorId}/unFollow",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<Author> unFollow(@PathVariable("authorId") Integer authorId,
                                   HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);

            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.unFollowAuthor(authPair, authorId));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.unFollowAuthor(authPair, authorId));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.unFollowAuthor(authPair, authorId));
            }
        } catch (IllegalStateException e) {
            return (new Result<Author>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 我的关注
     *
     * @param page
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/follow/{page}/{num}/myFollow",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Author>> myFollow(@PathVariable("page") Integer page,
                                         @PathVariable("num") Integer num,
                                         HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.myFollowAuthor(authPair, page, num));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.myFollowAuthor(authPair, page, num));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.myFollowAuthor(authPair, page, num));
            }
        } catch (IllegalStateException e) {
            return (new Result<List<Author>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }


    /**
     * 我的粉丝
     *
     * @param page
     * @param num
     * @param request
     * @return
     */
    @RequestMapping(value = "/follow/{page}/{num}/myFans",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Author>> myFans(@PathVariable("page") Integer page,
                                       @PathVariable("num") Integer num,
                                       HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);


            Integer ssoId = Integer.valueOf(request.getHeader(SSO_ID));
            String ssoToken = request.getHeader(SSO_TOKEN);


            AuthPair authPair = new AuthPair();
            authPair.setToken(ssoToken);
            authPair.setId(ssoId);

            if (request.getHeader(AGENT).equals(ANDROID)) {
                authPair.setClientType(MOBILE_ANDROID);
                return (forumService.myFansAuthor(authPair, page, num));
            } else if (request.getHeader(AGENT).equals(IOS)) {
                authPair.setClientType(MOBILE_IPHONE);
                return (forumService.myFansAuthor(authPair, page, num));
            } else {
                authPair.setClientType(BROWSER);
                return (forumService.myFansAuthor(authPair, page, num));
            }
        } catch (IllegalStateException e) {
            return (new Result<List<Author>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }

    /**
     * 获取快速入口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/entry/list",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Entry>> getEntry(HttpServletRequest request) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.getEntry());
        } catch (IllegalStateException e) {
            return (new Result<List<Entry>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }

    /**
     * 分页获取活动讯息
     *
     * @param request
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "/activity/{page}/{num}/list",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Activity>> getActivities(HttpServletRequest request,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.getActivities(page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<Activity>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }

    /**
     * 分页获取公告
     *
     * @param request
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "/attention/{page}/{num}/list",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Attention>> getEntry(HttpServletRequest request,
                                            @PathVariable("page") Integer page,
                                            @PathVariable("num") Integer num) {
        try {
            forumService = (IForumService) Consumer.singleton().getBean(FORUM_SERVICE_BEAN);
            return (forumService.getAttentions(page, num));
        } catch (IllegalStateException e) {
            return (new Result<List<Attention>>(false, CONSTANT.FORUM_SERVICE_EXCEPTION));
        }
    }
}


