package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/13 11:04 AM
 */
public class LeetCode_078_Subsets {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums==null||nums.length==0){
                res.add(new ArrayList<>());
                return res;
            }
            subsets(nums, 0, new ArrayList<>(), res);
            return res;

        }

        private void subsets(int[] nums, int i, List<Integer> track, List<List<Integer>> res){
            if(i>=nums.length){
                res.add(new ArrayList<>(track));
                return;
            }
            track.add(nums[i]);
            subsets(nums, i+1, track, res);
            track.remove(track.size()-1);

            subsets(nums, i+1, track, res);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);

        int nthBit = 1 << 3;
        for (int i = 0; i < (int)Math.pow(2, 3); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
            System.out.println(bitmask);
        }
    }
}
