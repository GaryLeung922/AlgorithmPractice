package cn.xiaojiaqi.myNowcoderPractice.part02;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * 随机快排
 *
 * @Author: Gary
 * @Date: 2023/8/20 10:54 AM
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Code_02_QuickSort02 {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 1)
            return;

        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int a, int b) {
        if (arr == null || arr.length == 1)
            return;
        if (a >= b) return;
        int index = (int) Math.floor(Math.random() * (b - a) + a);
        int flag = arr[index];
        int[] partition = partition(arr, a, b, flag);
        quickSort(arr, a, partition[0] - 1);
        quickSort(arr, partition[1] + 1, b);
    }

    /**
     * partition 把数组从a到b的区间，按比flag小的放左边，等于的中间，大于的放右边排列好。
     *
     * @param arr
     * @param flag
     * @return 范围中间等于的边界
     */
    public static int[] partition(int[] arr, int a, int b, int flag) {
        if (arr == null || arr.length <= 1)
            throw new RuntimeException("数组为空或数组长度小于等于1");
        if (a > b || a < 0 || b >= arr.length) {
            throw new RuntimeException("给定的a，b越界");
        }
        int left = a - 1;
        int right = b + 1;
        for (int i = a; i < right; ) {
            if (arr[i] < flag) {
                swap(arr, i++, ++left);
            } else if (arr[i] == flag) {
                i++;
            } else {
                swap(arr, i, --right);
            }
        }
        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        int[] arr_0 = {3, 9, 4, 10, 3};
        quickSort(arr_0);
        System.out.println(Arrays.toString(arr_0));

        int[] arr = TestUtil.generateArr(5, 0, 10);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        boolean isSucc = false;
        for (int i = 300; i >= 0; i--) {
            quickSort(arr1);
            Arrays.sort(arr2);
            isSucc = Arrays.equals(arr1, arr2);
            if (!isSucc)
                break;
            if (i < 5) {
                System.out.println("debug:arr =" + Arrays.toString(arr) + "\tarr1=" + Arrays.toString(arr1) + "\tarr2=" + Arrays.toString(arr2));
            }
            arr = TestUtil.generateArr(5, 0, 10);
            arr1 = Arrays.copyOf(arr, arr.length);
            arr2 = Arrays.copyOf(arr, arr.length);
        }
        System.out.println(isSucc ? "" : "arr =" + Arrays.toString(arr) + "\narr1=" + Arrays.toString(arr1) + "\narr2=" + Arrays.toString(arr2));
        System.out.println(isSucc ? "Nice" : "Fuck");
    }
}
