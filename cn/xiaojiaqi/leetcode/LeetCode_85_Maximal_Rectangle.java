package cn.xiaojiaqi.leetcode;

import java.util.Stack;

/**
 * 求最大子矩阵(子矩阵中的数,全为1)
 * based on Largest Rectangle in Histogram
 * 利用单调栈. 把问题化为每一行去求解
 * 关联 leetcode 221
 */
public class LeetCode_85_Maximal_Rectangle {
    public static int maximalRectangle(String[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        
        int[][] arrs = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                arrs[i][j] = Integer.valueOf(matrix[i][j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<arrs.length;i++){
            for(int j=0;j<arrs[0].length;j++){
                if(i>0){
                    arrs[i][j] = arrs[i][j]==1 ? 1+arrs[i-1][j] : 0;  //如果当前位置为1,则使其加上上一个位置(矩阵中)的值
                }
            }
            max = Math.max(max,maximalRectangle(arrs[i]));
        }
        return max;
    }
    public static int maximalRectangle(int[] arr) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<arr.length){
            if(stack.isEmpty()||arr[stack.peek()]<arr[i]){
                stack.push(i);
            }else if(arr[stack.peek()]>arr[i]){
            	while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]) {
            		int height = arr[stack.pop()];
                    int begin = stack.isEmpty() ? -1 : stack.peek();
                    max = Math.max(max,height*(i-begin-1));
            	}
                stack.push(i);
            }else {//如果相等，只要后面的
				stack.pop();
				stack.push(i);
			}
            i++;
        }
        while(!stack.isEmpty()){
            int height = arr[stack.pop()];
            int begin = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max,height*(i-begin-1));
        }
        return max;
    }


    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix==null || matrix.length==0)return 0;
            int[][] mat = char2int(matrix);

            // store index instead of element, if there are continuous equal elements the push the [left_index, right_index], instead [index, index];
            // There is an another way that we just record the mostRight index in continuous equal elements.
            Stack<int[]> stack = new Stack<>();
            int maxRectangle = 0;

            // travel every array
            for(int i=0;i<mat.length;i++){
                // travel every element
                for(int j=0;j<mat[0].length;j++){
                    // there is a problem when nums is [1,3,3,3,4,3,2,2], we must deal with the  continuous equal elements.
                    if(stack.isEmpty() || mat[i][stack.peek()[0]]<mat[i][j]){
                        stack.push(new int[]{j,j});
                    }else if(mat[i][stack.peek()[0]]>mat[i][j]){
                        while(!stack.isEmpty() && mat[i][stack.peek()[0]]>mat[i][j]){
                            int height = mat[i][stack.pop()[0]];

                            int left = stack.isEmpty() ? -1:stack.peek()[1];
                            int right = j;
                            int width = right-left-1;

                            // update maxRectangle
                            maxRectangle = Math.max(width*height, maxRectangle);
                        }
                        stack.push(new int[]{j,j});
                    }else{
                        int[] peek = stack.peek();
                        peek[1] = j;
                    }
                }
                while(!stack.isEmpty()){
                    int height = mat[i][stack.pop()[0]];

                    int left = stack.isEmpty() ? -1:stack.peek()[1];
                    int right = mat[0].length;
                    int width = right-left-1;

                    // update maxRectangle
                    maxRectangle = Math.max(width*height, maxRectangle);
                }
            }


            return maxRectangle;


        }

        private int[][] char2int(char[][] mat){
            int[][] res = new int[mat.length][mat[0].length];
            for(int i=0;i<mat[0].length;i++){
                res[0][i] = mat[0][i]=='0' ? 0 : 1;
            }
            for(int i=1;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    res[i][j] = mat[i][j]=='0' ? 0 : res[i-1][j]+1;
                }
            }
            return res;
        }

    }

    /**
     * 解法二：DP
     * 时间O(nm), 空间O(m)
     */
    class Solution2 {
        public int maximalRectangle(char[][] a) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
		String[][] matrix = {{"0","0","0","1","0","1","1","1"},{"0","1","1","0","0","1","0","1"},{"1","0","1","1","1","1","0","1"},{"0","0","0","1","0","0","0","0"},{"0","0","1","0","0","0","1","0"},{"1","1","1","0","0","1","1","1"},{"1","0","0","1","1","0","0","1"},{"0","1","0","0","1","1","0","0"},{"1","0","0","1","0","0","0","0"}};
		
		int ans = maximalRectangle(matrix);

		char[][] matrix2 = {{'1','0'},{'1','0'}};
        int ans2 = solution.maximalRectangle(matrix2);

		System.out.println(ans);

        System.out.println(ans2);

    }
}