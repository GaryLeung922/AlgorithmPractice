package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * 数组三连  2
 * @author Narut0
 *
 */
public class Leetcode_560_Subarray_Sum_Equals_K {
     //Recursion  Brute Force    499ms
     public static int subarraySum1(int[] nums, int k) {
        
         int count = 0;
        
         for(int i=0;i<nums.length;i++){
             int pi =  p(nums,i,k);
            
             count += pi;
         }
         return count;
     }
     public static int p(int[] nums,int i,int k){
         if(i<0)return 0;
         if(k==nums[i])return 1+p(nums,i-1,0);
        
         return p(nums,i-1,k-nums[i]);
     }
    //DP   MLE
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int rows = nums.length+1;
        int cols = 0;
        int begin = k;
        int end = k;
        for(int i=0;i<nums.length;i++){
    		if(nums[i]<0) {
        		end-=nums[i];
        	}else {
        		begin-=nums[i];
        	}
        }
        if(begin>end||begin>0)return 0;
        
        
        cols = end-begin+1;
        
        int[][] dp = new int[rows][cols];
        
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(nums[i-1]==j+begin){
                    dp[i][j] = 1+dp[i-1][-begin];
                }else{
                    if(j+begin-nums[i-1]<begin||j+begin-nums[i-1]>end){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i-1][j-nums[i-1]];
                    }
                    
                }
            }
        }
        
        for(int i=0;i<rows;i++){
            count+=dp[i][k-begin];
        }
        
        return count;
    }
    
  //数组三连  累加和hash表
    public static int subarraySum3(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,map.getOrDefault(0,0)+1);
        int sum = 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return count;
    }
    public static void main(String[] args) {
		int[] nums = {-1,-1,1};
		int k = 2;
		int ans = subarraySum2(nums, k);
		System.out.println(ans);
		
		List<Integer> list = new LinkedList<Integer>();
		
    }
}