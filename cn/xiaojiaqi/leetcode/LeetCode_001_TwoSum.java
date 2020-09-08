package cn.xiaojiaqi.leetcode;

import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.*;

/**
 * @Author: Gary Leung
 * @Date: 9/8/20 10:17 PM
 */
public class LeetCode_001_TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            if(nums==null || nums.length<2)return null;
            int[] arr = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                arr[i] = nums[i];
            }

            Arrays.sort(nums);

            int left = 0;
            int right = nums.length-1;
            while (left<right){
                int sum =nums[left]+nums[right];
                if(sum<target){
                    left++;
                }else if(sum>target){
                    right--;
                }else if(sum==target){
                    left = nums[left];
                    right = nums[right];
                    break;
                }
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]==left){
                    left = i;
                    break;
                }
            }
            for(int j=0;j<arr.length;j++){
                if(arr[j]==right && j!=left){
                    right = j;
                    break;
                }
            }
            return new int[]{left, right};
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, -8);
        System.out.println(Arrays.toString(ints));
    }
}
