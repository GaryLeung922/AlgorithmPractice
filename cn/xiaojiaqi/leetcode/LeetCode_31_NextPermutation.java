package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

public class LeetCode_31_NextPermutation {
    public static void nextPermutation(int[] nums) {
    	if(nums==null&&nums.length<2)return;
        
        int cur = nums.length-1;
        //1.逆序找，找出第一个不满足数组逆序为升序的数
        while(cur>0){
            if(nums[cur-1]<nums[cur]) {
            	//2.找倒序第一个大于nums[cur-1]的数
            	int k = binaryFind(nums, nums[cur-1], cur, nums.length-1);
            	while(k>=cur) {
            		if(nums[k]>nums[cur-1]) {
            			swap(nums,k,cur-1);
            			reverse(nums, cur);
            			return ;
            		}
            		k--;
            	}
            	
            	
            }else {
            	cur--;
            }
        }
        reverse(nums,0);
        return;
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void reverse(int[] nums,int begin){
        for(int i=begin;i<(nums.length+begin)/2;i++){
            swap(nums,i,nums.length+begin-i-1);
        }
    }
    public static int binaryFind(int[] nums,int k,int begin,int end) {
    	int mid = begin+((end-begin)>>1);
    	while(begin<end) {
    		if(nums[mid]>k) {
    			begin = mid+1;
    		}else if (nums[mid]<k) {
				end = mid -1;
			}else {
				return mid;
			}
    		mid = begin+((end-begin)>>1);
    	}
    	return begin;
    }
    public static void main(String[] args) {
		int[] nums = {4,2,0,2,3,2,0};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}