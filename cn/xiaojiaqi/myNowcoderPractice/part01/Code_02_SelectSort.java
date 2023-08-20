package cn.xiaojiaqi.myNowcoderPractice.part01;

import java.util.Arrays;

public class Code_02_SelectSort {
	public static void selectSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int max = Integer.MIN_VALUE;
			int index = -1;
			for(int i=0;i<arr.length-1;i++) {
				for(int j=0;j<arr.length-i;j++) {
					if(arr[j]>=max) {
						max = arr[j];
						index  = j;
					}
				}
				max = Integer.MIN_VALUE;
				swap(arr,index,arr.length-i-1);
			}
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		int[] arr = {4,6,8,3,2,9};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
		
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = cn.xiaojiaqi.common.TestUtil.generateArr(1, 100, -100, 100)[0];
			selectSort(arr);
			String str1 = Arrays.toString(arr);
			Arrays.sort(arr);
			String str2 = Arrays.toString(arr);
			if(!str1.equals(str2)) {
				success  = false;
				break;
			}
		}
		System.out.println(success?"Nice!":"Fucked!");
	}
	

}
