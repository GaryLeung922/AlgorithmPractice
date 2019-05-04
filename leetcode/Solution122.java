package cn.xiaojiaqi.leetcode;
public class Solution122 {
    public static int maxProfit(int[] prices) {
        return maxProfit(prices,0,-1);
    }

	private static int maxProfit(int[] prices, int i, int lastPrice) {
		if(i==prices.length)return 0;
		if(lastPrice>=0) {
			if(lastPrice-prices[i]<0) {
				return Math.max(prices[i]-lastPrice+maxProfit(prices,i+1,-1), maxProfit(prices,i+1,lastPrice));
			}else {
				return maxProfit(prices,i+1,lastPrice);
			}
		}else {
			return Math.max(maxProfit(prices,i+1,lastPrice), maxProfit(prices, i+1, prices[i]));
		}
		
		//return 0;
	}
	public static void main(String[] args) {
		int[] arr = {7,6,4,3,1};
		int res = maxProfit(arr);
		System.out.println(res);
	}
}