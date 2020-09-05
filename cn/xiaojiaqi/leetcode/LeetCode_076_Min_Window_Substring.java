package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/31 1:05 PM
 */
public class LeetCode_076_Min_Window_Substring {

    /**
     * 双指针-滑动窗口
     * 时间O(n+m) 空间O(m)，
     * 保证时间复杂度为O(n+m)的关键是判断子串是否包含的逻辑
     */
    static class Solution {

        public String minWindow(String s, String t) {

            if(s==null || t==null || s.length()==0|| t.length()==0)return "";

            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Map<Character, Integer> maps = new HashMap<>();
            Map<Character, Integer> mapt = new HashMap<>();


            for(int i=0;i<tt.length;i++){
                mapt.put(tt[i],mapt.getOrDefault(tt[i],0)+1);
            }
            int min = Integer.MAX_VALUE;
            String result = "";
            int left=0, right=0;
            // right 向右扩，满足条件之后，left向右扩（缩小窗口），寻找最优解。
            // left向右扩的时候，一旦不满足条件之后，立马right扩
            while (right<ss.length){
                if(mapt.containsKey(ss[right])){
                    maps.put(ss[right],maps.getOrDefault(ss[right],0)+1);
                    // if s contains t
                    while (isContain(mapt,maps)){
                        if(min>(right-left+1)){
                            result = s.substring(left,right+1);
                            min = right-left+1;
                        }
                        if(maps.get(ss[left])!=null){
                            if(maps.get(ss[left])==1){
                                maps.remove(ss[left]);
                            }else {
                                maps.put(ss[left],maps.get(ss[left])-1);
                            }
                        }
                        left++;
                    }
                }
                right++;
            }
            return result;
        }
        // 如果用这种方法，判断子串是否包含，那么时间复杂度将为O(NM)
        private boolean isContain(Map<Character,Integer> oldMap, Map<Character,Integer> newMap) {
            if (newMap.size() != oldMap.size()) return false;
            for (Character key : oldMap.keySet()) {
                if (oldMap.get(key) > newMap.get(key)) return false;
            }
            return true;

        }

        /**
         * 时间复杂度O(n+m)实现
         * 关键在于用match去匹配是否全部包含
         * @param s
         * @param t
         * @return
         */
        public String minWindow2(String s, String t) {

            if(s==null || t==null || s.length()==0|| t.length()==0)return "";

            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Map<Character, Integer> maps = new HashMap<>();
            Map<Character, Integer> mapt = new HashMap<>();


            for(int i=0;i<tt.length;i++){
                mapt.put(tt[i],mapt.getOrDefault(tt[i],0)+1);
            }
            int min = Integer.MAX_VALUE;
            String result = "";
            int match = 0;
            int left=0, right=0;
            // right 向右扩，满足条件之后，left向右扩（缩小窗口），寻找最优解。
            // left向右扩的时候，一旦不满足条件之后，立马right扩
            while (right<ss.length){
                if(mapt.containsKey(ss[right])){
                    maps.put(ss[right],maps.getOrDefault(ss[right],0)+1);
                    if(maps.get(ss[right]).equals(mapt.get(ss[right]))){
                        match++;
                    }
                    // if s contains t
                    while (match == mapt.size()){
                        if(min>(right-left+1)){
                            result = s.substring(left,right+1);
                            min = right-left+1;
                        }
                        if(maps.get(ss[left])!=null){
                            maps.put(ss[left],maps.get(ss[left])-1);
                            if(maps.get(ss[left]) < mapt.get(ss[left])){
                                match--;
                            }
                        }
                        left++;
                    }
                }
                right++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        Solution solution = new Solution();
        String s1 = solution.minWindow2(s, t);
        System.out.println(s1);
    }
}
