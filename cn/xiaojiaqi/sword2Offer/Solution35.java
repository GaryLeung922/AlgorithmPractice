package cn.xiaojiaqi.sword2Offer;
/**
 * Definition for singly-linked list.
 * public static class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution35 {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode head;
        ListNode p;
        int res = l1.val+l2.val+c;
        if(res<10){
                head = new ListNode(res);
        }else{
                head = new ListNode(res%10);
                c = 1;
        }
        l1 = l1.next;
        l2 = l2.next;
        p = head;
        while(l1!=null&&l2!=null){
            res = l1.val+l2.val+c;
            c = 0;
            if(res<10){
                p.next = new ListNode(res);
            }else{
                p.next = new ListNode(res%10);
                c = 1;
            }
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            res = l1.val+c;
            c = 0;
            if(res<10){
                p.next = new ListNode(res);
            }else{
                p.next = new ListNode(res%10);
                c = 1;
            }
            p = p.next;
            l1 = l1.next;
        }
        while(l2!=null){
            res = l2.val+c;
            c = 0;
            if(res<10){
                p.next = new ListNode(res);
            }else{
                p.next = new ListNode(res%10);
                c = 1;
            }
            p = p.next;
            l2 = l2.next;
        }
        if(c==1){
            p.next = new ListNode(c);
        }
        return head;
    }
    public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		ListNode head = addTwoNumbers(l1, l2);
		System.out.println(head.val);
	}
}