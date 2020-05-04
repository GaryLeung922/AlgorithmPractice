package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;



public class Test_03_BFPRT {

	public static int bfprt(int[] nums,int begin,int end,int k) {
		if(end==begin+1) return nums[begin];
		
		int groups = (end-begin)%5==0 ? (end-begin)/5 : (end-begin)/5+1;
		int left = begin;
		int[] medians = new int[groups];
		for(int i=0;i<groups;i++) {
			int right = left+5>end ? end : left+5;
			Arrays.sort(nums,left,right);
			medians[i] = nums[(left+right)/2];
			left +=5;
		}
		int median = bfprt(medians, 0, medians.length, medians.length/2);
		int[] res = partition(nums, begin, end, median);
		if(k<res[0]) {
			return bfprt(nums, begin, res[0], k);
		}else if(k>res[1]) {
			return bfprt(nums, res[1]+1, end, k);
		}else {
			return nums[res[0]];
		}
		
	}
	public static int[] partition(int[] nums,int start,int end,int pivot) {
		if(end<=start)return new int[] {start,end};
		
		int less = start-1;
		int more = end;
		int cur=start;
		while(cur<more) {
			if(nums[cur]<pivot) {
				swap(nums, ++less, cur++);
			}else if(nums[cur]>pivot) {
				swap(nums, --more, cur);
			}else {
				cur++;
			}
		}
		return new int[] {less+1,more-1};
	}
	public static void swap(int[] nums,int a,int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int ans = bfprt(nums, 0, nums.length, 5);
		System.out.println(ans);
		
		boolean success=true;
		for(int i=0;i<999999;i++) {
			nums = TestUtil.generateArr(1, 15, -15, 100)[0];
			int k = (int) Math.random()*15;
			int ans1 = bfprt(nums, 0, nums.length, k);
			Arrays.sort(nums);
			int ans2 = nums[k];
			if(ans1!=ans2) {
				success = false;
				break;
			}
		}
		System.out.println(success ? "Niced":"Fuced");
	}

}
