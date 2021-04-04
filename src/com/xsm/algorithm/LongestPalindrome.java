package com.xsm.algorithm;

/**
 * @author xsm
 * @date 2021/1/14
 * @Description 最长回文串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        String str = "babad";
        String s = longestPalindrome(str);
        System.out.println(s);

    }

    public static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();

        // 截取的起始位置
        int startIndex = 0;
        // 从起始位置到回文串的最大位置间距
        int endIndex = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                // 需要先判断起始和结尾的是否相同, 如果相同, 那么再判断起始和结尾位置中间的字符串是回文
                if (chars[i] == chars[j]) {
                    // 判断是否回文
                    boolean isPalindrome = isPalindrome(chars, i, j);
                    if (isPalindrome){
                        if (j - i > endIndex) {
                            endIndex = j-i;
                            startIndex = i;
                        }
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + endIndex + 1);
    }

    private static boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end){
            if (chars[start] != chars[end]) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }


}
