package cn.xiaojiaqi.leetcode;

/**
 *
 * @Author: liangjiaqi
 * @Date: 2020/6/28 1:08 PM
 */
public class LeetCode_080_RemoveDupElemInSortedArr2 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums==null || nums.length==0)return 0;

            int a = 0;
            int b = 1;
            int dup = 1;
            while(b<nums.length){
                if(nums[a]!=nums[b]){
                    swap(nums,++a,b++);
                    dup = 1;
                }else if(dup<2){
                    // we also need to swap in this situation.
                    swap(nums,++a,b++);
                    dup++;
                }else{
                    b++;
                }
            }
            return a+1;
        }
        public void swap(int[] nums, int i,int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
