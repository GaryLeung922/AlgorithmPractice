package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liangjiaqi
 * @Date: 2020/6/30 8:31 AM
 */
public class LeetCode_219_Contains_Dup_2 {

    /**
     * 解法一：HashMap
     * 时间复杂度O(n) ，空间复杂度O(n)
     */
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums==null||nums.length<1)return false;

            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    if((i-map.get(nums[i]))<=k)return true;
                }
                map.put(nums[i],i);
            }
            return false;
        }
    }

    /**
     * 解法二：Set
     * 时间复杂度O(n)，空间O(k)
     */
    class Solution2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums==null||nums.length<1)return false;

            Set<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                if(i>k)set.remove(nums[i-k-1]);
                if(!set.add(nums[i]))return true;
            }
            return false;
        }
    }
}
