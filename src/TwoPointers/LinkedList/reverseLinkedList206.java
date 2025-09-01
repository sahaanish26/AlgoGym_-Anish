package TwoPointers.LinkedList;

public class reverseLinkedList206 {

    //concept :https://www.youtube.com/watch?v=G0_I-ZF0S38

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur =head;

        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;

        }

        return prev;
        
    }

}
