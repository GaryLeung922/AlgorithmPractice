package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.ListNode;

/**
 * 反转链表：
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @Author: liangjiaqi
 * @Date: 2020/6/15 7:35 AM
 */
public class JZ15 {

    public static void main(String[] args) {

    }

    public static ListNode ReverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = null;
        ListNode c = head;
        while(c!=null){
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
}
