package lc142;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited=new HashSet<ListNode>();
        ListNode cur=head;
        while (cur!=null){
            if (visited.contains(cur)){
                return cur;
            }
            visited.add(cur);
            cur=cur.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        ListNode love=null;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                love=fast;
                break;
            }
        }
        if (love!=null){
            ListNode temp=head;
            while (temp!=love){
                temp=temp.next;
                love=love.next;
            }
        }
        return love;
    }

}
