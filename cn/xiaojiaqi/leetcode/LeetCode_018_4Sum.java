package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/9 1:11 PM
 */
public class LeetCode_018_4Sum {
    /**
     * 四数之和转化为三数之和，三数之和再转化为二数之和
     */
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if(nums==null || nums.length<4)return Collections.emptyList();

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for(int i=0;i<nums.length;i++){
                if(i>=1 && nums[i]==nums[i-1])continue;
                List<List<Integer>> twoum = threeSum(nums, target - nums[i],i+1);
                for(List<Integer> list: twoum){
                    list.add(nums[i]);
                    res.add(list);
                }
            }
            return res;

        }

        private List<List<Integer>> threeSum(int[] nums, int target, int left) {

            List<List<Integer>> res = new ArrayList<>();

            for(int i=left;i<nums.length;i++){
                if(i>=left+1 && nums[i]==nums[i-1])continue;
                List<List<Integer>> twoum = twoum(nums, target - nums[i], i+1);
                for(List<Integer> list: twoum){
                    ((ArrayList<Integer>)list).add(nums[i]);
                    res.add(list);
                }
            }
            return res;
        }

        private List<List<Integer>> twoum(int[] nums, int target, int left) {
            List<List<Integer>> res = new ArrayList<>();
            int right = nums.length-1;
            while (left<right){
                int sum = nums[left] + nums[right];
                if(sum==target){
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[left++],nums[right--])));
                    while(left <= right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right >= left && nums[right]==nums[right+1]){
                        right--;
                    }
                }else if(sum>target){
                    right--;
                }else {
                    left++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        List<List<Integer>> lists = solution.fourSum(nums, 0);
        System.out.println(lists);
    }
}
