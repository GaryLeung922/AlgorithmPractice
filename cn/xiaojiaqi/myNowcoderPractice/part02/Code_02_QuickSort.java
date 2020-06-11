package cn.xiaojiaqi.myNowcoderPractice.part02;

import java.util.Arrays;
/**
 * 随机快排
 * @author Narut0
 *
 */
public class Code_02_QuickSort {
	public static int[] partition(int[] arr,int left,int right) {
		int more = right;
		int less = left-1;
		swap(arr, (int)(Math.random()*(right-left+1))+left, right);
		
		int cur = left;
		while(cur<more) {
			if(arr[cur]<arr[right]) {
				swap(arr, cur++, ++less);
			}else if(arr[cur]>arr[right]) {
				swap(arr, cur, --more);
			}else {
				cur++;
			}
		}
		swap(arr, right, more++);
		//返回中间等于的边界
		return new int[] {less+1,more-1};
	}
	public static void quickSort(int[] arr) {
		if(arr!=null&&arr.length>1) {
			quickSort(arr, 0, arr.length-1);
		}
	}
	public static void quickSort(int[] arr,int left,int right) {
		if(left<right) {
			int[] p = partition(arr, left, right);
			quickSort(arr, left, p[0]-1);
			quickSort(arr, p[1]+1, right);
		}
	}
	
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		int[] arr = {3, 9, 4, 10, 3};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
		
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = cn.xiaojiaqi.common.TestUtil.generateArr(1, 100, -100, 100)[0];
			String arrstr = Arrays.toString(arr);
			quickSort(arr);
			String str1 = Arrays.toString(arr);
			Arrays.sort(arr);
			String str2 = Arrays.toString(arr);
			if(!str1.equals(str2)) {
				success  = false;
				System.out.println(arrstr);
				System.out.println(str1);
				System.out.println(str2);
				break;
			}
		}
		System.out.println(success?"Nice!":"Fucking fucked!");
	}

}
