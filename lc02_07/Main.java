package lc02_07;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Main {
    public static void main(String[] args) {

        // Creating the intersection node
        ListNode intersection = new ListNode(8, new ListNode(10));

        // Creating first linked list: 4 -> 1 -> 8 -> 10
        ListNode headA = new ListNode(4, new ListNode(1, intersection));

        // Creating second linked list: 5 -> 0 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(7, intersection)));

        // Calling the method to find intersection
        Main main = new Main();
        ListNode intersectionNode = main.getIntersectionNode(headA, headB);

        // Printing the intersection node
        if (intersectionNode != null) {
            System.out.println("Intersection Node value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection node found.");
        }
        while (headA!=null){
            System.out.println(headA.val);
            headA=headA.next;
        }
        while (headB!=null){
            System.out.println(headB.val);
            headB=headB.next;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result=null;
        ListNode curA=headA;
        ListNode curB=headB;

        while (curA!=null||curB!=null){
            if (curA!=null){
                if (curA.val<0){
                    result= curA;
                    result.val=-1*result.val-1;
                    break;
                }
                curA.val=-1*curA.val-1;
                curA=curA.next;
            }
            if (curB!=null){
                if (curB.val<0){
                    result= curB;
                    result.val=-1*result.val-1;
                    break;
                }
                curB.val=-1*curB.val-1;
                curB=curB.next;
            }
        }
        curA=headA;
        curB=headB;
        while (curA!=null){
            if (curA.val<0){
                curA.val=-1*curA.val-1;
            }
            curA=curA.next;
        }
        while (curB!=null&&curB.val<0){
            if (curB.val<0){
                curB.val=-1*curB.val-1;
            }
            curB=curB.next;
        }

        return result;
    }

    public ListNode getIntersectionNode_cite(ListNode headA, ListNode headB){
        //ListNode result=null;

        ListNode curA=headA;
        ListNode curB=headB;
        int lengthA=0;
        int lengthB=0;
        while(curA!=null){
            lengthA++;
            curA=curA.next;
        }
        while(curB!=null){
            lengthB++;
            curB=curB.next;
        }

        curA=headA;
        curB=headB;
        if (lengthA>lengthB){
            int count=lengthA-lengthB;
            while (count>0){
                curA=curA.next;
                count--;
            }
        }
        else {
            int count=lengthB-lengthA;
            while (count>0){
                curB=curB.next;
                count--;
            }
        }
        while (curA!=curB&&curA!=null){
            curA=curA.next;
            curB=curB.next;
        }

        return curA;
    }
}
