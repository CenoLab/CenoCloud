package com.iot.nero.utils.verifycode.test;

import com.iot.nero.utils.verifycode.SlideVerify;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/8/11
 * Time   下午4:54
 */
public class SlideVerifyTest {
        public static void main(String[] args) {
            JFrame jframe = new JFrame();
            jframe.add(new ImagePanel());
            jframe.setVisible(true);
            jframe.setSize(1280, 768);
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel() {
            SlideVerify slideVerify = null;

                slideVerify = new SlideVerify();
            System.out.println(System.getProperty("user.dir"));

            image = slideVerify.createImage(System.getProperty("user.dir")+"/common/assets/verify_back.png",System.getProperty("user.dir")+"/common/assets/board.png",1f,512,350);
        }

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
}
