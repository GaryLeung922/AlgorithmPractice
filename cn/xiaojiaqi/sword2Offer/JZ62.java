package cn.xiaojiaqi.sword2Offer;

import java.util.Stack;

/**
 * 二叉搜索树的第k个结点:
 *  给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @Author: Gary Leung
 * @Date: 6/17/20 10:21 PM
 */
public class JZ62 {
    public static void main(String[] args) {
        Stack<TreeNode> stack = new Stack<>();
    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        return inOrder(pRoot, k);
    }

    TreeNode inOrder(TreeNode pRoot, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        while(!stack.isEmpty() || p != null){
            if(p == null){
                p = stack.pop();
                k--;
                if(k==0){
                    return p;
                }
                p = p.right;
            }else{
                stack.push(p);
                p = p.left;
            }
        }
        return null;
    }
}
