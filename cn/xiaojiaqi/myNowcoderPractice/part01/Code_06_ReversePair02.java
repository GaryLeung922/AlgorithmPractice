package cn.xiaojiaqi.myNowcoderPractice.part01;

import java.util.Arrays;

/**
 * 逆序对问题
 * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
 * 对。
 * @Author: Gary
 * @Date: 2023/8/20 10:05 AM
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Code_06_ReversePair02 {


    public static void reversePair(int[] arr){
        if (arr == null || arr.length <= 1)
            return ;

        int[] copy = Arrays.copyOf(arr, arr.length);
        int[] help = new int[arr.length];
        mergeSort(copy, 0, copy.length - 1, help);
    }

    // 暴力法
    public static void smallSum02(int[] arr){
        int smallSum = 0;
        for (int i=0; i<arr.length;i++){
            for (int j=0;j<i;j++){
                smallSum += arr[j]<arr[i] ? arr[j] : 0;
            }
        }
    }

    public static void mergeSort(int[] arr, int a, int b, int[] help) {
        if (a == b) return;
        int mid = a + ((b - a) >> 1);
        //最后的逆序对只要打印出所有merge过程中的逆序对即可（包括当前的merge）
        mergeSort(arr, a, mid, help);
        mergeSort(arr, mid + 1, b, help);
        merge(arr, a, mid, b, help);
    }

    public static void merge(int[] arr, int a, int mid, int b, int[] help) {
        int i = a;
        int j = mid + 1;
        int index = a;
        while (i <= mid && j <= b) {
            if (arr[i] <= arr[j]) {
                help[index++] = arr[i++];
            } else {
                for (int tmp = i; tmp <= mid ; tmp++){
                    System.out.println(arr[tmp]+","+arr[j]);
                }
                help[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            help[index++] = arr[i++];
        }
        while (j <= b) {
            help[index++] = arr[j++];
        }
        for (; a <= b; a++) {
            arr[a] = help[a];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,2,4};
        reversePair(arr);

        int[] arr2 = {1,3,4,2,5};
        reversePair(arr2);
    }
}
