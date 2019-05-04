package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

public class LeetCode_34_SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        int mid = begin+((end-begin)>>1);
        while(end>begin){
            if(nums[mid]<target){
                
                begin = mid+1;
            }else if(nums[mid]>target){
            	end = mid-1;
            }else{
                int left = searchRange(nums,target,begin,mid-1,true);
                int right = searchRange(nums,target,mid+1,end,false);
                left = left==-1 ? mid : left;
                right = right==-1 ? mid : right;
                //
                return new int[]{left,right};
            }
            mid = begin+((end-begin)>>1);
        }
        if(nums[begin]==target)return new int[]{begin,begin};
        return new int[]{-1,-1};
    }
    public static int searchRange(int[] nums, int target,int begin,int end,boolean findLeft) {
        
        int mid = begin+((end-begin)>>1);
        while(begin<end){
            if(nums[mid]<target){
            	begin = mid+1;
                
            }else if(nums[mid]>target){
            	end = mid-1;
            }else{
                if(findLeft){
                    int left = searchRange(nums,target,begin,mid-1,true);
                    return left==-1 ? mid : left;
                }else{
                    int right = searchRange(nums,target,mid+1,end,false);
                    return right==-1 ? mid : right;
                } 
            }
            mid = begin+((end-begin)>>1);
        }
        if(nums[begin]==target) return begin;
        return -1;
        
    
    }
    public static void main(String[] args) {
		int[] nums = {1,2,3,3,3,3,4,5,9};
		int target = 3;
		int[] res = searchRange(nums, target);
		System.out.println(Arrays.toString(res));
	}
}