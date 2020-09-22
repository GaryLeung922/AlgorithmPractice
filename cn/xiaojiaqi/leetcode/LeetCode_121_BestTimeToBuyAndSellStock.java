package cn.xiaojiaqi.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/22 1:20 PM
 */
public class LeetCode_121_BestTimeToBuyAndSellStock {
    /**
     * 暴力解法
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;

            int res = 0;
            for(int i=0;i<prices.length;i++){
                for(int j=i+1;j<prices.length;j++){
                    res = Math.max(res, prices[j]-prices[i]);
                }
            }
            return res;
        }
    }

    /**
     * 单调栈
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            Deque<Integer> stack = new LinkedList<>();
            int res = 0;
            stack.push(prices[0]);
            for(int i=1;i<prices.length;i++){
                while (!stack.isEmpty() && stack.peek()>prices[i]){
                    res = Math.max(res, stack.peekFirst()-stack.peekLast());
                    stack.pop();
                }
                stack.push(prices[i]);
            }
            res = Math.max(res, stack.peek()-stack.peekLast());
            return res;
        }
    }

}
