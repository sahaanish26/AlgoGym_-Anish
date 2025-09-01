package TwoHeaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder finder = new MedianFinder();
        // Populate the MedianFinder with the initial sliding window
        for (int i = 0; i < k; i++) {
            finder.addNum(nums[i]);
        }

        int n = nums.length;
        double[] medians = new double[n - k + 1]; // Array to hold the medians
        medians[0] = finder.findMedian(); // Find the median for the first window

        // Move the sliding window and calculate the median for each window
        for (int i = k; i < n; ++i) {
            finder.addNum(nums[i]); // Add the new element to the sliding window
            finder.removeNum(nums[i - k]); // Remove the oldest element from the sliding window
            medians[i - k + 1] = finder.findMedian(); // Find the median for the current window
        }
        return medians; // Return the array of medians
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
            //extra methods required compared to find median
    // of a stream problem
            pruneHeap(leftMaxHeap); // Ensure maxHeap is pruned
        } else if (leftMaxHeapSize < rightMinHeapSize) {
            leftMaxHeap.offer(rightMinHeap.poll());
            rightMinHeapSize--;
            leftMaxHeapSize++;
            //extra methods required compared to find median
    // of a stream problem
            pruneHeap(rightMinHeap); // Ensure minHeap is pruned
        }
    }

    // removeNum and pruneHeap are the extra methods required compared to find median
    // of a stream problem

    //logical removal of number
    public void removeNum(int num) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1); // Mark the number for delayed removal
        if (num <= leftMaxHeap.peek()) {
            leftMaxHeapSize--;
            if (num == leftMaxHeap.peek()) {
                pruneHeap(leftMaxHeap); // Remove elements that should be delayed from the maxHeap
            }
        } else {
            rightMinHeapSize--;
            if (num == rightMinHeap.peek()) {
                pruneHeap(rightMinHeap); // Remove elements that should be delayed from the minHeap
            }
        }
        rebalanceHeaps(); // Ensure both heaps remain in a valid state
    }

    private void pruneHeap(PriorityQueue<Integer> heap) {
        // Remove elements from the heap that were marked for delayed removal
        while (!heap.isEmpty() && countMap.containsKey(heap.peek())) {
            int heapTop = heap.peek();
            countMap.put(heapTop, countMap.get(heapTop) - 1);

            if (countMap.get(heapTop) == 0) {
                countMap.remove(heapTop); // remove the entry from the map if the count goes to zero
            }

            heap.poll(); // remove the top element in the heap as it's already accounted for in the delayed removal
        }
    }

    
}


