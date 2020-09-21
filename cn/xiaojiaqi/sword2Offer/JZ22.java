package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Author: Gary Leung
 * @Date: 6/17/20 9:46 PM
 */
public class JZ22 {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.size();
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while(queue.size()>0){
            TreeNode p = queue.poll();
            result.add(Integer.valueOf(p.val));
            if(p.left!=null){
                queue.add(p.left);
            }
            if(p.right!=null){
                queue.add(p.right);
            }
        }
        return result;
    }
}
