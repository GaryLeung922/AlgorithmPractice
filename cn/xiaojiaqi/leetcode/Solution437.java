package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution437 {
	public static int pathSum(TreeNode root, int sum) {
        if(root==null)return 0;
        
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	root = queue.poll();
        	count+=p(root, sum);
        	if(root.left!=null)queue.offer(root.left);
        	if(root.right!=null)queue.offer(root.right);
        }
        
        return count;
    }
    private static int p(TreeNode root, int sum) {
		
    	if(root==null)return 0;
        
        int p1 = p(root.left,sum-root.val);
        
        int p2 = p(root.right,sum-root.val);
        
        return root.val==sum ? 1+p1+p2 : p1+p2;
	}
    static int pp;
    public static int pathSum2(TreeNode root, int sum) {
        if(root==null)return 0;
        
        pp = sum;
        
        return pathCore(root,sum);
        
    }
    public static int pathCore(TreeNode root,int sum){
        if(root==null)return 0;
        
        if(root.val==sum){
            return 1+pathSum(root.left,0)+pathSum(root.right,0)+pathSum(root.left,pp)+pathSum(root.right,pp);
        }else{
            return pathSum(root.left,sum-root.val)+pathSum(root.right,sum-root.val)+pathSum(root.left,pp)+pathSum(root.right,pp);
        }
    }
    
    
	public static void main(String[] args) {
    	String s = "10!5!-3!3!2!#!11!3!-2!#!1!#!#!#!#!#!#!#!#!";
		TreeNode root = SerAndDeSer.deserializeByLevel(s);
		
		//SerAndDeSer.printTree(root);
		//int ans = 
		int sum = 8;
		int ans = pathSum2(root, sum);
		System.out.println(ans+"  "+pp);
		
	}
}