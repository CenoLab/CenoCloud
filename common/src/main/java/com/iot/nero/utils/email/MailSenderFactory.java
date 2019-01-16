package com.iot.nero.utils.email;

import com.iot.nero.utils.spring.PropertyPlaceholder;
import org.springframework.beans.factory.annotation.Value;

import javax.jnlp.UnavailableServiceException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-4
 * time: 下午4:30.
 */
public class MailSenderFactory {


    /**
     * 服务邮箱
     */
    private static SimpleMailSender serviceSms = null;

    /**
     * 获取邮箱
     *
     * @param type 邮箱类型
     * @return 符合类型的邮箱
     */
    public static SimpleMailSender getSender(MailSenderType type) {
        if (type == MailSenderType.SERVICE) {
            if (serviceSms == null) {
                String username = PropertyPlaceholder.getProperty("email.address").toString();

                String password = (String)PropertyPlaceholder.getProperty("email.password").toString();


                username = username.substring(1,username.length()-1);
                password = password.substring(1,password.length()-1);
                System.out.println(username+"--------"+password);
                serviceSms = new SimpleMailSender("smtp.163.com",username,password);
            }
            return serviceSms;
        }
        return null;
    }

}
