package part04;

import java.util.LinkedList;
import java.util.Queue;

public class Code_03_SerializeAndReconstructTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 * 	先序遍历顺序序列化
	 * #代表空结点，_为分隔符
	 * @param p
	 * @return
	 */
	public static String serializeByPre(Node p) {
		if(p!=null) {
			return p.value+"_"+serializeByPre(p.left)+serializeByPre(p.right);
		}else {
			return "#_";
		}
	}
	public static Queue<String> str2que(String str){
		String[] strs = str.split("_");
		Queue<String> queue = new LinkedList<>();
		for(String s:strs) {
			queue.offer(s);
		}
		return queue;
		
	}
	/**
	 * 	通过先序遍历字符串来反序列化二叉树
	 * @param queue 先序字符队列
	 * @return
	 */
	public static Node reconstructByPre(Queue<String> queue) {
		String s = queue.poll();
		if(s.equals("#")) {
			return null;
		}
		Node p = new Node(Integer.parseInt(s));
		p.left = reconstructByPre(queue);
		p.right = reconstructByPre(queue);
		return p;
	}
	
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		String pre = serializeByPre(head);
		System.out.println(pre);
		Node p = reconstructByPre(str2que(pre));
		System.out.println(serializeByPre(p));
	}

}
