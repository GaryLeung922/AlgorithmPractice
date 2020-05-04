package cn.xiaojiaqi.sword2Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




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
	public static TreeNode deserializeByLevel(String level) {
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
	public static String serializeByPre(TreeNode root) {
		if(root==null)return "#!";
		return root.val+"!"+serializeByPre(root.left)+serializeByPre(root.right);
	}	
	public static TreeNode deserializeByPre(String pre) {
		String[] pres = pre.split("!");
		
		Queue<String> queue = new LinkedList<>();
		for(String str:pres) {
			queue.offer(str);
		}
		return deserializeByPre(queue);
	}
	private static TreeNode deserializeByPre(Queue<String> queue) {
		String value = queue.poll();
		TreeNode root =  "#".equals(value) ? null : new TreeNode(Integer.valueOf(value));

		if(root==null)return null;
		root.left = root==null ? null : deserializeByPre(queue);
		root.right = root==null ? null : deserializeByPre(queue);
		return root;
	}
	public static void travel_In(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null) {
            	stack.push(p);
            	p = p.left;
            }else {
            	p = stack.pop();
            	System.out.print(p.val+" ");
            	p = p.right;
            }
        }
    }
	// for test -- print tree
		public static void printTree(TreeNode head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}

		public static void printInOrder(TreeNode head, int height, String to, int len) {
			if (head == null) {
				return;
			}
			printInOrder(head.right, height + 1, "v", len);
			String val = to + head.val + to;
			int lenM = val.length();
			int lenL = (len - lenM) / 2;
			int lenR = len - lenM - lenL;
			val = getSpace(lenL) + val + getSpace(lenR);
			System.out.println(getSpace(height * len) + val);
			printInOrder(head.left, height + 1, "^", len);
		}

		public static String getSpace(int num) {
			String space = " ";
			StringBuffer buf = new StringBuffer("");
			for (int i = 0; i < num; i++) {
				buf.append(space);
			}
			return buf.toString();
		}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.right = new TreeNode(4);
		head.right.left = new TreeNode(5);
		String level = serializeByLevel(head);
		System.out.println(level);
		TreeNode root = deserializeByLevel(level);
		System.out.println(serializeByLevel(root));
		String[] strs = serializeByCBT(root);
		System.out.println(Arrays.toString(strs));
		TreeNode root2 = deserializeByCBT(strs);
		System.out.println(Arrays.toString(serializeByCBT(root2)));
		
		System.out.println("+++++++++++");
		String pre = serializeByPre(root2);
		System.out.println(pre);
		TreeNode root3 = deserializeByPre(pre);
		System.out.println("++++++++++++");
		pre = serializeByPre(root3);
		System.out.println(pre);
		travel_In(root3);
	}
}
