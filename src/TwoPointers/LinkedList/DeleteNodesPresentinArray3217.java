package TwoPointers.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesPresentinArray3217 {

    public ListNode modifiedList(int[] nums, ListNode head) {



         //set to maintain the numbers to be deleted 
        Set<Integer> numberSet = new HashSet<>();

         for(int i=0;i<nums.length;i++){
            numberSet.add(nums[i]);
         }
         //create a dummy node
        ListNode dummy = new ListNode(-200);
        //attach the dummy node to actual head node
        dummy.next=head;
        // Initialy reference dummy node with prev
        ListNode prev = dummy;
         // Initialy reference head node with current
        ListNode current = head;
      
        
       
        
       while (current!=null){
        // we can optimize the space by removing the set, may be we need another pointer to optimize
        if( numberSet.contains(current.val)){
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

