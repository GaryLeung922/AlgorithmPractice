package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/1 7:14 PM
 */
public class LeetCode_438_FindAllAnagramsInAString {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if(s==null || p==null || s.length()<p.length())return Collections.emptyList();

            char[] ss = s.toCharArray();
            char[] pp = p.toCharArray();
            List<Integer> res = new ArrayList<>();
            // 在全是小写字母的题目中，可以用int[26] 计数 来代替hashmap
            Map<Character,Integer> mapp = new HashMap<>();
            Map<Character,Integer> maps = new HashMap<>();

            for(int i=0;i<pp.length;i++){
                mapp.put(pp[i], mapp.getOrDefault(pp[i],0)+1);
            }

            int left=0,right=0;
            int match=0;
            while (right<ss.length){
                if(mapp.containsKey(ss[right])){
                    maps.put(ss[right],maps.getOrDefault(ss[right],0)+1);
                    if(maps.get(ss[right]).equals(mapp.get(ss[right]))){
                        match++;
                        // 这里一定要用mapp.size() 以防p有重复的字母
                        if(match==mapp.size()){
                            res.add(left);
                        }
                    }
                }
                if(right-left==pp.length-1){
                    if(maps.containsKey(ss[left]) && maps.get(ss[left]).equals(mapp.get(ss[left]))){
                        match--;
                    }
                    maps.put(ss[left],maps.getOrDefault(ss[left],0)-1);
                    left++;
                }
                right++;
            }
            return res;
        }
    }

    /**
     * int[] hash 代替HashMap
     * count（match）的定义不一样了
     */
    static class  Solution2{
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
            int[] hash = new int[256]; //character hash
            //record each character in p to hash
            for (char c : p.toCharArray()) {
                hash[c]++;
            }
            //two points, initialize count to p's length
            int left = 0, right = 0, count = p.length();
            while (right < s.length()) {
                //move right everytime, if the character exists in p's hash, decrease the count
                //current hash value >= 1 means the character is existing in p
                if (hash[s.charAt(right++)]-- >= 1) count--;

                //when the count is down to 0, means we found the right anagram
                //then add window's left to result list
                if (count == 0) list.add(left);

                //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
                //++ to reset the hash because we kicked out the left
                //only increase the count if the character is in p
                //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
                if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";

        Solution solution = new Solution();
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
