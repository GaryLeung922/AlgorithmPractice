package part03;

import java.util.HashSet;
/**
 * 	此题两种解法
 * 	1. 直接利用HashSet,适合笔试
 * 	2. 需要一定技巧，具体看注释（面试）
 * @author Narut0
 *
 */
public class Problem_10_FindFirstIntersectNode {

	public static class Node{
		public int value;
		public Node next;
		public Node() {
			super();
		}
		public Node(int data) {
			this.value = data;
			this.next = null;
		}	
	}
	//解法一：利用HashMap,其实可以直接遍历出两个链表的第一个相交结点（如果有的话）
	
	/**
	 * 	如果单链表有环，则返回第一个入环的结点，否则返回null。（使用HashSet）一种解法
	 * @param head
	 * @return
	 */
	public static Node getNodeLoop(Node head) {
		if(head!=null) {
			HashSet<Node> nset = new HashSet<>();
			while (head!=null) {
				if(nset.add(head)) {
					head = head.next;
				}else {
					return head;
				}	
			}
			return null;
		}
		return null;
	}
	//解法二：利用快慢指针求入环的第一个结点（如果有的话）
	/*
	 * 
	 */
	public static Node getNodeLoop2(Node head) {
		if(head!=null) {
			Node fast = head;
			Node low = head;
			while(true) {
				if(fast!=null) {//判断越界
					fast = fast.next;
				}
				if(fast!=null) {//判断越界
					fast = fast.next;
				}else {
					return null; //无环
				}
				low = low.next;
				if(fast==low) {//相遇，则把fast重新指向头节点，并且fast一次只跳一步
					fast = head;
					while(fast!=low) {
						low = low.next;
						fast = fast.next;
					}//再次相遇，则退出循环，此时相遇的位置即为入环的第一个结点位置
					return fast;
				}
			}

		}
		return null;
	}
	
	public static Node getNodeIntersect2(Node head1,Node head2) {
		//表一与表二都有环
		if(getNodeLoop(head1)!=null&&getNodeLoop(head2)!=null) {
			Node loop1 = getNodeLoop(head1);
			Node loop2 = getNodeLoop(head2);
			if(loop1==loop2) {//如果两链表的入环结点相等，则一定相交。
				//把环断开，利用isIntersect来获得相交结点
				System.out.println("？？？？？？");
				Node nextLoop = loop1.next;
				
				loop1.next = null;
				
				Node result  = isIntersect(head1, head2);
				//还原链表
				loop1.next = nextLoop;
				
				return result;
			}else {//如果两链表入环结点不一样，则需要从一个环的入环节点开始遍历一圈，看是否会有第二个环的入环结点
				Node p = loop1;
				p = p.next;
				while (p!=loop1) {
					if(p==loop2) {//如果是同一个环，只是入环结点不一样，那么返回二者其中任意一个即可
						return loop2;
					}
					p = p.next;
				}
				return null;
				
			}
			//表一表二都无环
		}else if (getNodeLoop(head1)==null&&getNodeLoop(head2)==null) {
			return isIntersect(head1, head2);
		}

		return null;
	}
	/**
	 * 	返回两条无环链表的相交结点，无则返回null
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node isIntersect(Node head1,Node head2) {
		int len = 0;
		Node p1 = head1;
		Node p2 = head2;
		while(p1!=null) {
			len++;
			p1 = p1.next;
		}
		p1 = head1;
		while (p2!=null) {
			len--;
			p2 = p2.next;
		}
		p2 = head2;
		//此时len为head1和head2的差值，先让长的链表走len步，再开始一起走，寻找是否有相交结点。
		if(len>=0) {
			for(int i=0;i<len;i++) {
				p1 = p1.next;
			}
		}else{
			for(int i=0;i>len;i--) {
				p2 = p2.next;
			}
		}
		while (p1!=p2&&p1!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		if(p1==null) {
			return null;
		}else {
			return p1;
		}
	}
	
	
	public static void main(String[] args) {
		Node head = new Node(9);
		head.next = new Node(0);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = head.next.next;//接到4
		
		Node head2 = new Node(10);
		head2.next = new Node(99);
		head2.next.next = head2.next;
		//head.next.next.next.next.next.next = head;
		/*System.out.println(getNodeLoop(head)==null?null:getNodeLoop(head).value);
		System.out.println(getNodeLoop2(head)==null?null:getNodeLoop2(head).value);
		*/
		//System.out.println(isIntersect(head, head2)==null?null:isIntersect(head, head2).value);
		/*Node p = getNodeIntersect2(head, head2);
		System.out.println(p==null?null:p.value);*/
		Node p = getNodeIntersect(head, head2);
		System.out.println(p==null?null:p.value);
		
	}
	//直接利用HashSet
	public static Node getNodeIntersect(Node head1,Node head2) {
		if(head1!=null&&head2!=null) {
			HashSet<Node> hs = new HashSet<>();
			Node p = head1;
			while (p!=null) {
				if(hs.add(p)) {
					p = p.next;
				}else {
					break;
				}
			}
			p = head2;
			HashSet<Node> hs2 = new HashSet<>();
			while (p!=null) {
				if(hs.contains(p)) {
					
					return p;
				}else {
					if(!hs2.add(p)) {
						return null;
					}
					p = p.next;
				}
			}
			return null;
	
		}
		
		return null;
	}
}
