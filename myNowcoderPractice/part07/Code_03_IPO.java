package part07;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 
	题目描述：
	输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，
	正数k 参数4，正数m
	costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
	费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多
	做k个项目 m表示你初始的资金
	说明：你每做完一个项目，马上获得的收益，可以支持你去做下
	一个 项目。一个项目只能做一次
	输出： 你最后获得的最大钱数。
	
	解题思路：
	利用大根堆存储项目的利润
	小根堆存储项目的花费
	每次做项目时取大根堆堆顶项目，同时更新小根堆
 * @author Narut0
 *
 */
public class Code_03_IPO {
	
	//cost和profit的结点
	public static class Node{
		int c;
		int p;
		public Node(int c,int p) {
			this.c = c;
			this.p = p;
		}
		public Node() {
			super();
		}
	}
	//按cost排序的升序比较器
	public static class CAcomparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c-o2.c;
		}
	}
	//按profit排序的降序比较器
	public static class PDcomparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			
			return o2.p-o1.p;
		}
	}
	public static int theMostMoney(int[] c,int[] p,int k,int m) {
		if(k>0&&m>0) {
			Node[] pc = new Node[c.length];
			//按profit排序的大根堆
			PriorityQueue<Node> pQueue  = new PriorityQueue<>(new PDcomparator());
			//按cost排序的xiao'geng'dui
			PriorityQueue<Node> cQueue = new PriorityQueue<>(new CAcomparator());
			for(int i=0;i<c.length;i++) {
				Node q = new Node(c[i], p[i]);
				pc[i] = q;
			}
			for(Node q:pc){
				if(q.c<=m) {
					pQueue.offer(q);
				}else {
					cQueue.offer(q);
				}
			}
			while (k>0&&!pQueue.isEmpty()) {
				Node q = pQueue.poll();//选取利润最大的项目
				k--;
				m+=q.p;
				//如果cQueue不为空，且堆顶项目cost小于当前m,则弹出并进入qQueue
				while (!cQueue.isEmpty()&&cQueue.peek().c<=m) {
					pQueue.offer(cQueue.poll());
				}
			}
			return m;
		}
		return m;
	}
	public static void main(String[] args) {
		int[] cost = {50,80,90,210};
		int[] profit = {20,20,30,50};
		int k = 4;
		int m = 60;
		System.out.println(theMostMoney(cost, profit, k, m));
	}
	

}
