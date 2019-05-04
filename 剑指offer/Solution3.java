package cn.xiaojiaqi.test;
import java.util.ArrayList;
public class Solution3 {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        return nodeIn(pRoot,k,new ArrayList<TreeNode>());
    }
    TreeNode nodeIn(TreeNode root,int k,ArrayList<TreeNode> arr){
        if(root!=null){
            nodeIn(root.left,k,arr);
            if(arr.size()!=k-1){
                arr.add(root);
            }else{
                return root;
            }
            nodeIn(root.right,k,arr);
        }
        return null;
    }
    public static void MorrisIn(TreeNode root1,TreeNode root2){
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
                        System.out.print(cur.val+" ");
                        mostRight.right = null;
                        cur = cur.right;
                    }
                }else{
                	System.out.print(cur.val+" ");
                    cur = cur.right;
                }
            }
        }
    }
    public static void main(String[] args) {
		Solution3 solution = new Solution3();
		TreeNode head = new TreeNode(8);
		head.left = new TreeNode(6);
		head.right = new TreeNode(10);
		head.left.left = new TreeNode(5);
		head.left.right = new TreeNode(7);
		head.right.left = new TreeNode(9);
		head.right.right = new TreeNode(11);
		System.out.println("_________________");
		MorrisIn(head, head);
		
		System.out.println("\n_________________");
		TreeNode pNode = solution.KthNode(head,1);
		System.out.println(pNode.val);
	}

}