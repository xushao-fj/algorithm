package com.xsm.algorithm;

import java.util.Stack;

/**
 * @author xsm
 * @date 2020/12/17
 * @Description 移除无效的括号
 * {@link https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/}
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String str = "lee)))))))t(c)o)de))))))))))))))))))";
        String result = minRemoveToMakeValid(str);
        System.out.println(result);
    }

    private static String minRemoveToMakeValid(String s) {
        // 存索引
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        if (s.length() == 0) {
            return s;
        }
        for (int i = 0; i < str.length(); i++) {
            // 判断栈中最后存放进入的索引对应的字符是否有和当前字符能够搭配成一个"()", 如果可以, 将其对应索引 pop
            if (!stack.isEmpty() && str.charAt(stack.peek()) == '(' && str.charAt(i) == ')') {
                stack.pop();
            }
            // 否则, 当前字符串为")", "("对应索引存入栈中
            else if (str.charAt(i) == ')' || str.charAt(i) == '(') {
                stack.push(i);
            }
        }
        // 从后往前删除不符合的数据, stack 存储对应的索引数据, 后进先出, 从字符串最后往前删除
        while (!stack.isEmpty()) {
            str.deleteCharAt(stack.pop());
        }
        return str.toString();
    }

}
