package cn.xiaojiaqi.myNowcoderPractice.part01;

import java.util.Arrays;

/**
 * 归并排序
 * 复杂度：时间复杂度O(NlogN),额外空间复杂度O(N)
 * 思路：
 * 把数组对半分，分别排好序之后，再合并
 *
 * @Author: Gary
 * @Date: 2023/8/20 8:23 AM
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Code_04_MergeSort02 {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int[] help = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, help);
    }

    public static void mergeSort(int[] arr, int a, int b, int[] help) {
        if (a == b)
            return;

        // 位运算符优先级低于算术运算符
        int mid = a + ((b - a) >> 1);
        // 左边有序 [a,mid]
        mergeSort(arr, a, mid, help);
        // 右边有序 [mid+1, b]
        mergeSort(arr, mid + 1, b, help);
        // 两边都有序之后，做合并
        merge(arr, a, mid, b, help);
    }

    /**
     * 数组的merge过程
     * [a,mid] 是第一个数组的边界
     * [mid+1,b] 是第二个数组的边界
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void merge(int[] arr, int a, int mid, int b, int[] help) {
        int i = a;
        int j = mid + 1;
        int index = a;
        while (i <= mid && j <= b) {
            if (arr[i] <= arr[j]) {
                help[index++] = arr[i++];
            } else {
                help[index++] = arr[j++];
            }
        }
        while (i <= mid)
            help[index++] = arr[i++];
        while (j <= b)
            help[index++] = arr[j++];
        for (;a<=b;a++){
            arr[a] = help[a];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,3,4,6,3,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
