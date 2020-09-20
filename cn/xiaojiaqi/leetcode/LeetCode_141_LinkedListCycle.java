package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 5:18 PM
 */
public class LeetCode_141_LinkedListCycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            return cycle(head)==null ? false : true;
        }

        public ListNode cycle(ListNode head){
            if(head==null)return head;
            ListNode fast = head;
            ListNode slow = head;

            while (fast!=null){
                fast = fast.next;
                if(fast==null){
                    return null;
                }
                fast = fast.next;
                slow = slow.next;
                if(slow==fast){
                    break;
                }
            }
            if(fast==null)return null;
            fast = head;
            while (fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
