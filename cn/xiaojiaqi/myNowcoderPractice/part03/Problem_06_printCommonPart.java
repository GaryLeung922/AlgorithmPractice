package part03;

public class Problem_06_printCommonPart {

	public static class Node{
		public int value;
		public Node next;
		public Node() {
		}
		public Node(int data) {
			this.value = data;
		}
	}
	public static void print(Node head1,Node head2) {
		while (head1!=null&&head2!=null) {
			if(head1.value==head2.value) {
				System.out.println(head1.value);
				head1 = head1.next;
				head2 = head2.next;
			}else if (head1.value>head2.value) {
				head1 = head1.next;
			}else {
				head2 =head2.next;
			}
		}
		
	}
	public static void main(String[] args) {
		Node head1 = new Node(8);
		Node p1 = head1;
		Node head2 = new Node(9);
		Node p2 = head2;
		for(int i=6;i>0;i--) {
			p1.next = new Node(i);
			p2.next = new Node(i+2);
			p1 = p1.next;
			p2 = p2.next;
		}
		
		print(head1, head2);
	}
	

}
