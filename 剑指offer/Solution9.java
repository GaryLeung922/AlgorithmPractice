package cn.xiaojiaqi.test;
import java.util.ArrayList;
public class Solution9{
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        if(matrix!=null&&matrix.length>0&&matrix[0].length>0){
        	int rows = matrix.length;
        	int columns = matrix[0].length;
            for(int i=0;i<=Math.min(rows/2,columns/2);i++){
                print(matrix,i,i,(rows-1-i),(columns-1-i),al);
            }
        }
        return al;
    }
    public void print(int[][] matrix, int r1,int c1,int r2,int c2,ArrayList<Integer> al){
        if(r1==r2&&c1==c2){
            al.add(matrix[r1][c1]);
            
        }else if(r1==r2&&c1!=c2){
            for(int j=c1;j<=c2;j++){
                al.add(matrix[r1][j]);
            }
        }else if(r1!=r2&&c1==c2){
            for(int i=r1;i<=r2;i++){
                al.add(matrix[i][c1]);
            }
        }else{
            for(int j=c1;j<c2;j++){
                al.add(matrix[r1][j]);
            }
            for(int i=r1;i<r2;i++){
                al.add(matrix[i][c2]);
            }
            for(int j=c2;j>c1;j--){
                al.add(matrix[r2][j]);
            }
            for(int i=r2;i>r1;i--){
                al.add(matrix[i][c1]);
            }
        }
    }
    public static void main(String[] args) {
		Solution9 solution9 = new Solution9();
		ArrayList<Integer> al = new ArrayList<>();
		int[][] matrix = {{1,2},{3,4},{5,6},{7,8},{9,10}};
		al = solution9.printMatrix(matrix);
		System.out.println(al);
	}
}