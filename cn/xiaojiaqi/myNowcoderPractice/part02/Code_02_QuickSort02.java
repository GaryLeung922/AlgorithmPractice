package cn.xiaojiaqi.myNowcoderPractice.part02;

import cn.xiaojiaqi.common.TestUtil;
import cn.xiaojiaqi.myNowcoderPractice.part01.AbstractSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Gary Leung
 * @Date: 5/14/20 9:16 PM
 */
public class Code_02_QuickSort02 extends AbstractSort {
    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        internalSort(arr, 0, arr.length-1);
    }
    private void internalSort(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int[] p = partition(arr, L, R);
        if(p != null){
            internalSort(arr,L, p[0]-1);
            internalSort(arr,p[1]+1,R);
        }
    }

    private int[] partition(int[] arr, int L, int R){
        if(L >= R){
            return null;
        }
        swap(arr,R, (int) (Math.random()*(R-L)+L));
        int a = L-1;
        int b = R;
        int c = L;
        int cur = arr[R];
        while (c < b){
            if(arr[c] < cur){
                swap(arr, c++, ++a);
            }else if(arr[c] == cur){
                c++;
            }else {
                swap(arr, c, --b);
            }
        }
        swap(arr, R, b);
        return new int[]{a+1, b};
    }

    public static void main(String[] args) {
        Code_02_QuickSort02 sort02 = new Code_02_QuickSort02();
        sort02.compareResult(99999);

//        boolean flag = true;
//        for(int i=0;i<5000000;i++){
//            int[] ints = TestUtil.generateArr(1,5,0,10)[0];
//            int[] ints1 = Arrays.copyOf(ints, ints.length);
//
//            sort02.sort(ints);
//            Arrays.parallelSort(ints1);
//            boolean result = Arrays.equals(ints, ints1);
//            if(!result) {
//                System.out.println(Arrays.toString(ints));
//                System.out.println(Arrays.toString(ints1));
//                flag = false;
//                break;
//            }
        //}
    }
}
