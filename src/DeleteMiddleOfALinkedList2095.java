public class DeleteMiddleOfALinkedList2095 {


    public static void main(String[] args){


    }

    public static ListNode deleteMiddle(ListNode head) {
        //creating dummy node since it involves deletion of node.
        ListNode dummy = new ListNode(-1,head);
        ListNode slowP = dummy;
        ListNode fastP = dummy;

        while(fastP.next!=null&& fastP.next.next!=null){
            slowP=slowP.next;
            fastP=fastP.next.next;

        }
        //slow is the first middle for even or prev to middle for even.
        //we have to remove slow.next

        ListNode secondHalfStart = slowP.next.next;
        slowP.next.next=null;
        slowP.next=secondHalfStart;
        return dummy.next;



     

    }
    
}
