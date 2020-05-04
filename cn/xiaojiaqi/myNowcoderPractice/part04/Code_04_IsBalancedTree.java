package part04;

/**
 * 	判断一颗二叉树是不是平衡二叉树的标准
 * 1.左右子树高度之差（平衡因子）的绝对值不大于1
 * 2.左右子树又分别是平衡树
 * @author Narut0
 *
 */
public class Code_04_IsBalancedTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 *  判断一颗二叉树是否为平衡二叉树
	 * @param head
	 * @return -1:不是平衡二叉树；正整数：树的高度
	 */
	public static int isBalance(Node head) {
		if(head!=null) {
			int left = isBalance(head.left);
			if(left<0) {
				return -1;
			}
			int right = isBalance(head.right);
			if(right<0) {
				return -1;
			}
			int abs = Math.abs(left-right);
			if(abs>1) {
				return -1;
			}else {
				return left>right?left+1:right+1;
			}

		}else {
			return 0;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.left.left.left = new Node(8);
		head.left.left.left.left = new Node(9);
		System.out.println(isBalance(head));
	}
}
