package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null)return lists;
        
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode end = root;
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            list.add(p.val);
            
            if(p.left!=null){
                queue.offer(p.left);
            }
            if(p.right!=null){
                queue.offer(p.right);
            }
            if(p==end){
                lists.add(list);
                list = new ArrayList<>();
                end = queue.peekLast();
            }
        }
        if(list.size()!=0)lists.add(list);
        return lists;
    }
    public static void main(String[] args) {
		String s= "-8!-6!7!6!#!#!#!#!5!#!#!";
		TreeNode root = SerAndDeSer.deserializeByLevel(s);
		List<List<Integer>> lists = levelOrder(root);
		System.out.println(lists);
	}
}