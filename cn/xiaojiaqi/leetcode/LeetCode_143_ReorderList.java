package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

import java.util.Collections;

/**
 * 重排链表
 * @Author: liangjiaqi
 * @Date: 2020/10/2 9:15 AM
 */
public class LeetCode_143_ReorderList {
    /**
     * 拆分成两段，反转第二段之后，依次插入
     */
    class Solution {
        public void reorderList(ListNode head) {
            if(head==null) return;
            int len = 0;
            ListNode p = head;
            while(p!=null){
                len++;
                p = p.next;
            }
            int trancate = len - (len-1)/2;

            // trancate from trancate index
            p = head;
            int c = 0;
            while(c!=trancate-1){
                c++;
                p = p.next;
            }
            // list2.head
            ListNode head2 = p.next;
            p.next = null;

            // revert list2
            head2 = revert(head2);


            // list2 insert into list
            p = head;
            ListNode p2 = head2;
            while(p2!=null){
                ListNode next1 = p.next;
                p.next = p2;
                ListNode next2 = p2.next;
                p2.next = next1;
                p = next1;
                p2 = next2;
            }
            return ;
        }

        private ListNode revert(ListNode head){
            if(head==null)return null;
            ListNode pre = head;
            ListNode p = head.next;
            ListNode next = null;
            if(p!=null){
                next = p.next;
            }
            pre.next = null;
            while(p!=null){
                p.next = pre;
                pre = p;
                p = next;
                if(next!=null){
                    next = next.next;
                }
            }
            return pre;
        }
    }
}
