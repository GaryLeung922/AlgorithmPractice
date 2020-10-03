package cn.xiaojiaqi.leetcode;

import cn.xiaojiaqi.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个有序列表
 * @Author: liangjiaqi
 * @Date: 2020/10/3 8:49 AM
 */
public class LeetCode_023_MergeKSortedLists {
    /**
     * 解法一：
     * 利用 priorityQueue 取出K个链表的头节点的最小值
     * 时间复杂度O(Nlogk) 空间O(k)
     * N 为总的节点数
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0)return null;
            if(lists.length==1)return lists[0];

            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if(o1.val<o2.val){
                        return -1;
                    }else if(o1.val>o2.val){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            });
            ListNode head = new ListNode(-1);
            ListNode p  =head;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                    queue.add(lists[i]);
                }
            }
            while (!queue.isEmpty()){
                ListNode node = queue.poll();
                p.next = node;
                p = p.next;
                if(node.next!=null){
                    queue.add(node.next);
                }
            }
            return head.next;
        }
    }

    /**
     * 解法二： 类似于merge, 分治
     * 时间O(Nlogk) 空间O(1)
     * https://leetcode.com/problems/merge-k-sorted-lists/solution/
     */
    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            return partition(lists, 0, lists.length-1);
        }

        private ListNode partition(ListNode[] lists, int start, int end){
            if(start==end)return lists[start];
            if(start<end){
                int mid = start+(end-start)/2;
                ListNode left = partition(lists, start, mid);
                ListNode right = partition(lists, mid+1, end);
                return merge(left, right);
            }else {
                return null;
            }
        }

        private ListNode merge(ListNode l1, ListNode l2){
            if(l1==null)return l2;
            if(l2==null)return l1;

            ListNode head = new ListNode(-1);
            ListNode p = head;
            while (l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    p.next = l1;
                    l1 = l1.next;
                }else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            while (l1!=null){
                p.next = l1;
                l1 = l1.next;
                p  =p.next;
            }
            while (l2!=null){
                p.next = l2;
                l2 = l2.next;
                p  =p.next;
            }
            return head.next;
        }
    }
}
