package com.xsm.algorithm;

/**
 * @author xsm
 * @date 2020/12/16
 * @Description 最长子数组算法
 * {@link https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/}
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 模型: 1. 动态规划
 *      2. 滑动窗口
 */
public class LongestSubarray {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        int result = findLength(A, B);
        System.out.println(result);
    }

    /**
     * 动态规划
     */
    public static int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] temp = new int[A.length+1][B.length+1];
        // 存储最长相同长度
        int max = 0;
        for (int i = 1; i <= A.length; i ++){
            for (int j = 1; j <= B.length; j ++){
                if (A[i - 1] == B[j -1]) {
                    temp[i][j] = temp[i-1][j-1] + 1;
                    max = Math.max(max, temp[i][j]);
                }
            }
        }
        return max;
    }
}
