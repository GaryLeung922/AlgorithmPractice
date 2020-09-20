package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.TreeNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 12:56 PM
 */
public class LeetCode_124_BinaryTreeMaximumPathSum {
    class Solution {
        public int maxPathSum(TreeNode root) {
            if(root==null)return 0;
            Result result = maxPath(root);
            return result.most;
        }


        public Result maxPath(TreeNode root){
            if(root==null)return null;

            Result left = maxPath(root.left);
            Result right = maxPath(root.right);

            /**
             * 局部最优的可能情况：
             * 1. 左子树的partial+自己的val
             * 2. 右子树的partial+自己的val
             * 3. 自己的val(左右子树的partial都为负)
             */
            int partial =  root.val;
            if(left!=null){
                partial = Math.max(left.partial+root.val, partial);
            }
            if(right!=null){
                partial = Math.max(right.partial+root.val, partial);
            }

            /**
             * 全局最优的可能情况：
             * 0. 当前root.val
             * 1. 当前子树的partial
             * 2. 左子树的most
             * 3. 右子树的most
             * 4. 左子树的partial + root.val + 右子树的partial
             */
            int most = Math.max(root.val,partial);

            if(left!=null){
                most = Math.max(left.most, most);
            }
            if(right!=null){
                most = Math.max(right.most, most);
            }
            if(left!=null&&right!=null){
                most = Math.max(most,left.partial+root.val+right.partial);
            }
            return new Result(partial, most);
        }
    }


    class Result{
        /**
         * 局部最优的路径, 一定包含当前节点
         */
        public int partial;
        /**
         * 全局最优。以当前节点为根节点的子树，全局最大路径和
         */
        public int most;

        public Result(int partial, int most) {
            this.partial = partial;
            this.most = most;
        }

        public Result() {

        }
    }
}
