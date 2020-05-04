package advanced_part02;

import java.util.ArrayList;
import java.util.Stack;

public class Code_01_MonotonousStack {
    public static class Num{
        public int left;
        public int right;
        public int val;

        public Num(int val){
            this.val = val;
        }
    }
    
    //这个node对象是为了处理重复的数的
    public static class Node{
        public int postion;
        public int counter;

        public Node(int postion){
            this.counter = 1;
            this.postion = postion;
        }
    }

    public static ArrayList<Num> monotonousStack(int[] arrays){
        if(arrays == null || arrays.length == 0) return null;
        Stack<Node> stack = new Stack<>();
        ArrayList<Num> res = new ArrayList<>();
        for(int i = 0; i < arrays.length; i++){
            while(!stack.isEmpty() && arrays[stack.peek().postion] < arrays[i]){
                Node t = stack.pop();
                //这些for循环是为了处理重复的数的，如果数组不重复，可以去掉
                for(int j = 0; j < t.counter; j++){
                    Num num = new Num(arrays[t.postion]);
                    num.left = stack.isEmpty() ? -1 : arrays[stack.peek().postion];
                    num.right = arrays[i];
                    res.add(num);
                }
            }
            if(!stack.isEmpty() && arrays[stack.peek().postion] == arrays[i])
                stack.peek().counter++;
            else
                stack.push(new Node(i));
        }
        while(!stack.isEmpty()){
            Node t = stack.pop();
            //这些for循环是为了处理重复的数的，如果数组不重复，可以去掉
            for(int j = 0; j < t.counter; j++){
                Num num = new Num(arrays[t.postion]);
                num.left = stack.isEmpty() ? -1 : arrays[stack.peek().postion];
                num.right = -1;
                res.add(num);
            }
        }
        return res;
    } 

    public static void main(String[] args){
        int[] array = new int[]{5, 5, 4, 5 ,3, 6, 5, 3};
        ArrayList<Num> arrayList = new Code_01_MonotonousStack().monotonousStack(array);
        for(Num num : arrayList){
            System.out.println(num.val + " 左边：" + num.left + "  右边：" + num.right);
        }
    }
}
