package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/30 1:34 PM
 */
public class Leetcode_300_Longest_Increasing_Subsequence_02 {
    public static void main(String[] args) {
        Leetcode_300_Longest_Increasing_Subsequence_02 c = new Leetcode_300_Longest_Increasing_Subsequence_02();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int lis = c.lengthOfLIS(nums);
        System.out.println(lis);
    }

    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums,0,Integer.MIN_VALUE);
    }

    public int lengthOfLIS(int[] nums, int i, int last){
        if(i==nums.length){
            return 0;
        }
        if(nums[i]<=last){
            return lengthOfLIS(nums,i+1,last);
        }
        return Math.max(lengthOfLIS(nums,i+1,nums[i])+1, lengthOfLIS(nums,i+1,last));
    }

    /**
     * DP 时间复杂度O(n^2) ,空间O(n)
     */
    class Solution02 {
        public int lengthOfLIS(int[] nums) {
            if(nums==null || nums.length==0)return 0;

            // 以nums[i]结尾的最长LIS。（一定包含nums[i]）
            int[] dp = new int[nums.length];

            for(int i=0;i<dp.length;i++){
                int maxLen = 0;
                for(int j=i-1;j>=0;j--){
                    if(nums[j]<nums[i]){
                        maxLen = Math.max(maxLen,dp[j]);
                    }
                }
                dp[i] = maxLen+1;
            }

            int result = 0;
            for(int i=0;i<dp.length;i++){
                result = Math.max(result,dp[i]);
            }
            return result;
        }
    }
}
