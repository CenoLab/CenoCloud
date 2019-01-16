package com.iot.nero.utils.md5;

import java.io.*;
import java.security.MessageDigest;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-15
 * Time   :  下午8:53
 */
public class FileDiffUtil {

    /**
     * 判断两个文件是否相同
     *
     * @param file1
     * @param file2
     * @return
     */
    public static boolean check(File file1, File file2) throws IOException {
        boolean isSame = false;
        String img1Md5 = getMD5(file1);
        String img2Md5 = getMD5(file2);
        if (img1Md5.equals(img2Md5)) {
            isSame = true;
        } else {
            isSame = false;
        }
        return isSame;
    }

    public static byte[] getByte(File file) throws IOException,FileNotFoundException {
        // 得到文件长度
        byte[] b = new byte[(int) file.length()];
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            try {
                in.read(b);
            } catch (IOException e) {
                throw e;
            }
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                throw e;
            }
        }
        return b;
    }

    public static String getMD5(byte[] bytes) {
        // 16进制字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = bytes;
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            // 移位 输出字符串
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMD5(File file) throws IOException {
        try {
            return getMD5(getByte(file));
        } catch (IOException e) {
            throw e;
        }
    }

}