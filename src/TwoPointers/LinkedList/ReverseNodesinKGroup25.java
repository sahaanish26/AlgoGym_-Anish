package TwoPointers.LinkedList;




public class ReverseNodesinKGroup25 {


    public static void main (String[] args){

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

        System.out.println(reverseKGroup(node1,2));


    }


    public static  ListNode reverseKGroupOld(ListNode head, int k) {
     

      //create the dummy node
      ListNode dummyNode = new ListNode(-1,head);
      // previous node to the start to window
      ListNode prevtoStartWindow = dummyNode;
      //declare both start and end to head.
      ListNode startWindow = head;
      ListNode endWindow = head;
      
      int counter =1;
      while(counter<k){
        counter++;
        endWindow=endWindow.next;
        
      }
      if(endWindow==null){
        return head;
      }
      ListNode nextToEndWindow = endWindow.next;

      while(endWindow!=null){
        
        prevtoStartWindow.next=null;
        endWindow.next=null;
        System.out.println("endWindow"+endWindow);
       
        ListNode tail = reverse(startWindow);
        endWindow=startWindow;
        startWindow=tail;
        prevtoStartWindow.next=startWindow;
        endWindow.next=nextToEndWindow;

        for (int i=1;i<=k;i++){
            if(endWindow!=null){
            startWindow=startWindow.next;
            endWindow=endWindow.next;
            prevtoStartWindow=prevtoStartWindow.next;
            if(nextToEndWindow!=null){
            nextToEndWindow=nextToEndWindow.next;
            }
            }
            
        }



      }




        return dummyNode.next;
        
    }

    public static  ListNode reverseKGroup(ListNode head, int k) {
     

      //create the dummy node
      ListNode dummyNode = new ListNode(-1,head);
      // previous node to the start to window
      ListNode groupPrev = dummyNode;
      // start node of the interval
      ListNode startNode = groupPrev.next;
      // end node i.e kth node of the interva;
      ListNode kthNode = getKthNode(groupPrev,k);
      // if kth node is null  then return dummynode.next
      if(kthNode==null){
        return dummyNode.next;
      }
      //next node to the interval
      ListNode groupNext= kthNode.next;
      //disconnect connection with next group
      kthNode.next=null;

     //run the loop until kthnode is null
      while(kthNode!=null){
       //reverse the linkedList , pass the start node of the group
        ListNode headOftheReversed = reverse(startNode);
        groupPrev.next=headOftheReversed;
        //tail of the group is the one which used to be  start node
        startNode.next=groupNext;
        //group prev now points to next group preview which is startnode
        groupPrev=startNode;
        //new start node is next to groupPrev
        startNode = groupPrev.next;
        kthNode = getKthNode(groupPrev,k);
        if(kthNode!=null){
        groupNext= kthNode.next;
        //disconnect connection with next group
      kthNode.next=null;
        }

      }
            
      
          return dummyNode.next;
                    
          }
      
          private static ListNode getKthNode(TwoPointers.LinkedList.ListNode groupPrev, int k) {
            int counter =0;
            ListNode kNode = groupPrev;
            while(counter<k){
              kNode=kNode.next;
              // if knode is not there return null as soon as it becomes null.
              if(kNode==null) return kNode;
              counter++;

               }

               return kNode;
      
              }
          
              private static ListNode reverse(ListNode startWindow) {
        System.out.println("startWindow"+startWindow);
        ListNode prev =null;
        ListNode cur = startWindow;
       
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        System.out.println("prev"+prev);

return prev;

          }
    
}

 class ListNode {
       int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;}
      
        @Override
        public String toString() {
            return String.valueOf(val) ;
        }
   }
