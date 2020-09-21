package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeNode;

/**
 * 重建二叉树
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Author: Gary Leung
 * @Date: 6/23/20 11:02 PM
 */
public class JZ04 {
    public static void main(String[] args) {
        JZ04 jz04 = new JZ04();

        TreeNode node = jz04.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return redo(pre,in,0,pre.length-1,0,in.length-1);
    }
    // 分治+递归思想
    public TreeNode redo(int[] pre, int[] in, int pl, int pr, int il, int ir){
        if(pr-pl==0){
            return new TreeNode(pre[pr]);
        }else if(pr-pl<=0){
            return null;
        }
        TreeNode cur = new TreeNode(pre[pl]);
        int index = il;
        while(index<ir){
            if(in[index]!=pre[pl]){
                index++;
            }else{
                break;
            }
        }
        cur.left = redo(pre,in,pl+1,pl+(index-il),il,index-1);
        cur.right = redo(pre,in,pr-(ir-index)+1,pr,index+1,ir);
        return cur;
    }
}
