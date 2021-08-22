package com.mellow;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DesAesDemo {
    public static void main(String[] args) throws Exception {
        // 原文
        String input = "硅谷";
        // des加密必须是8位
        String key = "123456";
        // 定义转换方式
        String transformation = "DES";
        // 声明算法规则
        String algorithm = "DES";
        // 获取加密对象
        Cipher cipher = Cipher.getInstance(transformation);

        // 创建加密规则
        // 第二个参数是算法规则
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),algorithm);
        // 初始化模式
        // Cipher.ENCRYPT_MODE表示加密模式
        // 第二个参数表示加密规则
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
    }
}
