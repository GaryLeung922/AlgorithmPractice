package advanced_part05;
/**
 * 	树形DP
 * 	二叉树套路
 * @author Narut0
 *
 */
public class Code_01_BiggestSubBSTInTree {

	public static class Node{
		int value;
		Node left,right;
		public Node(int data) {
			this.value = data;
		}
	}
	public static class ReturnData{
		int size;
		Node head;
		int max;
		int min;
		public ReturnData(int size, Node head, int max, int min) {
			this.size = size;
			this.head = head;
			this.max = max;
			this.min = min;
		}
	}
	public static ReturnData process(Node head) {
		if(head==null) {
			return new ReturnData(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		ReturnData leftData = process(head.left);
		ReturnData rightData = process(head.right);
		int includeIt = 0;
		if(leftData.head==head.left&&rightData.head==head.right&&leftData.max<head.value&&rightData.min>head.value) {
			includeIt = leftData.size+1+rightData.size;
		}
		int p1 = leftData.size;
		int p2 = rightData.size;
		int p3 = includeIt;
		int maxSize = Math.max(Math.max(p1, p2), p3);
		Node maxHead = null;
		if(maxSize==p3) {
			maxHead = head;
		}else {
			maxHead = p2>p1?rightData.head:leftData.head;
		}
		return new ReturnData(maxSize, maxHead, 
				Math.max(Math.max(leftData.max, rightData.max), head.value),
				Math.min(Math.min(leftData.min, rightData.min), head.value));
		
	}
	public static int getSubBst(Node head) {
		if(head!=null) {
			ReturnData ans = process(head);
			return ans.size;
		}
		return 0;
	}
	public static void main(String[] args) {
		Node head = new Node(6);
		head.left = new Node(1);
		head.left.left = new Node(0);
		head.left.right = new Node(3);
		head.right = new Node(12);
		head.right.left = new Node(10);
		head.right.left.left = new Node(4);
		head.right.left.left.left = new Node(2);
		head.right.left.left.right = new Node(5);
		head.right.left.right = new Node(14);
		head.right.left.right.left = new Node(11);
		head.right.left.right.right = new Node(15);
		head.right.right = new Node(13);
		head.right.right.left = new Node(20);
		head.right.right.right = new Node(16);
		
		System.out.println(getSubBst(head));
	}
}
