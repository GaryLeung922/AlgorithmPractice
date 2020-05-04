package part02;

import java.util.ArrayList;
import java.util.Arrays;

public class Code_04_MedianOfStream {
	public static double[] medianOfStream(int[] stream) {
		if(stream!=null&&stream.length>0) {
			double[] res = new double[stream.length];
			MinHeap minHeap = new MinHeap();
			MaxHeap maxHeap = new MaxHeap();
			for(int i=0;i<stream.length;i++) {
				if(minHeap.isEmpty()||minHeap.peek()<stream[i]) {
					minHeap.push(stream[i]);
				}else {
					maxHeap.push(stream[i]);
				}
				if(minHeap.size-maxHeap.size>1) {
					maxHeap.push(minHeap.pop());
				}else if(maxHeap.size-minHeap.size>1){
					minHeap.push(maxHeap.pop());
				}
				if(i%2==1) {
					res[i] = (minHeap.peek()+maxHeap.peek())/2.0;
				}else {
					res[i] = minHeap.size>maxHeap.size?minHeap.peek():maxHeap.peek();
				}
			}
			return res;
		}
		return null;
		
	}
	public static class MaxHeap{
		private ArrayList<Integer> heap = new ArrayList<>();
		private int size = 0;
		public MaxHeap() {
			
		}
		public boolean isEmpty() {
			return size==0;
		}
		public int getSize() {
			return size;
		}
		public int peek() {
			return isEmpty()?-1:heap.get(0);
		}
		public void push(int val) {
			//System.out.println("insert:"+val);
			heapInsert(val);
		}
		private void heapInsert(int val) {
			if(heap.size()>size) {
				heap.set(size++, val);
			}else {
				heap.add(val);
				size++;
			}
			int i = size-1;
			int tmp = heap.get(i);
			int k = (i-1)/2;
			while(heap.get(k)<tmp&&i>0) {
				heap.set(i, heap.get(k));
				i = k;
				k = (i-1)/2;
			}	
			heap.set(i, tmp);
		}
		public int pop() {
			if(size>0) {
				int res = heap.get(0);
				heap.set(0, heap.get(--size));
				heapify(0);
				return res;
			}
			return -1;
		}
		private void heapify(int i) {
			int tmp = heap.get(i);
			for(int k=2*i+1;k<size;k=2*i+1) {
				if(k+1<size&&heap.get(k)<heap.get(k+1)) {
					k++;
				}
				if(heap.get(k)>tmp) {
					heap.set(i, heap.get(k));
					i = k;
				}else {
					break;
				}
			}
			heap.set(i, tmp);
		}
	}
	public static class MinHeap{
		private ArrayList<Integer> heap = new ArrayList<>();
		private int size = 0;
		public MinHeap() {
			
		}
		public boolean isEmpty() {
			return size==0;
		}
		public int getSize() {
			return size;
		}
		public int peek() {
			return isEmpty()?-1:heap.get(0);
		}
		public void push(int val) {
			//System.out.println("insert:"+val);
			heapInsert(val);
		}
		private void heapInsert(int val) {
			if(heap.size()>size) {
				heap.set(size++, val);
			}else {
				heap.add(val);
				size++;
			}
			int i = size-1;
			int tmp = heap.get(i);
			int k = (i-1)/2;
			while(heap.get(k)>tmp&&i>0) {
				heap.set(i, heap.get(k));
				i = k;
				k = (i-1)/2;
			}	
			heap.set(i, tmp);
		}
		public int pop() {
			if(size>0) {
				int res = heap.get(0);
				heap.set(0, heap.get(--size));
				heapify(0);
				return res;
			}
			return -1;
		}
		private void heapify(int i) {
			int tmp = heap.get(i);
			for(int k=2*i+1;k<size;k=2*i+1) {
				if(k+1<size&&heap.get(k)>heap.get(k+1)) {
					k++;
				}
				if(heap.get(k)<tmp) {
					heap.set(i, heap.get(k));
					i = k;
				}else {
					break;
				}
			}
			heap.set(i, tmp);
		}
	}
	public static void main(String[] args) {
		int[] arr = {4,8,9,3,2,8,2,1};
		//System.out.println(-2/2);
		double[] res = medianOfStream(arr);
		
		System.out.println(Arrays.toString(res));
		
	}
}

