package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * @Author: liangjiaqi
 * @Date: 2020/9/29 8:48 AM
 */
public class LeetCode_199_BinaryTreeRightSideView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root==null)return res;

            Deque<TreeNode> deque = new LinkedList<>();
            TreeNode mostRight = root;
            deque.push(root);
            while (!deque.isEmpty()){
                TreeNode node = deque.poll();
                if(node.left!=null){
                    deque.addLast(node.left);
                }
                if(node.right!=null){
                    deque.addLast(node.right);
                }
                if(node==mostRight){
                    res.add(node.val);
                    mostRight = deque.peekLast();
                }
            }
            return res;
        }
    }
}
