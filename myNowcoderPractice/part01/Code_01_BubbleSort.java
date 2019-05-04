package part01;

import java.util.Arrays;

public class Code_01_BubbleSort {

	public static void bubbleSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length-i-1;j++) {
					if(arr[j]>arr[j+1])swap(arr, j, j+1);
				}
			}
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		int[] arr = {4,1,6,7,3,3};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = MyUtils.TestUtil.generateArr(1, 100, -100, 100)[0];
			bubbleSort(arr);
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
