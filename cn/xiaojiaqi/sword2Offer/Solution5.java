package cn.xiaojiaqi.sword2Offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution5 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>(); 
        if(sum>0){
            ArrayList<Integer> arr = new ArrayList<>(); 
            int a=1;
            int b=1;
            int res=0;
            for(int i=1;i<=sum/2+1;i++){
                res+=i;
                a = i;
                while(res>sum){
                    res-=b;
                    b++;
                }
                if(res==sum){
                    for(int j=b;j<=a;j++){
                        arr.add(j);
                    }
                    arrs.add(arr);
                    arr = new ArrayList<>();
                }
            }
        }
        return arrs;
    }
    public void swap(char[] ctr,int a,int b){
        char tmp = ctr[a];
        ctr[a] = ctr[b];
        ctr[b] = tmp;
        //return ctr;
    }
    public static void main(String[] args) {
		Solution5 solution5 = new Solution5();
		solution5.FindContinuousSequence(9);
		String string = "s";
		char[] ctr = string.toCharArray();
		System.out.println(Arrays.toString(ctr));
		int len = ctr.length;
		for(int i=0;i<len/2;i++){
            solution5.swap(ctr,i,len-1-i);
        }
		System.out.println(Arrays.toString(ctr));
	}
}