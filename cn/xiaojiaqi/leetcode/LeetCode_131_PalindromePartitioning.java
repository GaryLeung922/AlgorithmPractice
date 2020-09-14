package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/13 3:36 PM
 */
public class LeetCode_131_PalindromePartitioning {
    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            if(s==null || s.length()==0)return res;
            partition(s,0,new ArrayList<>(),res);
            return res;
        }

        private void partition(String s,int i, List<String> track, List<List<String>> res){
            if(i==s.length()){
                res.add(new ArrayList<>(track));
                return;
            }

            for(int j=i;j<s.length();j++){
                if(isPalindrome(s,i,j)){
                    track.add(s.substring(i,j+1));
                    partition(s,j+1,track, res);
                    track.remove(track.size()-1);
                }
            }
        }

        private boolean isPalindrome(String str, int l, int r){
            if(l==r) return true;
            while(l<r){
                if(str.charAt(l)!=str.charAt(r)) return false;
                l++;r--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution solution = new Solution();
        List<List<String>> lists = solution.partition(s);
        System.out.println(lists);
    }
}
