package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

public class Solution687 {
    public static int longestUnivaluePath(TreeNode root) {
        
        return longest(root)-1;
        
    }
    public static int longest(TreeNode root) {
    	if(root==null)return 0;
        
        int p1 = helper(root);
        int p2 = longest(root.left);
        int p3 = longest(root.right);
        return Math.max(p1,Math.max(p2,p3));
    }
    public static int helper(TreeNode root){
        if(root==null) return 0;
        
        int count = 1;
        if(root.left!=null&&root.left.val==root.val){
            int left = helper(root.left);
        	count+=left;
        }
        if(root.right!=null&&root.right.val==root.val){
            int right = helper(root.right);
        	count+=right;
        }
        return count;
    }
    public static void main(String[] args) {
		TreeNode root = SerAndDeSer.deserializeByLevel("1!4!5!4!4!5!#!#!#!#!#!#!#!");
		
		int res = longestUnivaluePath(root);
		System.out.println(res);
	}
    
    
}