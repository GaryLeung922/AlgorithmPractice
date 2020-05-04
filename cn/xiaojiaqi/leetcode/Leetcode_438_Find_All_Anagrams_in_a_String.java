package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode_438_Find_All_Anagrams_in_a_String {
    //自己的hash方法,很笨重
//     public List<Integer> findAnagrams(String s, String p) {
//         if(s==null||p==null||s.length()<p.length()||p.length()==0) return new LinkedList<>();
        
//         List<Integer> result = new LinkedList<>();
//         String pkey = getKey2(p);
//         HashSet<Character> set = new HashSet<>();
//         for(int i=0;i<p.length();i++){
//             set.add(p.charAt(i));
//         }
//         for(int i=0;i<=s.length()-p.length();i++){
//             if(set.contains(s.charAt(i))){
//                 String str = s.substring(i,i+p.length());
//                 if(pkey.equals(getKey2(str)))
//                     result.add(i);
//             }
//         }
//         return result;
//     }
//     public String getKey1(String p){
//         char[] chs = p.toCharArray();
//         Arrays.sort(chs);
        
//         return String.valueOf(chs);
//     }
//     public String getKey2(String p){
//         int[] keys = new int[26];
//         char[] chs = p.toCharArray();
//         for(int i=0;i<chs.length;i++){
//             keys[chs[i]-'a']++;   
//         }
//         StringBuilder key = new StringBuilder();
//         for(int i:keys){
//             key.append(i+"!");
//         }
//         return key.toString();
//     }
    //别人的sliding window
    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
    //other's Sliding Window
    public static List<Integer> findAnagrams2(String s, String p) {
        //the fastest way is to use sliding window
        int slen = s.length();
        int plen = p.length();
        List<Integer> res = new ArrayList<>();
        if (plen > slen) return res;
        
        int[] hash = new int[26];
        for (char pp : p.toCharArray()) {
            hash[pp - 'a']++;
        }
        int count = plen;
        
        //now we have all p in the hash array, if there is data value > 0, else vale = 0
        //use two pointers, one for begin, one for end
        //each time end++, then check if hash has value > 0, then--, count--

        
        int start = 0, end = 0;
        
        while (end < slen) {
            //always --, but only count if there is one in the hash
            if (hash[s.charAt(end) - 'a'] >= 1) { 
                count--;
            }
            hash[s.charAt(end) - 'a']--;
            end++;
            
            if (count == 0) res.add(start);
            
            if (end - start == plen) {
                //always ++, but only count if there is one in the hash count means need more to --
                if (hash[s.charAt(start) - 'a'] >= 0) {
                    count++;
                }
                hash[s.charAt(start) - 'a']++;//note, if it is not in the hash, it will be only add to zero
                start++;

            }
        }
        return res;
    }
    
    public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = findAnagrams2(s, p);
		System.out.println(res.toString());
	}
}