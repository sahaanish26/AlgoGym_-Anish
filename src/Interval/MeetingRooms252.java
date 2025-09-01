package Interval;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MeetingRooms252 {

public static void main(String[] args){

   int intervals[][] = {{0, 30}, {5, 10}, {15, 20}};
 //  int intervals[][] = {{7,10},{2,4}};
 
   System.out.println(canAttendMeetings(intervals));


   
}


    public static boolean canAttendMeetings(int[][] intervals){


        //sort the interval based on incoming

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Deque<int[]> mergedIntervals = new LinkedList<>();

        // add the first interval in Queue
        mergedIntervals.add(intervals[0]);
        int start =1;

        while (start<intervals.length){

            int[] firstInterval = mergedIntervals.getLast();
            int[] secondInterval = intervals[start];

            //check if the intervals Merge
            if (firstInterval[1]>secondInterval[0]){

                mergedIntervals.pop();
                int[ ] mergedInterVal = new int[2];

                mergedInterVal[0]=Math.min(firstInterval[0], secondInterval[0]);
                mergedInterVal[1]=Math.max(firstInterval[1], secondInterval[1]);
                mergedIntervals.add(mergedInterVal);
            

                return false;

            }
            else{
                // addign the second interval
                mergedIntervals.add(secondInterval);
            }
            start++;
        }



      /* if (mergedIntervals.size()==intervals.length){
        //means no intervals were merged
        return true;
      }else{
        return false;
      } */


        return true;


    }
    
}
