package cn.xiaojiaqi.sword2Offer;

import java.util.ArrayList;

public class Solution24 {
    public static class ReturnData{
        public ArrayList<ArrayList<Integer>> arrs;
        public ArrayList<Integer> sums;
        public ReturnData(ArrayList<ArrayList<Integer>> arrs,ArrayList<Integer> sums){
            this.arrs = arrs;
            this.sums = sums;
        }
    }
    public static ReturnData FindPath(TreeNode root,int target) {
        if(root.left==null&&root.right==null){
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<ArrayList<Integer>> arrs = new ArrayList<>();
            ArrayList<Integer> sums = new ArrayList<>();
            arr.add(root.val);
            arrs.add(arr);
            sums.add(root.val);
            return new ReturnData(arrs,sums);
        }else{
        	ReturnData leftData=null;
        	ReturnData rightData=null;
        	if(root.left!=null) {
        		leftData = FindPath(root.left, target);
        	}
        	if(root.right!=null) {
        		rightData = FindPath(root.right, target);
        	}
        	if(leftData!=null&&rightData!=null) {
        		for(int i=0;i<rightData.arrs.size();i++) {
        			rightData.arrs.get(i).add(root.val);
        			rightData.sums.set(i, rightData.sums.get(i)+root.val);
        		}
        		for(int i=0;i<leftData.sums.size();i++) {
        			leftData.arrs.get(i).add(root.val);
        			leftData.sums.set(i, leftData.sums.get(i)+root.val);
        		}
        		for(int i=0;i<rightData.arrs.size();i++) {
        			leftData.arrs.add(rightData.arrs.get(i));
        			leftData.sums.add(rightData.sums.get(i));
        		}
        		return new ReturnData(leftData.arrs, leftData.sums);
        	}else if(leftData!=null) {
        		for(int i=0;i<leftData.arrs.size();i++) {
        			leftData.arrs.get(i).add(root.val);
        			leftData.sums.set(i, leftData.sums.get(i)+root.val);
        		}
        		return new ReturnData(leftData.arrs, leftData.sums);
        	}else {
        		for(int i=0;i<rightData.arrs.size();i++) {
        			rightData.arrs.get(i).add(root.val);
        			rightData.sums.set(i, rightData.sums.get(i)+root.val);
        		}
        		return new ReturnData(rightData.arrs, rightData.sums);
			} 
        }
    }
    public static ArrayList<ArrayList<Integer>> result(TreeNode root,int target){
    	ReturnData res = FindPath(root, target);
    	ArrayList<ArrayList<Integer>> arrs = new ArrayList<>();
    	for(int i=0;i<res.sums.size();i++) {
    		if(res.sums.get(i)==target) {
    			if(arrs.size()==0) {
    				arrs.add(res.arrs.get(i));
    			}else {
    				int j=0;
    				for(;j<arrs.size();j++) {
        				if(res.arrs.get(i).size()>=arrs.get(j).size()) {
        					arrs.add(j,res.arrs.get(i));
        					break;
        				}
        			}
    				if(j==arrs.size()) {
    					arrs.add(res.arrs.get(i));
    				}
    			}
    		}
    	}
    	return arrs;
    }
    public static void main(String[] args) {
    	TreeNode head = new TreeNode(8);
		head.left = new TreeNode(6);
		head.right = new TreeNode(10);
		head.left.left = new TreeNode(5);
		head.left.right = new TreeNode(7);
		head.right.left = new TreeNode(9);
		head.right.right = new TreeNode(11);
		
		ReturnData result = FindPath(head, 17);
		
		
	}
}