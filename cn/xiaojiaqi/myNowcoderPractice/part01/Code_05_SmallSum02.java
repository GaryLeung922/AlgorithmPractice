package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * 小和问题
 * 小和问题：
 * 在一个数组中，每一个数，其左边比其小的数累加起来，叫做这个数组的小和。求一个数组
 * 的小和。
 * eg:
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 * <p>
 * 思路:
 *  利用归并排序，在每一次归并的merge过程中，求出右边数组的小和。
 *
 * @Author: Gary
 * @Date: 2023/8/20 9:27 AM
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Code_05_SmallSum02 {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length <= 1)
            return 0;
        int[] copy = Arrays.copyOf(arr, arr.length);
        int[] help = new int[arr.length];
        return mergeSort(copy, 0, copy.length - 1, help);
    }

    // 暴力法
    public static int smallSum02(int[] arr){
        if (arr == null || arr.length <= 1)
            return 0;
        int smallSum = 0;
        for (int i=0; i<arr.length;i++){
            for (int j=0;j<i;j++){
                smallSum += arr[j]<arr[i] ? arr[j] : 0;
            }
        }
        return smallSum;
    }

    public static int mergeSort(int[] arr, int a, int b, int[] help) {
        if (a == b)
            return 0;
        int mid = a + ((b - a) >> 1);
        //最后的小和等于所有merge过程中的小和累加（包括当前的merge）
        return mergeSort(arr, a, mid, help) + mergeSort(arr, mid + 1, b, help) + merge(arr, a, mid, b, help);
    }

    public static int merge(int[] arr, int a, int mid, int b, int[] help) {
        int i = a;
        int j = mid + 1;
        int index = a;
        int smallSum = 0;
        while (i <= mid && j <= b) {
            if (arr[i] < arr[j]) {
                help[index++] = arr[i];
                // 如果左边的数小于右边的数，那么对于左边的这个数来说，右边的所有数的小和可以一起累加
                smallSum += arr[i++] * (b - j + 1);
            } else {
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
        return smallSum;
    }

    public static void main(String[] args) {
        int[] arr_0 = {1,3,4,2,5};
        System.out.println(smallSum(arr_0));
        boolean isSucc = false;
        int[] arr = TestUtil.generateArr(5, 0, 10);
        for (int i=0 ;i<999;i++){
            int r1 = smallSum(arr);
            int r2 = smallSum02(arr);
            isSucc = r1 == r2;
            if (!isSucc)
                break;
        }
        System.out.println(isSucc ? "Nice" : "Fuck");

    }
}
