package cn.xiaojiaqi.test;

public class LCS {

	public static void main(String[] args) {
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		
		int ans = helper(s1.toCharArray(), s2.toCharArray(), 3,4);
		System.out.println(ans);
	}
	public static int helper(char[] c1,char[] c2,int i,int j) {
		if(i>=c1.length||i<0||j>=c2.length||j<0)return 0;
		if(c1[i]!=c2[j])return 0;
		
		int max = 1;
		int res = 1;
		for(int m=j-1;m>=0;m--) {
			for(int n=i-1;n>=0;n--) {
				int tmp = helper(c1, c2, n, m);
				max = Math.max(max, res+tmp);
			}
		}
		return max;
		
	}

}
