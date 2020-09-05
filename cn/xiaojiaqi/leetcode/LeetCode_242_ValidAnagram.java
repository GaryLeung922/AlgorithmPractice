package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/1 1:27 PM
 */
public class LeetCode_242_ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s==null || t==null )return false;
            if(s.length()!=t.length())return false;
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Map<Character, Integer> maps = new HashMap<>();
            Map<Character, Integer> mapt = new HashMap<>();

            for(int i=0;i<tt.length;i++){
                mapt.put(tt[i],mapt.getOrDefault(tt[i],0)+1);
            }
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
                }
                right++;
            }
            return match==mapt.size();
        }
    }
}
