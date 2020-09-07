package cn.xiaojiaqi.catalog.dp;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/7 8:17 AM
 */
public class BagProblam {
    static class Solution{
        public int mostValue(int[] val, int[] wt, int W){
            if(val==null || wt==null || W<=0)return 0;
            if(val.length!=wt.length)return  0;

            int[][] dp = new int[val.length+1][W+1];

            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    dp[i][j] = dp[i-1][j];
                    if(j-wt[i-1]>=0){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-wt[i-1]]+val[i-1]);
                    }
                }
            }
            return dp[dp.length-1][dp[0].length-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] val=  new int[]{4,2,3};
        int[] wt = new int[]{2,1,3};
        int W = 5;
        int mostValue = solution.mostValue(val, wt, W);
        System.out.println(mostValue);
    }
}
