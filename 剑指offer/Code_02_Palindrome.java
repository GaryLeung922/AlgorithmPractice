package cn.xiaojiaqi.test;



public class Code_02_Palindrome {
    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        return rotatePartList(pHead);
    }
    public static boolean rotatePartList(ListNode pHead){
        int len = 0;
        ListNode p = pHead;
        while(p!=null){
            len++;
            p = p.next;
        }
        p = pHead;
        for(int i=0;i<(len+1)>>1;i++){
            p = p.next;
        }
        ListNode next=null;
        ListNode pre = null;
        while(p!=null){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        while(pre!=null){
            if(pHead.val!=pre.val)return false;
            pHead = pHead.next;
            pre = pre.next;
        }
        return true;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		//head.next.next.next.next = new ListNode(1);
		boolean res = isPalindrome(head);
		System.err.println(res);
	}
}