package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

public class Solution1 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot!=null){
        	String pre1 = printPre(pRoot);
            swap(pRoot);
            String pre2 = printPre(pRoot);
            if(pre1.equals(pre2)){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
    void swap(TreeNode pRoot){
        if(pRoot!=null){
            TreeNode p = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = p;
            swap(pRoot.left);
            swap(pRoot.right);
        }
        return ;
    }
    String printPre(TreeNode pRoot){
        String pre = "";
        if(pRoot!=null){
            pre +=pRoot.val;
            pre+=printPre(pRoot.left);
            pre+=printPre(pRoot.right);
            return pre;
        }
        return "#_";
    }
    public static void main(String[] args) {
		TreeNode head = new TreeNode(8);
		head.left = new TreeNode(6);
		head.right = new TreeNode(6);
		head.left.left = new TreeNode(5);
		head.left.right = new TreeNode(7);
		head.right.left = new TreeNode(7);
		head.right.right = new TreeNode(5);
		
		
		
		Solution1 solution = new Solution1();
		String pre = solution.printPre(head);
		System.out.println(pre);
		
		boolean isTrue = solution.isSymmetrical(head);
		System.out.println(isTrue);
		
		
		//LinkedList<Integer>
	}
    
    
}