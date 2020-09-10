package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/9 12:32 PM
 */
public class LeetCode_015_3Sum {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if(nums==null || nums.length<3)return Collections.emptyList();

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for(int i=0;i<nums.length;i++){
                if(i>=1 && nums[i]==nums[i-1])continue;
                int left = i+1;
                int right = nums.length-1;
                while (left<right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum==0){
                        res.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                        while(left <= right && nums[left]==nums[left-1]){
                            left++;
                        }
                        while(right >= left && nums[right]==nums[right+1]){
                            right--;
                        }
                    }else if(sum>0){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }
}
