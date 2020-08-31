package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/26 1:10 PM
 */
public class LeetCode_198_House_Robber {
    class Solution {
        public int rob(int[] nums) {
            if(nums==null||nums.length==0)return 0;
            //dp[i][0] 当前第i家不抢劫，可以得到的最大收益
            //dp[i][1] 当前第i家抢劫，可以得到的最大收益
            int[][] dp = new int[nums.length+1][2];

            for(int i=1;i<dp.length;i++){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
                dp[i][1] = dp[i-1][0]+nums[i-1];
            }

            return Math.max(dp[nums.length][0], dp[nums.length][1]);
        }
    }
}
