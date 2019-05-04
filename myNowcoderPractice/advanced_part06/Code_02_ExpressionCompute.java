package advanced_part06;

import java.util.LinkedList;
import java.util.Stack;
//有问题！！！
public class Code_02_ExpressionCompute {
	public static int expressionCompute(String exp) {
		if(exp!=null&&exp.length()>0) {
			char[] exps = exp.toCharArray();
			LinkedList<Character> deque = new LinkedList<>();
			for(int i=0;i<exps.length;i++) {
				if(exps[i]>='0' && exps[i]<='9') {
					if(!deque.isEmpty()&&(deque.peekLast()=='*'||deque.peekLast()=='/')){
						char ops = deque.pollLast();
						int a = deque.pollLast()-'0';
						int b = exps[i]-'0';
						int res = ops=='*' ? a*b : a/b;
						deque.addLast( (char) (res+48) );
					}
				}else if (exps[i]==')') {
					Stack<Character> stack = new Stack<>();
					while (deque.peekLast()!='(') {
						stack.push(deque.pollLast());
					}
					while(stack.size()>1) {
						int a = stack.pop()-'0';
						char ops=  stack.pop();
						int b = stack.pop()-'0';
						int res = ops=='+' ? a+b : a-b;
						stack.push((char) (res+48));
					}
					deque.pollLast();
					deque.addLast(stack.pop());
				}else {
					deque.addLast(exps[i]);
				}
				
			}
			while (deque.size()>1) {
				int a = deque.pollFirst()-'0';
				char ops = deque.pollFirst();
				int b = deque.pollFirst();
				int res = ops== '+' ? a+b:a-b;
				deque.addFirst((char) (res+48));
			}
			return deque.poll()-'0';
		}
		return Integer.MIN_VALUE;
	}
	public static void main(String[] args) {
		int a = '0';
		char c = (char) (a);
		System.out.println(a);
	}
}
