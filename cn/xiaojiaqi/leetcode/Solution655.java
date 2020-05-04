package cn.xiaojiaqi.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
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
public class Solution655 {
    
    
    public static List<List<String>> printTree(TreeNode root) {
        int height = getHeightOfTree(root);
        int nums = (int)Math.pow(2,height) - 1;
        String[][] strs = new String[height][nums];
        for(int i=0;i<height;i++){
            for(int j=0;j<nums;j++){
                strs[i][j]="";
            }
        }
        printTree(root,nums,1,-1,false,strs);
        List<List<String>> result = new LinkedList<List<String>>();
        for(int i=0;i<height;i++) {
        	result.add(Arrays.asList(strs[i]));
        }
        return result;
    }
    public static int getHeightOfTree(TreeNode root){
        if(root==null)return 0;
        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);
        return Math.max(left,right)+1;
    }
    public static void printTree(TreeNode root,int nums,int level,int parentIn,boolean isLeft,String[][] strs){
        if(root==null){
            
            return ;
        }else{
        	int index;
        	if(nums==1) {
        		index = isLeft ? parentIn-1 : parentIn+1;
        	}else {
        		index = isLeft ? parentIn-(nums/2+1) : parentIn+(nums/2+1);
        	}
            
            strs[level-1][index] = root.val+"";
            printTree(root.left,nums/2,level+1,index,true,strs);
            printTree(root.right,nums/2,level+1,index,false,strs);
        }
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		List<List<String>> result = printTree(root);
		
	}
}