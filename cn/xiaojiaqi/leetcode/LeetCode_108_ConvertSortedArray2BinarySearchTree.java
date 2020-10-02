package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.SerAndDeSer;
import cn.xiaojiaqi.common.TreeNode;

/**
 * 把有序数组转化为平衡搜索二叉树
 * @Author: liangjiaqi
 * @Date: 2020/9/29 8:22 AM
 */
public class LeetCode_108_ConvertSortedArray2BinarySearchTree {
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums==null || nums.length==0)return null;

            return help(nums, 0, nums.length);
        }

        public TreeNode help(int[] nums, int start, int end){
            if(start>=end)return null;

            int mid = start+(end-start)/2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = help(nums,start,mid);
            root.right = help(nums,mid+1,end);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-10,-3,0,5,9};

        TreeNode node = solution.sortedArrayToBST(nums);

        SerAndDeSer.printTree(node);

    }
}
