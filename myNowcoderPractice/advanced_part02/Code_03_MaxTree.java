package advanced_part02;

import java.util.Stack;

/**
 * 	构建数组的MaxTree
 * 	一个数组的MaxTree定义：
	1.数组必须没有重复元素
	2.MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点
	    包括MaxTree树在内且在其中的每一棵子树上，值最大的节点都是树的头
	给定一个没有重复元素的数组arr，写出生成这个数组的MaxTree的函数，
	要求如果数组长度为N，则时间负责度为O(N)、额外空间负责度为O(N)。
	
	解题思路：
	1.	利用大根堆
	对数组heapify调整为对应的大根堆即可，时间复杂度为O(N),然后再构建出对应的MaxTree
	2.	利用单调栈
		a. 左右两边第一个比它大的数（以下简称左值和右值），如果都没有，则为头节点（说明此值最大）
		b. 左值和右值取小的那个，作为父节点（若只有一个则，其就是父节点）
		可以证明生成的不是多叉树，不是森林
		由于没有重复值，所以栈中只保留Integer的index即可
 * @author Narut0
 *
 */
public class Code_03_MaxTree {

	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	public static class Num{
		public int left;
		public int right;
		public Num() {
			this.left = -1;
			this.right = -1;
		}
		public Num(int left,int right) {
			this.left = left;
			this.right = right;
		}
	}
	/*
	 * 思路1. 利用单调栈来构建MaxTree
	 */
	public static Node maxTreeByMonStack(int[] arr) {
		if(arr!=null&&arr.length>0) {
			Node[] nodes = new Node[arr.length];//生成arr数组对应的Node数组
			Node head = null;//用来记录头节点
			//生成所有的Node
			for(int i=0;i<arr.length;i++) {
				nodes[i] = new Node(arr[i]);
			}
			Stack<Integer> stack = new Stack<>();
			int cur = 0;
			while (cur<arr.length) {
				//单调栈不为空并且栈顶元素小于arr[cur],则弹出并且与父节点建立连接
				while (!stack.isEmpty()&&arr[stack.peek()]<arr[cur]) {
					int index = stack.pop();
					int left = stack.isEmpty()?-1:arr[stack.peek()];//-1表示没有
					int right = arr[cur];
					if(left<right&&left!=-1) {//左值小且不为-1，则与左值结点为父节点
						link(nodes[stack.peek()], nodes[index]);
					}else {
						link(nodes[cur], nodes[index]);
					}
				}
				stack.push(cur++);
			}
			//遍历完之后，栈不为空，需要依此出栈进行处理
			while (!stack.isEmpty()) {
				int index = stack.pop();
				int left = stack.isEmpty()?-1:arr[stack.peek()];
				if(left!=-1) {
					link(nodes[stack.peek()], nodes[index]);
				}else {
					head = nodes[index];
				}
			}
			return head;
		}
		return null;
	}
	//parent的左指针或右指针与p结点建立引用
	public static void link(Node parent,Node p) {
		if(parent.left!=null) {
			parent.right = p;
		}else {
			parent.left = p;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node head = maxTreeByMonStack(arr);
		System.out.println(head.value);
	}
	//待补充
	public static void maxTreeByHeap(int[] arr) {
		if(arr!=null&&arr.length>0) {
			
		}
	}

}
