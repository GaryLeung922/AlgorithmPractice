package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/1 12:37 PM
 */
public class LeetCode_220_Contain_Dup_3 {

    /**
     * treeSet
     * 时间复杂度O(nlog(k)) 空间O(logk)
     */
    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if(nums==null||nums.length==0)return false;

            TreeSet<Long> set = new TreeSet<>();

            for(int i=0;i<nums.length;i++){
                if(i>k){
                    set.remove(Long.valueOf(nums[i-k-1]));
                }
                if(set.ceiling((long)nums[i]-t) != null && set.ceiling((long)nums[i]-t) - t <= nums[i])return true;
                set.add(Long.valueOf(nums[i]));
            }
            return false;
        }
    }

    /**
     * 桶 bucket
     * 桶大小：w=t+1
     * 下标：1. ((long)x-Integer.MIN_VALUE)/w;
     * 2.  x < 0 ? (x + 1) / w - 1 : x / w;
     */
    static class Solution2 {

            private long getID(int x, long w) {
                return ((long)x-Integer.MIN_VALUE)/w;
            }

            public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
                if(nums==null||nums.length==0||k<=0||t<0)return false;

                Map<Long,Long> map = new HashMap<>();
                long w = (long)t+1;
                for(int i=0;i<nums.length;i++){
                    long m = getID(nums[i],w);
                    //两个相邻的数在一个桶里，肯定满足要求
                    if(map.containsKey(m)||
                            (map.containsKey(m-1) && map.get(m-1)+t>=nums[i]) ||
                            (map.containsKey(m+1) && map.get(m+1)-t<=nums[i])
                    )return true;
                    //两个相邻的数在一个桶里，肯定满足要求
                    map.put(m,Long.valueOf(nums[i]));
                    if(i>=k)map.remove(getID(nums[i-k],w));
                }
                return false;
            }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int[] arr = new int[]{1,5,9,1,5,9};
        Solution solution = new Solution();
        boolean duplicate = solution.containsNearbyAlmostDuplicate(arr, 2, 3);
        System.out.println(duplicate);

        System.out.println(-5/3);
        System.out.println(-6/3);
        System.out.println(-2/3);


    }
}
