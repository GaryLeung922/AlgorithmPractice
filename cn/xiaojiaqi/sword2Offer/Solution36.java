package cn.xiaojiaqi.sword2Offer;

import java.util.Scanner;

public class Solution36 {

	public static String treeByPre_In(String pre,String in){
		if(pre==null||in==null||pre.length()==0||in.length()==0||pre.length()!=in.length())return "";
		
		return treeByPre_In(pre, in,0,0,pre.length());
	}

	private static String treeByPre_In(String pre, String in, int i, int j, int length) {
		if(length==0)return "";
		if(length==1)return pre.charAt(i)+"";
		int rootIndexOfIn = in.indexOf(pre.charAt(i));
		
		String left = treeByPre_In(pre,in,i+1,j,rootIndexOfIn-j);
		String right = treeByPre_In(pre, in,i+1+rootIndexOfIn-j,rootIndexOfIn+1,length-(rootIndexOfIn-j)-1);
		
		return left+right+pre.charAt(i);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pre;
		String in;
		String post;
		do {
			pre = sc.nextLine();
			in = sc.nextLine();
			post = treeByPre_In(pre, in);
			System.out.println(post);
		}while(sc.hasNextLine());
		
		
	}

}
