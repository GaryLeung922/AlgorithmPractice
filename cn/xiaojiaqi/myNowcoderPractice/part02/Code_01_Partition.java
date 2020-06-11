package cn.xiaojiaqi.myNowcoderPractice.part02;

import java.util.Arrays;
/**
 * Partition
 * 荷兰国旗问题：
 * 给定一个数num，把数组中，小于num的放左边，大于num的放右边，等于的放中间
 * @author Narut0 
 */
public class Code_01_Partition {
	public static void partition(int[] arr,int num) {
		if(arr!=null&&arr.length>0) {
			int L = -1;
			int R = arr.length;
			int cur = 0;
			while(cur<R) {
				if(arr[cur]<num) {
					swap(arr,cur++,++L);
				}else if(arr[cur]>num) {
					swap(arr, cur, --R);
				}else {
					cur++;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		int[] arr = {1,5,8,3,5,6,7,2,0};
		int num = 5;
		partition(arr, num);
		System.out.println(Arrays.toString(arr));
	}
}
