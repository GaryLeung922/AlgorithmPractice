package cn.xiaojiaqi.leetcode;

import java.util.LinkedList;

public class LeetCode_98_isBST {
    public static boolean isValidBST(TreeNode root) {
        ReturnType res = isValidBSTCore(root);
        return res.isBST;
    }
    public static ReturnType isValidBSTCore(TreeNode root){
    	if(root==null)return new ReturnType(1,-1,true);
        ReturnType left = isValidBSTCore(root.left);
        if(!left.isBST)return new ReturnType(0,0,false);
        ReturnType right = isValidBSTCore(root.right);
        if(!right.isBST)return new ReturnType(0,0,false);
        int min;
        int max;
        if(left.min>left.max){
            min = root.val;
        }else{
            if(root.val<=left.max)return new ReturnType(0,0,false);
            min = left.min;
        }
        if(right.min>right.max){
            max = root.val;
        }else{
            if(root.val>=right.min)return new ReturnType(0,0,false);
            max = right.max;
        }
        
        
        return new ReturnType(min,max,true);
    }
    public static class ReturnType{
        int min;
        int max;
        boolean isBST;
        public ReturnType(int i,int j,boolean flag){
            min = i;
            max = j;
            isBST = flag;
        }
    }
    public static boolean isValidBST2(TreeNode root) {
        if (root == null)
          return true;

        LinkedList<TreeNode> stack = new LinkedList();
        LinkedList<Integer> upper_limits = new LinkedList();
        LinkedList<Integer> lower_limits = new LinkedList();
        stack.add(root);
        upper_limits.add(null);
        lower_limits.add(null);

        while (!stack.isEmpty()) {
          TreeNode node = stack.poll();
          Integer lower_limit = lower_limits.poll();
          Integer upper_limit = upper_limits.poll();
          if (node.right != null) {
            if (node.right.val > node.val) {
              if ((upper_limit != null) && (node.right.val >= upper_limit))
                return false;
              stack.add(node.right);
              lower_limits.add(node.val);
              upper_limits.add(upper_limit);
            } else
              return false;
          }

          if (node.left != null) {
            if (node.left.val < node.val) {
              if ((lower_limit != null) && (node.left.val <= lower_limit))
                return false;
              stack.add(node.left);
              lower_limits.add(lower_limit);
              upper_limits.add(node.val);
            } else
              return false;
          }
        }
        return true;
      }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		System.out.println(Double.MAX_VALUE);
		
		boolean ans = isValidBST2(root);
		System.out.println(ans);
	}
}