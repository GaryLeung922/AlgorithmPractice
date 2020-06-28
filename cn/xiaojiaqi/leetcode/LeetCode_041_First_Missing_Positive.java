package cn.xiaojiaqi.leetcode;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
 * @Author: liangjiaqi
 * @Date: 2020/6/28 9:59 PM
 */
public class LeetCode_041_First_Missing_Positive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if(nums==null||nums.length==0)return 1;

            // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
            // (we can ignore those because if all number are > n then we'll simply return 1)
            int n = nums.length;
            for(int i=0;i<n;i++){
                if(nums[i]<=0||nums[i]>n){
                    nums[i] = n+1;
                }
            }
            // note: all number in the array are now positive, and on the range 1..n+1

            // 2. mark each cell appearing in the array, by converting the index for that number to negative
            for(int i=0;i<n;i++){
                // get Math.abs(nums[i]);
                int num = Math.abs(nums[i]);
                if(num<=n){

                    num--;// -1 for zero index based array (so the number 1 will be at pos 0)
                    if(nums[num]>0){
                        // negative it, indicate that num+1 is exist.
                        nums[num] = -1 * (nums[num]);
                    }
                }
            }

            // 3. find the first cell which isn't negative (doesn't appear in the array)
            for(int i=0;i<n;i++){
                if(nums[i]>=0){
                    return i+1;
                }
            }
            // 4. no positive numbers were found, which means the array contains all numbers 1..n
            return n+1;
        }
    }
}
