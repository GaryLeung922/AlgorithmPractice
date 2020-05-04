package cn.xiaojiaqi.leetcode;
public class Leetcode_62_Unique_Paths {
    // brute force  TLE
//     public int uniquePaths(int m, int n) {
//         return p(0,0,m,n);
//     }
//     public int p(int i,int j,int m,int n){
//         if(i==m-1&&j==n-1)return 1;
        
//         if(i>=m||j>=n||i<0||j<0)return 0;
        
//         return p(i,j+1,m,n)+p(i+1,j,m,n);
//     }
    //DP 1ms
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--)dp[i][n-1]=1;
        for(int i=n-1;i>=0;i--)dp[m-1][i]=1;
        
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];
    }
    
}