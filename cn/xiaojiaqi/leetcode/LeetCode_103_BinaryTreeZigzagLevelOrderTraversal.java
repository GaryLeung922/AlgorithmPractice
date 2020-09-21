package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/21 1:26 PM
 */
public class LeetCode_103_BinaryTreeZigzagLevelOrderTraversal {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root==null)return res;
            Deque<TreeNode> deque = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            boolean rotate = false;
            TreeNode mostNode = root;

            deque.addLast(root);
            while (!deque.isEmpty()){
                TreeNode node = null;
                if(rotate){
                    node =  deque.pollLast();
                }else{
                    node = deque.pollFirst();
                }
                list.add(node.val);
                if(node==mostNode){
                    rotate = !rotate;
                }

                if(node.left!=null){
                    deque.addLast(node.left);
                }
                if(node.right!=null){
                    deque.addLast(node.right);
                }

                if(mostNode==node){
                    if(rotate){
                        mostNode = deque.peekFirst();
                    }else{
                        mostNode = deque.peekLast();
                    }
                    res.add(list);
                    list = new ArrayList<>();
                }
            }
            return res;
        }
    }
}
