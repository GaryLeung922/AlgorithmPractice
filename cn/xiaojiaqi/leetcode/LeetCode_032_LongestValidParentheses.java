package cn.xiaojiaqi.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: liangjiaqi
 * @Date: 2020/10/3 10:34 AM
 */
public class LeetCode_032_LongestValidParentheses {
    /**
     * 解法一：
     * 时间O(n),空间O(n)
     * dp[i]表示，以i结尾的最长有效括号长度
     * 当s[i]=='('时， dp[i]=0, 因为以(结尾不可能构成有效括号
     * 当s[i]==')'时：
     *      如果s[i-1]=='(': dp[i] = dp[i-2]+2        类似 "....()"
     *      如果s[i-1]==')':                          类似 "....))"
     *          查看dp[i-1]最长有效括号的最左侧边上的不包含在dp[i-1]的那个字符
     *          如果 == '(' 那么 dp[i] = dp[i-1]+2; 再顺带看看这个字符的左侧是不是也构成有效字符dp[i-dp[i-1]-2]，构成则加上
     */
    class Solution {
        public int longestValidParentheses(String s) {
            if(s==null || s.length()==0 || s.length()==1)return 0;

            int max = 0;
            int[] dp = new int[s.length()];
            // base case
            dp[0] = 0;
            for(int i=1;i<dp.length;i++){
                if(s.charAt(i)=='('){
                    dp[i] = 0;
                }else {
                    if(s.charAt(i-1)==')'){
                        if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                            dp[i] = dp[i-1]+2;
                            if(i-dp[i-1]-1>0){
                                dp[i]+=dp[i-dp[i-1]-2];
                            }
                        }
                    }else{
                        if(i>=2){
                            dp[i] = dp[i-2]+2;
                        }else{
                            dp[i] = 2;
                        }
                    }
                }
                max = Math.max(max,dp[i]);

            }
            return max;
        }
    }

    /**
     * 用栈解决数组或者是字符串de 题，栈里面存索引比存真实值好很多
     * 解法二：用栈
     * 栈里面存索引
     * 时间O(n) 空间O(n)
     */
    class Solution2{
        public int longestValidParentheses(String s) {
            if(s==null || s.length()==0 || s.length()==1)return 0;
            int maxValid = 0;
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(-1);
            for(int i=0;i<s.length();i++){
                if(deque.peek()==-1){
                    deque.push(i);
                }else if(s.charAt(i)==')' && s.charAt(deque.peek())=='('){
                    deque.poll();
                    maxValid = Math.max(maxValid, i-deque.peek());
                }else {
                    deque.push(i);
                }
            }
            return maxValid;
        }
    }

    /**
     * 解法三：记录左右括号的数量
     * 时间O(n) 空间O(1)
     * 对于一个有效的括号，遍历过来你遇到的左括号数量(一定是要大于等于右括号)数量的
     * 一旦')'右括号数量大于'('左括号数量, 那个这个字符串一定不是有效的括号
     */
    class Solution3 {
        public int longestValidParentheses(String s) {
            if(s==null || s.length()==0 || s.length()==1)return 0;
            int left = 0;
            int right = 0;
            int maxValid = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==')'){
                    right++;
                }else {
                    left++;
                }
                if(right==left){
                    maxValid = Math.max(right*2, maxValid);
                }else if(right<left){

                }else {
                    left = 0;
                    right = 0;
                }
            }
            // 反向遍历一遍  以防 "(()" 这种情况
            left = 0;
            right = 0;
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)==')'){
                    right++;
                }else {
                    left++;
                }
                if(right==left){
                    maxValid = Math.max(right*2, maxValid);
                }else if(right>left){

                }else {
                    left = 0;
                    right = 0;
                }
            }

            return maxValid;

        }
    }
}
