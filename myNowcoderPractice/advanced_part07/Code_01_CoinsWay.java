package advanced_part07;

import java.util.Arrays;

public class Code_01_CoinsWay {
	//暴力递归
	public static int coinsWay1(int[] arr,int aim) {
		if(arr!=null&&arr.length>0) {
			return process(arr, 0, aim);
		}
		return -1;
	}
	public static int process(int[] arr,int i,int res) {
		if(i==arr.length) {
			return res==0?1:0;
		}
		int result = 0;
		for(int j=0;j<=res/arr[i];j++) {
			result += process(arr, i+1, res-arr[i]*j);
		}
		return result;
	}
	
	//DP
	public static int coinsWay_dp(int[] arr,int aim) {
		if(arr!=null&&arr.length>0) {
			int[][] dp = new int[arr.length+1][aim+1];
			for(int i=0;i<dp[0].length;i++) {
				dp[dp.length-1][i] = i==0? 1 : 0;
			}
			for(int i=dp.length-2;i>=0;i--) {
				for(int j=0;j<dp[0].length;j++) {
					for(int k=0;k*arr[i]<=j;k++) {
						dp[i][j]+=dp[i+1][j-arr[i]*k];
					}
				}
			}
			return dp[0][dp[0].length-1];
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,5,10};
		int aim = 10;
		int ans1 = coinsWay1(arr, aim);
		System.out.println(ans1);
		int ans2 = coinsWay_dp(arr, aim);
		System.out.println(ans2);
		
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = MyUtils.TestUtil.generateArr_unique(10, 1, 100);
			aim = (int) Math.round(Math.random()*100+5);
			ans1 = coinsWay1(arr, aim);
			ans2 = coinsWay_dp(arr, aim);
			if(ans1!=ans2) {
				success = false;
				System.out.println(Arrays.toString(arr));
				System.out.println("aim:"+aim);
				System.out.println("ans1:"+ans1);
				System.out.println("ans2:"+ans2);
			}
		}
		System.out.println(success?"Nice!":"Fucked!");
	}

}
