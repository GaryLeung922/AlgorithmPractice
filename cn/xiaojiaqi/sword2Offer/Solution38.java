package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution38 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> aa = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if(pRoot!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode end = pRoot;
            queue.add(pRoot);
            while(!queue.isEmpty()) {
            	TreeNode p = queue.poll();
            	arr.add(p.val);
            	
            	if(p==end) {
            		aa.add(arr);
            		arr = new ArrayList<>();
            		if(p.left!=null||p.right!=null) {
            			end = p.right==null?p.left:p.right;
            		}
            	}
            	if(p.left!=null) {
            		queue.add(p.left);
            	}
            	if(p.right!=null) {
            		queue.add(p.right);
            	}
            }
            
        }
        return aa;
    }
    public static void main(String[] args) {
    	TreeNode head = new TreeNode(8);
		head.left = new TreeNode(6);
		head.right = new TreeNode(6);
		head.left.left = new TreeNode(5);
		head.left.right = new TreeNode(7);
		head.right.left = new TreeNode(7);
		head.right.right = new TreeNode(5);
		
		ArrayList<ArrayList<Integer>> arr = new Solution38().Print(head);
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
}