package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

/**
 * 二叉树的镜像
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Author: liangjiaqi
 * @Date: 2020/6/21 9:48 PM
 */
public class JZ18 {
    public static void main(String[] args) {

    }
    public void Mirror(TreeNode root) {
        if(root == null)return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
