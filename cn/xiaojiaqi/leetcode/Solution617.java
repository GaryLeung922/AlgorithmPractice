package cn.xiaojiaqi.leetcode;
public class Solution617 {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1!=null&&t2!=null){
            mergeTreesCore(t1,t2,null,true);
            return t1;
        }else if(t1==null){
            return t2;
        }else if(t2==null){
            return t1;
        }else{
            return null;
        }
        
        
    }
    public static void mergeTreesCore(TreeNode t1, TreeNode t2,TreeNode p1,boolean isLeft){
        if(t1==null&&t2!=null){
            if(isLeft){
                p1.left = new TreeNode(t2.val);
                mergeTreesCore(p1.left.left,t2.left,p1.left,true);
                mergeTreesCore(p1.left.right,t2.right,p1.left,false);
                return;
            }else{
                p1.right = new TreeNode(t2.val);
                mergeTreesCore(p1.right.left,t2.left,p1.right,true);
                mergeTreesCore(p1.right.right,t2.right,p1.right,false);
                return;
            }
        }else if(t2!=null&&t1!=null){
            t1.val = t1.val+t2.val; 
            mergeTreesCore(t1.left,t2.left,t1,true);
            mergeTreesCore(t1.right,t2.right,t1,false);
            return;
        }else if(t1!=null&&t2==null){
            return;
        }else{
            return;
        }
        
    }
    public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		TreeNode root = mergeTrees(t1, t2);
		String s = "sadfa";
		System.out.println(s.lastIndexOf("a",3));
		StringBuilder str = new StringBuilder();
	}
}