package advanced_part05;

/**
 * 	树形DP
 * 	二叉树套路
 * @author Narut0
 *
 */
public class Code_02_MaxDistanceInTree {

	public static class Node{
		int value;
		Node left,right;
		
		public Node(int value) {
			
			this.value = value;
			
		}
	}
	public static class ReturnType{
		int distance;
		int high;
		public ReturnType(int distance, int high) {
			super();
			this.distance = distance;
			this.high = high;
		}
	}
	public static ReturnType process(Node head) {
		if(head==null) {
			return new ReturnType(0, 0);
		}
		ReturnType leftData = process(head.left);
		ReturnType RightData = process(head.right);
		int p1 = leftData.distance;
		int p2 = RightData.distance;
		int p3 = leftData.high+1+RightData.high;
		int maxDistance = Math.max(Math.max(p1, p2), p3);
		int high = Math.max(leftData.high, RightData.high)+1;
		return new ReturnType(maxDistance, high);
	}
	public static int getMaxDistance(Node head) {
		return process(head).distance;
	}
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.left = new Node(2);
		head1.right = new Node(3);
		head1.left.left = new Node(4);
		head1.left.right = new Node(5);
		head1.right.left = new Node(6);
		head1.right.right = new Node(7);
		head1.left.left.left = new Node(8);
		head1.right.left.right = new Node(9);
		System.out.println(getMaxDistance(head1));

		Node head2 = new Node(1);
		head2.left = new Node(2);
		head2.right = new Node(3);
		head2.right.left = new Node(4);
		head2.right.right = new Node(5);
		head2.right.left.left = new Node(6);
		head2.right.right.right = new Node(7);
		head2.right.left.left.left = new Node(8);
		head2.right.right.right.right = new Node(9);
		System.out.println(getMaxDistance(head2));
	}
}
