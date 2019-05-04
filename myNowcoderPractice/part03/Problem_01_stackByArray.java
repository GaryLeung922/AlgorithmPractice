package part03;

public class Problem_01_stackByArray {
	public static class StackByArray {
		private int[] arr;
		private int top=0;
		public StackByArray() {
			super();
			arr = new int[6];
		}
		public StackByArray(int size) {
			arr = new int[size];
		}
		public int peek() {
			if(this.top<=0){
				throw new RuntimeException("栈为空！");
			}else {
				
				return this.arr[top-1];
			}
		}
		public void push(int data) {
			if(this.arr.length-1<this.top) {
				throw new RuntimeException("栈已满！");
			}else {
				this.arr[top++] = data;
			}
		} 
		public int pop() {
			if(this.top<=0){
				throw new RuntimeException("栈为空！");
			}else {
				return this.arr[--top];
			}
		}
		public boolean isEmpty() {
			return top<0;
		}
	}

	public static void main(String[] args) {
		StackByArray sa = new StackByArray(6);
		//sa.pop();
		//sa.peek();
		for(int i=0;i<6;i++) {
			sa.push(i);
		}
		for(int i=0;i<6;i++) {
			System.out.println(sa.pop());
		}
		sa.peek();
	}
	
	
}
