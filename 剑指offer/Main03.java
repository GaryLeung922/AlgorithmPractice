package cn.xiaojiaqi.test;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Main03{
    public static void main(String[] args) {
    	
    	System.out.println(Integer.parseInt("0123"));
    	for(int i=2;i<10000;i++) {
    		int ans = test(i);
    		if(ans!=-1) {
    			System.out.println(ans+"  "+i);
    		}
    		
    		if(ans>=i) {
    			System.out.println(ans+" "+i);
    		}
    	}
    	System.out.println("asf");
        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        //System.out.println("aSD");
//        if(m<=1) {
//        	System.out.println(-1);
//        	return;
//        }
//		//int a = 2;
//		Set<Integer> set = new HashSet<>();
//		for(int a=2;a<m;a++) {
//			int j=a;
//			boolean flag = true;
//			set.add(j%m);
//			for(int i=2;i<m;i++) {
//				j*=a;
//				if(set.contains(j%m)) {
//					flag = false;
//					break;
//				}else {
//					set.add(j%m);
//				}
//			}
//			if(flag) {
//				System.out.println(a);
//				return;
//			}
//			set = new HashSet<>();
//			//a++;
//		}
//		System.out.println(-1);
    }
    public static boolean isSu(int m){
        int i=2;
        while(i<=Math.sqrt(m)) {
        	if(m%i==0)return false;
        	i++;
        }
        return true;
    }
    public static int test(int n) {
    	int m = n;
        //System.out.println("aSD");
        if(m<=1||!isSu(m)) {
        	//System.out.println(-1);
        	return -1;
        }
		//int a = 2;
		Set<Integer> set = new HashSet<>();
		for(int a=2;a<m;a++) {
			int j=a;
			boolean flag = true;
			set.add(j%m);
			for(int i=2;i<m;i++) {
				j*=a;
				if(set.contains(j%m)) {
					flag = false;
					break;
				}else {
					set.add(j%m);
				}
			}
			if(flag) {
				//System.out.println(a);
				return a;
			}
			set = new HashSet<>();
			//a++;
		}
		return -1;
		//System.out.println(-1);
    }
}