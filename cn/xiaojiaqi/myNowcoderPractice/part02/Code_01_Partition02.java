package cn.xiaojiaqi.myNowcoderPractice.part02;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 * 给定一个数num，把数组中，小于num的放左边，大于num的放右边，等于的放中间
 *
 * @Author: Gary
 * @Date: 2023/8/20 10:28 AM
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Code_01_Partition02 {

    public static void partition(int[] arr, int flag) {
        if (arr == null || arr.length <= 1)
            return;
        int left = -1;
        int right = arr.length;
        for (int i = 0; i < right; ) {
            if (arr[i] < flag) {
                //如果小于，那么把小于边界的下一个数，和当前数，交换，指针向右走
                swap(arr, i++, ++left);
            } else if (arr[i] > flag) {
                //如果大于，那么把大于边界的下一个数，和当前数，交换，指针向右不走
                swap(arr, i, --right);
            } else {
                //如果等于，指针向右走
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr_0 = {1, 4, 2, 3, 0,2,2};
        int flag = 2;
        partition(arr_0, flag);
        System.out.println(Arrays.toString(arr_0));

        int[] arr = TestUtil.generateArr(5, 0, 10);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        flag = 5;
        boolean isSucc = false;
        for (int i = 300; i >= 0; i--) {
            partition(arr1, flag);
            Code_01_Partition.partition(arr2, flag);
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
