package cn.xiaojiaqi.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列队尾的进数逻辑：
 *
 * 1. 队列为空或者队尾元素大于入队元素
 * 2. 如果入队元素大于等于队尾元素，则队尾元素弹出，再进行比较。（直到这个数入队为止）
 *
 * 双端队列队首的出数逻辑：
 * 1. 如果队首元素的下标小于等于L滑过的索引，那么出队，否则保持不动
 *
 * @Author: liangjiaqi
 * @Date: 2020/8/30 3:53 PM
 */
public class LeetCode_239_Sliding_window_Maximun2 {
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums==null || nums.length==0 || nums.length<k)return new int[0];


            int[] result = new int[nums.length -k + 1];
            // 队首为窗口中最大的值的下标
            Deque<Integer>  dequeue = new LinkedList<>();
            int left = 0;
            int right = 0;
            while(right<nums.length){
                // 入队逻辑
                if(dequeue.isEmpty()){
                    dequeue.offerLast(right);
                }else if(nums[dequeue.peekLast()]>nums[right]){
                    dequeue.offerLast(right);
                }else if(nums[dequeue.peekLast()]<=nums[right]){
                    dequeue.pollLast();
                    continue;
                }
                if(right-left<k-1){
                    // do nothing
                }else if(right-left==k-1){
                    result[left] = nums[dequeue.peekFirst()];
                    // 出队逻辑
                    if(dequeue.peekFirst()<= left){
                        dequeue.pollFirst();
                    }
                    left++;
                }
                right++;
            }
            return result;

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));

    }
}
