package cn.xiaojiaqi.leetcode;
public class Solution322 {
    // brute force   TLE
    public static int coinChange(int[] coins, int amount) {
        int min = p(coins,0,0,amount);
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    public static int p(int[] coins,int i,int n,int target){
        if(target==0)return n;
        if(i>=coins.length)return Integer.MAX_VALUE;
        
        int minN = Integer.MAX_VALUE;
        for(int j=0;target-j*coins[i]>=0;j++){
            minN = Math.min(minN,p(coins,i+1,n+j,target-j*coins[i]));
        }
        return minN;
    }
    
    //DP
//     public int coinChange(int[] coins, int amount) {
        
//     }
    public static void main(String[] args) {
		int[] coins = {288,160,10,249,40,77,314,429};
		int amount = 9208;
		int ans = coinChange(coins, amount);
		System.out.println(ans);
	}
}