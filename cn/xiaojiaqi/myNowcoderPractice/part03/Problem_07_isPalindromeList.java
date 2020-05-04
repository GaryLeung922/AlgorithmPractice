package part03;

public class Problem_07_isPalindromeList {

	public static class Node{
		public int value;
		public Node next;
		public Node() {
		}
		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 * 	局部反转链表(from2to)
	 * @param head
	 * @param from
	 * @param to
	 * @return
	 */
	public static Node reverse(Node head,int from,int to) {
		if(head!=null) {
			if(from>=to) {
				return head;
			}else if (from<1) {
				from = 1;
			}
			Node preFrom;
			Node nodeFrom;
			Node p = head;
			Node pre=null;
			Node next=null;
			for(int i=0;i<from-1;i++) {
				pre = p;
				p = p.next;
			}
			next  = p.next;
			nodeFrom = p;
			preFrom = pre;
			for(int i=0;i<to-from+1;i++) {
				p.next = pre;
				pre = p;
				p = next;
				if(p==null) {//p==null,说明to>=链表长度，直接跳出循环即可
					break;
				}
				next = next.next;
			}
			//反转完后，pre指向原链表的to结点
			if(from==1) {//若从头结点开始反转，则返回反转的最后一个结点
				nodeFrom.next = p;
				return pre;
			}else {
				nodeFrom.next = p;
				preFrom.next = pre;
				return head;
			}
	
		}
		return null;
	}
	public static boolean isPalindromeList(Node head) {
		if(head!=null) {
			int size=0;
			Node p = head;
			while(p!=null) {
				size++;
				p = p.next;
			}
			if(size<=1) {
				return true;
			}
			p = reverse(head, 1, size>>1);
			/*while(head!=null) {
				System.out.println(head.value);
				head = head.next;
			}
			System.out.println("____________");
			while(p!=null) {
				System.out.println(p.value);
				p = p.next;
			}*/
			Node re = p;
			if(size%2==1) {
				head = head.next;
				head = head.next;
				while (head!=null) {
					if(p.value!=head.value) {
						return false;
					}
					head = head.next;
					p  = p.next;
				}
				return true;
			}else {
				head = head.next;
				while (head!=null) {
					if(p.value!=head.value) {
						return false;
					}
					head = head.next;
					p  = p.next;
				}
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Node head = new Node(3);
		head.next = new Node(5);
//		head.next.next = new Node(9);
//		head.next.next.next = new Node(99);
//		head.next.next.next.next = new Node(6);
//		head.next.next.next.next.next = new Node(5);
//		head.next.next.next.next.next.next = new Node(3);
		System.out.println(isPalindromeList(head));
		
	}
	
	

}
