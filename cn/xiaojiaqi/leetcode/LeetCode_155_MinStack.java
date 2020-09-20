package cn.xiaojiaqi.leetcode;

import java.util.Stack;

/**
 * 最小栈
 * @Author: liangjiaqi
 * @Date: 2020/9/20 5:47 PM
 */
public class LeetCode_155_MinStack {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> help;
        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<>();
            this.help = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(help.isEmpty()){
                help.push(x);
            }else if(help.peek()>x){
                help.push(x);
            }else{
                help.push(help.peek());
            }
        }

        public void pop() {
            stack.pop();
            help.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return help.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
