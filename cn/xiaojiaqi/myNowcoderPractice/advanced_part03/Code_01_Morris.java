package advanced_part03;

import advanced_part02.Code_03_MaxTree.Node;

public class Code_01_Morris {

//	public static class Node{
//		public int value;
//		public Node left;
//		public Node right;
//		public Node(int data) {
//			this.value = data;
//		}
//	}
	public static void processPre(Node head) {
		if(head!=null) {
			System.out.print(head.value+" ");
			processPre(head.left);
			processPre(head.right);
		}
		return ;
	}
	public static void processIn(Node head) {
		if(head!=null) {
			processIn(head.left);
			System.out.print(head.value+" ");
			processIn(head.right);
		}
		return ;
	}
	public static void processPos(Node head) {
		if(head!=null) {
			processPos(head.left);
			processPos(head.right);
			System.out.print(head.value+" ");
		}
		return ;
	}
	
	//Morris先序遍历
	public static void morrisPre(Node head) {
		if(head!=null) {
			Node cur = head;
			while (cur!=null) {
				Node mostRight = cur.left;
				if(mostRight!=null) {
					Node p = mostRight;
					while(p!=null&&p!=cur) {
						mostRight = p;
						p = p.right;
					}
					if(p==null) {
						System.out.print(cur.value+" ");
						mostRight.right = cur;
						cur = cur.left;
					}else if(p==cur) {
						mostRight.right = null;
						cur = cur.right;
					}
				}else { 
					System.out.print(cur.value+" ");
				
					cur = cur.right;
				}
			}
		}
		System.out.println("");
		return ;
		
	}
	//Morris中序遍历
	public static void morrisIn(Node head) {
		if(head!=null) {
			Node cur = head;
			while(cur!=null) {
				Node mostRight = cur.left;
				if(mostRight!=null) {
					Node p = mostRight;
					while (p!=null&&p!=cur) {
						mostRight = p;
						p = p.right;
					}
					if(p==null) {
						mostRight.right = cur;
						cur = cur.left;
					}else {
						System.out.print(cur.value+" ");
						cur = cur.right;
						mostRight.right = null;
					}
				}else {
					System.out.print(cur.value+" ");
					cur = cur.right;
				}
			}
		}
		System.out.println("");
		return ;
		
	}
	//Morris后序遍历
	public static void morrisPos(Node head) {
		if(head!=null) {
			Node cur = head;
			while(cur!=null) {
				Node mostRight = cur.left;
				if(mostRight!=null) {
					Node p = mostRight;
					while (p!=null&&p!=cur) {
						mostRight = p;
						p = p.right;
					}
					if (p==null) {
						
						mostRight.right = cur;
						cur = cur.left;
					}else {//p==cur
						mostRight.right = null;
						printRightRev(cur.left);
						cur = cur.right;
						//System.out.println(cur.left.value);
					}
					
				}else {
					cur = cur.right;
				}
			}
			//System.out.println(head.value);
			printRightRev(head);
		}
		return;
		
	}
	//打印
	public static void printRightRev(Node p) {
		if(p!=null) {
			Node s = reverse(p);
			Node h = s;
			while(h!=null) {
				System.out.print(h.value+" ");
				h = h.right;
			}
			reverse(s);
		}
	}
	//逆序
	public static Node reverse(Node p) {
		if(p!=null) {
			Node pre = null;
			Node next = p.right;
			while (p!=null) {
				p.right = pre;
				pre = p;
				p = next;
				if(next!=null) {
					next = next.right;
				}else {
					break;
				}
			}
			return pre;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,6,1,3,5,7};
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		head.right.right = new Node(7);
		//Node head = Code_03_MaxTree.maxTreeByMonStack(arr);
		System.out.println("先序：");
		processPre(head);
		System.out.println("\n中序：");
		processIn(head);
		System.out.println("\n后序");
		processPos(head);
		System.out.println("\nMorris先序：");
		morrisPre(head);
		System.out.println("Morris中序：");
		morrisIn(head);
		System.out.println("");
		printTree(head);
		System.out.println("Morris后序：");
		morrisPos(head);

		//printRightRev(head);
		System.out.println("");
		printTree(head);
//		System.out.println(head.right.value);
		
	}
	
	
	
	
	// for test -- print tree
		public static void printTree(Node head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}

		public static void printInOrder(Node head, int height, String to, int len) {
			if (head == null) {
				return;
			}
			printInOrder(head.right, height + 1, "v", len);
			String val = to + head.value + to;
			int lenM = val.length();
			int lenL = (len - lenM) / 2;
			int lenR = len - lenM - lenL;
			val = getSpace(lenL) + val + getSpace(lenR);
			System.out.println(getSpace(height * len) + val);
			printInOrder(head.left, height + 1, "^", len);
		}

		public static String getSpace(int num) {
			String space = " ";
			StringBuffer buf = new StringBuffer("");
			for (int i = 0; i < num; i++) {
				buf.append(space);
			}
			return buf.toString();
		}

}
