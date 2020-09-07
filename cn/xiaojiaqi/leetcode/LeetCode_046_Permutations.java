package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gary Leung
 * @Date: 9/7/20 9:26 PM
 */
public class LeetCode_046_Permutations {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            permute(res, new ArrayList<Integer>(), new boolean[nums.length], nums);

            return res;
        }

        /**
         * result = []
         * def backtrack(路径, 选择列表):
         *     if 满足结束条件:
         *         result.add(路径)
         *         return
         *
         *     for 选择 in 选择列表:
         *         做选择
         *         backtrack(路径, 选择列表)
         *         撤销选择
         * @param res
         * @param path
         * @param select
         * @param nums
         */
        private void permute(List<List<Integer>> res, List<Integer> path, boolean[] select, int[] nums) {
            if (path.size() == select.length) {
                List<Integer> ress = new ArrayList<>(path.size());
                path.forEach((p) -> {
                    ress.add(p);
                });
                res.add(ress);
                return;
            }
            for (int i = 0; i < select.length; i++) {
                if (!select[i]) {
                    path.add(nums[i]);
                    select[i] = true;
                    permute(res, path, select, nums);
                    select[i] = false;
                    path.remove(path.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums= new int[]{1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}
