package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution301 {
	//花花酱  
	public static List<String> removeInvalidParentheses(String s) {
    	List<String> list = new ArrayList<>();
        
        int l=0;
        int r=0;
     // l/r: number of left/right parentheses to remove.
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                l++;
            }else if(s.charAt(i)==')'){
                if(l==0)r++;
                else l--;
            }
        }
        Set<String> set = new HashSet<>();
        dfs(s,0,l,r,set);
        list.addAll(set);
        return list;
    }
	private static void dfs(String s, int i, int l, int r, Set<String> set) {
		// Nothing to remove.
		if(l==0&&r==0) {
			if(valid(s)) {
				set.add(s);
				return;
			}
		}
		if(l>0) {
			for(int j=i;j<s.length();j++) {
				// We only remove the first parenthes if there are consecutive ones to avoid duplications.
                if (j != i && s.charAt(j) == s.charAt(j - 1)) continue;
				if(s.charAt(j)=='(') {
					if(l==1) {
						dfs(s.substring(0,j)+s.substring(j+1, s.length()), 0, l-1, r, set);
					}else {
						dfs(s.substring(0,j)+s.substring(j+1, s.length()), j, l-1, r, set);
					}
					
				}
			}
		}else {
			for(int j=i;j<s.length();j++) {
				// We only remove the first parenthes if there are consecutive ones to avoid duplications.
                if (j != i && s.charAt(j) == s.charAt(j - 1)) continue;
				if(s.charAt(j)==')') {
					dfs(s.substring(0,j)+s.substring(j+1, s.length()), j, l, r-1, set);
				}
			}
		}
		
	}
	private static boolean valid(String str) {
		if(str.equals(""))return true;
		
		int Llen=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				Llen++;
			}else if (str.charAt(i)==')') {
				Llen--;
			}
			if(Llen<0)return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String s1 = ")o(v(";
		List<String> list = removeInvalidParentheses(s1);
		System.out.println(list);
	}
}