package com.iot.nero.utils.verifycode;


import com.iot.nero.utils.verifycode.exception.VerifyFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * author: nero
 * date:   2016/11/2 0002
 * time:   14:10
 */
public class Verify {

    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    private HttpServletRequest request;

    private String sessionName = "verifyCode";

    public Verify() {
    }

    public Verify(HttpServletRequest request){
        this.request = request;
    }

    public Verify(HttpServletRequest request, String sessionName) {
        this.request = request;
        this.sessionName = sessionName;
    }

    private Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }

    /**
     * 获取6位随机串
     * @return
     */
    public String getVerifyCode6(){
        String sRand="";
        Random random = new Random();
        for (int i=0;i<6;i++)
        {
            int itmp = random.nextInt(26) + 65;
            char ctmp = (char)itmp;
            sRand += String.valueOf(ctmp);
        }
        return sRand;
    }

    /**
     * 产生验证码
     * session verifyCode
     * @param fontSize 字体大小
     * @param width 验证码宽度
     * @param height 验证码高度
     * @param line 是否绘制背景线条
     * @return BufferedImage 验证码
     */
    public BufferedImage createImage(int fontSize,int width,int height,boolean line){

        Font mFont = new Font("Times New Roman", Font.PLAIN, fontSize);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(1, 1, width-1, height-1);

        //g.setColor(new Color(102,102,102));//边框
        //g.drawRect(0, 0, width-1, height-1);
        g.setFont(mFont);



        if(line) {
            g.setColor(getRandColor(160,200));//线颜色
            //画随机线
            for (int i = 0; i < 255; i++) {
                int x = random.nextInt(width - 1);
                int y = random.nextInt(height - 1);
                int xl = random.nextInt(6) + 1;
                int yl = random.nextInt(12) + 1;
                g.drawLine(x, y, x + xl, y + yl);
            }

            //从另一方向画随机线
            for (int i = 0; i < 255; i++) {
                int x = random.nextInt(width - 1);
                int y = random.nextInt(height - 1);
                int xl = random.nextInt(12) + 1;
                int yl = random.nextInt(6) + 1;
                g.drawLine(x, y, x - xl, y - yl);
            }

        }
        //生成随机数,并将随机数字转换为字母
        String sRand="";
        for (int i=0;i<6;i++)
        {
            int itmp = random.nextInt(26) + 65;
            char ctmp = (char)itmp;
            sRand += String.valueOf(ctmp);
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            int y = random.nextInt(20)+50;
            g.drawString(String.valueOf(ctmp),(random.nextInt(10)+25)*i,y);
        }
        HttpSession session = this.request.getSession(true);
        session.setAttribute(this.sessionName,sRand);
        g.dispose();

        return image;

    }

    /**
     * 产生字符图片
     * session verifyCode
     * @param fontSize 字体大小
     * @param width 验证码宽度
     * @param height 验证码高度
     * @param line 是否绘制背景线条
     * @return BufferedImage 验证码
     */
    public BufferedImage createFontImage(String value,int fontSize,int width,int height,boolean line){

        Font mFont = new Font("Times New Roman", Font.PLAIN, fontSize);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(1, 1, width-1, height-1);

        //g.setColor(new Color(102,102,102));//边框
        //g.drawRect(0, 0, width-1, height-1);
        g.setFont(mFont);



        if(line) {
            g.setColor(getRandColor(160,200));//线颜色
            //画随机线
            for (int i = 0; i < 255; i++) {
                int x = random.nextInt(width - 1);
                int y = random.nextInt(height - 1);
                int xl = random.nextInt(6) + 1;
                int yl = random.nextInt(12) + 1;
                g.drawLine(x, y, x + xl, y + yl);
            }

            //从另一方向画随机线
            for (int i = 0; i < 255; i++) {
                int x = random.nextInt(width - 1);
                int y = random.nextInt(height - 1);
                int xl = random.nextInt(12) + 1;
                int yl = random.nextInt(6) + 1;
                g.drawLine(x, y, x - xl, y - yl);
            }

        }

        for (int i=0;i<6;i++)
        {
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            int y = random.nextInt(20)+50;
            g.drawString(String.valueOf(value.charAt(i)),(random.nextInt(10)+25)*i,y);
        }
        g.dispose();
        return image;
    }

    /**
     * 验证验证码是否正确
     * @param code 验证码
     * @return boolean
     */
    public boolean checkVerify(String code) throws VerifyFailedException {
        HttpSession session = this.request.getSession();
        Object verifyCode = session.getAttribute(this.sessionName);
        if(verifyCode!=null && code!=null){
            if(verifyCode.toString().toLowerCase().equals(code.toLowerCase())){
                session.setAttribute(this.sessionName,null);
                return true;
            }
            throw new VerifyFailedException("验证码错误");
        }
        throw new VerifyFailedException("验证码错误");
    }

    public String getVerifyCode(){
        return this.request.getSession().getAttribute(this.sessionName).toString();
    }
}
