package cn.xiaojiaqi.sword2Offer;

import java.util.Stack;

/**
 * 栈的压入、弹出顺序
 * @Author: Gary Leung
 * @Date: 6/5/20 10:25 PM
 */
public class JZ21 {
    public static void main(String[] args) {

    }
    public static boolean IsPopOrder(int [] pushA,int [] popA){
        if(pushA == null || popA == null || pushA.length != popA.length || pushA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < popA.length){
            if(j<pushA.length && pushA[j] != popA[i] ){
                stack.push(pushA[j++]);
            }else if(j >= pushA.length){
                if(stack.size() < 1) return false;
                int pop = stack.pop();
                if(pop != popA[i++]) return false;
            }else {
                i++;
                j++;
            }
        }
        return true;

    }
}
