package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

/**
 * 二叉树的最近公共祖先
 * @Author: liangjiaqi
 * @Date: 2020/9/29 10:50 AM
 */
public class LeetCode_236_LowestCommonAncestorOfBinaryTree {

    /**
     * 利用回溯
     */
    class Solution {
        TreeNode res;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            help(root, p, q);
            return res;
        }

        /**
         * res[0] 代表是否有p节点
         * res[1] 代表是否有q节点
         * @param root
         * @param p
         * @param q
         * @return
         */
        private int[] help(TreeNode root, TreeNode p, TreeNode q){
            if(root==null)return new int[]{0,0};
            int[] left = help(root.left,p,q);
            int[] right = help(root.right,p,q);
            int[] res = new int[2];
            res[0] = left[0]==1 ? left[0] : right[0];
            res[1] = left[1]==1 ? left[1] : right[1];
            if(root==p){
                res[0] = 1;
            }
            if(root==q){
                res[1] = 1;
            }
            if(this.res==null && res[0]==1 && res[1] == 1){
                this.res = root;
            }
            return res;
        }
    }
}
