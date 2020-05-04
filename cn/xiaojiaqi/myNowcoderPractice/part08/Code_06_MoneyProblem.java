package part08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题描述:
给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
数字，能不能累加得到aim，返回true或者false
	解题思路：
1.暴力递归
数组中每个数，都可以选择加或者不加
父问题f(n)可以分解为子问题arr[0]+f(n-1)与f(n-1)
注意边界
2.暴力递归转DP(暴力递归中是否有重复计算？)
从后往前推，整理出DP数组
得到答案
	
 * @author Narut0
 *
 */
public class Code_06_MoneyProblem {

	public static boolean isAim(int[] arr,int aim,int sum,int i) {
		if(arr!=null) {
			if(sum==aim) {
				return true;
			}
			if(i>=arr.length) {
				return false;
			}
			return isAim(arr,aim,sum+arr[i],i+1)||isAim(arr, aim, sum, i+1);
		}
		return false;
	}
	
	public static Boolean dpIsAim(int[] arr,int aim) {
		if(arr!=null) {
			Queue<Integer> help = new LinkedList<>();
			help.add(arr[arr.length-1]);
			help.add(0);
			Queue<Integer> dp = new LinkedList<>();
			for(int i=arr.length-2;i>=0;i--) {
				while(!help.isEmpty()) {
					if(help.peek()==aim||(arr[i]+help.peek())==aim) {
						return true;
					}else {
						dp.offer(help.peek());
						dp.offer(arr[i]+help.peek());
						help.poll();
					}
				}
				Queue<Integer> tmp = dp;
				dp = help;
				help = tmp;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		//int[] arr= {1,3,-9,-2,5,3};
		int[][] arr = Code_07_Knapsack.generateRandomMatrix(1,  (int)Math.ceil(Math.random()*20+1));
		for(int i=0;i<999999;i++) {
			int rand = (int)Math.ceil(Math.random()*50+1);
			if(isAim(arr[0], rand, 0, 0)!=dpIsAim(arr[0], rand)) {
				System.out.println("false");
				System.out.println(Arrays.toString(arr[0]));
				System.out.println("rand:"+rand);
				break;
			}else {
				//System.out.println("true");
			}
		}
		
		
	}
}
