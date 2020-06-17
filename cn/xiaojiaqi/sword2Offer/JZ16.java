package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.ListNode;

/**
 * 合并两个排序的链表:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author: liangjiaqi
 * @Date: 2020/6/15 7:43 AM
 */
public class JZ16 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)return list2;
        if(list2 == null)return list1;

        ListNode head;
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        ListNode p = head;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                head.next = list1;
                list1 = list1.next;
            }else{
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1!=null){
            head.next = list1;
        }else{
            head.next = list2;
        }

        return p;
    }
}
