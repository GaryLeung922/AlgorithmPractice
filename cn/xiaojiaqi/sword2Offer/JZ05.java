package cn.xiaojiaqi.sword2Offer;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * @Author: Gary Leung
 * @Date: 6/5/20 10:49 PM
 */
public class JZ05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while (stack1.size() > 1){
            stack2.push(stack1.pop());
        }
        return stack1.pop();
    }

}
