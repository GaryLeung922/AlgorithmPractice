package cn.xiaojiaqi.leetcode;

/**
 * 寻找峰值
 * @Author: liangjiaqi
 * @Date: 2020/9/29 9:17 AM
 */
public class LeetCode_162_FindPeakElement {
    /**
     * 二分法，哪边大走哪边， 两边都大，随便走一边
     * 画个图就很好理解。 峰值一定在大的那边
     */
    static class Solution {
        public int findPeakElement(int[] nums) {
            if(nums==null || nums.length==0)return -1;

            int L = 0;
            int R = nums.length;
            while (L<R){
                int mid = L+(R-L)/2;
                boolean t1 = mid-1>=0 ? nums[mid-1]<nums[mid] : true;
                boolean t2 = mid+1<nums.length ? nums[mid]>nums[mid+1] : true;
                if(t1&&t2){
                    return mid;
                }
                if(!t1){
                    R = mid;
                }else {
                    L = mid+1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3,1};
        int peakElement = solution.findPeakElement(nums);
        System.out.println(peakElement);
    }
}
