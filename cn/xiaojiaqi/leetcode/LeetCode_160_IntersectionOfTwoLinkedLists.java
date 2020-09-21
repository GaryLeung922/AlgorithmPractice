package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/21 12:36 PM
 */
public class LeetCode_160_IntersectionOfTwoLinkedLists {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode h1 = headA;
            ListNode h2 = headB;

            int l1 = 0;
            int l2 = 0;
            while (h1!=null){
                h1 = h1.next;
                l1++;
            }
            while (h2!=null){
                h2 = h2.next;
                l2++;
            }
            if(l1==0||l2==0)return null;
            h1 = headA;
            h2 = headB;
            if(l1>l2){
                while (l1!=l2){
                    h1 = h1.next;
                    l1--;
                }
            }else{
                while (l1!=l2){
                    h2 = h2.next;
                    l2--;
                }

            }
            while (h1!=h2 && h1!=null){
                h1 = h1.next;
                h2 = h2.next;
            }
            return h1;
        }
    }
}
