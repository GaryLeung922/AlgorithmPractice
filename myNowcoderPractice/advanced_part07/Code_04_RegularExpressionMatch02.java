package advanced_part07;

public class Code_04_RegularExpressionMatch02 {

	public static boolean isMatch(String str,String exp) {
		if(str==null||exp==null)return false;
		char[] s = str.toCharArray();
		char[] p = exp.toCharArray();
		return isValid(s,p) ? process(s,p,0,0) : false; 
	}

	private static boolean process(char[] s, char[] p, int i, int j) {
		//j 越界
		if(j==p.length)return i==s.length;
		//j 上还有字符,考察j+1的情况
		if(j+1==p.length||p[j+1]!='*') {//j+1越界,或者不为‘*’;
			return i!=s.length&&(p[j]==s[i]||p[j]=='.')&&
					process(s, p, i+1, j+1);
		}
		//潜台词：j+1位置有字符，且为‘*’;
		while(i!=s.length&&(p[j]==s[i]||p[j]=='.')) {
			if(process(s, p, i, j+1)) return true;
			i++;
		}
		//潜台词：j+1位置有字符，且为‘*’,且p[j]!=s[i]&&p[j]!='.';
		return process(s, p, i, j+2);
	}

	private static boolean isValid(char[] s, char[] p) {
		for(int i=0;i<s.length;i++) {
			if(s[i]=='.'||s[i]=='*')return false;
		}
		for(int i=0;i<p.length;i++) {
			if(i==0&&p[i]=='*')return false;
			if(p[i]=='*'&&p[i-1]=='*')return false;
		}
		return true;
	}
	public static boolean isMatchDP(String str,String exp) {
		if(str==null||exp==null)return false;
		char[] s = str.toCharArray();
		char[] p = exp.toCharArray();
		if(!isValid(s, p))return false;
		
		boolean[][] dp = initDPMap(s,p);
		int slen = s.length;
		int plen = p.length;
		for(int j=plen-2;j>=0;j--) {
			for(int i=slen-1;i>=0;i--) {
				if(p[j+1]=='*') {
					int si = i;
					while(si!=slen&&(p[j]==s[si]||p[j]=='.')) {
						if(dp[si][j+2]) {
							dp[i][j] = true;
							break;
						}
						si++;
					}
					if (dp[i][j] != true) {
						dp[i][j] = dp[si][j + 2];
					}
				}else {
					dp[i][j]= (s[i] == p[j] || p[j] == '.')
							&& dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}

	private static boolean[][] initDPMap(char[] s, char[] p) {
		int slen = s.length;
		int plen = p.length;
		boolean[][] dp = new boolean[slen+1][plen+1];
		dp[slen][plen]=true;
		
		//对于最后一行,如果j开始往后满足范式“a*b*c*”,设为true;
		for(int j=plen-2;j>-1;j=j-2) {
			if(p[j]!='*'&&p[j+1]=='*') {
				dp[slen][j] = true;
			}else {
				break;
			}
		}
		if(slen>0 && plen>0) {
			if((p[plen-1]=='.'||s[slen-1]==p[plen-1])) {
				//对于dp[slen-1][plen-1],可以直接判断
				dp[slen-1][plen-1] = true;
			}
		}
		return dp;
	}
	public static void main(String[] args) {
		String str = "mississippi";
		String exp = "mis*is*p*.";
		boolean ans = isMatchDP(str, exp);
		System.out.println(isMatch(str, exp));
		System.out.println(isMatchDP(str, exp));

	}
	

}
