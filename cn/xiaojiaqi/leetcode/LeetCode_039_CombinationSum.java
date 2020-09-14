package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/13 2:25 PM
 */
public class LeetCode_039_CombinationSum {

    /**
     * 和换零钱的方法数2， 有点不同，这道题需要记录走过的路径，所以不能用DP
     */
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if(candidates==null||candidates.length==0||target<=0)return res;

            combinationSum(candidates,0,target,new ArrayList<>(),res);

            return res;
        }
        private void combinationSum(int[] candidates, int i, int target, List<Integer> track, List<List<Integer>> res){
            if(target==0){
                res.add(new ArrayList<>(track));
                return;
            }
            if(target<0 || i>=candidates.length)return;

            if(target-candidates[i]>=0){
                track.add(candidates[i]);
                combinationSum(candidates, i, target-candidates[i], track, res);
                track.remove(track.size()-1);
            }
            combinationSum(candidates, i+1, target, track, res);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists);
    }
}
