package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution337 {
	public static int rob(TreeNode root) {
        if(root==null)return 0;
        Map<String,Integer> map = new HashMap<>();
        return helper(root,false,map);
    }
    public static int helper(TreeNode root,boolean robed,Map<String,Integer> map){
        if(root==null)return 0;
        
        int left = root.left==null ? 0 : map.containsKey(root.left.toString()+"false") ? map.get(root.left.toString()+"false") : helper(root.left,false,map);
        int right = root.right==null ? 0 : map.containsKey(root.right.toString()+"false") ? map.get(root.right.toString()+"false") : helper(root.right,false,map);
        int leftrob = root.left==null ? 0 : map.containsKey(root.left.toString()+"true") ? map.get(root.left.toString()+"true") : helper(root.left,true,map);
        int rightrob = root.right==null ? 0 : map.containsKey(root.right.toString()+"true") ? map.get(root.right.toString()+"true") : helper(root.right,true,map);
        if(robed){ 
            int res = left+right;
            map.put(root.toString()+robed,res);
            return res;
        }else{
            int res = Math.max(root.val+leftrob+rightrob,left+right);
            
            map.put(root.toString()+robed,res);
            return res;
        }
    }
    public static void main(String[] args) {
		String string = "3!2!3!#!3!#!1!#!#!#!#!";
		TreeNode root = SerAndDeSer.deserializeByLevel(string);
		//SerAndDeSer.printTree(root);
		int ans = rob(root);
		System.out.println(ans);
	}
}
