package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ancp = getAncestor(root,p,new ArrayList<>());
        List<TreeNode> ancq = getAncestor(root,q,new ArrayList<>());
        
        int i=0;
        int j=0;
        while(i<ancp.size()&&j<ancq.size()){
            if(ancp.get(i)!=ancq.get(j))break;
            i++;
            j++;
        }
        return ancp.get(--i);
    }
    public static List<TreeNode> getAncestor(TreeNode root,TreeNode t,List<TreeNode> list){
        if(root==null)return null;
    	if(root==t) {
        	list.add(root);
        	return list;
        }
        list.add(root);
        
        List<TreeNode> res = getAncestor(root.left,t,list);
    	if(res!=null)return res;
    	res = getAncestor(root.right,t,list);
    	if(res!=null)return res;
    	
    	list.remove(list.size()-1);
        return null;
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		
		TreeNode anc = lowestCommonAncestor(root, root.left, root.right);
		System.out.println(anc.val);
	}
}