package cn.xiaojiaqi.leetcode;

import java.util.Stack;
//求最大子矩阵(子矩阵中的数,全为1)
//based on Largest Rectangle in Histogram
//利用单调栈. 把问题化为每一行去求解
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
    public static void main(String[] args) {
		String[][] matrix = {{"0","0","0","1","0","1","1","1"},{"0","1","1","0","0","1","0","1"},{"1","0","1","1","1","1","0","1"},{"0","0","0","1","0","0","0","0"},{"0","0","1","0","0","0","1","0"},{"1","1","1","0","0","1","1","1"},{"1","0","0","1","1","0","0","1"},{"0","1","0","0","1","1","0","0"},{"1","0","0","1","0","0","0","0"}};
		
		int ans = maximalRectangle(matrix);
		
		System.out.println(ans);
    }
}