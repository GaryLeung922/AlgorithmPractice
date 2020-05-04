package part08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 问题描述：
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的
	重量，v[i]表示第i件商品的价值。 再给定一个整数bag，要求
	你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件
	下，你能获得的最大价值。
	
	解题思路：
	1. 暴力递归
	2. DP
 * @author Narut0
 *
 */
public class Code_07_Knapsack {

	public static int maxValue(int[] w,int[] v,int i,int sumw,int sumv,int bag) {
		if(w.length==v.length&&w!=null) {
			if(sumw>bag) {//如果发现超重装不下了，你得把商品取下来，同时减去取下商品的value
				return sumv-v[i-1];
			}
			if(sumw==bag) {
				return sumv;
			}
			if(i>=w.length) {
				return sumv;
			}
			int with = maxValue(w, v, i+1, sumw+w[i], sumv+v[i], bag);
			int without = maxValue(w, v, i+1, sumw, sumv, bag);
			return with>without?with:without;

		}
		return 0;
	}
	public static int dpMaxValue(int[] w,int[] v,int bag) {
		if(w.length==v.length&&w!=null) {
			 Queue<Integer> helpW = new LinkedList<>();
			 Queue<Integer> helpV = new LinkedList<>();
			 Queue<Integer> dpW = new LinkedList<>();
			 Queue<Integer> dpV = new LinkedList<>();
			 helpW.add(w[0]);
			 helpV.add(v[0]);
			 helpW.add(0);
			 helpV.add(0);
			 for(int i=1;i<w.length;i++) {
				 while(!helpW.isEmpty()) {
					 if(helpW.peek()>bag) {
						 
					 }else if (helpW.peek()+w[i]>bag) {
						 dpW.add(helpW.peek());
						 dpV.add(helpV.peek());
						 
					}else {
						dpW.add(helpW.peek());
						dpW.add(helpW.peek()+w[i]);
						dpV.add(helpV.peek());
						dpV.add(helpV.peek()+v[i]);
						
						
					}
					helpW.poll();
					helpV.poll();
				 }
				 Queue<Integer> tmpw = helpW;
				 Queue<Integer> tmpv = helpV;
				 helpW = dpW;
				 helpV = dpV;
				 dpW = tmpw;
				 dpV = tmpv;
				 
				 
			 }
			 int max = helpV.peek();
			 while (!helpV.isEmpty()) {
				if(max<=helpV.peek()) {
					max = helpV.peek();
				}
				helpV.poll();
			}
			return max;
		}
		return 0;
	}
	public static void main(String[] args) {
		int[] c = { 3, 2, 4, 7 };
		int[] p = { 5, 6, 3, 19 };
		int bag = 11;
		System.out.println(maxValue(c, p, 0, 0, 0, bag));
		System.out.println(dpMaxValue(c, p, bag));
		
		for(int i=0;i<999999;i++) {
			int[][] m = generateRandomMatrix(2, (int)Math.ceil(Math.random()*10+1));
			int bags = (int)Math.ceil(Math.random()*30+1);
			int re = maxValue(m[0], m[1], 0, 0, 0, bags);
			int dp = dpMaxValue(m[0], m[1], bags);
			
			
			if(re!=dp) {
				System.out.println("re:"+re);
				System.out.println("dp:"+dp);
				System.out.println(Arrays.toString(m[0]));
				System.out.println(Arrays.toString(m[1]));
				System.out.println("bag:"+bags);
				System.out.println(m[0][0]+"  "+m[1][0]);
				break;
			}
		}
	}
	//for test 对数器
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10+1);
			}
		}
		return result;
	}
}
