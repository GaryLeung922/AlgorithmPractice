package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

/**
 * 对称二叉树
 * @Author: liangjiaqi
 * @Date: 2020/9/29 2:41 PM
 */
public class LeetCode_101_SymmetricTree {

    /**
     * 递归解法
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null)return true;
            return help(root.left, root.right);
        }

        /**
         * 分别拿左子树和右子树进行比较
         * @param left
         * @param right
         * @return
         */
        private boolean help(TreeNode left, TreeNode right){
            if(left==null && right==null)return true;
            if(left!=null && right!=null){
                if(left.val!=right.val)return false;
                return help(left.left,right.right) && help(left.right, right.left);
            }else {
                return false;
            }
        }
    }
}
