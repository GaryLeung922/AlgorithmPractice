package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/5 11:42 AM
 */
public class LeetCode_011_ContainerWithMostWater {
    /**
     * two pointer.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if(height==null||height.length<=1)return 0;

        int left = 0;
        int right = height.length-1;

        int max = 0;
        while(left<right){
            max = Math.max(Math.min(height[left],height[right])*(right-left),max);

            // who less, turn whose direction.
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return max;
    }
}
