package cn.xiaojiaqi.sword2Offer;

/**
 * 平衡二叉树
 * 题目描述:
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * @Author: liangjiaqi
 * @Date: 2020/6/21 3:08 PM
 */
public class JZ39 {
    public static void main(String[] args) {

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return balance(root)==-1 ? false: true;
    }
    public int balance(TreeNode root){
        if(root==null)return 0;
        int left = balance(root.left);
        int right = balance(root.right);
        if(left==-1 || right==-1){
            return -1;
        }
        if(Math.abs(left-right)<=1){
            return left > right ? left+1 : right+1;
        }else{
            return -1;
        }
    }
}
