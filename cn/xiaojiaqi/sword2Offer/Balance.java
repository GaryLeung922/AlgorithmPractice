package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Balance {
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root==null)return false;
        ReturnType res = isBalanceDP(root);
        return res.balance;
    }
    public ReturnType isBalanceDP(TreeNode root){
        if(root==null) return new ReturnType(0,true);
        ReturnType left = isBalanceDP(root.left);
        if(!left.balance) return new ReturnType(0,false);
        ReturnType right = isBalanceDP(root.right);
        if(!right.balance) return new ReturnType(0,false);
        if(Math.abs(left.height-right.height)>1)return new ReturnType(0,false);
        return new ReturnType(1+Math.max(left.height,right.height),true); 
    }
    public static class ReturnType{
        int height;
        boolean balance=true;
        public ReturnType(int val,boolean flag){
            height = val;
            balance = flag;
        }
    }
    public static void main(String[] args) {
		
	}
}