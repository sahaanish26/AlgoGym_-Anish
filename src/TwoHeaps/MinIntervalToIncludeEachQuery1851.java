package TwoHeaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-interval-to-include-each-query/solutions/6515209/java-most-detailed-explanation-readable-and-easy-to-understand-solution-time-complexity-analyzed/?envType=problem-list-v2&envId=plakya4j
//https://www.youtube.com/watch?v=FZtDTYzVUhU
public  class MinIntervalToIncludeEachQuery1851 {

    public static int[] minInterval(int[][] intervals, int[] queries) {

        int [] result = new int[queries.length];

         // before sorting the queries array. store the originial position of the values
        //number, List<position>
        // making it list because of duplicate entry in query

        HashMap<Integer,List<Integer>> positionMap = new HashMap();

        for (int i= 0;i<queries.length;i++){
            List<Integer> pos = positionMap.getOrDefault(queries[i],new ArrayList<>());
            pos.add(i);
            positionMap.put(queries[i],pos);

        }
        System.out.println("positionMap queries sort "+positionMap);


        // now we can sort the queries
       Arrays.sort(queries);

       System.out.println("After queries sort "+Arrays.toString(queries));


       // sort the intervals based on the start
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);

       System.out.println("After intervals sort "+Arrays.deepToString(intervals));

       // define a PQ which will store the interval length and the interval and will be sorted
       // on the interval 
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] -b[2]);
        int intervalsPointer =0;
       
       for (int i=0;i<queries.length;i++){

       int query = queries[i];
       System.out.println("query i"+query);
       // add all eligible entries based on comparsion
       while( intervalsPointer < intervals.length && query>=intervals[intervalsPointer][0] ){

        // eligible to be put into queue
        int interval = intervals[intervalsPointer][1] -intervals[intervalsPointer][0] +1;
        int[] pqEntry = new int[3];
        pqEntry[0]=intervals[intervalsPointer][0];
        pqEntry[1]=intervals[intervalsPointer][1];
        pqEntry[2]=interval;
        System.out.println("pqEntry **"+Arrays.toString(pqEntry));
        pq.add(pqEntry);
        intervalsPointer++;

    } 
     //remove all ineligible entries

        while(!pq.isEmpty() && pq.peek()[1]<query ){
            System.out.println(Arrays.toString(pq.peek()));
         pq.poll();
        }

        // now determine min length
        int min =-1;
        if(pq.isEmpty()){
            List<Integer> pos = positionMap.get(query);
            for(int po:pos){
                result[po]=min;
            }
           
        }else{
            System.out.println("in else block of min");
            System.out.println(Arrays.toString(pq.peek()));
             min = pq.peek()[2];
             List<Integer> pos = positionMap.get(query);
             for(int po:pos){
                result[po]=min;
            }

        }
        
       
    
      



       }
    
        
    return result;
    }
    
    public static void main(String[] args){

       // int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
       // int[] queries = {2,3,4,5};

       // int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
      // int[] queries = {2,19,5,22};

         int [][] intervals ={{4,5},{5,8},{1,9},{8,10},{1,6}};
        int[] queries = {7,9,3,9,3};
      
        System.out.println(Arrays.toString(minInterval(intervals,queries)));
        System.out.println("result");
    }
}
