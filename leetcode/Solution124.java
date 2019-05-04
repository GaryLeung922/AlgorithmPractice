package cn.xiaojiaqi.leetcode;
public class Solution124 {
    public static int maxPathSum(TreeNode root) {
        ReturnType res = maxPath(root);
        return res.realMax;
    }
    public static ReturnType maxPath(TreeNode root){
        if(root==null)return new ReturnType(Integer.MIN_VALUE,Integer.MIN_VALUE);
        
        ReturnType left = maxPath(root.left);
        ReturnType right = maxPath(root.right);
        
        int posiMax = Math.max(left.posiMax,right.posiMax)>0 ? Math.max(left.posiMax,right.posiMax)+root.val : root.val;
        int p1 = Math.max(left.realMax,right.realMax);
        int p2 = root.val;
        if(root.left!=null)p2+=left.posiMax;
        if(root.right!=null)p2+=right.posiMax;
        int realMax = Math.max(Math.max(p1,p2),posiMax);
        return new ReturnType(realMax,posiMax);
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		int ans = maxPathSum(root);
		System.out.println(ans);
	}
}
class ReturnType{
    int realMax;
    int posiMax;
    public ReturnType(int i,int j){
        realMax = i;
        posiMax = j;
    }
}