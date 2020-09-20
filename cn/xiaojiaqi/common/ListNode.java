package cn.xiaojiaqi.common;

/**
 * @Author: Gary Leung
 * @Date: 6/11/20 10:10 PM
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode constracture(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 反转链表的一部分
     * @param headPre head的前一个节点
     * @param head 反转开始的头
     * @param tail 反转开始的尾（不为null）
     */
    public static void reversePartial(ListNode headPre, ListNode head, ListNode tail){
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next==null?"null":next.val+""+
                '}';
    }

    public String print() {
        StringBuilder sb = new StringBuilder("ListNode{ ");
        ListNode cur = this;
        while (cur!=null){
            sb.append(cur.val+"->");
            cur = cur.next;
        }
        sb.append("null }");
       return sb.toString();
    }
}
