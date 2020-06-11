package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode_148_Sort_List {
    public static ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null) {
        	list.add(p);
        	p = p.next;
        }
        Collections.sort(list,new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				
				return o1.val-o2.val;
			}});
        ListNode newHead = list.get(0);
        p = newHead;
        for(int i=1;i<list.size();i++) {
        	p.next = list.get(i);
        	p = p.next;
        }
        p.next = null;
        return newHead;
    }
// 快排 之ListNode
    
    public ListNode sortList2(ListNode head) {
        if(head==null)return head;
        
        return partition(head);
    }
    public ListNode partition(ListNode head){
        if(head==null||head.next==null)return head;
        
        int pivot = head.val;
        
        ListNode less = null;
        ListNode equal = null;
        ListNode more = null;
        ListNode p = head;
        while(p!=null){
            if(p.val<pivot){
                less = less==null ? p : less;
            }else if(p.val>pivot){
                more = more==null ? p : more;
            }else{
                equal = equal==null ? p : equal;
            }
            p = p.next;
        }
        p = head;
        ListNode lep = less;
        ListNode eqp = equal;
        ListNode mop = more;
        while(p!=null){
            if(p.val<pivot&&less!=p){
                lep.next = p;
                lep = p;
            }else if(p.val>pivot&&more!=p){
                mop.next = p;
                mop = p;
            }else if(p.val==pivot&&equal!=p){
                eqp.next = p;
                eqp = p;
            }
            p = p.next;
        }
        if(less!=null)lep.next = null;
        if(equal!=null)eqp.next = null;
        if(more!=null)mop.next = null;
        
        if(lep!=null){
            ListNode left = partition(less);
            p = left;
            while(p.next!=null){
                p = p.next;
            }
            p.next = equal;
            eqp.next = partition(more);
            return left;
        }else{
            eqp.next = partition(more);
            return equal;
        }
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		ListNode newHead = sortList(head);
		
		while(newHead!=null) {
			System.out.print(newHead.val);
			newHead = newHead.next;
		}
	}
}