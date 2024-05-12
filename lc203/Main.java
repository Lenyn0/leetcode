package lc203;
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
    int val;ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Main {

    public static void main(String[] args){

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode head_null=new ListNode();
        head_null.next=head;
        ListNode front=head_null;
        ListNode current=head;

        while (current!=null){
            if (current.val==val){
                front.next=current.next;
            }
            else {
                front=current;
            }
            current=current.next;
        }
        return head_null.next;
    }
}
