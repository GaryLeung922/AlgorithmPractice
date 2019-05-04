package cn.xiaojiaqi.leetcode;
public class Leetcode_494_Target_Sum {
    // Brute Force
    // public int findTargetSumWays(int[] nums, int S) {
    //     return findTargetSumWays(nums,S,0);
    // }
    // public int findTargetSumWays(int[] nums,int S,int i){
    //     if(i==nums.length)return S==0 ? 1 : 0;
    //     return findTargetSumWays(nums,S+nums[i],i+1)+findTargetSumWays(nums,S-nums[i],i+1);
    // }
    
    
    //DP
    public static int findTargetSumWays(int[] nums, int S) {
        int max = S;
        int min = S;
        for(int i=0;i<nums.length;i++){
            max+=nums[i];
            min-=nums[i];
        }
        int[][] dp = new int[nums.length+1][max-min+1];
        if(min>0)return 0;
        dp[nums.length][-min] = 1;
        for(int i=dp.length-2;i>=0;i--){
            for(int j=0;j<dp[0].length;j++){
                int addNum = j+nums[i]<dp[0].length ? dp[i+1][j+nums[i]] : 0;
                int subNum = j-nums[i]>=0 ? dp[i+1][j-nums[i]] : 0;
                dp[i][j] = addNum+subNum;
            }
        }
        return dp[0][S-min];
        
    }
    public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int S = 3;
		int ans = findTargetSumWays(nums, S);
		System.out.println(ans);
	}
    
}