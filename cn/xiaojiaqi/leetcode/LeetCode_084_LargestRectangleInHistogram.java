package cn.xiaojiaqi.leetcode;

import java.util.Stack;

/**
 * 最大矩形 - 直方图中的
 * @Author: liangjiaqi
 * @Date: 2020/10/2 2:19 PM
 */
public class LeetCode_084_LargestRectangleInHistogram {

    /**
     * 解法一：单调栈
     */
    class Solution {
        public int largestRectangleArea(int[] mat) {
            if(mat==null || mat.length==0)return 0;

            Stack<Integer> stack = new Stack<>();
            int maxRectangle = 0;
            // travel every element
            for(int j=0;j<mat.length;j++){
                // there is a problem when nums is [1,3,3,3,4,3,2,2], we must deal with the  continuous equal elements.
                if(stack.isEmpty() || mat[stack.peek()]<mat[j]){
                    stack.push(j);
                }else if(mat[stack.peek()]>mat[j]){
                    while(!stack.isEmpty() && mat[stack.peek()]>mat[j]){
                        int height = mat[stack.pop()];

                        int left = stack.isEmpty() ? -1:stack.peek();
                        int right = j;
                        int width = right-left-1;

                        // update maxRectangle
                        maxRectangle = Math.max(width*height, maxRectangle);
                    }
                    stack.push(j);
                }else{
                    stack.pop();
                    stack.push(j);
                }
            }
            while(!stack.isEmpty()){
                int height = mat[stack.pop()];

                int left = stack.isEmpty() ? -1:stack.peek();
                int right = mat.length;
                int width = right-left-1;

                // update maxRectangle
                maxRectangle = Math.max(width*height, maxRectangle);
            }
            return maxRectangle;
        }
    }

    /**
     * 解法二 DP[i][j] j的大小受数据影响
     */
    static class Solution2 {
        public int largestRectangleArea(int[] mat) {
            if(mat==null||mat.length==0)return 0;

            int height = 0;
            for(int i=0;i<mat.length;i++){
                height = Math.max(height, mat[i]);
            }

            int[][] dp = new int[mat.length][height+1];
            for(int i=0;i<dp[0].length;i++){
                dp[0][i] = i<=mat[0] ? i : 0;
            }

            int max = dp[0][mat[0]];
            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length && j<=mat[i];j++){
                    if(dp[i-1][j]>0){
                        dp[i][j] = dp[i-1][j]+j;
                    }else{
                        dp[i][j] = j;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }
    }

    /**
     * 双数组法 时间O(n) 空间O(n)
     * 原理上和单调栈一样，只不过求某一个元素左右两边小于其的下标的手法不一样
     * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
     */
    static class Solution3 {
        public int largestRectangleArea(int[] mat) {
            if(mat==null||mat.length==0)return 0;

            // lessFromLeft[i] 表示： 左边离mat[i]最近的小于mat[i]的元素下标
            int[] lessFromLeft = new int[mat.length];
            // lessFromRight[i] 表示： 右边离mat[i]最近的小于mat[i]的元素下标
            int[] lessFromRight = new int[mat.length];

            lessFromLeft[0] = -1;
            lessFromRight[mat.length-1] = mat.length;

            for(int i=1;i<mat.length;i++){
                int p = i-1;
                while (p>=0 && mat[p]>=mat[i]){
                    p = lessFromLeft[p];
                }
                lessFromLeft[i] = p;
            }
            for(int i=mat.length-2;i>=0;i--){
                int p = i+1;
                while (p<mat.length && mat[p]>=mat[i]){
                    p = lessFromRight[p];
                }
                lessFromRight[i] = p;
            }
            int maxRectangle = 0;
            for(int i=0;i<mat.length;i++){
                maxRectangle = Math.max(maxRectangle, (lessFromRight[i]-lessFromLeft[i]-1)*mat[i]);
            }
            return maxRectangle;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};

        int[] arr2 = new int[]{2,1,2};

        int[] arr3 = new int[]{9,0};
        Solution2 solution2 = new Solution2();
        int rectangleArea = solution2.largestRectangleArea(arr2);
        System.out.println(rectangleArea);
    }
}
