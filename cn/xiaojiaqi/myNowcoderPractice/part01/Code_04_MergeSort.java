package cn.xiaojiaqi.myNowcoderPractice.part01;

import java.util.Arrays;
/**
 * 归并排序
 * 时间复杂度O(nlogn)
 * 额外空间复杂度O(n)，需要一个辅助数组
 * @author Narut0
 *
 */
public class Code_04_MergeSort {
	public static void mergeSort(int[] arr) {
		if(arr!=null&&arr.length>0) {
			mergeSortCore(arr, 0, arr.length-1);
		}
	}
	public static void mergeSortCore(int[] arr,int begin,int end) {
		if(begin==end) {
			return;
		}
		int mid = begin+((end-begin)>>1);
		mergeSortCore(arr, begin, mid);//左边排好序
		mergeSortCore(arr, mid+1, end);//右边排好序
		//合并，并使其总体有序
		int[] help = new int[end-begin+1];
		int i = begin;
		int j = mid+1;
		int k=0;
		while(i<=mid&&j<=end) {
			help[k++] = arr[i]<=arr[j]? arr[i++]:arr[j++];
		}
		while(i<=mid) {
			help[k++] = arr[i++];
		}
		while (j<=end) {
			help[k++] = arr[j++];
		}
		for(k=0;k<help.length;k++) {
			arr[begin+k] = help[k];
		}
	}
	public static void main(String[] args) {
		int[] arr  = {4,5,9,6};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = cn.xiaojiaqi.common.TestUtil.generateArr(1, 100, -100, 100)[0];
			mergeSort(arr);
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
