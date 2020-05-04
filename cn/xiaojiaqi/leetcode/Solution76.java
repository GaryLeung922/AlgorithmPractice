package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public static String minWindow(String s, String t) {
        if(s==null||t==null||t.length()>s.length())return "";
        int startIndex = -1;
        int endIndex = s.length()+1;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int counter = map.size();
        int begin = 0,end = 0;
        int len = Integer.MAX_VALUE;
        
        while(end<s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    counter--;
                }
            }
            end++;
            
            while(counter==0){
                char c = s.charAt(begin);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0)counter++;
                }
                if(end-begin<endIndex-startIndex){
                    endIndex = end;
                    startIndex = begin;
                }
                begin++;
            }
        }
        return startIndex==-1 ? "" : s.substring(startIndex,endIndex);
    }
    public static void main(String[] args) {
		String s = "a";
		String t = "b";
		String res = minWindow(s, t);
		System.out.println(res);
	}
}