package cn.xiaojiaqi.leetcode;
public class Solution55 {
    // DP
    public static boolean canJumpDP(int[] nums) {
        int target = nums.length-1;
        int begin = 0;
        if(begin==target)return true;
        
        boolean[] dp = new boolean[nums.length];
        dp[dp.length-1] = true;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=1;j<=nums[i]&&i+j<nums.length;j++){
                if(dp[i+j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0]; 
    }
    // Greedy
    public static boolean canJump(int[] nums) {
        int target = nums.length-1;
        int begin = 0;
        if(begin==target)return true;
        
        //贪心策略：
        //假设当前位置为b,下一步考虑跳的位置为p,如果pMax>bMax,那就跳
        while(begin<target){
            if(nums[begin]==0)return false;
            int i=1;
            int size = nums[begin];
            for(;i<=size;i++){
                if(begin+i>=target)return true;
                if(nums[begin+i]+i>nums[begin]){
                    begin = begin+i;
                    break;
                }
            }
            if(i>size){//如果走不了更远，说明不能到最后
                return false;
            }
            
        }
        return true;
        
    }
    public static void main(String[] args) {
		int[] nums = {1,1,2,2,0,1,1};
		
		boolean flag = canJump(nums);
		System.out.println(flag);
	}
    
}