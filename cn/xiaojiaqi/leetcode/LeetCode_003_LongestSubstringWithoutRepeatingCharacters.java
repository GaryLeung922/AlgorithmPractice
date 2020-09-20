package cn.xiaojiaqi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Author: liangjiaqi
 * @Date: 2020/9/20 11:53 AM
 */
public class LeetCode_003_LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s==null || s.length()==0)return 0;
            char[] chars = s.toCharArray();
            int res = 0;
            int i =0;
            int j = 0;
            Set<Character> set  =new HashSet<>();
            for(;i<chars.length;i++){
                if(set.contains(chars[i])){
                    res = Math.max(res, i-j);
                    while (chars[j]!=chars[i]){
                        set.remove(chars[j]);
                        j++;
                    }
                    j++;
                }else{
                    set.add(chars[i]);
                }
            }
            res = Math.max(res, i-j);

            return res;

        }
    }

    public static void main(String[] args) {

    }
}
