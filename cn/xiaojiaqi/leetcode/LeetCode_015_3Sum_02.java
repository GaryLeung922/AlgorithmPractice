package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 3:02 PM
 */
public class LeetCode_015_3Sum_02 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums==null||nums.length==0)return res;
            Arrays.sort(nums);

            for(int i=0;i<nums.length;i++){
                if(i>0&&nums[i]==nums[i-1])continue;
                int a=i+1;
                int b=nums.length-1;
                int target = 0-nums[i];
                while (a<b){
                    if(nums[a]+nums[b]<target){
                        a++;
                    }else if(nums[a]+nums[b]>target){
                        b--;
                    }else {
                        res.add(Arrays.asList(nums[i],nums[a++],nums[b--]));
                    }
                    // 条件要齐全 a>i+1 ,以防[-1,0,1,2,-1,-4,-2,-3,3,0,4]  找不到[-1,-1,2]
                    while (a<b&&a>i+1&&nums[a]==nums[a-1]) {
                        a++;
                    }
                    while (a<b&&b<nums.length-1&&nums[b]==nums[b+1]){
                        b--;
                    }
                }
            }
            return res;
        }
    }
}
