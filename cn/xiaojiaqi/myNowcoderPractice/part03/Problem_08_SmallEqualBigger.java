package part03;

public class Problem_08_SmallEqualBigger {

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
	/**
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node smallEqualBigger(Node head,int k) {
		if(head!=null) {
			Node small = null;//第一个比k小的数
			Node equal = null;//第一个等于k的数
			Node bigger = null;//第一个大于k的数
			Node p = head;
			while(p!=null) {//遍历一遍找到small,equal,bigger
				if(p.value<k) {
					small= small==null?p:small;
				}else if (p.value==k) {
					equal= equal==null?p:equal;
				}else {
					bigger= bigger==null?p:bigger;
				}
				p = p.next;
			}
			p = head;
			Node sn=small;//用于small遍历，以下类似
			Node en=equal;
			Node bn=bigger;
			while (p!=null) {
				if(p.value<k) {
					if(p!=small) {
						sn.next = p;
						sn = sn.next;
					}
				}else if (p.value==k) {
					if(p!=equal) {
						en.next =p ;
						en = en.next;
					}
				}else {
					if(p!=bigger) {
						bn.next = p;
						bn = bn.next;
					}
				}
				p = p.next;
				
			}
			if(bn!=null) {//给最后一个大于k的结点附上null结尾，以下类似
				bn.next = null;
			}
			if(en!=null) {
				en.next = null;
			}
			if(sn!=null) {
				sn.next = null;
			}
			if(sn!=null&&equal!=null) {//判断
				sn.next = equal;
				en.next = bigger;
				return small;
			}else if (sn!=null&&equal==null) {
				sn.next = bigger;
				return small;
			}else if (sn==null&&equal!=null) {
				en.next = bigger;
				return equal;
			}else if (sn==null&&equal==null) {
				return bigger;
			}
		
		
		}
		return null;
		
	}
	public static void main(String[] args) {
		Node head = new Node(9);
		head.next = new Node(0);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		Node p = smallEqualBigger(head, 3);
		while (p!=null) {
			System.out.println(p.value);
			p = p.next;
		}
	}

}
