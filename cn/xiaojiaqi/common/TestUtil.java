package cn.xiaojiaqi.common;

import java.util.Arrays;
import java.util.HashSet;

public class TestUtil {
	/**
	 * 指定n*m的数组，每个元素1-100
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int[][] generateArr(int rows,int cols,int left,int right) {
		if(rows>0&&cols>0&&right>=left) {
			int[][] arr = new int[rows][cols];
			for(int i=0;i<rows;i++) {
				for(int j=0;j<cols;j++) {
					int rand = (int) Math.round(Math.random()*(right-left)+left);
					arr[i][j] = rand;
				}
			}
			return arr;
		}
		return null;
	}

	public static int[] generateArr(int cols) {
		return generateArr(1,cols,-10000,10000)[0];
	}

	public static int[] generateArr(){
		double rand = Math.random();
		int cols = (int) Math.round(rand*(Integer.MAX_VALUE));
		if(cols > 10000){
			cols  = 10000;
		}
		return generateArr(1,cols+1,-10000,10000)[0];
	}

	public static int[] generateArr_unique(int length,int left,int right) {
		if(right-left>=length&&length>0) {
			int[] arr = new int[length];
			HashSet<Integer> set = new HashSet<>();
			int rand;
			for(int i=0;i<length;i++) {
				do {
					rand = (int) Math.round(Math.random()*(right-left)+left);
				} while (set.contains(rand)); 
				arr[i] = rand;
				set.add(rand);
			}
			return arr;
		}
		return null;
	}
	public static String generateStr(int len,boolean hasCapital) {
		String str = "";
		if(len>0&&hasCapital) {
			int a;
			int A;
			
			for(int i=0;i<len;i++) {
				a = (int) Math.round(Math.random()*25+97);
				A = (int) Math.round(Math.random()*25+65);
				boolean or = (int)Math.round(Math.random())==1;
				
				str+= or?(char)a:(char)A;
			}
		}else if (len>0) {
			int a;
			for(int i=0;i<len;i++) {
				a = (int) Math.round(Math.random()*25+97);
				str+= (char)a;
			}
		}
		return str;
	}
	public static TreeNode generateTree(int size,int left,int right) {
		String[] rand = new String[size];
		for(int j=0;j<size;j++) {
			int random = (int) Math.round(Math.random()*(right-left)+left);
			if(random==right) {
				if(j==0) {
					return null;
				}
				rand[j] = "#";
			}else {
				rand[j] = random+"";
			}
		}
		return SerAndDeSer.deserializeByCBT(rand);
	}
	public static void main(String[] args) {
		TreeNode head = generateTree(8, 0, 10);
		SerAndDeSer.printTree(head);
		System.out.println("============");
		head  = generateTree(8, 0, 10);
		SerAndDeSer.printTree(head);

		System.out.println(Arrays.toString(generateArr(3,10,1,100)[1]));
	}
}
