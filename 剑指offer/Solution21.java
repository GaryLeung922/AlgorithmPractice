package cn.xiaojiaqi.test;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution21 {
	public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if(root1!=null){
            TreeNode cur = root1;
            TreeNode mostRight;
            while(cur!=null){
                mostRight = cur.left;
                if(mostRight!=null){
                    while(mostRight.right!=null&&mostRight.right!=cur){
                        mostRight = mostRight.right;
                    }
                    if(mostRight.right==null){
                        mostRight.right = cur;
                        cur = cur.left;
                    }else{
                        flag = MorrisIn(cur,root2);
                        if(flag){
                            return flag;
                        }
                        mostRight.right = null;
                        cur = cur.right;
                    }
                }else{
                    flag = MorrisIn(cur,root2);
                    if(flag){
                        return flag;
                    }
                    cur = cur.right;
                }
            }
        } 
        return flag;
    }
    public static boolean MorrisIn(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null) {
        	return false;
        }
        if(root1.val==root2.val){
            return MorrisIn(root1.left,root2.left)&&MorrisIn(root1.right,root2.right);
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
    	String[] strs = {"8","8","7","9","2","#","#","#","#","4","7"};
    	String[] strs1 = {"8","9","2"};
		TreeNode root1 = SerAndDeSer.deserializeByCBT(strs);
		SerAndDeSer.printTree(root1);
		String[] strs2 = {"8","9","2"};
		TreeNode root2 = SerAndDeSer.deserializeByCBT(strs2);
		SerAndDeSer.printTree(root2);
		System.out.println(HasSubtree(root1, root2));
	}
}