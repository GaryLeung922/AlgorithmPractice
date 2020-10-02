package cn.xiaojiaqi.leetcode;

/**
 * 第一个缺失的正整数
 * @Author: liangjiaqi
 * @Date: 2020/9/29 4:39 PM
 */
public class LeetCode_041_FirstMissingPositive_02 {
    /**
     *
     */
    static class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) return 1;

            int len = nums.length / 32 + 1;

            int[] help = new int[len];

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 1 && nums[i] <= nums.length) {
                    put(help, nums[i] - 1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (get(help, i) != 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        private void put(int[] nums, int index) {
            int a = index / 32;
            int b = index % 32;

            nums[a] = (nums[a] | 1 << b);
        }

        private int get(int[] nums, int index) {
            int a = index / 32;
            int b = index % 32;

            return (nums[a] & 1 << b) > 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{99,94,96,11,92,5,91,89,57,85,66,63,84,81,79,61,74,78,77,30,
                64,13,58,18,70,69,51,12,32,34,9,43,39,8,1,38,49,27,21,45,47,44,53,52,48,19,
                50,59,3,40,31,82,23,56,37,41,16,28,22,33,65,42,54,20,29,25,10,26,4,60,67,83,
                62,71,24,35,72,55,75,0,2,46,15,80,6,36,14,73,76,86,88,7,17,87,68,90,95,93,97,98};
        
        Solution solution = new Solution();
        int positive = solution.firstMissingPositive(nums);
        System.out.println(positive);
    }
}
