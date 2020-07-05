package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/3 1:27 PM
 */
public class LeetCode_045_JumpGame2 {


    /**
     * 暴力
     */
    class Solution {
        public int jump(int[] nums) {
            if(nums==null||nums.length<=1)return 0;
            return jump(nums,0);

        }
        private int jump(int[] nums, int i) {
            if (i >= nums.length - 1) return 0;

            int nextMax = 0;
            int maxJump = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) return 1;
                if (j + nums[i + j] > maxJump) {
                    maxJump = j + nums[i + j];
                    nextMax = i + j;
                }
            }
            return 1 + jump(nums, nextMax);
        }
    }

    /**
     * 从左向右
     */
    class Solution2{
        public int jump(int[] nums) {
            if(nums==null||nums.length<=1)return 0;
            int mostRight = 0;  //能够走到的最右边
            int end = 0;    //上一次走的最右边
            int step = 0;

            for(int i=0;i<nums.length-1;i++){
                if(nums[i]+i>mostRight){
                    mostRight = Math.max(nums[i]+i,mostRight);
                }
                if(i==end){
                    end = mostRight;
                    step++;
                }
            }
            return step;
        }
    }
}
