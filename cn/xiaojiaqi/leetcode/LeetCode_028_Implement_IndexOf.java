package cn.xiaojiaqi.leetcode;

/**
 * KMP
 * @Author: liangjiaqi
 * @Date: 2020/7/7 9:45 PM
 */
public class LeetCode_028_Implement_IndexOf {
    static class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.length()==0)return 0;
            char[] s1 = haystack.toCharArray();
            char[] s2 = needle.toCharArray();
            int[] next = nextStr(needle);
            int a = 0;
            int b = 0;
            while(a<s1.length&&b<s2.length){
                if(s1[a]==s2[b]){
                    a++;
                    b++;
                }else{
                    if(next[b]<0){
                        a++;
                    }else{
                        b = next[b];
                    }
                }
            }
            return b==s2.length ? a-b : -1;

        }

        private int[] nextStr(String str){
            char[] chars = str.toCharArray();

            int[] next = new int[chars.length];
            next[0] = -1;
            next[1] = 0;

            int i=2;
            int cur = 0;
            while(i<chars.length){
                if(cur>=0){
                    if(chars[cur]==chars[i-1]){
                        next[i++] = ++cur;
                    }else{
                        cur = next[cur];
                    }
                }else{
                    cur = 0;
                    next[i++] = 0;
                }
            }
            return next;
        }
    }

    public static void main(String[] args) {

        String s1 = "mississippi";
        String s2 = "pi";

        Solution s = new Solution();

        int str = s.strStr(s1, s2);
        System.out.println(str);
    }
}
