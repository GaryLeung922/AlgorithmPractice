package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/13 2:50 PM
 */
public class LeetCode_784_LetterCasePermutation {
    static class Solution {
        public List<String> letterCasePermutation(String S) {
            List<String> res = new ArrayList<>();
            if(S==null || S.length()==0)return res;

            letterCasePermutation(S,0,new char[S.length()], res);

            return res;
        }
        private void letterCasePermutation(String S, int i, char[] track, List<String> res){
            if(i==S.length()){
                res.add(new String(track));
                return;
            }
            track[i] = S.charAt(i);
            letterCasePermutation(S,i+1,track, res);
            if('a'<=S.charAt(i) && S.charAt(i)<='z'){

                track[i] = (char)(S.charAt(i)-32);
                letterCasePermutation(S,i+1,track, res);
            }
            if('A'<=S.charAt(i) && S.charAt(i)<='Z'){

                track[i] = (char)(S.charAt(i)+32);
                letterCasePermutation(S,i+1,track, res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println('a'-0);
        System.out.println('z'-0);
        System.out.println('A'-0);
        System.out.println('Z'-0);

        String S = "a1b2";

        Solution solution = new Solution();
        List<String> list = solution.letterCasePermutation(S);
        System.out.println(list);
    }
}
