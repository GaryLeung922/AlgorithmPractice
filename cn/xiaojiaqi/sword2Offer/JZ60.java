package cn.xiaojiaqi.sword2Offer;

import java.lang.reflect.Array;
import java.util.*;
/**
 * 把二叉树打印成多行
 * 题目描述：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @Author: liangjiaqi
 * @Date: 2020/6/21 10:28 AM
 */
public class JZ60 {

    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeNode cur = pRoot;
        TreeNode mostRight = pRoot;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> level = new ArrayList<>();
        if(pRoot == null)return null;
        queue.offer(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            level.add(cur.val);
            if(cur.left!=null) queue.offer(cur.left);
            if(cur.right!=null) queue.offer(cur.right);
            if(mostRight == cur){
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
