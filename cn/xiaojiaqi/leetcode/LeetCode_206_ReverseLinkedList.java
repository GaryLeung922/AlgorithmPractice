package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 2:56 PM
 */
public class LeetCode_206_ReverseLinkedList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null)return null;
            ListNode p = head;
            ListNode cur = head.next;
            ListNode n = null;
            if(cur!=null){
                n = cur.next;
            }

            while (cur!=null){
                cur.next = p;
                p = cur;
                cur = n;
                if(n!=null){
                    n = n.next;
                }
            }
            head.next = null;
            return p;
        }
    }
}
