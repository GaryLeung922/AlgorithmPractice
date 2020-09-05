package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/3 7:54 PM
 */
class LeetCode_003_lengthOfLongestSubstring2 {
    static class Solution{
        public int lengthOfLongestSubstring(String s){
            if(s==null || s.length()==0)return 0;
            Map<Character, Integer> map = new HashMap<>();
            int res = 0;
            int left=0,right=0;
            while (right<s.length()){
                if(map.containsKey(s.charAt(right))){
                    while (left<=right) {
                        map.remove(s.charAt(left));
                        if (s.charAt(left) == s.charAt(right)) {
                            left++;

                            break;
                        }
                        left++;

                    }
                }else{
                    map.put(s.charAt(right),1);
                    right++;
                }
                res = Math.max(res, right-left);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        int ss = solution.lengthOfLongestSubstring(s);
        System.out.println(ss);
    }

}
