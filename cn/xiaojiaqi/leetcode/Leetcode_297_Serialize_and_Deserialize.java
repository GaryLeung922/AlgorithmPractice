package cn.xiaojiaqi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_297_Serialize_and_Deserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serByPre(root);
    }
    public String serByPre(TreeNode root){
        if(root==null)return "#!";
        String pre = root.val+"!";
        pre+=serByPre(root.left);
        pre+=serByPre(root.right);
        return pre;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] pre = data.split("!");
        Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i != pre.length; i++) {
			queue.offer(pre[i]);
		}
        
        return desByPre(queue);
    }
    public TreeNode desByPre(Queue<String> queue){
        if(queue.isEmpty())return null;
        
        String str = queue.poll();
        if(str.equals("#"))return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = desByPre(queue);
        root.right = desByPre(queue);
        return root;
    }
}