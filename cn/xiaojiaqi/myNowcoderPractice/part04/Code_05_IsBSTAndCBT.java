package part04;

import java.util.LinkedList;
import java.util.Queue;

public class Code_05_IsBSTAndCBT {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 * 判断二叉树是否为二叉搜索树(这里利用中序遍历的递归思路)
	 * 	特点：二叉搜索树的中序遍历是升序的
	 * 1.二叉搜索树的根节点大于左子树的任何一个结点，小于右子树的任意结点
	 * 2.二叉搜索树的左右子树分别为二叉搜索树
	 * @param head
	 * @return 返回系统最大值表示不是二叉搜索树
	 */
	public static int isBST(Node head) {
		if(head!=null) {
			int value = head.value;
			int left = isBST(head.left);
			if(left==Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if(value<=left) {
				return Integer.MAX_VALUE;
			}else{
				int right = isBST(head.right);
				//返回这棵子树中序遍历的最后一个值，
				//其实也就是它右子树返回的值
				if(right==Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if(right==Integer.MIN_VALUE) {
					return value;
				}else {
					if(value>=right) {
						return Integer.MAX_VALUE;
					}else {
						return right;
					}
				}
				
				
			}
		}else {
			return Integer.MIN_VALUE;//如果结点为空，则返回系统最小值
		}
		
	}
	/**
	 * 	判断二叉树是否是完全二叉树
	 * 	通过层序遍历来判断
	 * 1.如果结点只有右孩子没有左孩子，返回false
	 * 2.如果flag为true，则接下来的结点只能为叶节点，否则返回false
	 * @param head
	 * @return
	 */
	public static boolean isCBT(Node head) {
		if(head!=null) {
			Queue<Node> queue = new LinkedList<>();
			boolean flag = false;//标记为：第一个只有左孩子的结点是否出现了
			Node p = head;
			queue.offer(p);
			while (!queue.isEmpty()) {
				p = queue.poll();
				if(flag) {
					if(p.left!=null||p.right!=null) {
						return false;
					}
				}else {
					if(p.right==null&&p.left!=null) {
						flag = true;
					}
				}
				if(p.right!=null&&p.left==null) {
					return false;
				}
				if(p.left!=null) {
					queue.offer(p.left);
				}
				if(p.right!=null) {
					queue.offer(p.right);
				}	
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(7);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(6);
		
		if(isBST(head)==Integer.MAX_VALUE) {
			System.out.println("false");
		}else {
			System.out.println(isBST(head));
		}
		System.out.println(isCBT(head));
		
	}

}
