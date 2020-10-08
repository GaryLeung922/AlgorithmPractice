package cn.xiaojiaqi.leetcode;

/**
 * 斐波那契数列
 * @Author: liangjiaqi
 * @Date: 2020/10/8 3:09 PM
 */
public class LeetCode_509_FibonacciNumber {

    /**
     * DP dp[i]  = dp[i-1]+dp[i-2]
     *
     */
    class Solution {
        public int fib(int N) {
            if(N<0)return 0;
            if(N==0)return 0;
            if(N==1)return 1;
            int dp0 = 0;
            int dp1 = 1;
            for(int i=2;i<N;i++){
                int dp2 = dp0+dp1;
                dp0 = dp1;
                dp1 = dp2;
            }
            return dp0+dp1;
        }
    }
}
