package advanced_part02;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * 	问题描述：
 * 	最大值减去最小值小于或等于 k 的子数组数量

	给定数组 arr 和整数 k,共返回有多少个子数组满足如下情况:
	max(arr[i..j]) - min(arr[i..j]) <= k
	max(arr[i..j])表示子数组 arr[i..j]中的最大值,min(arr[i..j])表示子数组 arr[i..j]中的最小值。
	【要求】
	如果数组长度为 N,请实现时间复杂度为 O(N)的解法。
	
	解题思路：
	利用窗口结构，同时注意两点：
	1.如果L-R数组达标，则L-R的子数组也是达标的
	2 如果L-R数组不达标，那么以L-R为子数组的数组也是不达标的
	维护两个窗口结构：最大值窗口结构，最小值窗口结构
 * @author Narut0
 *
 */
public class Code_06_AllLessNumSubArray {

	public static int allLessKSubArray(int[] arr,int k) {
		if(arr!=null&&arr.length!=0) {
			int res=0;
			int L=0;
			int R=0;
			LinkedList<Integer> qmax = new LinkedList<>();
			LinkedList<Integer> qmin = new LinkedList<>();
			while(R<arr.length&&L<arr.length) {
				while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[R]) {
					qmax.pollLast();
				}
				qmax.addLast(R);
				while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[R]) {
					qmin.pollLast();
				}
				qmin.addLast(R);
				if(arr[qmax.peekFirst()]-arr[qmin.peekFirst()]>k) {
					//System.out.println("L:"+L+"  R:"+R);
					res+=(R-L);
					R--;
					L++;
					if(qmax.peekFirst()<L) {
						qmax.pollFirst();
					}
					if(qmin.peekFirst()<L) {
						qmin.pollFirst();
					}
					
				}
				R++;
				
			}
			for(int i=L;i<arr.length;i++) {
				res += (arr.length-i);
			}
			return res;
			
			
		}
		return 0;
	}
	public static void main(String[] args) {
		int[][] arr = cn.xiaojiaqi.common.TestUtil.generateArr(999999, 10,0,100);
		for(int i=0;i<9999;i++) {
			int rand = (int)Math.ceil(Math.random()*100);
			int res1 = allLessKSubArray(arr[i], rand);
			int res2 = forTest(arr[i], rand);
			if(res1!=res2) {
				System.out.println(Arrays.toString(arr[i]));
				System.out.println("res1:"+res1+"  res2:"+res2+"   k:"+rand);
				break;
			}
		}
		System.out.println("over");
	/*	int[] arr = {52, 94, 29, 74, 42};
		int res = allLessKSubArray(arr, 8);
		System.out.println(res);*/
		//int min = Arrays.stream(arr, 0, 2).max().getAsInt();
		//System.out.println(min);
	}
	//暴力方法仅作测试
	public static int forTest(int[] arr,int k) {
		
		if(arr!=null&&arr.length>0) {
			
			int res=0;
			for(int i=0;i<arr.length;i++) {
				for(int j=i;j<arr.length;j++) {
					int min = Arrays.stream(arr, i, j+1).min().getAsInt();
					int max = Arrays.stream(arr, i, j+1).max().getAsInt();
					if(max-min<=k) {
						res++;
					}
				}
			}
			return res;
		}
		return -1;
	}

}
