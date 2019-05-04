package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

public class Test_02_HeapSort {
	public static void heapSort(int[] arr) {
		heapInit(arr, arr.length);
		int size = arr.length;
		while(size>1) {
			swap(arr, 0, size-1);
			heapify(arr, 0, --size);
		}
	}
	//只往下沉，不向上冒
	public static void heapify(int[] arr,int index,int size) {
		int cur = index;
		int left = 2*cur+1;
		while(left<size) {
			int great = left+1<size&&arr[left+1]>arr[left] ? left+1 : left;
			if(arr[great]<=arr[cur])return;
			swap(arr, cur, great);
			cur = great;
			left = cur*2+1;
		}
	}
	//只向上冒
	public static void heapInsert(int[] arr,int size) {
		
	}
	public static void heapInit(int[] arr,int size) {
		for(int i=size/2-1;i>=0;i--) {
			heapify(arr, i, size);
		}
	}
	
	
	public static void swap(int[] arr,int a,int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,2,7,3,6,8};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = utils.ToolUtil.generateArr(1, 100, -100, 100)[0];
			String str = Arrays.toString(arr);
			heapSort(arr);
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
