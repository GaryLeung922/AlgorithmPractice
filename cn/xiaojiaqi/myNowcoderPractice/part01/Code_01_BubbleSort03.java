package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 * 复杂度：时间复杂度O(N^2)，额外空间复杂度O(1)
 * 思路：
 *  从左往右，两个相邻的数比较，左边的数大于右边则交换
 *
 * @Author: Gary
 * @Date: 2023/8/20 7:14 AM
 * @Version: v1.0.0
 * @Description:
 **/
public class Code_01_BubbleSort03 {


    /**
     * @param arr
     * @return
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int j = arr.length; j > 0; j--) {
            // j 代表目前数组有序的左边界，[j,arr.length)都有序
            for (int i = 0; i + 1 < j; i++) {
                // 相邻的做比较, 如果大于则交换
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            }
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
        int[] arr = TestUtil.generateArr();
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        for (int i = 300; i >= 0; i--) {
            bubbleSort(arr1);
            Arrays.sort(arr2);
            isSucc = Arrays.equals(arr1, arr2);
            if (!isSucc)
                break;
            arr = TestUtil.generateArr();
            arr1 = Arrays.copyOf(arr, arr.length);
            arr2 = Arrays.copyOf(arr, arr.length);
        }
        System.out.println(isSucc ? "" : "arr =" + Arrays.toString(arr1) + "\narr1=" + Arrays.toString(arr1) + "\narr2=" + Arrays.toString(arr1));
        System.out.println(isSucc ? "Nice" : "Fuck");
    }
}
