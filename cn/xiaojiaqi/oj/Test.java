package cn.xiaojiaqi.oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/26 4:03 PM
 */
public class Test {

    public static void main(String args[]) {
        int[] arr = {110, 67, 111, 95, 98, 115, 118};

        int i = countGroupAgeMoreThanHalf(arr);
        System.out.println(i);

        // 思路正确  结果正确    没有判空异常处理  结果错误 有判空处理 非最佳解法 api使用有问题 代码不规范 代码有bug


    }
    public static int countGroupAgeMoreThanHalf(int[] a){
        int count = 1;
        int left = 0;
        int right = 1;
        int length = a.length;
        while(left<=length-count){
            int target = a[left];
            right = left+1;
            while(right<length){
                if(a[right]>target){
                    target = a[right];
                    continue;
                }else{
                    break;
                }
            }
            if((right-left)>count){
                count = right-left;
            }
            left = right;
        }
        return count;
    }
}
