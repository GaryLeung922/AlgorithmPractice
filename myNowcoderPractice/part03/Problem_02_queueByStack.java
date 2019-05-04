package part03;

import java.util.Stack;

public class Problem_02_queueByStack {
	public static class QueueByStack{
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;
		public QueueByStack() {
			super();
			stackPush = new Stack<>();
			stackPop = new Stack<>();
		}
		public void add(int data) {
			stackPush.push(data);
		}
		public int poll() {
			if(!stackPop.isEmpty()) {
				return stackPop.pop();
			}else if (!stackPush.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
				return stackPop.pop();
			}else {
				throw new RuntimeException("队列为空");
			}
		}
		public int peek() {
			int data = poll();
			add(data);
			return data;
		}
		public boolean isEmpty() {
			return (stackPop.isEmpty()&&stackPush.isEmpty());
			
		}
	}
	public static void main(String[] args) {
		QueueByStack qs = new QueueByStack();
		//qs.peek();
		//qs.poll();
		for(int i=0;i<6;i++) {
			qs.add(i);
		}
		while (!qs.isEmpty()) {
			System.out.println(qs.poll());
		}
		qs.peek();
		
	}
}
