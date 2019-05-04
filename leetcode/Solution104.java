package cn.xiaojiaqi.leetcode;


public class Solution104 {
    static int depth = 0;
    public static int maxDepth(TreeNode root) {
        if(root==null)return 0;
        maxDepthCore(root);
        return depth;
    }
    public static int maxDepthCore(TreeNode root) {
        if(root==null)return 0;
        int left = maxDepthCore(root.left);
        int right = maxDepthCore(root.right);
        depth = Math.max(depth,Math.max(left,right)+1);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right =new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.right.right = new TreeNode(5);
		
		int ans = maxDepth(root);
		System.out.println(ans);
		
	}
}