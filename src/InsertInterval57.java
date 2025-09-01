import java.util.*;

public class InsertInterval57 {
 
    public static void main(String[] args){

        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

       // int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
       // int[] newInterval = {4,8};


        int[][] result = insert(intervals,newInterval);

        for (int i=0;i<result.length;i++){
            System.out.println("result"+Arrays.toString(result[i]));
        }

       

      


    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        //if original interval lenght is 0 then just return the new interval in result
        if(intervals.length==0){
            int[][] res = new int[1][2];
            res[0]=newInterval;
            return res;
        
        }

        Deque<int[]> mergedQueue = new LinkedList<>();
        int startP=0;

        while(startP<intervals.length && intervals[startP][0]<newInterval[0] ){
            //add to merged queue until it meets the start of new interval.
            mergedQueue.add(intervals[startP]);
            startP++;
        }

          //int[] secondInterval = newInterval;
          //there is an overlap
          if(!mergedQueue.isEmpty() && mergedQueue.getLast()[1]>=newInterval[0] ) {
            // then compare and merge between last of the queue and new interval.
            int[] firstChoice=mergedQueue.getLast() ;
            
            mergedQueue.pollLast();
            int[] mergedInterval = new int[2];
            mergedInterval[0]=firstChoice[0];
            mergedInterval[1]= Math.max(newInterval[1],firstChoice[1]);
            mergedQueue.add(mergedInterval);

          }
          else{
            mergedQueue.add(newInterval);
          }

          // now iterate further on original list and compare with merged list so far

          while(startP<intervals.length  ){
           
            int[] firstInterval= mergedQueue.getLast();
            int[] secondInterval = intervals[startP];
            //there is an overlap
            if(firstInterval[1]>=secondInterval[0]){
              mergedQueue.pollLast();
              int[] mergedInterval = new int[2];
              mergedInterval[0]=firstInterval[0];
              mergedInterval[1]= Math.max(secondInterval[1],firstInterval[1]);
              mergedQueue.add(mergedInterval);
  
            }
            else{
              mergedQueue.add(secondInterval);
            }
  
            startP++;
        }

        int[][] result = new int[mergedQueue.size()][2];
        int i=0;
        while(!mergedQueue.isEmpty()){
            int[] resultInterval = mergedQueue.poll();
            result[i]=resultInterval;
            i++;
        }

        

        return result;

        
    }
    
}
