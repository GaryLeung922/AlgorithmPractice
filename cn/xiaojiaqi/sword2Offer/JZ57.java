package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.TreeLinkNode;

/**
 * 二叉树的下一个结点
 * 题目描述:
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @Author: liangjiaqi
 * @Date: 2020/6/21 2:48 PM
 */
public class JZ57 {
    public static void main(String[] args) {

    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)return null;
        if(pNode.right==null){
            while(pNode.next!=null&&pNode.next!=pNode){
                if(pNode.next.left == pNode){
                    return pNode.next;
                }
                pNode = pNode.next;
            }
            return null;
        }else{
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
    }

}
