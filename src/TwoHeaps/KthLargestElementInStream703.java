package TwoHeaps;

import java.util.PriorityQueue;

public class KthLargestElementInStream703 {
    PriorityQueue<Integer> pq;
    int limit;
 
    //since ask is kth top , in a MIN heap of size k , return the top element always

    public KthLargestElementInStream703(int k, int[] nums) {
        limit=k;
    // min heap
    pq = new PriorityQueue<>();
    for (int i =0;i<nums.length;i++){
        pq.add(nums[i]);
        if(pq.size()>k){
            pq.poll();
        }
        
    }
        
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>limit){
            pq.poll();
        }
        return pq.peek();

        
    }

}
