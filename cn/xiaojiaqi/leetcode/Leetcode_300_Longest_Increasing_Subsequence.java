package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

public class Leetcode_300_Longest_Increasing_Subsequence {
    //1.Recursion with memorization
    
     public int lengthOfLIS1(int[] nums) {
         if(nums==null||nums.length==0)return 0;
        
         int max = 0;
         int[] help = new int[nums.length];
         for(int i=0;i<nums.length;i++){
             int tmax = p(nums,i,help);
             help[i]=tmax;
             max = Math.max(max,tmax);
         }
         return max;
     }
     //返回以i结尾的的最长递增子序列的个数
     public int p(int[] nums,int i,int[] help){
         if(i==0)return 1;
        
         int leftMax = 0;
         for(int j=0;j<i;j++){
             if(nums[j]<nums[i]){
                 leftMax = Math.max(leftMax,help[j]);
             }
         }
         return leftMax+1;
     }
    //2.DP
    public int lengthOfLIS2(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<nums.length;i++){
            int leftMax = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])leftMax = Math.max(leftMax,dp[j]);
            }
            dp[i] = leftMax+1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    
    //DP whit Binary search
    public static int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
		int[] nums = {0, 8, 4, 12, 2};
		int ans = lengthOfLIS3(nums);
		System.out.println(ans);
	}
}