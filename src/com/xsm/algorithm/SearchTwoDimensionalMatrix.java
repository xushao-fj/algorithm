package com.xsm.algorithm;

/**
 * @author xsm
 * @date 2020/12/28
 * @Description 搜索二维矩阵
 */
public class SearchTwoDimensionalMatrix {

    public static void main(String[] args) {
        //int[][] matrix = new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int[][] matrix = new int[][]{{-1, 3}};
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }

    /**
     * 暴力拆解法
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int[] a = matrix[i];
            for (int j = 0; j < a.length; j ++){
                int b = a[j];
                if (target == b) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二分法
     * @param matrix
     * @param target
     * @return
     */
    public static boolean dichotomy(int[][] matrix, int target){
        boolean result = false;
        for (int i = 0; i < matrix.length; i++) {
            int[] a = matrix[i];
            int startIndex = 0;
            int endIndex = a.length - 1;
            int middle = (startIndex + endIndex) / 2;

            while (target == a[middle]) {
                if (target > a[middle]) {
                    startIndex = middle + 1;
                } else {
                    endIndex = middle - 1;
                }
                middle = (startIndex + endIndex) / 2;
            }
        }
        return result;
    }
}
