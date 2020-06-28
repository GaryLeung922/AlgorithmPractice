package cn.xiaojiaqi.leetcode;

/**
 *
 * @Author: liangjiaqi
 * @Date: 2020/6/28 9:02 PM
 */
public class LeetCode_189_Rotate_Array {

    class Solution {
        public void rotate(int[] nums, int k) {
            if(nums==null||nums.length==0)return;
            if(k>nums.length){
                k = k%nums.length;
            }
            rotate(nums,0,(nums.length-k)-1);
            rotate(nums,nums.length-k,nums.length-1);
            rotate(nums,0,nums.length-1);

        }

        public void rotate(int[] nums, int i, int j){
            while(i<j){
                swap(nums,i++,j--);
            }
        }
        public void swap(int[] nums, int i,int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
