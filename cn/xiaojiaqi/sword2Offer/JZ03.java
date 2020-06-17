package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.ListNode;

import java.util.ArrayList;

/**
 * 从尾到头打印链表:
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author: liangjiaqi
 * @Date: 2020/6/15 8:01 AM
 */
public class JZ03 {
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        recursion(listNode);
        return res;
    }

    public void recursion(ListNode listNode){
        if(listNode == null){
            return;
        }
        recursion(listNode.next);
        res.add(listNode.val);
    }
}
