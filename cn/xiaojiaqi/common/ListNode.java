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
}
