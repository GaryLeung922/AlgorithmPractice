package cn.xiaojiaqi.leetcode;
import java.util.ArrayList;
import java.util.List;

public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        if(n>0&&m>0) {
        	List<Integer> res = new ArrayList<>(n*m);
            if(mat!=null&&mat.length==n&&mat[0].length==m){
	            int r1=0;
	            int c1=0;
	            int r2=n-1;
	            int c2=m-1;
	            while(r1<=r2&&c1<=c2){
	                print(mat,r1++,c1++,r2--,c2--,res);
	            }
	            int[] result = new int[n*m];
	            for(int i=0;i<result.length;i++){
	                result[i] = res.get(i);
	            }
	            return result;
            }
        }
            
        return null;
    }
    public void print(int[][] mat,int r1,int c1,int r2,int c2,List<Integer> res){
        if(r1==r2){
            for(int i=c1;i<=c2;i++){
                res.add(mat[r1][i]);
            }
        }else if(c1==c2){
            for(int i=r1;i<=r2;i++){
                res.add(mat[i][c1]);
            }
        }else{
            for(int i=c1;i<c2;i++){
                res.add(mat[r1][i]);
            }
            for(int i=r1;i<r2;i++){
                res.add(mat[i][c2]);
            }
            for(int i=c2;i>c1;i--){
                res.add(mat[r2][i]);
            }
            for(int i=r2;i>r1;i--){
                res.add(mat[i][c1]);
            }
        }
    }
}