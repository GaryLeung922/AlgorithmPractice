package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.ListNode;

/**
 * 链表中倒数第k个结点：
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @Author: liangjiaqi
 * @Date: 2020/6/15 7:55 AM
 */
public class JZ14 {

    // 缺陷：没有考虑有环的情况
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<k;i++){
            if(fast==null)return null;
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
