package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * @Author: Gary Leung
 * @Date: 5/4/20 11:19 AM
 */
public class Code_05_SmallSum02 {
    public static int forceMethod(int[] arr){
        if(arr == null || arr.length <2){
            return 0;
        }

        int sum = 0;

        for(int i =0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    sum += arr[j];
                }
            }
        }
        return sum;
    }
    public static int mergeSort(int[] arr){
        return mergeSort(arr, 0 ,arr.length-1);
    }

    private static int mergeSort(int[] arr, int L, int R) {
        if(L >= R){
            return 0;
        }
        int mid = L + ((R-L)>>1);
        return mergeSort(arr, L , mid)
        + mergeSort(arr,mid+1, R)
        + merge(arr, L, R);
    }

    private static int merge(int[] arr, int l, int r) {
        int[] help = new int[r-l+1];
        int mid = l + ((r-l)>>1);
        int a = l;
        int b = mid+1;
        int h = 0;
        int sum = 0;
        while(a<=mid && b<= r){
            if(arr[a]< arr[b]){
                sum += (arr[a] * (r-b+1));
                help[h++] = arr[a++];
            }else {
                help[h++] = arr[b++];
            }
        }
        while(a<=mid){
            help[h++] = arr[a++];
        }
        while (b<=r){
            help[h++] = arr[b++];
        }

        for(int i=0;i<help.length;i++){
            arr[l++] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ints = TestUtil.generateArr(1, 5, 0, 10)[0];

        System.out.println(Arrays.toString(ints));
        int r1 = forceMethod(ints);
        int r2 = mergeSort(ints);

        System.out.println(r1+":"+r2);

        for(int i=0;i<9999;i++){
            int[] ints1 = TestUtil.generateArr();
            int i1 = forceMethod(ints1);
            int i2 = mergeSort(ints1);
            if(i1 != i2){
                System.out.println("Fail!");
            }
        }

    }
}
