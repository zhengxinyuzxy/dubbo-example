package com.mellow;

public class KaiserDemo {

    public static void main(String[] args) {
        // 加密
        String orignal = "hello word";
        int key = 3;
        String encryptedData = encryptKaiser(orignal, key);
        System.out.println("密文：" + encryptedData);

        // 解密
        String decryptData = decryptKaiser(encryptedData, key);
        System.out.println("原文：" + decryptData);
    }

    /**
     * 解密
     */
    public static String decryptKaiser(String encryptedData, int key) {
        // 字符串转换为数组
        char[] chars = encryptedData.toCharArray();
        //         new StringBuffer()
        StringBuffer stringBuffer = new StringBuffer();
        // 遍历数组得到ASCII码
        for (char asciiCode : chars) {
            asciiCode -= key;
            char charCode = (char) asciiCode;
            stringBuffer.append(charCode);
        }
        return stringBuffer.toString();

    }

    /**
     * 加密
     *
     * @param orignal
     * @param key
     * @return
     */
    public static String encryptKaiser(String orignal, int key) {
        // 字符串转为字符数组
        char[] chars = orignal.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        // 字符转为Int类型
        for (char aChar : chars) {
            int code = aChar;
            code += key;
            char result = (char) code;
            stringBuffer.append(result);
        }
        return stringBuffer.toString();
    }
}
