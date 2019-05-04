package advanced_part02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 	引子题
 * 	问题描述：
 * 	有一个arr，代表一个直方图
 * 	问直方图中最大矩形的面积
 * 	eg:[4,3,2,5,6] 输出：10
 * 
 * 	引申问题：
 * 	求最大子矩阵的大小
 * 	矩阵中值为0/1，求值全是1的子矩阵的大小
 * 	eg:1011
 * 	   1111
 * 	   1110
 * 	输出：6
 * 	要求：时间复杂度O(N*M)
 * 	解题思路：
 * 	
 * @author Narut0
 *
 */
public class Code_04_MaxSubMatrix {

	public static int maxSubRect(int[] arr) {
		if(arr!=null&&arr.length>0) {
			Stack<ArrayList<Integer>> stack = new Stack<>();
			int max = Integer.MIN_VALUE;
			int i=0;
			while (i<arr.length) {
				while (!stack.isEmpty()&&arr[stack.peek().get(0)]>arr[i]) {
					
					int index = stack.pop().get(0);
					int left = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
					max = Math.max(max, (i-left-1)*arr[index]);
				}
				if(!stack.isEmpty()&&arr[stack.peek().get(0)]==arr[i]) {//相等时可以不做任何操作
					stack.peek().add(i++);
					continue;
				}
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i++);
				stack.push(al);
			}
			while (!stack.isEmpty()) {
				int index = stack.pop().get(0);
				int left = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
				max = Math.max(max, (arr.length-left-1)*arr[index]);
			}
			return max;
		}
		return -1;
	}
	//暴力方法  fortest用
	public static int maxSubRect2(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int max = Integer.MIN_VALUE;
			for(int i=0;i<arr.length;i++) {
				int left = i;
				int right = i;
				for(;left>-1;left--) {//往左边扩
					if(arr[left]<arr[i]) {
						break;
					}
				}
				for(;right<arr.length;right++) {//往右边扩
					if(arr[right]<arr[i]) {
						break;
					}
				}
				max = Math.max(max, (right-left-1)*arr[i]);//取max比较
			}
			return max;
		}
		return -1;
	}
	public static void main(String[] args) {
//		int[][] arr = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
//		System.out.println(maxSubRect(arr));
//		System.out.println(maxSubRect2(arr));
//		int[][] arrs = MyUtils.TestUtil.generateArr(99999, 100,100);
//		for(int i=0;i<99999;i++) {
//			int res1 = maxSubRect(arrs[i]);
//			int res2 = maxSubRect2(arrs[i]);
//			if(res1!=res2) {
//				System.out.println("arr[]:"+Arrays.toString(arrs[i]));
//				System.out.println("res1:"+res1+" res2:"+res2);
//				break;
//			}
//		}
//		System.out.println(maxSubMatrix(arr));
//		System.out.println(maxSubMatrix2(arr));
		for(int i=0;i<999999;i++) {
			int[][] arr = MyUtils.TestUtil.generateArr(10, 10,0,1);
			int res1 = maxSubMatrix(arr);
			int res2 = maxSubMatrix2(arr);
			if(res1!=res2) {
				System.out.println("arr[]:"+Arrays.toString(arr));
				System.out.println("res1:"+res1+" res2:"+res2);
				break;
			}
		}
		System.out.println("over");
		
	}
	public static int maxSubMatrix(int[][] arr) {
		if(arr!=null&&arr.length>0&&arr[0].length>0) {
			int[] cur = new int[arr[0].length];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					cur[j] = arr[i][j]==0?0:arr[i][j]+cur[j];
				}
				max = Math.max(max, maxSubRect(cur));
			}
			return max;
		}
		return -1;
	}
	public static int maxSubMatrix2(int[][] arr) {
		if(arr!=null&&arr.length>0&&arr[0].length>0) {
			int[] cur = new int[arr[0].length];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					cur[j] = arr[i][j]==0?0:arr[i][j]+cur[j];
				}
				max = Math.max(max, maxSubRect2(cur));
			}
			return max;
		}
		return -1;
	}
}
