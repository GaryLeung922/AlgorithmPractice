package cn.xiaojiaqi.leetcode;

import java.util.Stack;

/**
 * 有效括号
 * @Author: liangjiaqi
 * @Date: 2020/10/2 8:49 AM
 */
public class LeetCode_020_ValidParentheses {
    public boolean isValid(String s) {
        if(s==null || s.length()==0)return true;
        if(s.length()%2 != 0)return false;

        char[] brackets = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<brackets.length;i++){
            if(isLeftBracket(brackets[i])){
                stack.push(brackets[i]);
            }else if(stack.isEmpty() || !isMatch(stack.peek(),brackets[i])){
                return false;
            }else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeftBracket(char c){
        return c=='(' || c== '{' || c== '[';
    }

    private boolean isRightBracket(char c){
        return c==')' || c=='}' || c== ']';
    }

    private boolean isMatch(char c1, char c2){
        return (c1=='(' && c2 == ')') || (c1=='{' && c2=='}') || (c1=='[' && c2==']');
    }
}
