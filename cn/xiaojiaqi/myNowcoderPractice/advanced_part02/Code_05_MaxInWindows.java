package advanced_part02;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * 	题目描述：
 * 	给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 	例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 	他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， 
 *  {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， 
 *  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *  
 *	 解题思路：
 *	利用窗口结构：可以实现时间复杂度O(N)
 *	
 * @author Narut0
 *
 */
public class Code_05_MaxInWindows {
	
	public static void main(String[] args) {
		int[] arr = {10,14,12,11};
		//ArrayList<Integer> arr2 = new ArrayList<>();
		
		System.out.println(Arrays.toString(maxInWindwos(arr, 1)));
	}
	public static int[] maxInWindwos(int[] arr,int size) {
		if(arr!=null&&arr.length!=0&&size>=1&&arr.length>=size) {
			LinkedList<Integer> deque = new LinkedList<>();
			int R = 0;
			int L = 0;
			int[] num = new int[arr.length-size+1];
			int i=0;
			while (R<arr.length) {	
				while(true) {
					if(deque.isEmpty()||arr[deque.peekLast()]>arr[R]) {
						deque.addLast(R);
						break;
					}else{
						deque.pollLast();
					}
				}
				if(R-L==size-1) {
					num[i++] = arr[deque.peekFirst()];
					L++;
					while (!deque.isEmpty()&&deque.peekFirst()<L) {
						deque.pollFirst();
					}
				}
				R++;
			}
			return num;
		}
		return null;
	}

}
