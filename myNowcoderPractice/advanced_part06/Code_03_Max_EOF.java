package advanced_part06;

import java.util.Arrays;

public class Code_03_Max_EOF {
	public static class Node{
		Node[] next;
		public Node() {
			next = new Node[2];
		}
	}
	public static int maxOfEOF(int[] arr) {
		if(arr!=null&&arr.length>1) {
			Node head = new Node();
			int res = 0;
			int max = Integer.MIN_VALUE;
			for(int i=0;i<arr.length;i++) {
				res ^= arr[i];
				max = Math.max(Math.max(max, trieTree(res,head)), res);
			}
			return max;
		}
		return Integer.MIN_VALUE;
	}
	private static int trieTree(int res, Node head) {
		Node p = head;
		int ans = 0;
		for(int i=31;i>=0;i--) {
			int path = (res>>i)&1;
			if(p.next[path]==null) {
				p.next[path] = new Node();
			}
			p = p.next[path]; 
		}
		p = head;
		for(int i=31;i>=0;i--) {
			int path = (res>>i)&1;
			//System.out.println("path:"+path);
			if(p.next[path]!=null&&i==31) {
				ans |= (0<<i); 
				p = p.next[path];
			}else if(i==31){
				ans |= (1<<i);
				p = p.next[Math.abs(path-1)];
			}else if (p.next[Math.abs(path-1)]!=null) {
				ans |= (1<<i);
				p = p.next[Math.abs(path-1)];
			}else {
				ans |= (0<<i);
				p = p.next[path];
			}
		}
		return ans;
	}
	
	public static int forceMaxEOF(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int max = Integer.MIN_VALUE;
			int res = 0;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<=i;j++) {
					for(int k=j;k<=i;k++) {
						res ^=arr[k];
					}
					max = Math.max(max, res);
					res = 0;
				}
			}
			return max;
		}
		return Integer.MIN_VALUE;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		int res1 = maxOfEOF(arr) ;
		int res2 = forceMaxEOF(arr);
		System.out.println("res1:"+res1);
		System.out.println("res2:"+res2);
		
		int[][] arrs = MyUtils.TestUtil.generateArr(99999, 100, 0, 10);
		boolean success = true;
		for(int i=0;i<arrs.length;i++) {
			res1 = maxOfEOF(arrs[i]);
			res2 = forceMaxEOF(arrs[i]);
			if(res1!=res2) {
				System.err.println(Arrays.toString(arrs[i]));
				System.out.println("res1:"+res1);
				System.out.println("res2:"+res2);
				success = false;
			}
		}
		System.out.println(success?"nice":"fucked");
		
	}
}
