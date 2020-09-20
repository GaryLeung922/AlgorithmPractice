package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 12:03 PM
 */
public class LeetCode_102_levelOrder {
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
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;

            Deque<TreeNode> queue = new LinkedList<>();

            queue.add(root);
            TreeNode mostRight = root;
            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode p = queue.poll();
                if(p!=null){
                    if(p.left!=null){
                        queue.add(p.left);
                    }
                    if(p.right!=null){
                        queue.add(p.right);
                    }

                    list.add(p.val);
                    if(p==mostRight){
                        res.add(list);
                        list = new ArrayList<>();
                        mostRight = queue.peekLast();
                    }
                }
            }
            return res;
        }
    }
}
