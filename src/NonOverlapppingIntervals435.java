import java.util.*;

public class NonOverlapppingIntervals435 {

    public static void main(String[] args){

   // int[][]intervals = {{1,2},{2,3},{3,4},{1,3}};

    int[][]intervals= {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};

    //int[][]intervals = {{1,2},{1,2},{1,2}};
   // int[][]intervals = {{1,2},{2,3}};


    System.out.println(eraseOverlapIntervals(intervals));
    

    }


    public static int eraseOverlapIntervals(int[][] intervals) {

        //sort the interval based on start time of interval
        //need to practice the sort interval
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        for(int i=0;i<intervals.length;i++){
            System.out.println(Arrays.toString(intervals[i]));
        }
        Deque<int[]> mergedList = new LinkedList<>();
        mergedList.add(intervals[0]);
        List<int[]> deletedIntervals = new ArrayList<>();
        int startP=1;
        while(startP<intervals.length){
            int[] firstInterval =mergedList.getLast();
            int[] secondInterval = intervals[startP];
            //compare if there is any intersection
            if(firstInterval[1]>secondInterval[0]){
                mergedList.pollLast();
              //wrong assumption  //since there is an intersection only one of the interval[the smaller one] will be staying in merged list
                //if first is smaller than second if , the absolute difference check does not work(firstInterval[1]-firstInterval[0]<=secondInterval[1]-secondInterval[0])
                // since the intervals are sorted on start time .. we have to delete the interval whose end time is more
                if(secondInterval[1]>= firstInterval[1]){
                    mergedList.add(firstInterval);
                    deletedIntervals.add(secondInterval);

                }else{
                    mergedList.add(secondInterval);
                    deletedIntervals.add(firstInterval);
                }

            }else{
                mergedList.add(secondInterval);
            }
            startP++;



        }

        for (int i=0;i<deletedIntervals.size();i++){
            System.out.println("deleted intervals");
            System.out.println(Arrays.toString(deletedIntervals.get(i)));
        }
       // System.out.println(deletedIntervals);
        return deletedIntervals.size();
        
    }
    
}
