package cn.xiaojiaqi.test;
import java.util.Stack;

public class Solution27 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA!=null&&popA!=null&&pushA.length>=0&&pushA.length==popA.length){
            Stack<Integer> stack = new Stack<>();
            int j=0;
            for(int i=0;i<popA.length;i++){
                if(stack.isEmpty()&&j<pushA.length){
                    stack.push(pushA[j++]);
                }else if(stack.isEmpty()&&j>=pushA.length){
                    return false;
                }else if(stack.peek()!=popA[i]&&j<pushA.length){
                    stack.push(pushA[j++]);
                }else if(stack.peek()!=popA[i]&&j>=pushA.length){
                    return false;
                }else{
                    stack.pop();
                }
            }
            return true;
        }
        return false;
    }
}