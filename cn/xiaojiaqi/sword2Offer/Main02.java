package cn.xiaojiaqi.sword2Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> strs = new LinkedList<String>();
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			if(str.equals("end"))break;
			strs.add(str);
		}
		char[][] chs = new char[strs.size()][strs.get(0).length()];
		int n = strs.size();
		int m = strs.get(0).length();
		int i=0;
		int j=0;
		for(int k=0;k<n;k++) {
			chs[k] = strs.get(k).toCharArray();
			if(strs.get(k).indexOf("@")!=-1) {
				i = k;
				j = strs.get(k).indexOf("@");
			}
		}
		chs[i][j] = '=';
		walk(chs, i, j);
		int ans = 0;
		for(int p=0;p<n;p++) {
			for(int q=0;q<m;q++) {
				if(chs[p][q]=='@')ans++;
			}
		}
		System.out.println(ans);
		

	}
	public static void walk(char[][] mat,int i,int j) {
		if(i>=0&&i<mat.length&&j>=0&&j<mat[0].length&&mat[i][j]=='=') {
				mat[i][j]='@';
				walk(mat, i+1, j);
				walk(mat, i-1, j);
				walk(mat, i, j+1);
				walk(mat, i, j-1);
		}
		
	}

}
