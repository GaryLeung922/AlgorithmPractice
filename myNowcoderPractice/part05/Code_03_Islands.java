package part05;

import java.util.HashMap;

/**
 * 
//	岛问题
//	一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
//	四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
//	矩阵中有多少个岛？
//	举例：
//	0 0 1 0 1 0
//	1 1 1 0 1 0
//	1 0 0 1 0 0
//	0 0 0 0 0 0
//	这个矩阵中有三个岛。
 * @author Narut0
 *
 *	解法1：利用感染函数，将相邻区域全置为2
 *	解法2：并查集
 */
public class Code_03_Islands {
	
	public static class Unode{
		int value;
		Unode pre;
		int size;
		public Unode() {
			this.pre = this;
		}
		
	}
	/**
	 * 感染函数：
	 * 如果arr[i][j]==1，则把于arr[i][j]相连通的区域值全置为2
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void infect(int[][] arr,int i,int j) {
		arr[i][j]=2;
		if(i+1<arr.length&&arr[i+1][j]==1) {
			infect(arr, i+1, j);
		}
		if(i-1>=0&&arr[i-1][j]==1) {
			infect(arr, i-1, j);
		}
		if(j+1<arr[0].length&&arr[i][j+1]==1) {
			infect(arr, i, j+1);
		}
		if(j-1>=0&&arr[i][j-1]==1) {
			infect(arr, i, j-1);
		}
	}
	/**
	 * 解法1
	 * @param arr
	 * @return
	 */
	public static int island(int[][] arr) {
		
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==1) {//值为1时，进入感染函数，不用担心重复计数。
					infect(arr, i, j);
					count++;
				}
			}
		}
		
		return count;
	}
	/**
	 * 解法2 使用并查集
	 * 获得对应并查集的头节点
	 * @param p
	 * @return
	 */
	public static Unode getHead(Unode p) {
		if(p!=null) {
			while (p!=p.pre) {
				p = p.pre;
			}
			return p;
		}
		return null;
	}
	//是否是同一个并查集
	public static boolean isSame(Unode p,Unode q) {
		return getHead(p)==getHead(q);
	}
	
	public static int island2(int[][] arr) {
		HashMap<String, Unode> hm = new HashMap<>();
		int count=0;
		for(int k=0;k<arr.length;k++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[k][j]==1) {
					Unode p = new Unode();
					hm.put(k+""+j, p);
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==1) {
					if(j-1>=0&&arr[i][j-1]==1) {
						Unode q = hm.get(i+""+(j-1));
						hm.get(i+""+j).pre =getHead(q);
					}else {
						if(i-1>=0&&arr[i-1][j]==1) {
							Unode q = hm.get((i-1)+""+j);
							hm.get(i+""+j).pre =getHead(q);
						}else {
							if(j+1<arr[0].length&&arr[i][j+1]==1) {
								Unode q = hm.get((i-1)+""+j);
								hm.get(i+""+j).pre =getHead(q);
							}
						}
					}
					
				}
			}
		}
		
		
		
		return count;
	}
	
	private static void joinU(int i, int j) {
	}
	public static void main(String[] args) {
		int[][] arr = {{0,0,1,0,1,0},{1,1,1,0,1,0},{1,0,0,1,0,0},{0,0,0,0,0,0}};
		//System.out.println(island(arr));
		System.out.println(island2(arr));
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		
	}
	}
}
