package part01;

import java.util.Arrays;

public class Code_07_RadixSort {

	public static void radixSort(int[] nums) {
		if(nums==null||nums.length<2)return ;
		radixSort(nums,0,nums.length,maxDigits(nums));
	}
	private static int maxDigits(int[] nums) {
		int res = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			max = Math.max(max, nums[i]);
		}
		while(max>0) {
			res++;
			max/=10;
		}
		return res;
	}
	private static void radixSort(int[] nums, int begin, int end,int digit) {
		int radix = 10;
		int[] count = new int[radix];
		int[] bucket = new int[end-begin];
		
		for(int d=1;d<=digit;d++) {
			for(int i=0;i<count.length;i++) {
				count[i]=0;
			}
			for(int i=begin;i<end;i++) {
				count[getDigit(nums[i],d)]++;
			}
			for(int i=1;i<count.length;i++) {
				count[i]+=count[i-1];
			}
			for(int i=end-1;i>=begin;i--) {
				bucket[count[getDigit(nums[i], d)]-1] = nums[i];
				count[getDigit(nums[i], d)]--;
			}
			for(int i=begin;i<end;i++) {
				nums[i] = bucket[i-begin];
			}
		}
		
		
	}
	private static int getDigit(int n,int d) {
		
		return (n%(int)(Math.pow(10, d)))/((int)(Math.pow(10, d-1)));
	}
	public static void main(String[] args) {
		int[] nums = {15,66,82,74,55,33};
		radixSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
