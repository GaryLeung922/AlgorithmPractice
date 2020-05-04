package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
	/*public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s!=null&&s.length()>0){
            int[] cache = new int[s.length()];
            HashMap<Character,Integer> map = new HashMap<Character,Integer>();
            for(int i=0;i<s.length();i++) {
                cache[i] = lenOfSubstring(s, i, map,cache);
            	max = Math.max(max, cache[i]);
            }
        }
        return max;
    }
    
    public static int lenOfSubstring(String s,int i,HashMap<Character,Integer> map,int[] cache){
        if(i==0){
            map.put(s.charAt(i),i);
            return 1;
        }
        int last = cache[i-1];
        if(map.containsKey(s.charAt(i))&&i-map.get(s.charAt(i))<=last){
            int res = i-map.get(s.charAt(i));
            map.put(s.charAt(i),i);
            return res;
        }else{
            map.put(s.charAt(i),i);
            return last+1;
        }
    }*/
	
	
	
    // my Sliding Window
    public static int lengthOfLongestSubstring2(String str) {
    	if(str==null||str.length()==0)return 0;
        
        Map<Character,Integer> map = new HashMap<>();

        int begin = 0,end = 0;
        
        int max = map.size();
        while(end<str.length()){
            char ch = str.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            max = Math.max(max,map.size());
            end++;
            while(map.get(ch)>1){
                char c = str.charAt(begin);
                if(map.containsKey(c)){//如果有这个key，value-1
                	map.put(c,map.get(c)-1);
                    if(map.get(c)<=0)map.remove(c);//当value<=0时，可以把这个key去掉。证明窗口中已经不包含这个key
                }
                begin++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
		String s = "abcabcbb";
		int ans = lengthOfLongestSubstring2(s);
		System.out.println(ans);
	}
}