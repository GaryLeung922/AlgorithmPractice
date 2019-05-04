package part04;

public class Code_06_CBTNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		
		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 * 	利用递归求完全二叉树的结点数（平均复杂度低于O(N)）
	 * 	
	 * @param head 头节点
	 * @param h 树高，保持不变（原树高度）
	 * @param l 当前递归的层数
	 * @return 完全二叉树的结点数（时间复杂度低于O(N)）
	 */
	public static int CBTNodeNums(Node head,int h,int l) {
		if(head!=null) {
			int leftNum = mostLeftNode(head.left); //左子树长度
			int rightNum = mostLeftNode(head.right); //右子树长度
			//System.out.println("left:"+leftNum+"  right:"+rightNum);
//			if(leftNum==0) { 若左子树
//				return 1;
//			}
			if(leftNum==rightNum) {//若左子树长度等于右子树长度
				//则说明左子树为满二叉树，树的总结点数为左子树结点数+1+右子树结点数
			
				return (1<<(h-l+1))+CBTNodeNums(head.right, h, l+1);
			}else {//不相等说明，右子树为满二叉树。
				
				return CBTNodeNums(head.left,h,l+1)+(1<<(h-l));
			}
		}
		return 0;
	}
	/**
	 * 获得包含根节点在内的左子树最大高度
	 * @param p
	 * @return
	 */
	public static int mostLeftNode(Node p) {
		if(p!=null) {
			int num = 0;
			while (p!=null) {
				num++;
				p = p.left;
			}
			return num;
		}
		return 0;
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
		head.left.left.right = new Node(9);
		head.left.right.left = new Node(10);
		head.left.right.right = new Node(11);
		head.right.left.left = new Node(12);
		head.right.left.right  = new Node(13);
		head.right.right.left = new Node(14);
		head.right.right.right = new Node(15);
		System.out.println(CBTNodeNums(head, mostLeftNode(head), 2));
		
	}

}
