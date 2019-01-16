package com.iot.nero.utils.aliyun.mail;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class AliyunMail {

    public static String  VERIFY_EMAIL_TEMPLETE = "<div class='x_cenocloud-email' style='font-family: &quot;Microsoft Yahei&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, serif, EmojiFont;'>\n" +
            "    <center>\n" +
            "    <table class='x_email-body' style='vertical-align:top; border:0; border-collapse:collapse; margin-left:auto; margin-right:auto; width:100%; height:100%; background-color:#EAECED'>\n" +
            "    <tbody>\n" +
            "    <tr height='30' style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    </tr>\n" +
            "    <tr style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <td style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <table class='x_email-content' style='vertical-align:top; border:0; border-collapse:collapse; margin-left:auto; margin-right:auto; width:600px; background-color:#FFFFFF'>\n" +
            "    <tbody>\n" +
            "    <tr style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <td style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <table class='x_content-header' style='vertical-align:top; border:0; border-collapse:collapse; margin-left:auto; margin-right:auto; width:100%; height:50; background-color:#3e3d49'>\n" +
            "    <tbody>\n" +
            "    <tr style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <td style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <a href='http://www.cenocloud.com/' target='_blank' rel='noopener noreferrer' style='text-decoration:none; display:block'><img data-imagetype='External' src='http://www.cenocloud.com/static/img/CenoCloudLogo.png' alt='qingcloud_banner' style='height:80px;'> </a></td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "    </table>\n" +
            "    </td>\n" +
            "    </tr>\n" +
            "    <tr height='50' style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    </tr>\n" +
            "    <tr style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <td style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <div class='x_content-body' style='width:85%; margin-left:auto; margin-right:auto; text-align:left'>\n" +
            "    <p>尊敬的用户__name__：</p>\n" +
            "    <p>您好！感谢您注册CenoCloud+</p>\n" +
            "    <p>您的验证码为：</p>\n" +
            "    <p style='font-size:40px;font-weight:bolder;'>__code__</p>\n" +
            "    <p>请在三十分钟内填写。</p>\n" +
            "    <p>如有问题，请及时与我司联系：</p>\n" +
            "    <p>方法一：&nbsp;请加 QQ：422242680 3068591197 </p>\n" +
            "    <p>方法二：&nbsp;可以咨询CenoCloud+在线客服&nbsp;www.cenocloud.com&nbsp;&nbsp;</p>\n" +
            "    <p>感谢您对CenoCloud+的支持</p>\n" +
            "    </div>\n" +
            "    </td>\n" +
            "    </tr>\n" +
            "    <tr height='50' style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    </tr>\n" +
            "    <tr style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <td style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <table class='x_content-bottom' style='vertical-align:top; border:0; border-collapse:collapse; margin-left:auto; margin-right:auto; border-top:1px solid #eee; width:100%'>\n" +
            "    <tbody>\n" +
            "    <tr style='padding:0; margin:0; border:0; text-align:center; vertical-align:top'>\n" +
            "    <td style='padding:0 10px; margin:0; border:0; text-align:left; vertical-align:top'>\n" +
            "    <span class='x_left' style='color:#EEE'><a href='http://www.cenocloud.com' target='_blank' rel='noopener noreferrer' style='text-decoration:none; display:inline-block; font-size:14px; line-height:22px; margin:5px; color:#429368'>CloudCloud+官网</a> <span style='color:#EEE'>/</span> <a href='http://www.cenocloud.com/iot.html' target='_blank' rel='noopener noreferrer' style='text-decoration:none; display:inline-block; font-size:14px; line-height:22px; margin:5px; color:#429368'>控制台</a> </span></td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "    </table>\n" +
            "    </td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "    </table>\n" +
            "    </td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "    </table>\n" +
            "    </center>\n" +
            "    </div>";

    public static Boolean sendRegisterMail(String name,String email,String code) {

        String verifyEmail = VERIFY_EMAIL_TEMPLETE.replaceAll("__name__", name);
        verifyEmail = verifyEmail.replaceAll("__code__", code);

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIr1CEAT80ffuC", "HUiji3BDDW1lTiO4Jlj8kByppjTXZG");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            request.setAccountName("sso@support.cenocloud.com");
            request.setFromAlias("CenoCloud+");
            request.setAddressType(1);
            request.setTagName("verify");
            request.setReplyToAddress(true);
            request.setToAddress(email);
            request.setSubject("CenoCloud+注册验证码");
            request.setHtmlBody(verifyEmail);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            return true;
        } catch (ServerException e) {
            return false;
        } catch (ClientException e) {
            return false;
        }
    }
}
