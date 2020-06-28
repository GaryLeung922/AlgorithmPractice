package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/6/28 8:04 AM
 */
public class LeetCode_027_Remove_Element {
}

class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)return 0;

        int length = nums.length;
        for(int i=0;i<length;){
            if(val == nums[i]){
                swap(nums, i, length-1);
                length--;
            }else{
                i++;
            }
        }
        return length;

    }
    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}