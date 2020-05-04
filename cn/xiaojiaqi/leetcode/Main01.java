package cn.xiaojiaqi.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] L = new int[n];
		int[] D = new int[n];
		Kv[] kvs = new Kv[n];
		for(int i=0;i<n;i++) {
			L[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			D[i] = sc.nextInt();
			kvs[i] = new Kv(L[i],D[i]);
		}
		Arrays.sort(kvs,new Comparator<Kv>() {
			@Override
			public int compare(Kv o1, Kv o2) {
				
				return o1.l-o2.l;
			}
		});
		
		int half = n-(n/2+1);
		int std = kvs[half].l;
		//System.out.println(std+"  "+half);
		int cost=0;
		for(int i=half+1;i<n;i++) {
			if(kvs[i].l!=std) {
				cost+=kvs[i].d;
			}
		}
		System.out.println(cost);
		//System.out.println(Arrays.toString(kvs));
	}
	public static class Kv{
		int l;
		int d;
		public Kv(int l,int d) {
			this.l = l;
			this.d = d;
		}
		@Override
		public String toString() {
			
			return "["+l+"--"+d+"]";
		}
	}

}
