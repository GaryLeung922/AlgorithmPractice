package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * @Author: liangjiaqi
 * @Date: 2020/5/3 5:38 PM
 */
public class Code_02_SelectSort02 extends AbstractSort{

    public static void selectSort(int[] arr){

    }

    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length <2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=i;j<arr.length;j++){
                if(arr[minIndex]>=arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,minIndex, i);
        }
    }

    public static void main(String[] args) {
         Code_02_SelectSort02 sort02 = new Code_02_SelectSort02();
         sort02.compareResult(999);
    }
}
