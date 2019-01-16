package com.iot.nero.utils.verifycode;


import com.iot.nero.utils.verifycode.exception.VerifyFailedException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * author: nero
 * date:   2016/11/2 0002
 * time:   14:10
 */
public class SlideVerify {

    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    private HttpServletRequest request;

    private String sessionName = "SlideVerifyValue";

    public SlideVerify() {
    }

    public SlideVerify(HttpServletRequest request) {
        this.request = request;
    }

    public SlideVerify(HttpServletRequest request, String sessionName) {
        this.request = request;
        this.sessionName = sessionName;
    }


    /**
     * 产生验证码
     * session verifyCod
     *
     * @param width  验证码宽度
     * @param height 验证码高度
     * @return BufferedImage 验证码
     */
    public BufferedImage createImage(String srcImgPath, String iconPath, float alpha, int width, int height) {


        Image srcImg = null;

        try {
            File file = new File(srcImgPath);
            srcImg = ImageIO.read(file);
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 1、得到画笔对象
            Graphics2D g = buffImg.createGraphics();

            // 2、设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g.drawImage(
                    srcImg.getScaledInstance(srcImg.getWidth(null),
                            srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                    null);



            Random random = new Random();
            int verifyValue = random.nextInt(250) + 10;
            int verifyH = random.nextInt(64)+128;
            Rectangle rect = new Rectangle(verifyValue, verifyH, width, height);

            // 4、水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);
            // 5、得到Image对象。
            Image img = imgIcon.getImage();
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 6、水印图片的位置
            g.drawImage(img, verifyValue, verifyH, null);

            // 4、水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon Icon = new ImageIcon(System.getProperty("user.dir")+"/common/assets/card.png");
            // 5、得到Image对象。
            Image img_ = Icon.getImage();
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    0.7f));
            // 6、水印图片的位置
            g.drawImage(img_, 400, 10, null);



            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 7、释放资源
            g.dispose();
            return buffImg;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 验证验证码是否正确
     *
     * @param code 验证码
     * @return boolean
     */
    public boolean checkVerify(String code) throws VerifyFailedException {
        HttpSession session = this.request.getSession();
        Object verifyCode = session.getAttribute(this.sessionName);
        if (verifyCode != null && code != null) {
            if (verifyCode.toString().toLowerCase().equals(code.toLowerCase())) {
                session.setAttribute(this.sessionName, null);
                return true;
            }
            throw new VerifyFailedException("验证码错误");
        }
        throw new VerifyFailedException("验证码错误");
    }

    public String getVerifyCode() {
        return this.request.getSession().getAttribute(this.sessionName).toString();
    }
}
