package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/24 9:37 PM
 */
public class LeetCode_053_Max_Subarray {
    /**
     * DP
     * dp[i] 以nums[i]为结尾的最大子数组的和
     * dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
     *
     * base case : dp[0] = nums[0];
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }

            // dp[i] 以nums[i]为结尾的最大子数组的和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i=1;i<dp.length;i++){
                dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            }
            int result = dp[0];
            for(int i=0;i<dp.length;i++){
                result = Math.max(result,dp[i]);
            }
            return result;
        }
    }

    /**
     * DP 优化
     * 压缩
     */
    class Solution2 {
        public int maxSubArray(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            int dp0 = nums[0];
            int max = Integer.MIN_VALUE;
            for(int i=1;i<nums.length;i++){
                int dp1 = Math.max(dp0+nums[i],nums[i]);
                max = Math.max(max, dp1);
                dp0 = dp1;
            }
            return max;
        }
    }
}
