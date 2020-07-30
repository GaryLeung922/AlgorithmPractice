package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Gary Leung
 * @Date: 7/20/20 7:08 AM
 */
public class LeetCode_003_LengthOfLongestSubstring {
    // 通过Map和遍历数组来完成最长无重复子串 （sliding window）
    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if(s==null||s.length()==0)return 0;

            char[] c = s.toCharArray();
            Map<Character,Integer> map = new HashMap();

            int a = 0;
            map.put(c[0],0);
            int b = 1;
            int max = 1;
            while(b<c.length){
                if(map.containsKey(c[b]) && (int)map.get(c[b])>=a){
                    max = Math.max(max,b-a);
                    a = (int)map.get(c[b]) + 1;

                }
                map.put(c[b], b);
                b++;
            }
            max = Math.max(max, b-a);
            return max;
        }
    }

    public static void main(String[] args) {
        LeetCode_003_LengthOfLongestSubstring.Solution1 l = new LeetCode_003_LengthOfLongestSubstring.Solution1();

        String a = "abba";

        int length = l.lengthOfLongestSubstring(a);
        System.out.println(length);
    }
}
