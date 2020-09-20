package cn.xiaojiaqi.leetcode;

import java.util.PriorityQueue;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 4:46 PM
 */
public class LeetCode_215_findKthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums==null||nums.length==0)return -1;

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(nums[0]);
            for(int i=1;i<nums.length;i++){
                if(nums[i]>priorityQueue.peek() || priorityQueue.size()<k){
                    priorityQueue.add(nums[i]);
                    if(priorityQueue.size()>k){
                        priorityQueue.poll();
                    }
                }
            }
            return priorityQueue.peek();
        }
    }
}
