package com.jozz.alex.util;

public class ConvertUtil {

    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();

    public static String convertTo(int number, int n) {
        StringBuilder result = new StringBuilder();
        // 模拟计算进制的过程
        while (number > 0) {
            result.insert(0, array[number % n]);
            number /= n;
        }
        return result.toString();
    }

    /**
     * 解码,从64进制解码到10进制
     *
     * @param str
     *            string类型的64进制数A-Z,a-z,0-9,+,-
     * @return long类型的10进制数
     */
    public static long decode(String str) {
        // 倍数
        int multiple = 1;
        long result = 0;
        Character c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(str.length() - i - 1);
            result += decodeChar(c) * multiple;
            multiple = multiple * 64;
        }
        return result;
    }

    /**
     * 比对数组,得到字符对应的值
     * @param c 64位字符
     * @return
     */
    private static int decodeChar(Character c) {
        for (int i = 0; i < array.length; i++) {
            if (c == array[i]) {
                return i;
            }
        }
        return -1;
    }



}
