package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

/**
 * 双指针整理：
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shuang-zhi-zhen-zhi-tong-xiang-zhi-zhen-che-di-jie/
 * @Author: liangjiaqi
 * @Date: 2020/6/28 8:31 AM
 */
public class LeetCode_026_Remove_Dup_From_Sorted_Array {



    static class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums==null||nums.length==0)return 0;

            int length = nums.length;
            int max = nums[0];
            int left = 0;
            int right = 0;
            for(int i=1;i<length;){
                if(nums[i]>max){
                    if(right>left){
                        leftShift(nums,left+1,right,length);
                        i -= (right-left);
                        length -= (right-left);
                    }
                    max = nums[i];
                    left = i;
                    right = i;
                }else{
                    right = i;
                }
                i++;
            }
            if(right>left) {
                leftShift(nums, left + 1, right, length);
                length -= (right-left);
            }
            return length;

        }
        private void leftShift(int[] nums,int begin,int end,int len){
            for(int i=begin;i+(end-begin)<len;i++){
                swap(nums,i,end+(i-begin)+1);
            }
        }
        private void swap(int[] nums, int a, int b){
            if(b>=nums.length)return;
            nums[a] = nums[b];
        }

    }

    /**
     * 解法二：双指针
     */
    static class Solution2{
        // 双指针
        public int removeDuplicates(int[] nums) {
            if(nums==null||nums.length==0)return 0;
            int a = 0;
            int b = 1;
            while(b<nums.length){
                if(nums[a]==nums[b]){
                    b++;
                }else{
                    swap(nums,++a,b++);
                }
            }
            return a+1;
        }
        public void swap(int[] nums,int i,int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = s.removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{1,1};
        int len2 = s.removeDuplicates(arr2);
        System.out.println(Arrays.toString(arr2));

    }
}


