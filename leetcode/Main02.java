package cn.xiaojiaqi.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] h = new int[n];
		for(int i=0;i<n;i++) {
			h[i] = sc.nextInt();
		}
		Arrays.sort(h);
		Type[] types = new Type[h[h.length-1]-h[0]];
		int index = 0;
		int i = h[h.length-1]-1;
		//System.out.println();
		//int j = h.length-1;
		int cost = 0;
		while (i>=h[0]) {
			//int cost = 0;
			int j = h.length-1;
			while(h[j]>i) {
				cost++;
				j--;
			}
			types[index++] = new Type(i--, cost);
		}
		PriorityQueue<Type> minpq = new PriorityQueue<>(new Comparator<Type>() {
			@Override
			public int compare(Type o1, Type o2) {
				
				return o1.cost-o2.cost;
			}
		});
		PriorityQueue<Type> maxpq = new PriorityQueue<>(new Comparator<Type>() {
			@Override
			public int compare(Type o1, Type o2) {
				return o2.cost-o1.cost;
			}
		});
		//System.out.println(Arrays.toString(types));
		for(int m=0;m<types.length;m++) {
			minpq.add(types[m]);
		}
		while(!minpq.isEmpty()&&minpq.peek().cost<=k) {
			maxpq.add(minpq.poll());
		}
		int ans = 0;
		while(maxpq.peek().onh>h[0]) {
			Type cut = maxpq.poll();
			//System.out.println("cut:"+cut.onh);
			k+=cut.cost;
			ans++;
			while(!minpq.isEmpty()&&minpq.peek().cost<=k) {
				maxpq.add(minpq.poll());
			}
					
		}
		System.out.println(ans+1);
		
	}
	public static class Type{
		public int onh;
		public int cost;
		public Type(int onh,int cost) {
			this.onh = onh;
			this.cost = cost;
		}
		@Override
		public String toString() {
			
			return "["+onh+"--"+cost+"]";
		}
	}

}
