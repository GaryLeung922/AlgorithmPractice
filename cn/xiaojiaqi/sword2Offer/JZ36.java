package cn.xiaojiaqi.sword2Offer;

import cn.xiaojiaqi.common.ListNode;

/**
 * 两个链表的第一个公共结点:
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @Author: liangjiaqi
 * @Date: 2020/6/17 7:28 AM
 */
public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null)return null;
        ListNode c1 = hasCircle(pHead1);
        ListNode c2 = hasCircle(pHead2);
        if(c1==null && c2!= null){
            return null;
        }else if(c1!=null && c2==null){
            return null;
        }else if(c1!=null && c2!=null){
            if(c1 != c2){
                ListNode tmp = c1;
                while(tmp!=c1){
                    if(tmp==c2){
                        return c2;
                    }
                    tmp = tmp.next;
                }
                return null;
            }else{
                return firstCommonNode(pHead1,pHead2,c1,c2);
            }
        }else{
            return firstCommonNode(pHead1,pHead2,null,null);
        }
    }
    public ListNode hasCircle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            fast = fast.next;
            if(fast==null){
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null){
            return null;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode firstCommonNode(ListNode pHead1, ListNode pHead2, ListNode t1, ListNode t2){
        ListNode p1=pHead1,p2=pHead2;
        int L1=1,L2=1;
        while(p1.next!=t1 && p2.next!=t2){
            p1 = p1.next;
            L1++;
            p2 = p2.next;

        }
        if(p1.next == t1){
            while(p2.next!=t2){
                p2 = p2.next;
                L2++;
            }
        }
        if(p2.next == t2){
            while(p1.next!=t1){
                p1 = p1.next;
                L1++;
            }
        }
        if(p1!=p2){
            return null;
        }
        p1=pHead1;p2=pHead2;
        if(L1>L2){
            for(int i=0;i<L1-L2;i++){
                p1 = p1.next;
            }
            while(p1!=p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }else{
            for(int i=0;i<L2-L1;i++){
                p2 = p2.next;
            }
            while(p2!=p1){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
    }
}
