package advanced_part07;

import java.util.Arrays;

public class Code_02_CardsInLine {

	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int fa = f(arr, 0, arr.length - 1);
		int fs = s(arr, 0, arr.length - 1);
		//System.out.println(fa>fs?"先手":"后手");
		return Math.max(fa, fs);
	}

	public static int f(int[] arr, int i, int j) {//先手拿牌，能获得的最大收益
		if (i == j) {
			return arr[i];
		}
		//返回能使目前的点数加上后手拿牌能获得的最大值
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
	}

	public static int s(int[] arr, int i, int j) {//后手拿牌，能获得的最大收益
		if (i == j) {
			return 0;
		}
		//联系20行，后手只能在先手挑完之后选择。所以先手留给后手来先手的情况必定是下面二者， 
		if(arr[i] + s(arr, i + 1, j)>arr[j] + s(arr, i, j - 1)) {
			return f(arr, i+1, j);
		}else {
			return f(arr, i, j-1);
		}
		//return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}

	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for (int j = 0; j < arr.length; j++) {
			f[j][j] = arr[j];
			for (int i = j - 1; i >= 0; i--) {
				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}
		return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 10 ,11};
		
		int ans1 = win1(arr);
		int ans2 = win2(arr);
		System.out.println(ans1);
		System.out.println(ans2);
		
		int[][] arrs = cn.xiaojiaqi.common.TestUtil.generateArr(99999, 11, 0, 20);
		boolean success = true;
		for(int[] arrr:arrs) {
			ans1 = win1(arrr);
			ans2 = win2(arrr);
			if(ans1!=ans2) {
				success = false;
				System.out.println(Arrays.toString(arrr));
				System.out.println("ans1:"+ans1);
				System.out.println("ans2:"+ans2);
			}
		}
		System.out.println(success?"Nice！":"Fucked!");

	}

}
