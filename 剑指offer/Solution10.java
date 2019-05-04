package cn.xiaojiaqi.test;

import java.util.Date;
import java.util.HashSet;

public class Solution10 {
    public static int GetUglyNumber_Solution(int index) {
    	long start = new Date().getTime();
        if(index>1){
            HashSet<Integer> set = new HashSet<>();
            set.add(1);
            int count=1;
            int i = 2;
            while(true){
                if(set.contains(i%2==0?i/2:-1)||set.contains(i%3==0?i/3:-1)||set.contains(i%5==0?i/5:-1)){
                    set.add(i);
                    count++;
                    
                }
                if(count==index){
                	long end = new Date().getTime();
                	System.out.println(end-start);
                    return i;
                }
                i++;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
		int res = GetUglyNumber_Solution(10);
		System.out.println(res);
		System.out.println((int)'a');
		System.out.println((int)'A');
	}
}