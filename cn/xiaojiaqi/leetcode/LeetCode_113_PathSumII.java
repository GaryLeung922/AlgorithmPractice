package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/22 8:27 AM
 */
public class LeetCode_113_PathSumII {
    /**
     * 遇到树的题目，多想着递归
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            if(root==null){
                return res;
            }

            // base case
            if(root.left==null && root.right==null && root.val == sum){
                res.add(new ArrayList<>(Arrays.asList(root.val)));
                return res;
            }

            // 只有不为null才进行递归
            if(root.left!=null){
                List<List<Integer>> help = pathSum(root.left, sum - root.val);
                for(List<Integer> li: help){
                    li.add(0,root.val);
                    res.add(li);
                }
            }
            if(root.right!=null){
                List<List<Integer>> help = pathSum(root.right, sum - root.val);
                for(List<Integer> li: help){
                    li.add(0,root.val);
                    res.add(li);
                }
            }
            return res;

        }
    }
}
