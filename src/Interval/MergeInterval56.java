package Interval;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class MergeInterval56 {

    public static  int[][] merge(int[][] intervals) {

        //Sort the intervals by start time
        //add the first interval in a Queue
        //iterate over the intervals from index 1 instead of 0
        //compare the last one in the queue with the ith index in the list
        //based on comparison create new merged interval  in Queue, or add the unmerged one in queue.

        Deque<int[]> mergedInterval = new LinkedList<>();

        //sort the interval 
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);

        mergedInterval.add(intervals[0]);

        for ( int i=1 ;i<intervals.length;i++){
  // this is where using a deque helps we can use peekLast
        int[] first = mergedInterval.peekLast();
        int[] second = intervals[i];

        //intervals merge
        if(first[1]>=second[0]){
            int[] nMergedInterval = new int[2];
            nMergedInterval[0]=first[0];
            //always use the max of end intervals to get the end
            //of the merged interval
            nMergedInterval[1]= Math.max(first[1],second[1]);
            //take out original interval
            // this is where using a deque helps we can use pollLast
            // in queue we can only use poll which gives the first element in the poll
            mergedInterval.pollLast();
            //add the merged interval
            mergedInterval.add(nMergedInterval); 
        }
        //intervals dont merge
        else{
            //add the second non intersecting interval
            mergedInterval.add(second);

        }

        }

        int[][] result = new int[mergedInterval.size()][2];
         int k=0;
        while(!mergedInterval.isEmpty()){
            int[] interval = mergedInterval.pollFirst();
            result[k][0]=interval[0];
            result[k][1]=interval[1];
            k++;
        }

        return result;

        
    }


    public static void main(String[] args){
  
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

       int[][] result =  (merge(intervals));

       for (int i=0;i<result.length;i++){
        int[] interval = result[i];
        System.out.println(Arrays.toString(intervals));
       }

    }

}
