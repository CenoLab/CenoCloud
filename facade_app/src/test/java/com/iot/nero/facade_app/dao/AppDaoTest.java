package com.iot.nero.facade_app.dao;

import com.iot.nero.dto.KeySecret;
import com.iot.nero.parent_app.entity.Application;
import org.apache.ibatis.jdbc.Null;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   下午3:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_app/spring/*.xml")
public class AppDaoTest {


    @Autowired
    private AppDao appDao;

    @Test
    public void findAppByUid() throws Exception {
        Assert.assertEquals(1,appDao.findAppByUid(2).size());
    }

    @Test
    public void createApplication() throws Exception {
        Assert.assertEquals(new Integer(1),appDao.createApplication(2,
                "test",
                "smart",
                "wifi",
                1,
                "CenoCloud",
                "pk",
                "ps",
                10,
                "desc"));
    }

    @Test
    public void findAppByKey() throws Exception {
        Application application = appDao.findAppByProductKey("pk");
        Assert.assertEquals("test",application.getName());
        Assert.assertEquals("smart",application.getType());
        Assert.assertEquals("wifi",application.getTech());
        Assert.assertEquals(new Integer(1),application.getTrans());
        Assert.assertEquals("CenoCloud",application.getCompany());
        Assert.assertEquals("pk",application.getProductKey());
        Assert.assertEquals("ps",application.getProductSecret());
        Assert.assertEquals(new Integer(10),application.getMaxConnect());
        Assert.assertEquals("desc",application.getDescription());
    }

    @Test
    public void findAppById() throws Exception {
        Application applicationNull = appDao.findAppById(1);
        Assert.assertEquals(null,applicationNull);
        Application application = appDao.findAppById(17);
        Assert.assertEquals("CenoLight",application.getName());
        Assert.assertEquals("smart life robot",application.getType());
        Assert.assertEquals("Wi-Fi",application.getTech());
        Assert.assertEquals(new Integer(1),application.getTrans());
        Assert.assertEquals("M",application.getCompany());
        Assert.assertEquals("ZyQg4+dgiwDwGkG0GW2JCg==",application.getProductKey());
        Assert.assertEquals("T39ifrtfusXaAXTNEEYkzQ==",application.getProductSecret());
        Assert.assertEquals(new Integer(80),application.getMaxConnect());
        Assert.assertEquals(null,application.getDescription());
    }

    @Test
    public void findKeySecretByKey() throws Exception {
        KeySecret keySecretNull = appDao.findKeySecretByKey("lalala");
        Assert.assertEquals(null,keySecretNull);
        KeySecret keySecret = appDao.findKeySecretByKey("ZyQg4+dgiwDwGkG0GW2JCg==");
        Assert.assertEquals("ZyQg4+dgiwDwGkG0GW2JCg==",keySecret.getSecretKey());
        Assert.assertEquals("T39ifrtfusXaAXTNEEYkzQ==",keySecret.getSecret());
    }

    @Test
    public void fullTest() throws  Exception{
        int size = 1;
        // test all
        Assert.assertEquals(size,appDao.findAppByUid(2).size());
        // insert 10
        for(int i = 0;i<10;i++) {
            Assert.assertEquals(new Integer(1), appDao.createApplication(2,
                    "test",
                    "smart",
                    "wifi",
                    1,
                    "CenoCloud",
                    "pk"+i,
                    "ps",
                    10,
                    "desc"));
            size++;
        }
        Assert.assertEquals(size,appDao.findAppByUid(2).size());
        for(int i = 0;i<10;i++) {
            Application application = appDao.findAppByProductKey("pk"+i);
            Assert.assertEquals("test",application.getName());
            Assert.assertEquals("smart",application.getType());
            Assert.assertEquals("wifi",application.getTech());
            Assert.assertEquals(new Integer(1),application.getTrans());
            Assert.assertEquals("CenoCloud",application.getCompany());
            Assert.assertEquals("pk"+i,application.getProductKey());
            Assert.assertEquals("ps",application.getProductSecret());
            Assert.assertEquals(new Integer(10),application.getMaxConnect());
            Assert.assertEquals(null,application.getDescription());
        }
        // test insert
        for(int i = 0;i<10;i++) {
            KeySecret keySecret = appDao.findKeySecretByKey("pk"+i);
            Assert.assertEquals("pk"+i, keySecret.getSecretKey());
            Assert.assertEquals("ps", keySecret.getSecret());
        }
    }

}