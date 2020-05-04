package part07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
问题描述：
一个数据流中，随时可以取得中位数
有个一数据流，每次都会冒出一个数
现在有这个一个需求：
可以在任何时候取前面所有数的中位数，要求时间复杂度为O(1)

解题思路：
准备一个大根堆，一个小根堆
大根堆存储比小根堆堆顶还要小的数，小根堆存储不小于其堆顶的数
在数据流依此进入时，还要保证两个堆的大小之差不超过1
 * @author Narut0
 *
 */
public class Code_04_MadianQuick {

	public static class Madian{
		//小根堆
		PriorityQueue<Integer> min = new PriorityQueue<Integer>(new MinComparator());
		//大根堆
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(new MaxComparator());
		public void getIn(int e) {
			if(min.isEmpty()) {//先往小根堆存
				min.offer(e);
			}else {
				if(e>=min.peek()) {//冒出来的数，不小于小根堆堆顶，存小根堆
					min.offer(e);
				}else {//冒出来的数，小于小根堆堆顶，存大根堆
					max.offer(e);
				}
			}
			while(Math.abs(min.size()-max.size())>1) {//平衡两堆的大小
				if(min.size()>max.size()) {
					max.offer(min.poll());
				}else {
					min.offer(max.poll());
				}
			}
		}
		public int getMadian() {
			if(min.size()>max.size()) {
				return min.peek();
			}else if(max.size()>min.size()){
				return max.peek();
			}else {
				return Math.round((min.peek()+max.peek())/2);
			}

		}
		
	}
	public static class MinComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return o1-o2;
		}
		
	}
	public static class MaxComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return o2-o1;
		}
		
	}
	public static void main(String[] args) {
		Madian md = new Madian();
		for(int i=0;i<10;i++) {
			int rand = (int)Math.ceil((Math.random()*20));
			md.getIn(rand);
			System.out.print(rand+" ");
		}
		System.out.println(" ");
		int madian = md.getMadian();
		System.out.println(madian);
	}

}
