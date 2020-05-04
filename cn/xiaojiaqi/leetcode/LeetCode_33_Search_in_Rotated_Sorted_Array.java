package cn.xiaojiaqi.leetcode;
public class LeetCode_33_Search_in_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0)return -1;
        
        int minIndex = binaryFindMin(nums); //先找最小值的位置
        int maxIndex = minIndex-1==-1 ? nums.length-1 : minIndex-1;
        if(target<nums[minIndex]||target>nums[maxIndex])return -1;
        if(target>=nums[0]) return binaryFindK(nums,target,0,maxIndex);
        return binaryFindK(nums,target,minIndex,nums.length-1);
    }
    public static int binaryFindMin(int[] nums){
        int begin = 0;
        int end = nums.length-1;
        int mid = begin+((end-begin)>>1);
        while(begin<end){
            if(nums[mid]<nums[nums.length-1]){
                end = mid;
            }else{
                begin = mid+1;
            }
            mid = begin+((end-begin)>>1);
        }
        return begin;
    }
    public static int binaryFindK(int[] nums,int k,int begin,int end){
        int mid = begin+((end-begin)>>1);
        while(begin<end){
            if(nums[mid]>k){
                end = mid-1;
            }else if(nums[mid]<k){
                begin = mid+1;
            }else{
                return mid;
            }
            mid = begin+((end-begin)>>1);
        }
        if(nums[begin]==k)return begin;
        return -1;
    }
    
    public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		int ans = search(nums, target);
		System.out.println(ans);

	}
}