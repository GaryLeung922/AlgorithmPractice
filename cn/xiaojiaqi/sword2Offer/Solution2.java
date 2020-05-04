package cn.xiaojiaqi.sword2Offer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    String Serialize(TreeNode root) {
        if(root!=null){
            String pre = root.val+"!";
            pre+=Serialize(root.left);
            pre+=Serialize(root.right);
            return pre;
        }else{
            return "#!";
        }
  }
    TreeNode Deserialize(String str) {
       String[] pre = str.split("!");
       Queue<String> queue = new LinkedList<String>();
       for(int i=0;i<pre.length;i++) {
    	   queue.offer(pre[i]);
       }
       return desPreMain(queue);
    }
    TreeNode desPreMain(Queue<String> pre) {
    	TreeNode root = desPre(pre.poll());
    	if(root!=null) {
    		root.left = desPreMain(pre);
    		root.right = desPreMain(pre);
    	}
    	return root;
    
    }
    TreeNode desPre(String c) {
    	if("#".equals(c)) {
    		return null;
    	}else {
			return new TreeNode(Integer.parseInt(c));
		}
    }
    public static void main(String[] args) {
    	TreeNode head = new TreeNode(8);
		head.left = new TreeNode(6);
		head.right = new TreeNode(10);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);
		
		Solution2 solution = new Solution2();
		String pre = solution.Serialize(head);
		System.out.println(pre);
		TreeNode head2 = solution.Deserialize(pre);
		String pre2 = solution.Serialize(head2);
		System.out.println(pre2);
		//System.out.println("1234560".substring(1));
	}
  }
