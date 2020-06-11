package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.ListNode;
/**
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Author: Gary Leung
 * @Date: 6/11/20 10:21 PM
 */
public class JZ55 {
    public static void main(String[] args) {

    }

    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }

        ListNode slow, fast;
        slow = pHead.next;
        fast = pHead;
        while (true){
            fast = fast.next;
            if(fast == null){
                return null;
            }
            fast = fast.next;
            if(fast == slow){
                fast = pHead;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            slow = slow.next;
        }
    }
}
