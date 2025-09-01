public class RemoveNthNodeFromEndOfList19 {


    public static void main(String[] args){

    }
//piece of advice-whenever you see a linked list removal type question ,always make a dummy node at the beginning!
//anyways!
//slow and fast both start from pointing to the -1 dummy start Node. the gap between slow and fast pointer has to be n+1;
// so that slow.next is the one that is deleted.
//If we start slow and fast p from head and maintain a ga of n , some edge cases will fail since in some cases head may be 
//deleted itself. so the technique is start,slow,fast everything points at a dummy node behind the head node.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode startP= new ListNode(-1,head);
        ListNode slowP = startP;
        ListNode fastP= startP;
       
        int k=0;
        while(k<=n){
            fastP=fastP.next;
            k++;
        }
        //invalid scenario
       // if(fastP==null){return null;}

        while(fastP!=null){
            slowP=slowP.next;
            fastP=fastP.next;

        }
        ListNode nodeToBeDeleted= slowP.next;
        slowP.next=nodeToBeDeleted.next;

        return startP.next;
        
    }
    
}

 class ListNode {
         int val;
         ListNode next;
       ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString() {
            return " [val=" + val + ", next=" + next + "]";
        }

     }