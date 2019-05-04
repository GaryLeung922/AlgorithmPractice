package cn.xiaojiaqi.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Printer2 {
    public static int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
        if(n>0&&m>0&&mat!=null&&mat.length==n&&mat[0].length==m){
            List<Integer> res = new ArrayList<>(m*n);
            int r1=0;
            int c1=0;
            
            int r2=0;
            int c2=0;
            boolean flag = true;
            while(r1<=r2&&c1>=c2){
                print(mat,r1,c1,r2,c2,flag,res);
                r1 = c1==m-1 ? r1+1 : r1;
                c1 = c1==m-1 ? m-1 : c1+1;
                c2 = r2==n-1 ? c2+1 : c2;
                r2 = r2==n-1 ? n-1 : r2+1;
                
                flag = !flag;
            }
            int[] result = new int[m*n];
            for(int i=0;i<result.length;i++){
                result[i] = res.get(i);
            }
            return result;
        }
        return null;
    }
    public static void print(int[][] mat,int r1,int c1,int r2,int c2,boolean flag,List<Integer> res){
        while(r1<=r2&&c1>=c2){
            if(flag){
                res.add(mat[r1++][c1--]);
            }else{
                res.add(mat[r2--][c2++]);
            }
        }
    }
    public static void main(String[] args) {
		int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[] res = printMatrix(mat, mat.length, mat[0].length);
		System.out.println(Arrays.toString(res));
		
		if(5>3) {
			System.out.println(1);
		}else if(5>3) {
			System.out.println(2);
		}else {
			System.out.println(3);
		}
	}
}