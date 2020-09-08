package cn.xiaojiaqi.leetcode;

/**
 * @Author: Gary Leung
 * @Date: 9/8/20 10:50 PM
 */
public class LeetCode_167_TwoSum2 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length-1;
            while (left<right){
                int sum =numbers[left]+numbers[right];
                if(sum<target){
                    left++;
                }else if(sum>target){
                    right--;
                }else if(sum==target){
                    return new int[]{++left, ++right};
                }
            }
            return null;
        }
    }
}
