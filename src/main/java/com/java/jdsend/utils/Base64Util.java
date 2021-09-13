package com.java.jdsend.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author linqiu
 * @version 1.0
 * @description: Base64加密工具类
 * @date 2021/9/9 20:06
 */
public class Base64Util {
    /**
     * 加密
     *
     * @param plainText
     * @return
     */
    public static String encodeStr(String plainText) {
        byte[] b = plainText.getBytes();
        Base64 base64 = new Base64();
        b = base64.encode(b);
        return new String(b);
    }

    /**
     * 解密
     *
     * @param encodeStr
     * @return
     */
    public static String decodeStr(String encodeStr) {
        byte[] b = encodeStr.getBytes();
        Base64 base64 = new Base64();
        b = base64.decode(b);
        return new String(b);
    }


    /**
     * 64位编码解码转byte[]数组
     *
     * @param encodeStr
     * @return
     */
    public static byte[] decodeStr2byte(String encodeStr) {
        byte[] b = encodeStr.getBytes();
        Base64 base64 = new Base64();
        b = base64.decode(b);
        return b;
    }


    /**
     * 字节数组加密
     *
     * @param b
     * @return
     */
    public static String encodeByte(byte[] b) {
        Base64 base64 = new Base64();
        b = base64.decode(b);
        return new String(b);
    }


    /**
     * @param imageBase64 (图片的base64位编码)
     * @param filePath    (欲存储的路径)
     * @return
     */
    public static Boolean Base64ToImg(String imageBase64, String filePath) {
        byte[] buffer;
        try {
            buffer = Base64.decodeBase64(imageBase64.replace("data:image/png;base64,", "").replace("data:image/jpeg;base64,", "").replace("data:image/gif;base64,", "").replace("data:image/bmp;base64,", ""));
            String path = filePath + "/" + System.currentTimeMillis() + ".png";
            FileOutputStream out = new FileOutputStream(path);
            out.write(buffer);
            out.close();
            return Boolean.TRUE;
        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }


    /**
     * 根据图片地址转换为base64编码字符串
     *
     * @param imgFile
     * @return
     */
    public static String img2base64(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        return encodeByte(data);
    }

}
