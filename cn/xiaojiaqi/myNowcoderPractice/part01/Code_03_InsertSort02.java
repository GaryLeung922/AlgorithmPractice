package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * 插入排序
 * 复杂度：时间复杂度O(N^2), 额外空间复杂度O(1)
 * 思路：
 * 和打扑克一样，从左到右，依次把扑克牌整理好。
 *
 * @Author: Gary
 * @Date: 2023/8/20 8:12 AM
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Code_03_InsertSort02 {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
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
            insertSort(arr1);
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
