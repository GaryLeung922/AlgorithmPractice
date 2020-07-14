package cn.xiaojiaqi.leetcode;

/**
 * length-next[length]是最小周期长度
 * @Author: liangjiaqi
 * @Date: 2020/7/7 10:33 PM
 */
public class LeetCode_459_Repeat_String_Pattern {

    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if(s==null||s.length()<=1)return false;

            int[] next = nextStr(s);
            if(next[s.length()]==0)return false;

            int gap = s.length() - next[s.length()];
            // length-next[length]是最小周期长度
            return s.length()%gap==0 ? true : false;
        }

        public int[] nextStr(String s){
            char[] chars = s.toCharArray();

            int[] next = new int[chars.length+1];

            next[0] = -1;
            next[1] = 0;
            int i=2;
            int cur = next[i-1];
            while(i<=chars.length){
                if(cur>=0){
                    if(chars[cur]==chars[i-1]){
                        next[i++] = ++cur;
                    }else{
                        cur = next[cur];
                    }
                }else{
                    next[i++]=0;
                    cur = 0;
                }

            }
            return next;
        }
    }
}
