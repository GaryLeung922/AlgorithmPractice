package cn.xiaojiaqi.sword2Offer;


import cn.xiaojiaqi.common.*;
/**
 * 	删除链表中重复的结点
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author: Gary Leung
 * @Date: 6/11/20 10:09 PM
 */
public class JZ56 {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode head = pHead;
        ListNode pre = null, cur = pHead, next = cur.next;
        while(next != null){
            if(next.val == cur.val){
                while(next != null && next.val == cur.val){
                    next = next.next;
                }
                if(pre == null){
                    cur = next;
                    head = next;
                }else{
                    pre.next = next;
                    cur = next;
                }
                if(next == null){
                    break;
                }else {
                    next = next.next;
                }
            }else{
                pre = cur;
                cur = next;
                next = next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode node = deleteDuplication(head);


    }
}
