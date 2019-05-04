package cn.xiaojiaqi.leetcode;

import java.util.Stack;

public class Solution581 {
    public static int findUnsortedSubarray(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        int left = Integer.MAX_VALUE;
        int right = -1;
        stack.push(0);
        for(int i=1;i<nums.length;i++){
            if(stack.isEmpty()||nums[stack.peek()]<=nums[i]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                    help.push(stack.pop());
                }
                stack.push(i);
                left = left>help.peek() ? help.peek() : left;
                right = i;
                while(!help.isEmpty()){
                    stack.push(help.pop());
                }
            }
        }
        return right-left+1;
    }
    public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		int ans = findUnsortedSubarray(nums);
		System.out.println(ans);
	}
    
}