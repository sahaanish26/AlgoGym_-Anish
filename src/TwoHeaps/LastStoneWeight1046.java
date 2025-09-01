package TwoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {

    public static int lastStoneWeight(int[] stones) {



        //create a PQ with max on top
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       

        for (int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        // loop until we have  in PQ atleast 2 stones 
        while(pq.size()>1){
         // poll the highets one
         int highest = pq.poll();
         int secondHighest = pq.poll();
         if(highest==secondHighest){
            // do nothing
         }else{
            int net = highest-secondHighest;
            pq.add(net);
         }
        }
        // loop has ended so size can be =1 or <1 i.e 0
        // if pq is 0 return 0
        if(pq.isEmpty()){
            return 0;
        }
        //else return the last one in PQ
        return pq.poll();


        
    }
    

    public static void main(String[] args) {

       // int[] stones = {2,7,4,1,8,1};
        int[] stones = {1};

        System.out.println(lastStoneWeight(stones));
        
    }
}
