package cn.xiaojiaqi.sword2Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，
 * 按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @Author: liangjiaqi
 * @Date: 2020/6/22 7:53 AM
 */
public class JZ24 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)return result;
        findPath(root, target);
        return result;
    }
    public void findPath(TreeNode root, int target){

        path.add(root.val);
        if(root.left==null && root.right==null){
            if(target == root.val){
                result.add(new ArrayList(Arrays.asList(path)));
            }
            path.remove(path.size()-1);
            return;
        }else {
            if(root.left!=null){
                findPath(root.left, target-root.val);
            }
            if(root.right!=null){
                findPath(root.right, target-root.val);
            }

        }
    }
}
