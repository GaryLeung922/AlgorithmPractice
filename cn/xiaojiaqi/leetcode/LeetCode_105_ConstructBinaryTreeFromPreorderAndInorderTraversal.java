package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

/**
 * 前序+中序 还原 二叉树
 * @Author: liangjiaqi
 * @Date: 2020/9/20 5:53 PM
 */
public class LeetCode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            return buildTree(preorder, inorder, 0,preorder.length,0,inorder.length);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int pL, int pR, int iL, int iR){
            if(pL>=pR)return null;

            TreeNode root = new TreeNode(preorder[pL]);
            int pivot = 0;
            for(int i=iL;i<iR;i++){
                if(inorder[i]==preorder[pL]){
                    pivot = i;
                    break;
                }
            }
            root.left = buildTree(preorder, inorder, pL+1, pL+1+(pivot-iL), iL, pivot);
            root.right = buildTree(preorder, inorder, pL+1+(pivot-iL), pR, pivot+1, iR);
            return root;
        }
    }
}
