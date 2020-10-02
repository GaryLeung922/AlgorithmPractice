package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/29 8:57 AM
 */
public class LeetCode_088_MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for(int i=m;i<nums1.length;i++){
                nums1[i] = nums2[i-m];
            }
            Arrays.sort(nums1);
        }
    }
}
