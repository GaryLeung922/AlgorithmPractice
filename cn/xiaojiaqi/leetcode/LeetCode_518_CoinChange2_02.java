package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/6 11:18 AM
 */
public class LeetCode_518_CoinChange2_02 {
    static class Solution {
        public int change(int amount, int[] coins) {

            if(coins==null ||coins.length==0 || amount<0)return 0;

            // dp[i][j] 从0..i-1为止，凑出j金额的方法数
            int[][] dp = new int[coins.length+1][amount+1];

            // dp[i][j] == 0 表示 从0..i-1为止，凑不出j金额
            // base case: 凑成金额0都有一种方法
            for(int i=0;i<dp.length;i++){
                dp[i][0] = 1;
            }

            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    if(j-coins[i-1]>=0){
                        dp[i][j] += dp[i][j-coins[i-1]];
                    }
                    dp[i][j]+= dp[i-1][j];
                }
            }
            return dp[dp.length-1][amount];
        }
    }

    class Solution2 {
        public int change(int amount, int[] coins) {
            if (coins == null || coins.length == 0 || amount < 0) return 0;

            // dp[i] 凑成i金额的方法数
            int[] dp = new int[amount + 1];
            // base case: 0金额，自然有1种方法
            dp[0] = 1;

            for (int i = 1; i < dp.length; i++) {
                // 对每一面硬币，如果i - coins[j] 都有方法凑成，累加
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        dp[i] += dp[i - coins[j]];
                    }
                }
            }
            return dp[dp.length - 1];
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{1,2,5};
        int change = solution.change(5, coins);
        System.out.println(change);
    }
}
