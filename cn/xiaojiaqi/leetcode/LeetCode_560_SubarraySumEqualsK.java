package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/11 12:58 PM
 */
public class LeetCode_560_SubarraySumEqualsK {

    /**
     * 前缀和  时间O(n^2) 空间O(n)
     */
    static class Solution01 {
        public int subarraySum(int[] nums, int k) {
            if(nums==null || nums.length==0)return 0;

            int[] presum = new int[nums.length+1];

            int res = 0;
            for(int i=0;i<nums.length;i++){
                presum[i+1] = presum[i]+nums[i];
            }
            // nums[i..j)的和 =  presum[j]-presum[i]
            for(int i=1;i<nums.length+1;i++){
                for(int j=0;j<i;j++){
                    if(presum[j] == presum[i]-k){
                        res++;
                    }
                }
            }
            return res;

            // presum  0,1,2,3...j...i
        }
    }

    /**
     * 前缀和技巧延伸, 其实每次只想知道在presum[i] 之前有多少个，presum[i]-k
     */
    static class Solution02 {
        public int subarraySum(int[] nums, int k) {
            if(nums==null || nums.length==0)return 0;

            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int res = 0;
            map.put(0,1);
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                if(map.containsKey(sum-k)){
                    res += map.get(sum-k);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        Solution02 solution = new Solution02();
        int sum = solution.subarraySum(nums, k);
        System.out.println(sum);
    }
}
