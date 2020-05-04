package part04;

public class Code_02_SuccessorNode {
	public static class Node{
		public Node right;
		public Node left;
		public Node parent;
		public int value;
		public Node(int data) {
			this.value = data;
		}
	}
	public static Node getSuccessorNode(Node p) {
		if(p!=null) {
			if(p.right!=null) {
				Node q = p.right;
				while (q.left!=null) {
					q = q.left;
				}
				return q;
			}else {
				Node q = p;
				while (q.parent!=null) {
					if(q.parent.left==q) {
						return q.parent;
					}
					q = q.parent;
				}
				return null;
			}
		}
		return null;
	}
	public static Node getPredecessorNode(Node p) {
		if(p!=null) {
			if(p.left!=null) {
				Node q = p.left;
				while (q.right!=null) {
					q = q.right;
				}
				return q;
			}else {
				Node q = p;
				while (q.parent!=null) {
					if(q.parent.right==q) {
						return q.parent;
					}
					q = q.parent;
				}
				return null;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
		
		System.out.println("+++++++++++++++++++++++=");
		
		test = head.left.left;// 1's pre is null
		System.out.println(test.value + " pre: " + getPredecessorNode(test));
		test = head.left.left.right;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
		test = head.right.right; 
		System.out.println(test.value + " pre: " + getPredecessorNode(test).value);
	}

}
