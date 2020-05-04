package cn.xiaojiaqi.sword2Offer;
public class Solution32 {
    public boolean match(char[] str, char[] pattern)
    {    
        if(str!=null&&pattern!=null&&str.length==0&&pattern.length==0)return true;
        if(isValid(str,pattern)) {
			return process(str,pattern,0,0);
		}
		return false;
	}
	public  boolean process(char[] str, char[] exp, int i, int j) {
		if(j==exp.length-1) {
			return str[i]==exp[j]||exp[j]=='.';
		}else if(exp[j+1]!='*'){
			if(str[i]==exp[j]||exp[j]=='.')return process(str, exp, i+1, j+1);
			return false;
		}else {
			if(str[i]!=exp[j]) {
				return process(str, exp, i, j+2);
			}else {
				int k=i+1;
				while(str[k]==str[i]) {
					k++;
				}
				boolean[] p = new boolean[k-i+1];
				for(int m=0;m<k-i+1;m++) {
					p[m] = process(str, exp, i+m, j+2);
					if(p[m])return true;
				}
				return false;
			}
		}
		
	}

	public  boolean isValid(char[] str, char[] exp) {
		if(str!=null&&exp!=null&&str.length>0&&exp.length>0){
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

    
}