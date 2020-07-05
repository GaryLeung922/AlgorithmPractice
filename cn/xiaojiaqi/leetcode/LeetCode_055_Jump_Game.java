package cn.xiaojiaqi.leetcode;

/**
 * from recurtion to DP
 * https://leetcode.com/problems/jump-game/solution/
 * @Author: liangjiaqi
 * @Date: 2020/7/2 8:17 AM
 */
public class LeetCode_055_Jump_Game {

    /**
     * 暴力尝试  Time Limit Exceeded
     */
    class Solution1 {
        public boolean canJump(int[] nums) {
            if(nums==null||nums.length==0)return true;
            return canJump(nums,0);
        }

        private boolean canJump(int[] nums,int i){
            if(i>=nums.length-1)return true;
            for(int j=1;j<=nums[i];j++){
                if(canJump(nums,i+j))return true;
            }
            return false;
        }
    }

    /**
     * Greedy， step into the position on where you can go the furthest. O(n^2)
     */
    class Solution2 {
        public boolean canJump(int[] nums) {
            if(nums==null||nums.length==0||nums.length==1)return true;
            return canJump(nums,0);
        }

        private boolean canJump(int[] nums, int i){
            if(i>=nums.length-1)return true;

            int nextMax = 0;
            int maxJump = 0;
            for(int j=1;j<=nums[i];j++){
                if(j+nums[i+j]>maxJump){
                    maxJump = j+nums[i+j];
                    nextMax = i+j;
                }
                if(maxJump+i >= nums.length-1) return true;

            }
            if(maxJump==0)return false;
            return canJump(nums,nextMax);
        }
    }

    /**
     * Greedy. Step from right -> left
     * O(n)
     */
    class Solution3 {
        public boolean canJump(int[] nums) {
            if(nums==null||nums.length==0||nums.length==1)return true;
            int last = nums.length-1;
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]+i>=last){
                    last = i;
                }
            }
            return last==0;
        }
    }

}
