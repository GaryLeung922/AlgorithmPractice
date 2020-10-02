package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/29 10:43 AM
 */
public class LeetCode_110_BalancedBinaryTree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            int height = height(root);
            return height!=-1;
        }

        private int height(TreeNode root){
            if(root==null)return 0;
            int left = height(root.left);
            int right = height(root.right);
            if(left==-1 || right==-1 || Math.abs(left-right)>1){
                return -1;
            }else{
                return left>right ? left+1: right+1;
            }
        }
    }
}
