package cn.xiaojiaqi.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Test_01_QuickSort {

	
	
	
	public static void quickSort(int[] arr) {
		quickSort2(arr, 0, arr.length-1);
	}
	//快排 递归
	public static void quickSort(int[] arr,int left,int right) {
		
		if(left>=right)return;
		int[] res = partition(arr, left, right);
		quickSort(arr,left,res[0]-1);
		quickSort(arr,res[1]+1,right);
	}
	//快排非递归
	public static void quickSort2(int[] arr,int left,int right) {
		Stack<Integer> leftStack = new Stack<>();
		Stack<Integer> rightStack = new Stack<>();
		if(left<right) {
			leftStack.push(left);
			rightStack.push(right);
		}
		while(!leftStack.isEmpty()) {
			left = leftStack.pop();
			right = rightStack.pop();
			int[] res = partition(arr, left, right);
			if(left<res[0]-1) {
				leftStack.push(left);
				rightStack.push(res[0]-1);
			}
			if(res[1]+1<right) {
				leftStack.push(res[1]+1);
				rightStack.push(right);
			}
		}
	}
	public static int[] partition(int[] arr,int left,int right) {
		int rand = (int)Math.random()*right+left;
		swap(arr, rand, right);
		
		int less = left-1;
		int more = right;
		int cur = left;
		while(cur<more) {
			if(arr[cur]>arr[right]) {
				swap(arr, cur, --more);
			}else if(arr[cur]==arr[right]) {
				cur++;
			}else {
				swap(arr, cur, ++less);
				cur++;
			}
		}
		swap(arr, right, more++);
		return new int[] {less+1,more-1};
	}
	public static void swap(int[] arr,int a,int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,2,7,3,6};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = utils.ToolUtil.generateArr(1, 100, -100, 100)[0];
			String str = Arrays.toString(arr);
			quickSort(arr);
			String str1 = Arrays.toString(arr);
			Arrays.sort(arr);
			String str2 = Arrays.toString(arr);
			if(!str1.equals(str2)) {
				success  = false;
				System.out.println(str);
				System.out.println(str1);
				System.out.println(str2);
				break;
			}
		}
		System.out.println(success?"Nice!":"Fucked!");
	}
	

}
