package cn.xiaojiaqi.leetcode;

/**
 * 二分搜索
 * @Author: liangjiaqi
 * @Date: 2020/10/7 4:32 PM
 */
public class LeetCode_704_Binary_Search {
    class Solution {
        public int search(int[] nums, int target) {
            if(nums==null||nums.length==0)return -1;
            int L = 0;
            int R = nums.length;

            while(L<R){
                int mid = L+(R-L)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    R = mid;
                }else{
                    L = mid+1;
                }
            }
            return -1;
        }
    }
}
