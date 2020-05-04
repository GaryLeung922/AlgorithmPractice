package cn.xiaojiaqi.sword2Offer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Printer3 {
    public static int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
        if(n>0&&m>0&&mat!=null&&mat.length==n&&mat[0].length==m){
            List<Integer> res = new ArrayList<>(m*n);
            int r1=0;
            boolean flag = true;
            while(r1<n){
                print(mat,r1++,flag,res);  
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
    public static void print(int[][] mat,int r,boolean flag,List<Integer> res){
        
            if(flag){
                for(int i=0;i<mat[0].length;i++){
                    res.add(mat[r][i]);
                }
            }else{
                for(int i=mat[0].length-1;i>=0;i--){
                    res.add(mat[r][i]);
                }
                
            }
    }
    public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int[] res = printMatrix(mat, 4, 3);
		System.out.println(Arrays.toString(res));
	}
}