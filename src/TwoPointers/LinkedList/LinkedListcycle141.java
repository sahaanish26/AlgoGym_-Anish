package TwoPointers.LinkedList;

public class LinkedListcycle141 {


    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        // slow will go one time
        // fast will go two times
        //check needs to be on both fast and fast.next
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next; 
            if(slow==fast) {
                return true;
            }  
        }


        


        return false;
        
    }




}


class ListNode {
         int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
 }
