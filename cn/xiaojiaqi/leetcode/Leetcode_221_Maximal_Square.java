package cn.xiaojiaqi.leetcode;

import java.util.Stack;

/**
 * 最大的正方形，
 * 现转化为一个一个的数组，然后实际上是在求数组可以组成的最大正方形
 * 可以用单调栈，对任意一个元素求其左右两边比其小且离其最近的元素
 */
public class Leetcode_221_Maximal_Square {
    public static int maximalSquare(String[][] matrix) {
        int[][] mat = char2int(matrix);
        
        Stack<Integer> stack = new Stack<>();
        int maxSquare = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(stack.isEmpty()||mat[i][j]>mat[i][stack.peek()]){
                    stack.push(j);
                }else if(mat[i][j]<mat[i][stack.peek()]){
                    while(!stack.isEmpty()&&mat[i][stack.peek()]>=mat[i][j]){
                        int height = mat[i][stack.pop()];
                        int weight = stack.isEmpty() ? j-(-1)-1 : j-stack.peek()-1;
                        maxSquare = Math.max(maxSquare,Math.min(height,weight)*Math.min(height,weight));
                    }
                    stack.push(j);
                }else{ // 如果相等只要后面的
                    stack.pop();
                    stack.push(j);
                }
            }
            while(!stack.isEmpty()){
                int height = mat[i][stack.pop()];
                int weight = stack.isEmpty() ? mat[0].length-(-1)-1 : mat[0].length-stack.peek()-1;
                maxSquare = Math.max(maxSquare,Math.min(height,weight)*Math.min(height,weight));
            }
        }
        return maxSquare;
    }

    /**
     * char to int, beside 对同一列进行累加
     * @param mat
     * @return
     */
    public static int[][] char2int(String[][] mat){
        int[][] res = new int[mat.length][mat[0].length];
        for(int i=0;i<mat[0].length;i++){
            res[0][i] = mat[0][i].equals("0") ? 0 : 1;
        }
        for(int i=1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                res[i][j] = mat[i][j].equals("0") ? 0 : res[i-1][j]+1;
            }
        }
        return res;
    }

    /**
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare2(String[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        
        int maxSize = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxSize = Math.max(p(matrix,i,j),maxSize);
            }
        }
        return maxSize*maxSize;
    }
    public static int p(String[][] mat,int i,int j){
        if(i==0||j==0) return mat[i][j].equals("0") ? 0 : 1;
        
        return Math.min(p(mat,i-1,j-1),Math.min(p(mat,i-1,j),p(mat,i,j-1)))+1;
        
    }

    /**
     * 单调栈 时间复杂度O(nm) 空间可以O(n)， 但是我为了方便。。。
     */
    static class Solution {
        /**
         * 最大的正方形，现转化为一个一个的数组，然后实际上是在求数组可以组成的最大正方形
         *  * 可以用单调栈，对任意一个元素求其左右两边比其小且离其最近的元素
         * @param matrix
         * @return
         */
        public int maximalSquare(char[][] matrix) {
            if(matrix==null || matrix.length==0)return 0;
            int[][] mat = char2int(matrix);

            // store index instead of element, if there are continuous equal elements the push the [left_index, right_index], instead [index, index];
            Stack<int[]> stack = new Stack<>();
            int maxSquare = 0;

            // travel every array
            for(int i=0;i<mat.length;i++){
                // travel every element
                for(int j=0;j<mat[0].length;j++){
                    // There is a problem when nums is [1,3,3,3,4,3,2,2], we must deal with the  continuous equal elements.
                    // There is an another way that we just record the mostRight index in continuous equal elements.
                    if(stack.isEmpty() || mat[i][stack.peek()[0]]<mat[i][j]){
                        stack.push(new int[]{j,j});
                    }else if(mat[i][stack.peek()[0]]>mat[i][j]){
                        while(!stack.isEmpty() && mat[i][stack.peek()[0]]>mat[i][j]){
                            int height = mat[i][stack.pop()[0]];

                            int left = stack.isEmpty() ? -1:stack.peek()[1];
                            int right = j;
                            int width = right-left-1;
                            int maxLength = Math.min(height,width);

                            // update maxSquare
                            maxSquare = Math.max(maxLength*maxLength, maxSquare);
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
                    int maxLength = Math.min(height,width);

                    // update maxSquare
                    maxSquare = Math.max(maxLength*maxLength, maxSquare);
                }
            }


            return maxSquare;


        }

        /**
         * char to int and accumulate the 1 from up row.
         * Input:
         *
         * 1 0 1 0 0
         * 1 0 1 1 1
         * 1 1 1 1 1
         * 1 0 0 1 0
         *
         * Output:
         *
         * 1 0 1 0 0
         * 2 0 2 1 1
         * 3 1 3 2 2
         * 4 0 0 3 0
         * @param mat
         * @return
         */
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

        private int getMaxSquare(int height, int left, int right){
            // int left = stack.isEmpty() ? -1:stack.peek();
            // int right = j;
            // int maxLength = Math.max(right-left-1,height);
            // return maxLength*maxLength;
            return 0;
        }
    }

    /**
     * 解法二：DP
     * dp[i][j] 表示以a[i][j]为右下角可以获得的最大的正方形的边长
     * 当a[i][j]== '0' 时， dp[i][j] = 0;
     * 当a[i][j]== '1' 时， dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
     * 时间O(nm), 空间O(nm)
     */
    class Solution2 {
        public int maximalSquare(char[][] a) {
            if(a==null || a.length==0)return 0;
            int n = a.length;
            int m = a[0].length;
            int[][] dp = new int[n][m];
            int square = 0;
            for(int i=0;i<n;i++){
                if(a[i][0]=='1'){
                    dp[i][0] = 1;
                    square = Math.max(square, dp[i][0]);
                }
            }
            for(int i=0;i<m;i++){
                if(a[0][i]=='1'){
                    dp[0][i] = 1;
                    square = Math.max(square, dp[0][i]);
                }
            }
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    if(a[i][j]=='1'){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                        square = Math.max(square, dp[i][j]);
                    }
                }
            }

            return square*square;
        }
    }

    /**
     * 解法三：DP 优化，压缩dp表
     * 时间O(nm), 空间O(m)
     *
     */
    static class Solution3 {
        public int maximalSquare(char[][] a) {
            if(a==null || a.length==0)return 0;
            int n = a.length;
            int m = a[0].length;
            int[] dp = new int[m+1];
            int square = 0;
            for(int i=1;i<n+1;i++){
                int prev = 0;
                for(int j=1;j<m+1;j++){
                    if(a[i-1][j-1]=='1'){
                        int tmp = dp[j];
                        dp[j] = Math.min(Math.min(dp[j-1],prev),dp[j])+1;
                        square = Math.max(square, dp[j]);
                        prev = tmp;
                    }else {
                        prev = dp[j];
                        dp[j] = 0;
                    }
                }
            }

            return square*square;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution3 solution3 = new Solution3();
		String[][] matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
		char[][] matrix2 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		char[][] a = {{'1'}};
		int[][] res = char2int(matrix);
		int ans = maximalSquare(matrix);
		int ans2 = maximalSquare2(matrix);
		int ans3 = solution.maximalSquare(matrix2);
		int ans4 = solution3.maximalSquare(a);
		System.out.println(ans);
		System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);

	}
}