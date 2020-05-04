package cn.xiaojiaqi.sword2Offer;

public class Walks {

	public static int walk(int n,int m) {
		if(n<=0||m<=0)return 0;
		return walk(n,m,0,0);
	}
	private static int walk(int n,int m,int i,int j) {
		if(i==n-1&&j==m-1)return 1;
		if(i==n-1) return walk(n, m,i,j+1);
		if(j==m-1) return walk(n, m,i+1,j);
		
		return walk(n, m,i+1,j)+walk(n, m,i,j+1);
	}
	
	public static void main(String[] args) {
		int ans = walk(2, 3);
		System.out.println(ans);
	}

}
