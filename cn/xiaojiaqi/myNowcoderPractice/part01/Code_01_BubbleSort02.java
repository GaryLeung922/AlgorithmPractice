package cn.xiaojiaqi.myNowcoderPractice.part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 * @Author: liangjiaqi
 * @Date: 2020/5/3 4:49 PM
 */
public class Code_01_BubbleSort02 extends AbstractSort{
    /**
     * 思路：[a,b,c,d,e,f,g]
     * 1. 顺序比较，指针指向第一个位置, 比较指针指向的位置与它的下一个位置。例如，a，b。如果此时a>b，交换位置，此时指针指向下一个位置
     * @param
     * @return
     */

    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length == 0){
            return;
        }
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[j+1]){
                    continue;
                }else {
                    swap(arr,j,j+1);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Code_01_BubbleSort02 sort02 = new Code_01_BubbleSort02();

        sort02.compareResult(999);
    }
}
