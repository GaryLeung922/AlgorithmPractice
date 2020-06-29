package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author: liangjiaqi
 * @Date: 2020/6/29 7:55 AM
 */
public class LeetCode_299_Bulls_Cows {

    /**
     * 方法一：Hash表
     */
    static class Solution {
        public String getHint(String secret, String guess) {
            if(secret==null||guess==null||secret.length()!=guess.length())return "0A0B";
            Map<Character, List<Integer>> map = new HashMap<>();
            char[] chars = secret.toCharArray();
            char[] char2 = guess.toCharArray();
            boolean[] marked = new boolean[chars.length];

            int bulls = 0;
            int cows = 0;

            for(int i=0;i<char2.length;i++){
                if(chars[i]==char2[i]){
                    bulls++;
                    marked[i] = true;
                }
            }
            for(int i=0;i<chars.length;i++){
                if(marked[i]){
                    continue;
                }
                if(map.containsKey(chars[i])){
                    map.get(chars[i]).add(i);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(chars[i], list);
                }
            }




            for(int i=0;i<char2.length;i++){
                if(marked[i]){
                    continue;
                }
                if(map.containsKey(char2[i]) && map.get(char2[i]).size()>0){
                    map.get(char2[i]).remove(0);
                    cows++;
                }
            }

            return bulls+"A"+cows+"B";
        }

    }

    static class Solution2{
        public String getHint(String secret, String guess) {
            char[] char1 = secret.toCharArray();
            char[] char2 = guess.toCharArray();
            int[] first = new int[10];
            int[] two = new int[10];

            int bulls = 0;
            int cows = 0;

            for(int i=0;i<char1.length;i++){
                if(char1[i]==char2[i]){
                    bulls++;
                }else {
                    first[char1[i]-'0']++;
                    two[char2[i]-'0']++;
                }
            }
            for(int i=0;i<10;i++){
                cows+=Math.min(first[i],two[i]);
            }
            return bulls+"A"+cows+"B";
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String hint = s.getHint("1807", "7801");
        System.out.println(hint);
    }
}
