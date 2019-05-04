package part07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 哈夫曼树
 * 
 * 问题描述：
	 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如
	长度为20的 金条，不管切成长度多大的两半，都要花费20个铜
	板。一群人想整分整块金 条，怎么分最省铜板？
	例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为
	10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
	度60的金条分成10和50，花费60 再把长度50的金条分成20和30，
	花费50 一共花费110铜板。
	但是如果， 先把长度60的金条分成30和30，花费60 再把长度30
	金条分成10和20，花费30 一共花费90铜板。
	输入一个数组，返回分割的最小代价。
 * @author Narut0
 *
 */
public class Code_02_HuffmanTree {
	/**
	 * 哈夫曼树结点
	 * @author Narut0
	 *
	 */
	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int data) {
			this.value = data;
		}
		public Node() {
			super();
		}
	}
	//比较器，默认升序
	public static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o1.value-o2.value;
		}
		
	}
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		int sum = huffman(arr);
		System.out.println(sum);
		
	}
	/**
	 * 利用哈夫曼算法，求最小代价
	 * @param arr
	 * @return
	 */
	public static int huffman(int[] arr) {
		//优先级队列，内部就是堆。
		PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
		for(int i=0;i<arr.length;i++) {
			Node p = new Node(arr[i]);
			pq.add(p);
		}
		int sum=0;
		while (pq.size()>=2) {
			Node left = pq.poll();
			Node right = pq.poll();
			sum+=left.value+right.value;
			Node p = new Node(left.value+right.value);
			p.left  =left;
			p.right = right;
			pq.add(p);
		}
		return sum;
		
	}
	
	
	
	

}
