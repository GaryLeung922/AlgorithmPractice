package cn.xiaojiaqi.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Solution139 {
	//
    public static boolean wordBreak1(String s, List<String> wordDict) {
        if(s.equals(""))return true;
        for(int i=0;i<wordDict.size();i++){
            String exp = wordDict.get(i);
            int index = s.indexOf(exp);
            if(index!=-1){
                boolean p1 = wordBreak1(s.substring(0,index),wordDict);
                boolean p2;
                if(p1){
                    p2 = wordBreak1(s.substring(index+exp.length()),wordDict);
                }else{
                    continue;
                }
                if(p2){
                    return true;
                }
            }
        }
        return false;
    }
    //Recurtion with memorization 
    //寻找能匹配s开头的word,对每个能匹配的word递归p(sub,wordDict);
    static Set<String> set = new HashSet();//oj中静态变量有可能出错，可以放到参数上去
    public static boolean wordBreak2(String s, List<String> wordDict) {
        if(s.equals(""))return true;
        for(int i=0;i<wordDict.size();i++){
            String exp = wordDict.get(i);
            if(s.startsWith(exp)) {//startsWith() 很关键，如果是indexOf(要承担O(n)的代价)
            	String sub = s.substring(exp.length());
            	if(set.contains(sub))continue;
            	boolean p =  wordBreak2(sub, wordDict);
            	if(p)return true;
            	set.add(sub);
            }
        }
        return false;
    }
    //DP 
    public static boolean wordBreak(String s, Set<String> dict) {
    	  if (s == null || s.length() == 0) return false;
    	  
    	  int n = s.length();
    	  
    	  // dp[i] represents whether s[0...i] can be formed by dict
    	  boolean[] dp = new boolean[n];
    	  
    	  for (int i = 0; i < n; i++) {
    	    for (int j = 0; j <= i; j++) {
    	      String sub = s.substring(j, i + 1);
    	      
    	      if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
    	        dp[i] = true;
    	        break;
    	      }
    	    }
    	  }
    	  
    	  return dp[n - 1];
    	}
    
    public static void main(String[] args) {
    	String[] words = {"pie","pear","apple","peach"};
		List<String> wordDict = Arrays.asList(words);
		String s = "applepie";
				
		
		boolean ans = wordBreak2(s, wordDict);
		System.out.println(ans);
		
		
//		System.out.println(s.lastIndexOf("leet", 6));
//		System.out.println(s.startsWith("leet", 3));
		
	}
}