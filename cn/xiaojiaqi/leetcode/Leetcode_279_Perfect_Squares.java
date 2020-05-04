package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * 思路： eg：f(13)
 *  最少的平方数可能来自下面几种可能：
 *  可能1：从9开始，问题转化为求1+f(4)
 *  可能2：从4开始，-->1+f(9)
 *  可能3：从1开始  --->1+f(12)
 * @author Narut0
 *
 */
public class Leetcode_279_Perfect_Squares {
	//Recursion with memorization   36ms
    //Recursion Brute Force     326ms
    public  static int numSquares(int n) {
    	if(n<=3)return n;
    	Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        
    	return f(n,map);
    }
    public static int f(int n,Map<Integer,Integer> map){
        if(n<=3)return n;
        int sn = (int) Math.sqrt(n);
    	
    	int min = Integer.MAX_VALUE;
    	for(int i=sn;i>0;i--) {//从可以要的最大的平方数开始
    		int p = 0;
    		int tmp = n;
    		if(tmp%(i*i)==0) {//如果当前平方数已经可以瓜分完sum则，一定比更小的平方数瓜分sum的需要的个数少。
    			min = Math.min(min, tmp/(i*i)) ;
    			break;
    		}
    		while(tmp>i*i) {//当前平方数尽可能多的要。
    			tmp-=i*i;
    			p++;
    		}
            if(map.containsKey(tmp)){
                min = Math.min(p+map.get(tmp), min);
            }else{
                min = Math.min(p+f(tmp,map), min);
            }	
    	}
        map.put(n,min);
    	return min;
    }
  //DP   281ms ???why
    public static int numSquares2(int n) {
        if(n<0)return -1;
        if(n<4)return n;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4;i<dp.length;i++){
            int sn = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;

            for(int j=sn;j>0;j--){
            	//dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
                //       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
                //       = 2
            	min = Math.min(1+dp[i-j*j], min);
            }
            dp[i] = min;
        }
        return dp[dp.length-1];

    }
	public static void main(String[] args) {
		int n = 12;
		int ans = numSquares(n);
		System.out.println(ans);
	}
}