package TwoPointers.LinkedList;

public class SwappingNodesinLinkedList1721 {


    public ListNode swapNodes(ListNode head, int k) {

        ListNode dummyNode = new ListNode(-1,head);

ListNode slow =dummyNode;
ListNode fast = dummyNode;
int count = 0;

while(count<=k){
    fast =fast.next;
    count=count+ 1;
}
// Initial gap between slow and fast is k.

while(fast!=null){

    slow=slow.next;
    fast=fast.next;
}

System.out.println("slow"+slow.val+"fast"+fast);
//when fast is null we have reached the before kth node

ListNode beforeSecondNode =slow;
ListNode secondNode = slow.next;
ListNode AfterSecondNode = secondNode.next;
//beforeSecondNode.next=AfterSecondNode;
//secondNode.next=null;


System.out.println("beforeSecondNode"+beforeSecondNode.val+"AfterSecondNode"+AfterSecondNode.val);


ListNode cur =dummyNode;

int count1 = 0;

while(count1<k-1){
    cur =cur.next;
    count1=count1+ 1;
}

System.out.println("cur"+cur.val);

ListNode beforeFirstNode=cur;
ListNode firstNode = cur.next;
ListNode AfterFirstNode= firstNode.next;

System.out.println("beforeFirstNode"+beforeFirstNode.val+"AfterFirstNode"+AfterFirstNode.val);

//firstNode.next=null;
//beforeFirstNode.next=AfterFirstNode;

//firstNode.next=null;
//secondNode.next=null;
System.out.println("firstNode"+firstNode.val+"secondNode"+secondNode.val);


int temp = secondNode.val;
secondNode.val=firstNode.val;
firstNode.val = temp;
//beforeFirstNode.next=secondNode;
//secondNode.next=AfterFirstNode;


//beforeSecondNode.next=firstNode;
//firstNode.next=AfterSecondNode;

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