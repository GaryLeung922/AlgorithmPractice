package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/21 8:13 AM
 */
public class LeetCode_033_SearchInRotatedSortedArray {
    static class Solution {
        public int search(int[] nums, int target) {
            if(nums==null||nums.length==0)return -1;

            int a = 0;
            int b = nums.length-1;
            int pre = a;
            int pivot=0;
            // 如果本身就是有序的
            if(nums[a]<nums[b]){
                return binarySearch(nums, 0, nums.length, target);
            }
            while(a<b){
                if(a==b-1){
                    pivot = b;
                    break;
                }
                if(nums[a]<nums[b]){
                    b = a;
                    a = pre;
                }else if(nums[a]>=nums[b]){
                    pre = a;
                    a = a+(b-a)/2;
                }
            }
            if(nums[0]>target){
                return binarySearch(nums,pivot,nums.length,target);
            }else if(nums[0]<target){
                return binarySearch(nums,0,pivot,target);
            }else {
                return 0;
            }
        }
        private int binarySearch(int[] nums, int start, int end, int target){
            int mid = start+(end-start)/2;
            while (start<end){
                if(nums[mid]<target){
                    start = mid+1;
                }else if(nums[mid]>target){
                    end = mid;
                }else {
                    return mid;
                }
                mid = start+(end-start)/2;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{0,0,0,0,0};
        int search = solution.search(nums, 0);
        System.out.println(search);
    }
}
