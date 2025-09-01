package TwoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

class FindMedianFromDataStream290 {


   //define leftMaxHeap
    PriorityQueue<Integer> leftMaxHeap ;

    PriorityQueue<Integer> rightMinHeap ;

    int leftMaxHeapSize ;
    int rightMinHeapSize ;
    public   int windowSize =0;






    public FindMedianFromDataStream290(int size) {

        leftMaxHeap =  new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap  =  new PriorityQueue<>();
        leftMaxHeapSize =0;
        rightMinHeapSize=0;
        this.windowSize=size; 
        
    }
    
    public void addNum(int num) {
        //since leftmaxHeap can have one extra than  rightMinHeap so if leftmaxHeap is empty preference s
        // is on leftmaxHeap . Also leftmaxHeap should maintain the max value at the top , so any new number
        // that comes in should be kept in leftMaxHeap only if it is <= the top value. i.e less than current 
        //max
        if(leftMaxHeap.isEmpty()|| num <=leftMaxHeap.peek() ){
            leftMaxHeap.add(num);
            leftMaxHeapSize++;
            //else put it in rightMinHeap.
        }else{
            rightMinHeap.add(num);
            rightMinHeapSize++;

        }
       //after add operation rebalance
        rebalance();
                
            }
            
            private void rebalance() {
                // leftMaxHeapSize can be more than rightMinHeapSize by 1 only
                if(leftMaxHeapSize>rightMinHeapSize+1){
                    rightMinHeap.add(leftMaxHeap.poll());
                    rightMinHeapSize++;
                    leftMaxHeapSize--;

                }else if(rightMinHeapSize>leftMaxHeapSize)
                {
                    leftMaxHeap.add(rightMinHeap.poll());
                    rightMinHeapSize--;
                    leftMaxHeapSize++;

                }
                    

                

            }
        
            public double findMedian() {

                if(leftMaxHeapSize==rightMinHeapSize){
                    return ((double) leftMaxHeap.peek() + (double) rightMinHeap.peek())/2;

                }

            return leftMaxHeap.peek();
        
    }
    
    
    
    
}


class MedianFinder {

    private PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>(); // holds all the larger elements
    private PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder()); // holds the smaller elements, reversed to act as a max-heap
    private Map<Integer, Integer> countMap = new HashMap<>(); // keeps track of the number of instances a number has been delayed for removal
    private int rightMinHeapSize = 0;
    private int leftMaxHeapSize = 0;
   

    public MedianFinder() {
       
    }
    
   public void addNum(int num) {
        // Add the number to the appropriate heap
        if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.offer(num);
            leftMaxHeapSize++;
        } else {
            rightMinHeap.offer(num);
            rightMinHeapSize++;
        }
        rebalanceHeaps(); // Ensure both heaps remain in a valid state
    }

    public double findMedian() {
        // If odd window size, the median is the top of the max heap, otherwise, the median is the average of the tops of both heaps
        return leftMaxHeapSize!=rightMinHeapSize ? leftMaxHeap.peek() : ((double) leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
    }

    private void rebalanceHeaps() {
        // Maintain the property that maxHeap has the same number of elements as minHeap, or 1 more
        if (leftMaxHeapSize > rightMinHeapSize + 1) {
            rightMinHeap.offer(leftMaxHeap.poll());
            leftMaxHeapSize--;
            rightMinHeapSize++;
           // pruneHeap(maxHeap); // Ensure maxHeap is pruned
        } else if (leftMaxHeapSize < rightMinHeapSize) {
            leftMaxHeap.offer(rightMinHeap.poll());
            rightMinHeapSize--;
            leftMaxHeapSize++;
           // pruneHeap(minHeap); // Ensure minHeap is pruned
        }
    }


   
}
   

    

    

   
   
   

