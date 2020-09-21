package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树
 * 题目描述:
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @Author: liangjiaqi
 * @Date: 2020/6/21 10:44 AM
 */
public class JZ59 {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeNode cur = pRoot;
        TreeNode mostRight = pRoot;
        int levels = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> level = new ArrayList<>();
        if(pRoot == null)return result;
        queue.offer(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(levels%2==0){
                level.add(0,cur.val);
            }else {
                level.add(cur.val);
            }
            if(cur.left!=null) queue.offer(cur.left);
            if(cur.right!=null) queue.offer(cur.right);

            if(mostRight == cur){
                levels++;
                result.add(level);
                level = new ArrayList<>();
                if(cur.right!=null){
                    mostRight = cur.right;
                }else {
                    mostRight = cur.left;
                }
            }
        }
        return result;
    }
}
