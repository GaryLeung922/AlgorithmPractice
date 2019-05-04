package part03;

import java.util.HashMap;

public class Problem_09_CopyListWithRandom {
	public static class Node{
		public int value;
		public Node next;
		public Node rand;
		public Node() {
			super();
		}
		public Node(int data) {
			this.value = data;
			this.next = null;
			this.rand = null;
		}	
	}
	public static Node solution1(Node head) {//利用HashMap
		if(head!=null) {
			HashMap<Node, Node> toCopy = new HashMap<>();
			Node p = head;
			while (p!=null) {
				toCopy.put(p, new Node(p.value));
				p = p.next;
			}
			p = head;
			while (p!=null) {
				Node copy = toCopy.get(p);
				copy.next = toCopy.get(p.next);
				copy.rand = toCopy.get(p.rand);
				p = p.next;
			}
			return toCopy.get(head);
		}
		return null;
	}
	public static void main(String[] args) {
		Node head = new Node(9);
		head.next = new Node(0);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.rand = head.next.next;
		head.next.rand = head;
		head.next.next.rand = head.next;
		
		
		Node copy = solution2(head);
		/*while (copy!=null) {
			System.out.print(copy.value);
			System.out.println(copy==head);
			copy = copy.next;
			head = head.next;
		}*/
		System.out.println(copy.rand.value);
		System.out.println(copy.rand==head.rand);
	}
	/**
	 * 把复制的新结点依此放在原结点后面
	 * eg:1->1'->2->2'->3->3'>4->4'->null;
	 * 把原链表的rand结构信息复制给新链表之后，只需要拆开结合的链表即可
	 * @param head
	 * @return
	 */
	public static Node solution2(Node head) {
		if(head!=null) {
			Node oP = head;
			Node oN = oP.next;
			while(oN!=null) {
				oP.next = new Node(oP.value);
				oP.next.next = oN;
				oP = oN;
				oN = oN.next;
			}
			//收尾工作
			oP.next = new Node(oP.value);
			
			
			oP = head;
			Node nP=oP.next;
			while(oP!=null) {
				if(oP.rand!=null) {
					nP.rand = oP.rand.next;
					
				}else {
					nP.rand = null;
				}
				oP = oP.next.next;
				if(oP==null){
					break;
				}
				nP = oP.next;
				
			}
			//把链表拆开
			oP = head;
			nP=oP.next;
			Node result = nP;
			while(oP!=null) {
				oP.next = nP.next;
				oP = oP.next;
				if(oP==null) {
					nP.next = null;
					break;
				}
				nP.next = oP.next;
				nP = nP.next;
			}
			return result;
			
		}
		return null;

	}
}
