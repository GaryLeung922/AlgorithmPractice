package cn.xiaojiaqi.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0||nums.length<k)return new int[]{};
        
        int L = -1;
        int R = 0;
        int[] max = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        
        while(R<nums.length){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[R]) {
            	deque.pollLast();
            }
            deque.addLast(R);
            if(R>=k-1) {
            	L++;
            	if(deque.peekFirst()<L)deque.pollFirst();
            	max[L] = nums[deque.peekFirst()];
            }
            R++;
        }
        return max;
        
    }
}