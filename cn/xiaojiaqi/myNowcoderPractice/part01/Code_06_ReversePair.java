package part01;

import java.util.Arrays;
import java.util.Stack;

/**
 * 逆序对问题：
 * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
        对。
        思路：
   1.暴力解
   2.单调栈
   3.递归排序  
 * @author Narut0
 *
 */
public class Code_06_ReversePair {
	public static int stackReversePair(int[] arr) {
		int res = 0;
		if(arr!=null&&arr.length>0) {
			Stack<Integer> stack = new Stack<>();
			Stack<Integer> help = new Stack<>();
			for(int i=0;i<arr.length;i++) {
				if(stack.isEmpty()) {
					stack.push(arr[i]);
				}else if(stack.peek()>arr[i]){
					while (!stack.isEmpty()&&stack.peek()>arr[i]) {
						res++;
						help.push(stack.pop());
					}
					stack.push(arr[i]);
					while(!help.isEmpty()) {
						stack.push(help.pop());
					}
				}else {
					stack.push(arr[i]);
				}
			}
		}
		return res;
	}
	public static int mergeReversePair(int[] arr) {
		int res = 0;
		if(arr!=null&&arr.length>0) {
			res+=mergeCore(arr,0,arr.length-1);
		}
		return res;
	}
	private static int mergeCore(int[] arr, int i, int j) {
		int res=0;
		if(i==j) {
			return res;
		}
		int mid = i+((j-i)>>1);
		res+=mergeCore(arr, i, mid);
		res+=mergeCore(arr, mid+1, j);
		int[] help = new int[j-i+1];
		int k=0;
		int p1=i;
		int p2=mid+1;
		while(p1<=mid&&p2<=j) {
			if(arr[p1]>arr[p2]) {
				res+=(j-p2+1);
				help[k++]=arr[p1++];
			}else {
				help[k++]=arr[p2++];
			}
		}
		while (p1<=mid) {
			help[k++]=arr[p1++];
		}
		while (p2<=j) {
			help[k++]=arr[p2++];
		}
		for(k=0;k<help.length;k++) {
			arr[i+k]=help[k];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,0};
		int res1 = stackReversePair(arr);
		int res2 = mergeReversePair(arr);
		System.out.println("res1:"+res1+"  res2:"+res2);
		
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = cn.xiaojiaqi.common.TestUtil.generateArr(1, 100, 0, 10)[0];
			res1 = stackReversePair(arr);
			res2 = mergeReversePair(arr);
			
			if(res1!=res2) {
				success  = false;
				System.out.println(Arrays.toString(arr));
				System.out.println("res1:"+res1+"  res2:"+res2);
				break;
			}			
		}
		System.out.println(success?"Nice!":"Fucking fucked!");
	}

}
