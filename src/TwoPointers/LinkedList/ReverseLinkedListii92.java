package TwoPointers.LinkedList;

public class ReverseLinkedListii92 {

   // we will take approach of reverse linked list in k groups
   // identify the sublist that needs to be reversed
   // keep reference to the previous pointer before the start of the sublist
   // keep reference to the next pointer after the end of the sublist
   // before passing the list for reversal cut the connections previous and next to the sublist
   // we have to utilize the concpet of dummy node for handling edge case


    public ListNode reverseBetween(ListNode head, int left, int right) {

    // create a dummy node
ListNode dummy = new ListNode(-501,head);
ListNode prev = dummy;
// for start point both startOfInterval,endOfInterval to head
ListNode startOfInterval = head;
ListNode endOfInterval=head;

int start =1;
int end =1;

while(start<left){
    startOfInterval=startOfInterval.next;
    prev=prev.next;
    start=start+1; 
}

while(end<right){
    endOfInterval=endOfInterval.next;
    //prev is already in position not required anymore
   // prev=prev.next;
   end=end+1; 
}
ListNode nodeAfterWindow = endOfInterval.next;
//cut the connection
endOfInterval.next=null;
ListNode nodeBeforeWindow =prev;
//cut the connection
nodeBeforeWindow.next=null;

//this will also be the new tail
ListNode oldHeadOftheSubList = startOfInterval;

ListNode newHeadOftheSublist = reverse(oldHeadOftheSubList);

nodeBeforeWindow.next=newHeadOftheSublist;
//toldHeadOftheSubList is the new tail now
oldHeadOftheSubList.next =nodeAfterWindow;

return dummy.next;





// now cut the links at both ends and pass the sublist for reversal



// now take these to correct position









        
    }

   
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

 class ListNode {
       int val;
    ListNode next;
       ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    
