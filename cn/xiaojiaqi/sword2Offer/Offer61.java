package cn.xiaojiaqi.sword2Offer;

/**
 * 扑克牌中的顺子
 * @Author: liangjiaqi
 * @Date: 2020/10/3 9:56 AM
 */
public class Offer61 {
    /**
     * 利用辅助数组， 其实也可以先排序然后直接干
     * 时间O(n) 空间O(n)
     */
    class Solution {
        public boolean isStraight(int[] nums) {
            if(nums==null || nums.length!=5)return false;
            // 最小的牌
            int min = 100;
            // 大小王的个数
            int zeroCount = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    zeroCount++;
                }else{
                    min = Math.min(min,nums[i]);
                }
            }
            // 如果最小牌>=10，那么重制为9， 因为顺子不可能从10开始
            if(min>9){
                min = 9;
            }
            int[] help = new int[5];

            for(int i=0;i<nums.length;i++){
                // 如果nums[i] 太大，则肯定不在顺子中
                if(nums[i]!=0 && nums[i]-min<=4){
                    help[nums[i]-min] = 1;
                }
            }
            for(int i=0;i<help.length;i++){
                if(help[i]==0){
                    zeroCount--;
                }
            }
            return zeroCount>=0;
        }
    }
}
