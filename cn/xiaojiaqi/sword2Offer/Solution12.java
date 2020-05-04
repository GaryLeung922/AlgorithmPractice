package cn.xiaojiaqi.sword2Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 	连续子数组的最大累加和
 * @author Narut0
 *
 */
public class Solution12 {
	//解法1.
	public static int FindGreatestSumOfSubArray(int[] array) {
        if(array!=null&&array.length>0){
            int max = array[0];
            int sum = array[0];
            for(int i=1;i<array.length;i++){
                if(sum+array[i]<0){
                    max = Math.max(max,array[i]);
                    if(max==array[i]){
                        sum = array[i];
                    }else{
                        sum = 0;
                    }
                }else{
                    sum += array[i];
                    max = Math.max(max,sum);
                }
            }
            return max;
        }
        return 0;
 
    }
	//解法2.DP
	
	public static int getMax(int[] arr) {
		int max = arr[0];
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			max = Math.max(max,dp[i]);
		}
		return max;
	}
    public static void main(String[] args) {
		int[] arr = {-2,-8,-1,-5,-9};
		int res = FindGreatestSumOfSubArray(arr);
		System.out.println(res);
		
		System.out.println(getMax(arr));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2-o1;
			}
			
		});
		
		
	}
}