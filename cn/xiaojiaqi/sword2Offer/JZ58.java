package cn.xiaojiaqi.sword2Offer;

/**
 * 对称的二叉树
 * 题目描述:
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @Author: liangjiaqi
 * @Date: 2020/6/21 11:46 AM
 */
public class JZ58 {
    public static void main(String[] args) {

    }
    boolean isSymmetrical1(TreeNode pRoot)
    {
        String str1 = serialPre(pRoot);
        transferTreeNode(pRoot);
        String str2 = serialPre(pRoot);
        return str1.equals(str2);
    }

    void transferTreeNode(TreeNode pRoot){
        if(pRoot == null)return;
        TreeNode tmp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = tmp;
        transferTreeNode(pRoot.left);
        transferTreeNode(pRoot.right);
    }
    String serialPre(TreeNode root){
        if(root==null)return "#!";
        return root.val+"!"+serialPre(root.left)+serialPre(root.right);
    }

    boolean isSymmetrical2(TreeNode pRoot)
    {
        if(pRoot==null)return true;
        return isDup(pRoot.left, pRoot.right);
    }
    boolean isDup(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot==null && rightRoot==null){
            return true;
        }else if(leftRoot==null ||rightRoot==null){
            return false;
        }else if(leftRoot.val!=rightRoot.val){
            return false;
        }else {
            return isDup(leftRoot.left, rightRoot.right) && isDup(leftRoot.right, rightRoot.left);
        }
    }

}
