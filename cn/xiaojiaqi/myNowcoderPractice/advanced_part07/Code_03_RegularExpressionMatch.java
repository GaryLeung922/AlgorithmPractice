package advanced_part07;

public class Code_03_RegularExpressionMatch {
	public static boolean isMatch(char[] str,char[] exp) {
		if(isValid(str,exp)) {
			if(str!=null&&exp!=null&&str.length==0&&exp.length==0)return true;
			if(str!=null&&exp!=null&&str.length==0) {
				if(exp.length%2!=0)return false;
				for(int i=1;i<exp.length;i+=2) {
					if(exp[i]!='*') {
						return false;
					}
				}
				return true;
			}
			return process(str,exp,0,0);
		}
		return false;
	}
	public static boolean process(char[] str, char[] exp, int i, int j) {
		if(j>exp.length-1&&i>=str.length) {
			return true;
		}else if(j>exp.length-1&&i<str.length) {
			return false;
		}else if (j<=exp.length&&i>=str.length) {
			char[] subexp = new char[exp.length-j];
			for(int m=j;m<exp.length;m++) {
				subexp[m-j] = exp[m];
			}
			return isMatch("".toCharArray(), subexp);
		}else if(j==exp.length-1) {
			return (str[i]==exp[j]||exp[j]=='.')&&i==str.length-1;
		}else if(exp[j+1]!='*'){
			if(str[i]==exp[j]||exp[j]=='.')return process(str, exp, i+1, j+1);
			return false;
		}else {
			if(str[i]!=exp[j]&&exp[j]!='.') {
				return process(str, exp, i, j+2);
			}else if(exp[j]==str[i]){
				int k=i+1;
				while(k<str.length&&str[k]==str[i]) {
					k++;
				}
				boolean[] p = new boolean[k-i+1];
				for(int m=0;m<k-i+1;m++) {
					p[m] = process(str, exp, i+m, j+2);
					if(p[m])return true;
				}
				return false;
			}else {
				boolean[] p = new boolean[str.length-i+1];
				for(int m=0;m<str.length-i+1;m++) {
					p[m] = process(str, exp, i+m, j+2);
					if(p[m])return true;
				}
				return false;
			}
		}
	}

	public static boolean isValid(char[] str, char[] exp) {
		if(str!=null&&exp!=null) {
			for(int i=0;i<str.length;i++) {
				if(str[i]=='.'||str[i]=='*')return false;
			}
			for(int j=0;j<exp.length;j++) {
				if(j==0&&exp[j]=='*')return false;
				if(exp[j]=='*'&&exp[j-1]=='*')return false;
			}
			return true;
		}else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		String string  = "ab";
		String string2 = "a.a";
		String string3 = ".*";
		char[] str = string.toCharArray();
		char[] exp = string3.toCharArray(); 
		System.out.println(isMatch(str, exp));
	}
}

