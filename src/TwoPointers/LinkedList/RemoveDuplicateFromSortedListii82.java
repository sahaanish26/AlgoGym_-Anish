package TwoPointers.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedListii82 {

    public ListNode deleteDuplicates(ListNode head) {

        //create a dummy node
        ListNode dummy = new ListNode(-200);
        //attach the dummy node to actual head node
        dummy.next=head;
        // Initialy reference dummy node with prev
        ListNode prev = dummy;
         // Initialy reference head node with current
        ListNode current = head;
      //  ListNode future = current.next;
        if(current==null)
        return null;
        
        //if there is only one node then no chance of duplicate
        if(current.next==null)
        return head;
        
        //set to maintain the numbers to be deleted when all duplicate instances of it except this one is deleted. 
        //this is the hard requirement of the problem and diff with problem 83
        Set<Integer> numberSet = new HashSet<>();
        
       while (current!=null){
        // we can optimize the space by removing the set, may be we need another pointer to optimize
        if( (current.next!=null && current.val==current.next.val) || numberSet.contains(current.val)){
            //remove current 
            numberSet.add(current.val);
        //first needs to be removed.
        ListNode future =current.next;
        current.next=null;
        current =future;
        prev.next=current;
       


        }
        else{
            current =current.next;
            prev=prev.next;

        }
    }

        


            return dummy.next;
        
       
    }

}

 class ListNode {
        int val;
        ListNode next;
        ListNode() {}
       ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
