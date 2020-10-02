package cn.xiaojiaqi.leetcode;

/**
 * 青蛙跳台阶 一次跳一步或两步
 * @Author: liangjiaqi
 * @Date: 2020/10/2 6:26 PM
 */
public class LeetCode_070_ClimbingStairs {
    /**
     * DP : dp[i] 表示上到第i个台阶有dp[i]种方法
     * base case: dp[0] = 1, dp[1] = 2
     * dp[i] = dp[i-1] + dp[i-2]
     * 第i个台阶的方法数 = 第i-1个台阶方法数 + 第i-2个台阶的方法数
     * 因为你可以从i-1跳一步到i，也可以从i-2跳两步到i
     * 时间复杂度O(n) ，空间复杂度O(n)
     */
    class Solution1 {
        public int climbStairs(int n) {
            if(n<=0) return 0;
            if(n==1)return 1;
            if(n==2)return 2;

            int dp0 = 1;
            int dp1 = 2;
            int dp2 = 0;
            for(int i=2;i<n;i++){
                dp2 = dp0+dp1;
                dp0 = dp1;
                dp1 = dp2;
            }
            return dp2;
        }
    }

    /**
     * DP
     * 状态压缩
     * 时间O(n) , 空间O(1)
     */
    class Solution2 {
        public int climbStairs(int n) {
            if(n<=0) return 0;
            if(n==1)return 1;
            if(n==2)return 2;

            int dp0 = 1;
            int dp1 = 2;
            int dp2 = 0;
            for(int i=2;i<n;i++){
                dp2 = dp0+dp1;
                dp0 = dp1;
                dp1 = dp2;
            }
            return dp2;
        }
    }
}
