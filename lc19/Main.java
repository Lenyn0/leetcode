package lc19;



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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resultHead=new ListNode();
        resultHead.next=head;

        ListNode pre_n=resultHead;
        ListNode cur=resultHead;
        while (cur!=null){
            cur=cur.next;
            if (n<0){
              pre_n=pre_n.next;
            }
            n--;
        }
        pre_n.next=pre_n.next.next;
        return  resultHead.next;

    }
}