package cn.xiaojiaqi.leetcode;

/**
 * 字符串相加
 * @Author: liangjiaqi
 * @Date: 2020/10/7 4:02 PM
 */
public class LeetCode_415_AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            if(num1==null||num2==null||num1.length()==0||num2.length()==0)return null;
            StringBuilder sb = new StringBuilder();
            int a = num1.length()-1;
            int b = num2.length()-1;
            int carry = 0;
            while(a>=0 && b>=0){
                int sum = num1.charAt(a)-'0' + num2.charAt(b)-'0' + carry;
                carry = 0;
                if(sum>=10){
                    carry = 1;
                    sum = sum%10;
                }
                sb.insert(0,sum);
                a--;
                b--;
            }
            while(a>=0){
                int sum = num1.charAt(a)-'0' + carry;
                carry = 0;
                if(sum>=10){
                    carry = 1;
                    sum = sum%10;
                }
                sb.insert(0,sum);
                a--;
            }
            while(b>=0){
                int sum = num2.charAt(b)-'0' + carry;
                carry = 0;
                if(sum>=10){
                    carry = 1;
                    sum = sum%10;
                }
                sb.insert(0,sum);
                b--;
            }
            if(carry>0){
                sb.insert(0,carry);
            }
            return sb.toString();
        }
    }
}
