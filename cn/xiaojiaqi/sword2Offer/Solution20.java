package cn.xiaojiaqi.sword2Offer;
public class Solution20 {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1!=null&&list2!=null){
            ListNode head=null;
            ListNode p;
            if(list1.val<=list2.val){
                head = list1;
                list1 = list1.next;
            }else{
                head = list2;
                list2 = list2.next;
            }
            p = head;
            while(list1!=null&&list2!=null){
                if(list1.val<=list2.val){
                    p.next = list1;
                    list1 = list1.next;
                    p = p.next;
                }else{
                    p.next = list2;
                    list2 = list2.next;
                    p = p.next;

                }
            }
            while(list1!=null){
                p.next = list1;
                list1 = list1.next;
                p = p.next;

            }
            while(list2!=null){
                p.next = list2;
                list2 = list2.next;
                p = p.next;

            }
            return head;
        }
        return list1==null?(list2==null?null:list2):list1;
    }
    public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(3);
		list1.next.next = new ListNode(5);
		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(4);
		list2.next.next = new ListNode(6);
		ListNode head = Merge(list1, list2);
	}
}