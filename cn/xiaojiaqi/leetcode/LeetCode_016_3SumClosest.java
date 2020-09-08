package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/8 3:53 PM
 */
public class LeetCode_016_3SumClosest {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if(nums==null||nums.length==0)return -1;
            Arrays.sort(nums);

            int res = target >=0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            for(int i=0;i<nums.length-2;i++){
                int left = i+1;
                int right = nums.length-1;
                int tar = target-nums[i];
                while (left<right){
                    if(tar>nums[left]+nums[right]){
                        res = Math.abs(nums[i]+nums[left]+nums[right]-target) > Math.abs(res-target) ? res : nums[i]+nums[left]+nums[right];
                        left++;
                    }else if(tar<nums[left]+nums[right]){
                        res = Math.abs(nums[i]+nums[left]+nums[right]-target) > Math.abs(res-target) ? res : nums[i]+nums[left]+nums[right];
                        right--;
                    }else {
                        return target;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2,1,-2,3};
        int target = 5;

        int closest = solution.threeSumClosest(nums, target);
        System.out.println(closest);
    }
}
