package lc206;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode resultHead=new ListNode(0,null);
        while (head!=null){
            ListNode add=new ListNode(head.val);
            add.next=resultHead.next;
            resultHead.next=add;
            head=head.next;
        }
        return resultHead.next;
    }

    //双指针
    public ListNode reverseList_1(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    //递归
    public ListNode reverseList_2(ListNode head) {
        return reverse(null,head);
    }

    public ListNode reverse(ListNode pre,ListNode cur){
        if (cur==null){
            return pre;
        }
        ListNode next=cur.next;

        cur.next=pre;
        reverse(cur,next);
        return null;
    }
}
