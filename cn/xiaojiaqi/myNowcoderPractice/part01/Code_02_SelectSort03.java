package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * 选择排序
 * 复杂度：时间复杂度O(N^2)，额外空间复杂度O(1)
 * 思路：
 * 从数组中选出最大的与最后一个交换，此时数组的右边界向右缩一个，依此类推，直到数组完全排好序
 *
 * @Author: Gary
 * @Date: 2023/8/20 7:45 AM
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Code_02_SelectSort03 {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int j = arr.length; j > 0; j--) {
            // 当前的最大值
            int max = arr[0];
            // 最大值的索引
            int max_index = 0;
            for (int i = 1; i < j; i++) {
                max_index = arr[i] > max ? i : max_index;
                max = arr[i] > max ? arr[i] : max;
            }
            swap(arr, max_index, j - 1);
        }
    }

    /**
     * 两数交换
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        boolean isSucc = false;
        int[] arr = TestUtil.generateArr_unique(3, 0 ,5);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        for (int i = 300; i >= 0; i--) {
            selectSort(arr1);
            Arrays.sort(arr2);
            isSucc = Arrays.equals(arr1, arr2);
            if (!isSucc)
                break;
            arr = TestUtil.generateArr();
            arr1 = Arrays.copyOf(arr, arr.length);
            arr2 = Arrays.copyOf(arr, arr.length);
        }

        System.out.println(isSucc ? "" : "arr =" + Arrays.toString(arr) + "\narr1=" + Arrays.toString(arr1) + "\narr2=" + Arrays.toString(arr2));
        System.out.println(isSucc ? "Nice" : "Fuck");
    }
}
