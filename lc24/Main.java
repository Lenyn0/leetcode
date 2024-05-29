package lc24;



//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Main {

    public static void main(String[] args) {

    }
    public ListNode swapPairs(ListNode head) {

        ListNode resultHead=new ListNode();
        resultHead.next=head;


        ListNode cur=head;
        ListNode pre=resultHead;
        while (cur!=null&&cur.next!=null){
            pre.next=cur.next;
            cur.next=cur.next.next;
            pre.next.next=cur;
            pre=cur;
            cur=cur.next;
        }

        return resultHead.next;

    }

}
