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
}
