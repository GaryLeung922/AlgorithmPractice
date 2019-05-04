package part04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 二叉树的先序、中序、后序遍历。（递归和非递归实现）
 * 其中先序和后序的非递归又提供了多种思路
 * @author Narut0
 *
 */
public class Code_01_PreInPosTraversal {
	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int data) {
			this.value = data;
			
		}
	}
	/**
	 * 先序递归遍历
	 * @param head
	 */
	public static void PreRecursive(Node head) {
		if(head==null) {
			return;
		}
		System.out.print(head.value+" ");
		PreRecursive(head.left);
		PreRecursive(head.right);
	}
	/**
	 * 中序递归遍历
	 * @param head
	 */
	public static void InRecursive(Node head) {
		if(head==null) {
			return;
		}
		InRecursive(head.left);
		System.out.print(head.value+" ");
		InRecursive(head.right);
	}
	/**
	 * 后序递归遍历
	 * @param head
	 */
	public static void PosRecursive(Node head) {
		if(head==null) {
			return;
		}
		PosRecursive(head.left);
		
		PosRecursive(head.right);
		System.out.print(head.value+" ");
	}
	/**
	 * 先序非递归 1
	 * 思路是：
	 * 1.根节点入栈，进入循环。
	 * 2.根节点出栈并访问
	 * 3.依此进栈右子树和左子树（各自不为空）
	 * 4.当栈为空时，遍历完成
	 * @param head
	 */
	public static void PreNorecur1(Node head) {
		if(head!=null) {
			Stack<Node> stack = new Stack<>();
			stack.push(head);
			while (!stack.isEmpty()) {
				Node p = stack.pop();
				System.out.print(p.value+" ");
				if(p.right!=null) {
					stack.push(p.right);
				}
				if(p.left!=null) {
					stack.push(p.left);
				}
			}
			
			
		}
	}
	/**
	 * 先序非递归 2
	 * 可与中序非递归对比学习
	 * 此方法是入栈时访问，中序非递归是出栈时访问，代码几乎相同
	 * 思路是：
	 * 1.一棵子树先把左孩子一一入栈（并访问）。
	 * 2.若在1步骤中遇到结点为空，则出栈一个元素，把此节点的右子树又进行一遍步骤1。
	 * 3.当结点为空并且栈中无元素时，遍历完成。
	 * @param head
	 */
	public static void PreNorecur2(Node head) {
		if(head!=null) {
			Node p = head;
			Stack<Node> stack = new Stack<>();
			//stack.push(p);
			while (p!=null||!stack.isEmpty()) {
				if(p!=null) {
					stack.push(p);
					System.out.print(p.value+" ");//入栈时访问
					p = p.left;
				}else {
					p = stack.pop();
					
					p = p.right;
				} 
			}
		}
	}
	/**
	 * 中序非递归
	 * 与先序非递归遍历2思路相同，唯一不同点在于中序是元素出栈时访问
	 * @param head
	 */
	public static void InNorecur(Node head) {
		if(head!=null) {
			Node p = head;
			Stack<Node> stack = new Stack<>();
			//stack.push(p);
			while (p!=null||!stack.isEmpty()) {
				if(p!=null) {
					stack.push(p);
					p = p.left;
				}else {
					p = stack.pop();
					System.out.print(p.value+" ");//出栈时访问
					p = p.right;
				} 
			}
		}
	}
	/**
	 * 后序非递归遍历1（思路很简单，也很容易理解）
	 * 思路：
	 * 稍微修改先序非递归遍历1，使其顺序变为根右左，然后依此顺序进栈，出栈顺序即为后序遍历
	 * 
	 * @param head
	 */
	public static void PosNorecur1(Node head) {
		if(head!=null) {
			Stack<Node> stack = new Stack<>();
			Stack<Node> help = new Stack<>();
			stack.push(head);
			while (!stack.isEmpty()) {
				Node p = stack.pop();
				//System.out.print(p.value+" ");
				help.push(p);//打印操作修改为进栈操作
				//下面交换先序遍历中左右孩子入栈的顺序
				if(p.left!=null) {
					stack.push(p.left);
				}
				if(p.right!=null) {
					stack.push(p.right);
				}
			}
			while (!help.isEmpty()) {//进栈时顺序为根右左，出栈顺序即为左右根
				System.out.print(help.pop().value+" ");
			}
			
			
		}
	}
	/**
	 * 后序非递归遍历2（可与中序非递归进行比较学习）
	 * 思路：
	 * 1.遍历左结点并进栈
	 * 2.若此时结点为空，则查看（peek）栈顶元素，
	 * 3.若栈顶元素的右孩子不为空，且右孩子不为上一个访问（打印）的结点则对右子树进行步骤1，否则弹出栈顶元素并访问
	 * 4.当结点为空且栈也为空，此时遍历完成
	 * @param head
	 */
	public static void PosNorecur2(Node head) {
		if(head!=null) {
			Node p = head;
			Stack<Node> stack = new Stack<>();
			Node help = null;//用于记录上一个访问（打印）的结点
			while(p!=null||!stack.isEmpty()) {
				if(p!=null) {
					stack.push(p);
					p = p.left;
				}else {
					p = stack.peek();
					if(p.right!=null&&help!=p.right) {
						p = p.right;
					}else {
						p = stack.pop();
						System.out.print(p.value+" ");
						help = p;//记录下来
						p = null;
					}
				}
				
			}
		}
		
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        TreeNode p = root;
        while(stack.isEmpty()||p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }
	
	/**
	 * 			    5
	 * 		   3         8
	 * 		 2   4	   7   10
	 *     1		 6    9  11
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		
		
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.println("PreTraversal");
		PreRecursive(head);
		System.out.println("");
		System.out.println("InTraversal");
		InRecursive(head);
		System.out.println("");
		System.out.println("PosTraversal");
		PosRecursive(head);
		System.out.println("");
		System.out.println("==============nonrecursive==============");
		System.out.println("PreTraversal");
		PreNorecur1(head);
		System.out.println("");
		System.out.println("PreTraversal2");
		PreNorecur2(head);
		System.out.println("");
		System.out.println("InTraversal");
		InNorecur(head);
		System.out.println("");
		System.out.println("PosTraversal");
		PosNorecur1(head);
		System.out.println("");
		System.out.println("PosTraversa2");
		PosNorecur2(head);
		
		String str = "sdaf";
		
	}

}
