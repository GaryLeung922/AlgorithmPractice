package cn.xiaojiaqi.sword2Offer;

import java.util.ArrayList;

public class Solution14 {
    public static int NumberOf1Between1AndN_Solution(int n) {
    	if(n>1) {
    		ArrayList<Integer> al = new ArrayList<>();
    		al = getPart(n);
    		System.out.println(al.toString());
    	}
    	return 0;
    }
    public static ArrayList<Integer> getPart(int n) {
    	ArrayList<Integer> al = new ArrayList<>();
    	while (true) {
			if(n/10>0) {
				al.add(n%10);
				n /= 10;
			}else {
				break;
			}
		}
    	al.add(n);
    	return al;
    }
    public static int f(long x,int n) {
    	
    	int y = (int) (x/Math.round(Math.pow(10, n)));
    	if(y>1) {
    		return y*g(n-1)+f(x%Math.round(Math.pow(10, n)),n-1);
    	}else {
    		
    	}
    	return 0;
    }
    private static int g(int i) {
		if(i==1) {
			return 1;
		}else{
			return (int) (10*g(i-1)+Math.round(Math.pow(10, i-1)));
		}
	}
	public static void main(String[] args) {
		NumberOf1Between1AndN_Solution(19356);
	}
}