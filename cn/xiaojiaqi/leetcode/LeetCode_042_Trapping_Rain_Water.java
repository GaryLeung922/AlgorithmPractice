package cn.xiaojiaqi.leetcode;

/**
 * 接雨水
 * @Author: liangjiaqi
 * @Date: 2020/7/15 7:25 AM
 */
public class LeetCode_042_Trapping_Rain_Water {


    /**
     * 在从左到右遍历过程中，依次找出各个元素的左边的最大值
     * 从右向左类似
     * 最后求能够接的雨水
     *
     * 时间O(n) ，空间O(n)
     */
    class Solution {
        public int trap(int[] height) {
            if(height==null||height.length<=2)return 0;

            int max = -1;
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            int trapRain = 0;

            for(int i=0;i<height.length;i++){
                if(height[i]>=max){
                    max = height[i];
                    leftMax[i] = height[i];
                }else{
                    leftMax[i] = max;
                }
            }

            max = -1;

            for(int i=height.length-1;i>=0;i--){
                if(height[i]>=max){
                    max = height[i];
                    rightMax[i] = height[i];
                }else{
                    rightMax[i] = max;
                }
            }

            for(int i=0;i<height.length;i++){
                trapRain+=(Math.min(leftMax[i],rightMax[i]) - height[i]);
            }
            return trapRain;
        }
    }
}
