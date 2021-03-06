package part04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;








public class SerAndDeSer {
	//以完全二叉树的形式(nowcoder题库)序列化
	public static String[] serializeByCBT(TreeNode root) {
		ArrayList<String> level = new ArrayList<>();
		serializeBycbt(root,0,level);
		return level.toArray(new String[level.size()]);
	}
	public static void serializeBycbt(TreeNode root,int i,ArrayList<String> level) {
		if(root!=null) {
			TreeNode p = root;
			if(i>=level.size()) {
				int size = level.size();
				for(int j=size;j<=i;j++) {
					level.add("#");
				}
			}
			level.set(i, p.val+"");
			serializeBycbt(p.left,2*i+1,level);
			serializeBycbt(p.right,2*i+2,level);
		}	
	}
	public static TreeNode deserializeByCBT(String[] strs) {
		if(strs!=null&&strs.length>0) {
			TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
			if(1<strs.length&&!strs[1].equals("#")) {
				root.left = new TreeNode(Integer.parseInt(strs[0]));
			}
			if(2<strs.length&&!strs[2].equals("#")) {
				root.right = new TreeNode(Integer.parseInt(strs[0]));
			}
			deserializeBycbt(strs,1,root.left);
			deserializeBycbt(strs,2,root.right);
			return root;
		}
		return null;
		
	}
	public static void deserializeBycbt(String[] strs,int i,TreeNode root) {
		if(i>=strs.length||strs[i].equals("#")) {
			return;
		}
		if(2*i+1<strs.length&&!strs[2*i+1].equals("#")) {
			root.left = new TreeNode(Integer.parseInt(strs[0]));
		}
		if(2*i+2<strs.length&&!strs[2*i+2].equals("#")) {
			root.right = new TreeNode(Integer.parseInt(strs[0]));
		}
		root.val = Integer.parseInt(strs[i]);
		deserializeBycbt(strs, 2*i+1, root.left);
		deserializeBycbt(strs, 2*i+2, root.right);
	}
	//以层序遍历的方式序列化
	public static String serializeByLevel(TreeNode root) {
		String level = "";
		if(root!=null) {
			TreeNode p = root;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(p);
			while(!queue.isEmpty()) {
				p = queue.poll();
				if(p!=null) {
					level += (p.val+"!");
					queue.offer(p.left);
					queue.offer(p.right);
				}else {
					level += "#!";
				}
			}
		}
		return level;
	}
	public static TreeNode deserialize(String level) {
		if(level!=null&&level.length()>0) {
			String[] levels = level.split("!");
			int i=0;
			Queue<TreeNode> queue = new LinkedList<>();
			TreeNode p = new TreeNode(Integer.parseInt(levels[i++]));
			TreeNode head = p;
			queue.add(p);
			while(!queue.isEmpty()) {
				p = queue.poll();
				if("#".equals(levels[i])) {
					p.left = null;
					i++;
				}else {
					p.left = new TreeNode(Integer.parseInt(levels[i++]));
					queue.offer(p.left);
				}
				if("#".equals(levels[i])) {
					p.right = null;
					i++;
				}else {
					p.right = new TreeNode(Integer.parseInt(levels[i++]));
					queue.offer(p.right);
				}	
			}
			return head;
		}
		return null;
		
	}
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.right = new TreeNode(4);
		head.right.left = new TreeNode(5);
		String level = serializeByLevel(head);
		System.out.println(level);
		TreeNode root = deserialize(level);
		System.out.println(serializeByLevel(root));
		String[] strs = serializeByCBT(root);
		System.out.println(Arrays.toString(strs));
		TreeNode root2 = deserializeByCBT(strs);
		System.out.println(Arrays.toString(serializeByCBT(root2)));
		
	}
}
