package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;

public class Solution25 {
   public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
        if(root==null)return paths;
        find(paths,new ArrayList<Integer>(),root,target);
        return paths;
    }
    public  static void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(target==root.val){
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        if(root.left!=null)find(paths,path,root.left,target-root.val);
        if(root.right!=null)find(paths,path2,root.right,target-root.val);
    }
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	TreeNode head = new TreeNode(10);
    	head.right = new TreeNode(5);
    	head.left =  new TreeNode(12);
    	head.right.left = new TreeNode(7);
    	res = FindPath(head, 22);
	}
    
}