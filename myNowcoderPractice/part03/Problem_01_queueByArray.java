package part03;

public class Problem_01_queueByArray {

	public static class QueueByArray{
		private int[] arr;
		private int rear; //指向队尾要插入的位置，即队尾元素的下一个位置
		private int front;//指向队首元素
		private int size;
		public QueueByArray() {
			super();
			arr = new int[6];
			front = arr.length-1;
			rear = front;
		}
		public QueueByArray(int size) {
			super();
			arr = new int[size];
			front = arr.length-1;
			rear = front;
		}
		public void put(int data) {
			if(this.size>=this.arr.length) {
				throw new RuntimeException("队列已满");
			}else {
				this.arr[rear] = data;
				rear = rear==0?arr.length-1:rear-1;
				this.size++;
			}
		}
		public int poll() {
			if(this.size<=0) {
				throw new RuntimeException("队列为空");
			}else {
				int data = this.arr[front];
				front = front==0?arr.length-1:front-1;
				this.size--;
				return data;
			}
		}
		public int peek() {
			if(this.size<=0) {
				throw new RuntimeException("队列为空");
			}else {
				return this.arr[front];
			}
		}
		public boolean isEmpty() {
			return size==0;
		}
		
	}
	
	public static void main(String[] args) {
		QueueByArray qa = new QueueByArray(6);
		//qa.peek();
		//qa.poll();
		for(int i=0;i<6;i++) {
			qa.put(i);
		}
		for(int i=0;i<6;i++) {
			System.out.println(qa.poll());
		}
	}

}
