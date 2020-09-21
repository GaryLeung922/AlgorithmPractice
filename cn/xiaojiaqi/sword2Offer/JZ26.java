package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

import java.util.*;

/**
 * 二叉搜索树与双向链表
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Author: liangjiaqi
 * @Date: 2020/6/21 3:19 PM
 */
public class JZ26 {
    public static void main(String[] args) {

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        Queue<TreeNode> queue = new LinkedList<>();

        travel(pRootOfTree, queue);
        if(queue.isEmpty())return null;
        TreeNode head = queue.peek();
        TreeNode pre = null;
        TreeNode cur = queue.poll();
        cur.left = pre;
        while(!queue.isEmpty()){
            cur.right = queue.peek();
            pre = cur;
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
        }
        cur.right = null;
        return head;

    }
    public void travel(TreeNode root, Queue<TreeNode> queue){
        if(root==null)return;
        travel(root.left, queue);
        queue.offer(root);
        travel(root.right, queue);
    }

    TreeNode pre = null;
    TreeNode head = null;
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree==null)return null;
        travel(pRootOfTree);
        return head;

    }
    public void travel(TreeNode root){
        if(root==null)return;
        travel(root.left);
        if(pre==null){
            root.left = pre;
            pre = root;
            head = root;
        }else{
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        travel(root.right);
    }
}
