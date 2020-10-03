package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

/**
 * 删除有序链表中的重复元素
 * @Author: liangjiaqi
 * @Date: 2020/10/3 9:45 AM
 */
public class LeetCode_083_RemoveDuplicatesFromSortedList {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null)return head;

            ListNode p = head;
            ListNode cur = p.next;
            while(cur!=null){
                while(cur!=null && cur.val==p.val){
                    cur = cur.next;
                }
                p.next = cur;
                p = cur;
                cur = cur==null ? null : cur.next;
            }
            return head;
        }
    }
}
