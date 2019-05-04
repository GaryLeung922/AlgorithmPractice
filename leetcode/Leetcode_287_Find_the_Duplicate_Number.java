package cn.xiaojiaqi.leetcode;
/**
 * 思路 ：
 * 	n放到放到应该在的位置
 * @author Narut0
 *
 */
public class Leetcode_287_Find_the_Duplicate_Number {
    public static int findDuplicate(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i+1){
                if(nums[i]==nums[nums[i]-1])return nums[i];//当n与现在正在n-1位置上的数相同时，说明n即为重复的数
                swap(nums,i,nums[i]-1);
            }
        }
        return -1;
    }
    public static void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public static void main(String[] args) {
		int[] nums = {2,1,2};
		int ans = findDuplicate(nums);
		System.out.println(ans);
	}
    
}