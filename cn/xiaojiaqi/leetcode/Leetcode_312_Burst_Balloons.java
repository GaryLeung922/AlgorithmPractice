package cn.xiaojiaqi.leetcode;

public class Leetcode_312_Burst_Balloons {
	//Recurtion brute force
	//化解为子问题.假设最后一个留下来爆破的气球的原来位置为k.
	//原问题[0,...,k,...n-1] 
	//可以化解为求不同的k, 使得 max(0,k-1)+nums[k-1]*nums[k]*nums[k+1]+max(k+1,n-1) 最大
	public static int maxCoins(int[] nums) {
        if(nums.length==0)return 0;
        
        int n = nums.length;
        int[] help = new int[n+2];
        help[0]=1;
        for(int i=0;i<n;i++){
            help[i+1]=nums[i];
        }
        help[n+1]=1;
        
        return p(help,1,n);
	}
    private static int p(int[] help, int i, int j) {
    	if(i>j)return 0;
		if(i==j)return help[i-1]*help[i]*help[i+1];
		
		int max = 0;
    	for(int k=i;k<=j;k++) {
    		max = Math.max(max,p(help,i,k-1)+help[i-1]*help[k]*help[j+1]+p(help, k+1, j));
    	}
		return max;
	}
    //DP 花花酱
    //dp[i][j] = max(nums[i:j+1])  :i到j子数组能获得的最大硬币
    public static int maxCoinsDP(int[] nums) {
        if(nums.length==0)return 0;
        
        int n = nums.length;
        int[] help = new int[n+2];
        help[0]=1;
        for(int i=0;i<n;i++){
            help[i+1]=nums[i];
        }
        help[n+1]=1;
        
        int[][] dp = new int[n+2][n+2];
        for(int l=1;l<=n;l++) { //l : [i,j]长度
        	for(int i=1;i<=n-l+1;i++) {
        		int j=i+l-1;
        		for(int k=i;k<=j;k++) {//[i,j] 最后留下的位置
        			//key point
        			dp[i][j] = Math.max(dp[i][j], dp[i][k-1]+help[i-1]*help[k]*help[j+1]+dp[k+1][j]);
        		}
        	}
        }
        return dp[1][n];
    }
	public static void main(String[] args) {
		int[] nums = {8,3,4,3,5,0,5,6,6,2,8,5,6,2,3,8,3,5,1,0,2};
		int ans = maxCoinsDP(nums);
		System.out.println(ans);
	}
}
