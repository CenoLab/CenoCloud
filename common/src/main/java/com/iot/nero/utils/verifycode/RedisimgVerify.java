package com.iot.nero.utils.verifycode;

import com.iot.nero.utils.redis.JedisUtil;
import com.iot.nero.utils.verifycode.entity.ImgVerify;
import com.iot.nero.utils.verifycode.exception.VerifyFailedException;
import org.apache.commons.codec.binary.Base64;
import redis.clients.jedis.Jedis;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/8/16
 * Time   10:04 PM
 */
public class RedisimgVerify {

    public ImgVerify getVerify() throws IOException {
        // 随机生成验证码
        Verify verify = new Verify();
        String vCode = verify.getVerifyCode6();
        String jSessionId = UUID.randomUUID().toString();

        BufferedImage bufferedImage = verify.createFontImage(vCode,60,200,80,false);

        Jedis jedis= JedisUtil.getInstance().getJedis();
        jedis.set(jSessionId, vCode,"NX", "EX", 60*3);
        JedisUtil.getInstance().returnJedis(jedis);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        boolean flag = ImageIO.write(bufferedImage, "JPEG", out);
        byte[] b = out.toByteArray();
        String imgString = Base64.encodeBase64String(b).replaceAll("\r\n","");

        ImgVerify imgVerify = new ImgVerify("data:image/JPEG;base64," + imgString,jSessionId);
        return imgVerify;
    }

    public Boolean verify(String jSessionId,String code) throws VerifyFailedException{
        Jedis jedis= JedisUtil.getInstance().getJedis();
        String vCode = jedis.get(jSessionId);
        if(vCode==null || !vCode.equals(code)){
            throw new VerifyFailedException("验证码错误");
        }
        JedisUtil.getInstance().returnJedis(jedis);
        return true;
    }
}
