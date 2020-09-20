package cn.xiaojiaqi.leetcode;


import cn.xiaojiaqi.common.ListNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 5:08 PM
 */
public class LeetCode_002_AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            int add = 0;
            while (l1!=null&&l2!=null){
                int res = l1.val+l2.val+ add;
                if(res>=10){
                    add = 1;
                    res = res%10;
                }else {
                    add = 0;
                }
                cur.next = new ListNode(res);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1!=null){
                int res = l1.val+add;
                if(res>=10){
                    add = 1;
                    res = res%10;
                }else {
                    add = 0;
                }
                cur.next = new ListNode(res);
                cur = cur.next;
                l1 = l1.next;
            }
            while (l2!=null){
                int res = l2.val+add;
                if(res>=10){
                    add = 1;
                    res = res%10;
                }else {
                    add = 0;
                }
                cur.next = new ListNode(res);
                cur = cur.next;
                l2 = l2.next;
            }
            // 还要进位
            if(add!=0){
                cur.next = new ListNode(1);
            }
            return head.next;
        }
    }
}
