package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists23 {

    //using PQ
    //https://www.youtube.com/watch?v=ptYUCjfNhJY&list=LL&index=1
    public ListNode mergeKLists(ListNode[] lists) {

    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new NodeComparator());

     //populate the PQ with head of all the given linkedList
     // at max size will be equal to k = size of the array
     // Note we are NOT populating the PQ with all the nodes of
     //all the linked list just he head nodes.

     for (ListNode node : lists){
        //check for null linkedlist inside the lists
        if(node!=null){pq.add(node);}
        
     }
     // Create the dummy node
     ListNode dummyNode = new ListNode(-1);
     ListNode cur = dummyNode ;
     

     while(!pq.isEmpty()){
      //get the node with min value
      ListNode min  = pq.poll();
      cur.next=min;
      cur=cur.next;
      //put the next node after head into PQ
      // if the linked list is finsihed then do not put null
      if(min.next!=null){
        pq.add(min.next);
      }


     }

     //return the head of the merged list

return dummyNode.next;

        
    }

    

}

 class ListNode {
         int val;
        ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     class NodeComparator implements Comparator<ListNode>{
             
        // Overriding compare()method of Comparator 
        @Override
        public int compare(ListNode n1, ListNode n2) {
            if (n1.val < n2.val)
                return -1;
            else if (n1.val > n2.val)
                return 1;
            
                return 0;
            }

      
    }

