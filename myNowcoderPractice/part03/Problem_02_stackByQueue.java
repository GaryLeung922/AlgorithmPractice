package part03;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_02_stackByQueue {

	public static class StackByQueue{
		private Queue<Integer> queue;
		private Queue<Integer> help;
		public StackByQueue() {
			super();
			queue = new LinkedList<Integer>();
			help = new LinkedList<>();
		}
		public void add(int data) {
			queue.add(data);
		}
		public int pop() {
			while (queue.size()>1) {
				help.add(queue.poll());
			}
			int data = queue.poll();
			Queue<Integer> tmp = queue;
			queue = help;
			help = tmp;
			return data;
		}
		public int peek() {
			while (queue.size()>1) {
				help.add(queue.poll());
			}
			int data = queue.peek();
			help.add(queue.poll());
			Queue<Integer> tmp = queue;
			queue = help;
			help = tmp;
			return data;
			
		}
		public boolean isEmpty() {
			return queue.isEmpty();
		}
		public static void main(String[] args) {
			StackByQueue sq = new StackByQueue();
			for(int i=0;i<6;i++) {
				sq.add(i);
			}
			while (!sq.isEmpty()) {
				System.out.println(sq.pop());
			}

		}
		
	}

}
