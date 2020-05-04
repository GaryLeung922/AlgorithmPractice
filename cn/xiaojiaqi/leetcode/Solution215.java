package cn.xiaojiaqi.leetcode;

import java.util.PriorityQueue;

public class Solution215 {
	public static int findKthLargest1(int[] nums, int k) {
        if(nums==null||nums.length<k)return -1;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(heap.size()>=k){
                if(nums[i]>heap.peek()){
                    heap.poll();
                    heap.offer(nums[i]);
                }
            }else{
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
    public static void main(String[] args) {
		int[] nums=  {1,9,3,8,4};
		findKthLargest1(nums, 2);
	}
}