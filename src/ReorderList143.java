import java.util.*;


public class ReorderList143 {

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println("head"+node1);
        System.out.println("head"+node2);
        System.out.println("head"+node3);
        System.out.println("head"+node4);
        System.out.println("head"+node5);

        reorderList(node1);



    }

    public static void reorderList(ListNode head) {

        //first find the middle of the linkedlist
        ListNode startP=head;
       // ListNode prevToSlow=null;
        ListNode slowP = head;
        ListNode fastP = head;
        //Trying to find the second half of the linkedlist
        // so when fast pointer is at the end node or the end but one node
        //slow should be on the end of first half.
        //so for even number of nodes , slow the first of the middle two nodes
        // for odd number of nodes slow is the only middle node.
        while (fastP.next!=null && fastP.next.next!=null){
           // prevToSlow=slowP;
            slowP=slowP.next;
            fastP=fastP.next.next;

        }
       // System.out.println("prevToSlow"+prevToSlow);
       
        //mid of linkedlist is slowP
        //now reverse the linkedList
       System.out.println("slowP"+slowP);
       // for reversing pass the second half of the node..so slow.next
       ListNode tailP= reverse(slowP.next);
       //make slow.next as null otherwise there will be infinite loop link[both way link]
       slowP.next=null;
       System.out.println("tail"+tailP);
       System.out.println("startP"+startP);
      

      

       while(startP!=null && tailP!=null){
       ListNode nextToStartP = startP.next;
       ListNode prevToTailP =tailP.next;
       startP.next=tailP;
       tailP.next=nextToStartP;
       startP=nextToStartP;
       tailP=prevToTailP;
       //System.out.println("startP"+startP);
      // System.out.println("tailP"+tailP);
       }

       System.out.println("head"+head);
     
        
           
    }

    private static ListNode reverse(ListNode slowP) {

       

        ListNode prev= null;
        ListNode cur =slowP;
       
        while(cur!=null){
            ListNode next =cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
          
        }

        return prev;
        

       

         }
    
}
