package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/27 1:22 PM
 */
public class LeetCode_213_House_Robber2 {
    class Solution {
        public int rob(int[] nums) {
            if(nums==null || nums.length==0)return 0;
            if(nums.length==1)return nums[0];

            int[] dp = new int[nums.length+1];

            // 第一个房间不抢
            for(int i=2;i<dp.length;i++){
                // 第i个房间，抢 和 不抢
                if(i-2>=0){
                    dp[i] = Math.max(nums[i-1]+dp[i-2],dp[i-1]);
                }else{
                    dp[i] = Math.max(nums[i-1]+0,dp[i-1]);
                }
            }

            int[] dp1 = new int[nums.length];
            // 最后一个房间不抢
            for(int i=1;i<dp1.length;i++){
                if(i-2>=0){
                    dp1[i] = Math.max(nums[i-1]+dp1[i-2],dp1[i-1]);
                }else{
                    dp1[i] = Math.max(nums[i-1]+0,dp1[i-1]);
                }
            }
            return Math.max(dp[dp.length-1],dp1[dp1.length-1]);
        }
    }
}
