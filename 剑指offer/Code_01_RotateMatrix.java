package cn.xiaojiaqi.test;

import java.util.Arrays;

public class Code_01_RotateMatrix {

	public static void rotateMat(int[][] mat) {
		if(mat!=null&&mat.length>0&&mat[0].length>0) {
			int r1=0;
			int c1=0;
			
			int r2=mat.length-1;
			int c2=mat[0].length-1;
			
			while(r1<=r2&&c1<=c2) {
				swap(mat,r1++, c1++, r2--, c2--);
			}
		}
	}

	private static void swap(int[][] mat, int r1, int c1, int r2, int c2) {
		for(int i=0;i<c2-c1;i++) {
			int tmp = mat[r1][c1+i];
			mat[r1][c1+i] = mat[r2-i][c1];
			mat[r2-i][c1] = mat[r2][c2-i];
			mat[r2][c2-i] = mat[r1+i][c2];
			mat[r1+i][c2] = tmp;
		}
	}
	public static void main(String[] args) {
		int[][] mat1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] mat2 = {{1,2,3},{4,5,6},{7,8,9}};
		rotateMat(mat1);
		rotateMat(mat2);
		System.out.println(Arrays.toString(mat1));
	}

}
