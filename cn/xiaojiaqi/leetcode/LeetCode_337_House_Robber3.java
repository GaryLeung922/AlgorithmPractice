package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/27 12:54 PM
 */
public class LeetCode_337_House_Robber3 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /**
     * 暴力递归
     */
    class Solution {
        public int rob(TreeNode root) {
            if(root==null) return 0;

            int do_rob = root.val
                    + (root.left==null ? 0 : rob(root.left.left) + rob(root.left.right))
                    + (root.right==null ? 0 : rob(root.right.left) + rob(root.right.right));
            int no_rob = rob(root.left) + rob(root.right);

            return Math.max(do_rob, no_rob);
        }
    }
    /**
     * 备忘录
     */

}
