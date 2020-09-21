package cn.xiaojiaqi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/21 1:10 PM
 */
public class LeetCode_128_LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums==null || nums.length==0) return 0;

            Set<Integer> set = new HashSet<>();

            for(int num: nums){
                set.add(num);
            }

            int longest = 0;
            for(int num: nums){
                if(!set.contains(num-1)){
                    int longs = 1;
                    while(set.contains(num+1)){
                        longs++;
                        num = num+1;
                    }
                    longest = Math.max(longest, longs);
                }
            }

            return longest;
        }
    }
}
