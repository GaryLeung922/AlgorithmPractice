package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 有冷冻期
 * other's DP
 * The idea is as follows:

	First, think about what we can do on day i? You either have one stock or you don't on day i. For each case, you have two options, making a total of four possible actions on day i:
	
	you have 1 stock and you sell it
	you have 1 stock and you do nothing
	you have 0 stock and you buy stock i
	you have 0 stock and you do nothing
	As you can imagine, these four actions are correlated between day i-1 and day i. For example, if you take action 1 on day i, you then have either taken action 2 or 3 on day i-1 but not 1 or 4. In precise, two consecutive days are related as follows:
	
	if you take action 1 on day i ==> you have either taken action 2 or 3 on day i-1
	if you take action 2 on day i ==> you have either taken action 2 or 3 on day i-1
	if you take action 3 on day i ==> you must have taken action 4 on day i-1 (you can not sell on day i-1 due to cool down)
	if you take action 4 on day i ==> you have either taken action 1 or 4 on day i-1
	Now you want to maximize your total profit, but you don't know what action to take on day i such that you get the total maximum profit, so you try all 4 actions on every day. Suppose you take action 1 on day i, since there are two possible actions on day i-1, namely actions 2 and 3, you would definitely choose the one that makes your profit on day i more. Same thing for actions 2 and 4. So we now have an iterative algorithm.
	
	Before coding, one detail to emphasize is that the initial value on day 0 is important. You basically cannot take action 1, so the corresponding profits should be 0. You cannot take action 2 in practice, but you cannot set up the profit to 0, because that means you don't have a stock to sell on day 1. Therefore, the initial profit should be negative value of the first stock. You can also think of it as you buy the stock on day -1 and do nothing on day 0.
	'''
 * @author Narut0
 *
 */
public class Leetcode_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)return 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=prices.length-2;i>-1;i--){
            int pi = p(prices,i,map);
            map.put(i,pi);
            max = Math.max(pi,max);
        }
        return max;
    }
    public static int p(int[] prices,int i,Map<Integer,Integer> map){
        if(i>=prices.length-1)return 0;
        
        int maxp = 0;
        for(int j=i+1;j<prices.length;j++){
            if(prices[j]>=prices[i]){
            	int pi=0;
            	for(int k=j+2;k<prices.length-1;k++) {
            		int pii = 0;
            		if(map.containsKey(k)){
                        pii = map.get(k);
                    }else{
                        pii = p(prices,k,map);
                        map.put(k,pii);
                    }
            		pi = Math.max(pi,pii);
            	}
                maxp = Math.max(maxp,prices[j]-prices[i]+pi);
            }
        }
        return maxp;
    }
    //DP
    public static int maxProfit2(int[] prices) {
        if(prices==null||prices.length<2)return 0;
        int max = 0;
        int[] dp = new int[prices.length];
        dp[dp.length-1]=0;
        for(int i=dp.length-2;i>-1;i--){
            int pj = 0;
            for(int j=i+1;j<dp.length;j++){
                if(prices[j]>prices[i]){
                    int pk = 0;
                    for(int k=j+2;k<dp.length;k++){
                        pk = Math.max(pk,dp[k]);
                    }
                    pj = Math.max(pj,prices[j]-prices[i]+pk);
                    max = Math.max(max,pj);   
                }
            }
            dp[i] = pj;
        }
        return max;
    }
    
    //other's DP
    public int maxProfit3(int[] prices) {
        int L = prices.length;
        if(L < 2) return 0;

        int has1_doNothing = -prices[0];
        int has1_Sell = 0;
        int has0_doNothing = 0;
        int has0_Buy = -prices[0];
        for(int i=1; i<L; i++) {
            has1_doNothing = has1_doNothing > has0_Buy ? has1_doNothing : has0_Buy;
            has0_Buy = -prices[i] + has0_doNothing;
            has0_doNothing = has0_doNothing > has1_Sell ? has0_doNothing : has1_Sell;
            has1_Sell = prices[i] + has1_doNothing;
        }
        return has1_Sell > has0_doNothing ? has1_Sell : has0_doNothing;
    }

    /**
     * 通用框架
     * *  通用解法
     *  *  dp[i][j][0] :第i-th天，已经进行j次交易，当前没有持有股票
     *  *  dp[i][j][1] :第i-th天，已经进行j次交易，当前持有股票
     *  *
     *  *  dp[i][j][0] = max(dp[i-1][j][0], dp[i-1][j-1][1]+prices[i])
     *  *  解释：第i-th天，已经进行j次交易，当前没有持有股票 可以由 第（i-1）-th天，已经进行j次交易，当天没有持有股票，在i-th天并决定继续不买入 转移而来，
     *  *      也可以由 第（i-1）-th天，已经进行j-1次交易，当天持有股票，决定在i-th天卖出 转移而来
     *  *
     *  *  dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i])
     *  *  解释：同上
     *  *
     *  *  basecase:
     *  *  i==0 时，dp[0][j][0] = 0 ; dp[0][j][1] = -price[0]
     *  *
     *  *  j==0 时，dp[i][0][0] = 0 ; dp[i][0][1] = max(dp[i-1][0][1], -price[i])
     *  *
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = dp[i-1][1];

            // 冷冻期导致
            if(i>=2) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }else{
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
            }

        }
        return dp[n-1][0];
    }


    public static void main(String[] args) {
		int[] prices = {6,1,6,4,3,0,2};
		int ans = maxProfit2(prices);
		
		System.out.println(ans);
	}
}