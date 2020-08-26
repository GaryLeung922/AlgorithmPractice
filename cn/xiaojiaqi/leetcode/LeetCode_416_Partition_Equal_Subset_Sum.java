package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/24 10:48 PM
 */
public class LeetCode_416_Partition_Equal_Subset_Sum {
    static class Solution {
        public boolean canPartition(int[] nums) {
            if(nums==null || nums.length==0)return false;

            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
            }
            if(sum%2!=0)return false;

            sum = sum/2;

            // dp[i][j] 到第i个（从1开始）元素时，总和可以凑成j吗？ [0,i-1] 是不是可以凑成j
            boolean[][] dp = new boolean[nums.length+1][sum+1];
            for(int i=0;i<dp.length;i++){
                dp[i][0] = true;
            }

            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    dp[i][j] = dp[i-1][j];
                    if(j-nums[i-1]>=0){
                        dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                    }
                }
                if(dp[i][dp[0].length-1])return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};

        Solution s = new Solution();

        boolean b = s.canPartition(nums);
    }
}
