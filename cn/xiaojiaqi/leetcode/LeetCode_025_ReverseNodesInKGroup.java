package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 9:34 AM
 */
public class LeetCode_025_ReverseNodesInKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            //if(k<=1)return head;
            // 假头节点，为了更方便获得反转后的节点
            ListNode fakeHead = new ListNode(0);
            ListNode pHeadPre = fakeHead;
            ListNode pHead = head;
            ListNode pTail = head;
            int i = 1;
            for(ListNode cur=head; cur!=null; cur = cur.next,i++){
                if(i%k==0){
                    pTail = cur;
                    reverse(pHeadPre,pHead,pTail);
                    // 局部反转之后，cur已来到头部位置，需要重置为尾部位置
                    cur = pHead;
                    pHeadPre = pHead;
                    pHead = pHead.next;
                }
            }
            return fakeHead.next;
        }

        /**
         * 反转链表的一部分
         * @param headPre head的前一个节点
         * @param head 反转开始的头
         * @param tail 反转开始的尾（不为null）
         */
        private void reverse(ListNode headPre, ListNode head, ListNode tail){
            ListNode p = head;
            ListNode pivot = tail.next;
            ListNode c = head.next;
            ListNode n = null;
            if(c!=null){
                n = c.next;
            }
            while (c!=pivot){
                c.next = p;
                p = c;
                c = n;
                if(n!=null){
                    n = n.next;
                }
            }
            head.next = pivot;
            if(headPre!=null){
                headPre.next = tail;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = ListNode.constracture(new int[]{1, 2, 3, 4, 5});

        System.out.println(listNode.print());

        int k =1;
        ListNode node = solution.reverseKGroup(listNode, k);

        System.out.println(node.print());
    }
}
