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
    /**
     * 解法一：之字形遍历，在遍历到每一层de最后节点时，转换方向
     * 解法二：层序遍历，然后单各一行，单独倒序
     */
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
                // 正常是从头开始去，如果是反方向，那么是从尾开始
                if(rotate){
                    node =  deque.pollLast();
                }else{
                    node = deque.pollFirst();
                }
                list.add(node.val);
                // 左右子树加入的位置和顺序都要变
                if(rotate){
                    if(node.right!=null){
                        deque.addFirst(node.right);
                    }
                    if(node.left!=null){
                        deque.addFirst(node.left);
                    }

                }else{
                    if(node.left!=null){
                        deque.addLast(node.left);
                    }
                    if(node.right!=null){
                        deque.addLast(node.right);
                    }
                }
                if(mostNode==node){
                    rotate = !rotate;
                    // 这个时候，层序最后的节点应该是队首元素
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
