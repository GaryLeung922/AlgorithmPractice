package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * @Author: liangjiaqi
 * @Date: 2020/5/3 5:53 PM
 */
public abstract class AbstractSort implements IntSort {

    @Override
    public abstract void sort(int[] arr);

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public boolean compareResult(int times){
        boolean result = true;
        for(int i=0;i<times;i++){
            int[] ints = TestUtil.generateArr();
            int[] ints1 = Arrays.copyOf(ints, ints.length);

            sort(ints);
            Arrays.parallelSort(ints1);
            result = Arrays.equals(ints,ints1);
            if(!result) {
                System.out.println(Arrays.toString(ints));
                System.out.println(Arrays.toString(ints1));
                break;
            }
        }
        System.out.println(result ? "Bingo" : "Failed");
        return result;
    }
    public boolean compareResult(){
        return compareResult(9999);
    }
}
