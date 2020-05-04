package cn.xiaojiaqi.sword2Offer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * DP,

	compare with LCS I, we have one more dimension to deal with
	so for the base case of third dimension, k,
	for k = 0, we do LCS I
	for k > 0, then we do another round of DP,
	```
	when two chars are equal, then dp[i][j][k] = dp[i -1][ j - 1][ k ]+ 1
	when two char are not the same, then dp[i][j][k] = max(dp[i - 1][j][k], dp[i][ j - 1][k] and dp[i - 1][j - 1][ k - 1] + 1), for this situation, we correct for once)
	```
	
	逻辑实现还有问题！！！
 * 
 * 
 * @author Narut0
 *
 */
public class LongestCommonSubsequenceTwo {
    /**
     * @param P: an integer array P
     * @param Q: an integer array Q
     * @param k: the number of allowed changes
     * @return: the length of lca with at most k changes allowed.
     */
    public int longestCommonSubsequenceTwo(int[] P, int[] Q, int k) {
        // Write your code here
        
        if(P==null||P.length==0||Q==null||Q.length==0)return 0;
       
        //dp[i][j] 表示已i结尾的A和以j结尾的B，最长公共子序列的长度。（可以不包括i，j）
        if(k<=0){
            int[][] dp = helper2(P,Q);
            return dp[P.length-1][Q.length-1];
        }else{
            int[][][] dp = helper1(P,Q,k);
            return dp[P.length-1][Q.length-1][k];
        }
        
    }
    
    public int[][] helper2(int[] c1,int[] c2){
        int[][] dp = new int[c1.length][c2.length];
        
        dp[0][0] = c1[0]==c2[0] ? 1 : 0;
        for(int i=1;i<c1.length;i++){
            dp[i][0] = Math.max((c1[i]==c2[0] ? 1 : 0),dp[i-1][0]);
        }
        for(int j=1;j<c2.length;j++){
            dp[0][j] = Math.max((c1[0]==c2[j] ? 1 : 0),dp[0][j-1]);
        }
        //核心逻辑
        for(int i=1;i<c1.length;i++){
            for(int j=1;j<c2.length;j++){
                dp[i][j] = c1[i]==c2[j] ? dp[i-1][j-1]+1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp;
    }
    public int[][][] helper1(int[] c1,int[] c2,int k){
        int[][][] dp = new int[c1.length][c2.length][k+1];
        
        dp[0][0][0] = c1[0]==c2[0] ? 1 : 0;
        
        for(int i=1;i<c1.length;i++){
            dp[i][0][0] = Math.max((c1[i]==c2[0] ? 1 : 0),dp[i-1][0][0]);
        }
        for(int j=1;j<c2.length;j++){
            dp[0][j][0] = Math.max((c1[0]==c2[j] ? 1 : 0),dp[0][j-1][0]);
        }
        for(int m=1;m<=k;m++){
            dp[0][0][m] = 1;
            for(int i=1;i<c1.length;i++){
                dp[i][0][m] = c1[i]==c2[0] ? 1 : Math.max(Math.max(dp[i-1][0][m],0),1);
            }
            for(int j=1;j<c2.length;j++){
                dp[0][j][m] = c1[0]==c2[j] ? 1 : Math.max(Math.max(0,dp[0][j-1][m]),1);
            }
        }
        //核心逻辑
        for(int m=1;m<=k;m++) {
	        for(int i=1;i<c1.length;i++){
	            for(int j=1;j<c2.length;j++){
	                dp[i][j][m] = c1[i]==c2[j] ? Math.max(Math.max(dp[i-1][j][m],dp[i][j-1][m]),dp[i-1][j-1][m]+1) : Math.max(Math.max(dp[i-1][j][m],dp[i][j-1][m]),dp[i-1][j-1][m-1]+1);
	            }
	        }
        }
        return dp;
    }
    public static void main(String[] args) {
    	LongestCommonSubsequenceTwo solution = new LongestCommonSubsequenceTwo();
		int[] P = {1,2,3,4,5};
		int[] Q = {5,3,1,4,2};
		int k = 1;
		
		int ans = solution.longestCommonSubsequenceTwo(P, Q, k);
		System.out.println(ans);
		
		ConcurrentLinkedQueue<Integer> ss;
		HashMap<Integer, Integer> map;
	}
}