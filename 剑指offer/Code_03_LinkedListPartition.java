package cn.xiaojiaqi.test;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Code_03_LinkedListPartition {
    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode p = pHead;
        ListNode less = null;
        ListNode equal = null;
        ListNode more = null;
        while(p!=null){
            if(p.val<x){
                less = less==null ? p : less;
            }else if(p.val>x){
                more = more==null ? p : more;
            }else{
                equal = equal==null ? p : equal;
            }
            p = p.next;
        }
        ListNode le = less;
        ListNode eq = equal;
        ListNode mo = more;
        p = pHead;
        while(p!=null){
            if(p.val<x&&p!=less){
                le.next = p;
                le = le.next;
            }else if(p.val>x&&p!=more){
                mo.next = p;
                mo = mo.next;
            }else if(p.val==x&&p!=equal){
                eq.next = p;
                eq = eq.next;
            }
            p = p.next;
        }
        if(less==null&&equal!=null){
            eq.next = more;
            if(more!=null)mo.next=null;
            return equal;
        }else if(less==null&&equal==null){
            if(mo!=null)mo.next=null;
            return more;
        }else if(less!=null&&equal==null){
            le.next = more;
            if(mo!=null)mo.next=null;
            return less;
        }else if(less!=null&&equal!=null){
            le.next = equal;
            eq.next = more;
            if(mo!=null)mo.next=null;
            return less;
        }
        return pHead;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(6);
		head.next = new ListNode(2);
		head.next.next = new ListNode(8);
		ListNode p = partition(head, 4);
		StringBuilder s = new StringBuilder();
		s.append("sadf");
		char[] chs = {'1','2','3'};
		
		
	}
}