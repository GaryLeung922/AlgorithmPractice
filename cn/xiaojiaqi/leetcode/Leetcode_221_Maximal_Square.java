package cn.xiaojiaqi.leetcode;

import java.util.Stack;

public class Leetcode_221_Maximal_Square {
    public static int maximalSquare(String[][] matrix) {
        int[][] mat = char2int(matrix);
        
        Stack<Integer> stack = new Stack<>();
        int maxSquare = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(stack.isEmpty()||mat[i][j]>mat[i][stack.peek()]){
                    stack.push(j);
                }else{
                    while(!stack.isEmpty()&&mat[i][stack.peek()]>=mat[i][j]){
                        int height = mat[i][stack.pop()];
                        int weight = stack.isEmpty() ? j-(-1)-1 : j-stack.peek()-1;
                        maxSquare = Math.max(maxSquare,Math.min(height,weight)*Math.min(height,weight));
                    }
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
    public static void main(String[] args) {
		String[][] matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
		int[][] res = char2int(matrix);
		int ans = maximalSquare(matrix);
		int ans2 = maximalSquare2(matrix);
		System.out.println(ans);
		System.out.println(ans2);
	}
}