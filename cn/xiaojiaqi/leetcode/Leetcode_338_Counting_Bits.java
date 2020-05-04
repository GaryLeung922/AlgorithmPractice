package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

public class Leetcode_338_Counting_Bits {
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0;i<=num;i++){
            res[i] = binaryOne(i);
        }
        return res;
    }
    public static int binaryOne(int n){
        int count=0;
        while(n>0){
            if((n&1)==1)count++;
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
		int num = 2;
		int[] res = countBits(num);
		System.out.println(Arrays.toString(res));
	}
}