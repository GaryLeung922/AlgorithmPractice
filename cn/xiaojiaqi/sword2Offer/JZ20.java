package cn.xiaojiaqi.sword2Offer;

import java.util.Stack;

/**
 * 最小栈
 * @Author: Gary Leung
 * @Date: 6/5/20 10:42 PM
 */
public class JZ20 {
    public Stack<Integer> stack = new Stack<>();

    public Stack<Integer> help = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(help.isEmpty() || help.peek() >= node){
            help.push(node);
        }else {
            help.push(help.peek());
        }
    }

    public void pop() {
        help.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return help.peek();
    }
}
