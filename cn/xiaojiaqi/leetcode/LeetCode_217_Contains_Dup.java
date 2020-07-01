package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/6/30 8:21 AM
 */
public class LeetCode_217_Contains_Dup {

    /**
     * 解法一：HashTable
     */
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if(nums==null||nums.length<1)return true;

            Map<Integer, Boolean> map = new HashMap<>();

            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i]))return false;
                map.put(nums[i],true);
            }
            return false;
        }
    }
    /**
     * 解法二：排序
     */
}
