package lc707;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class MyLinkedList {
    ListNode head;
    public MyLinkedList() {
        head=new ListNode();
        head.next=null;
    }

    public int get(int index) {
        if (index<0){
            return -1;
        }
        int count=0;
        ListNode current=head;
        while (current.next!=null){
            current=current.next;
            if (count==index){
                return current.val;
            }
            count++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode add=new ListNode(val);
        add.next=head.next;
        head.next=add;
    }

    public void addAtTail(int val) {
        ListNode add=new ListNode(val,null);

        ListNode current=head;
        while (current.next!=null){
            current=current.next;
        }
        current.next=add;
    }

    public void addAtIndex(int index, int val) {
        ListNode add=new ListNode(val);

        ListNode current=head;
        int count=0;
        while (current.next!=null){
            if (index==count){
                add.next=current.next;
                current.next=add;
                return;
            }
            current=current.next;
            count++;
        }
        if (index==count){
            current.next=add;
            add.next=null;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode current=head;
        int count=0;
        while (current.next!=null){
            if (index==count){
                current.next=current.next.next;
                return;
            }
            current=current.next;
            count++;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */