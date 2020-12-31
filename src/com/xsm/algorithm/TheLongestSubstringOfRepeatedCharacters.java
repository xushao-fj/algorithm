package com.xsm.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xsm
 * @date 2020/12/31
 * @Description
 * {@link https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/}
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度
 * ex1:
 * 输入:
 * s = "aaabb", k = 3
 * 输出:
 * 3
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * ex2:
 * 输入:
 * s = "ababbc", k = 2
 * 输出:
 * 5
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class TheLongestSubstringOfRepeatedCharacters {

    public static void main(String[] args) {
        String str = "aaabacb";
        int k = 3;
        int repeatCount = longestSubstring(str, k);
        System.out.println(repeatCount);
    }

    /**
     * 计算最长子串长度
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring(String s, int k) {
        // 使用map装每个字符出现的次数
        Map<Character, Integer> char2CountMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            boolean exit = char2CountMap.containsKey(c);
            if (exit) {
                Integer count = char2CountMap.get(c);
                count = count + 1;
                char2CountMap.put(c, count);
            }
            else {
                char2CountMap.put(c, 1);
            }
        }

        // 判断一个字数串中有多少符合条件的子字符串
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (char2CountMap.get(s.charAt(i)) < k) {
                // 标记中断位置
                sb.setCharAt(i, ',');
            }
        }
        // 分组处理 -> 有多少个符合的子串
        String[] subs = sb.toString().split(",");
        if (subs.length == 1) {
            return subs[0].length();
        }
        int repeatCount = 0;
        for (String sub : subs) {
            repeatCount = Math.max(repeatCount, longestSubstring(sub, k));
        }

        return repeatCount;
    }

}
