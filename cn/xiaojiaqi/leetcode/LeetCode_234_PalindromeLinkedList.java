package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 5:28 PM
 */
public class LeetCode_234_PalindromeLinkedList {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head==null)return true;
            int len = 0;
            ListNode cur = head;
            while (cur!=null){
                cur = cur.next;
                len++;
            }
            int k=0;
            cur = head;
            while (k<(len+1)/2){
                cur = cur.next;
                k++;
            }
            ListNode head2 = reverse(cur);
            cur = head;
            while (head2!=null){
                if(cur.val!=head2.val)return false;
                cur = cur.next;
                head2 = head2.next;
            }
            return true;

        }

        private ListNode reverse(ListNode head){
            if(head==null)return null;
            ListNode p = head;
            ListNode c = head.next;
            ListNode n = null;
            if(c!=null){
                n = c.next;
            }
            while (c!=null){
                c.next = p;
                p = c;
                c = n;
                if(n!=null){
                    n = n.next;
                }
            }
            head.next = c;
            return p;
        }
    }
}
