package com.iot.nero.facade_forum.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   上午9:30
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_forum/spring/*.xml")

public class ArticleDaoTest {


    @Autowired
    private ArticleDao articleDao;

    @Test
    public void findArticleById() throws Exception {
        System.out.println(articleDao.findArticleById(1));
    }

    @Test
    public void listArticlesByAuthorId() throws Exception {
        System.out.println(articleDao.listArticlesByAuthorId(20,0,100));
    }

    @Test
    public void descArticleByStarCount() throws Exception {
        System.out.println(articleDao.descArticleByStarCount(0,100));
    }

    @Test
    public void addArticle() throws Exception {
        System.out.println(articleDao.addArticle(
                1,
                "卖了平台去打工！",
                "我从没有见过一个不孤独的人，会发出耀眼的光芒！付出不一定马上会有回报，除非是钟点工，对于事业，傻逼一样的坚持，总会得到牛逼一样的结果！",
                "测试;平台;",
                1,
                "张小龙说",
                1,
                "原创",
                ""
        ));
    }

}