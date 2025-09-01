package Greedy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class HandOfStraights846 {

    public  static boolean isNStraightHand(int[] hand, int groupSize) {

        // if total numbers are not divisible by groupsize it can not be
        // arranhed for sure
        if(hand.length%groupSize!=0){
            return false;

        }
        int totalGroup = hand.length/groupSize;
        System.out.println("totalGroup"+totalGroup);
        // map to store the digit and count of digits
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+ 1);

        }

         //create upper while loop
         int counter =0;
         while(counter<totalGroup){
            System.out.println("start outer while");
            System.out.println("start outer while map"+map);

        Deque<Integer> group = new LinkedList<>();
        int least = map.firstKey();
        System.out.println("least"+least);
        group.add(least);
        map.put(least,map.getOrDefault(least,0)-1);
        if(map.get(least)<=0){
            map.remove(least);
        }

       
        while(group.size()<groupSize){
            int last = group.peekLast();
            System.out.println("last"+last);
            if (map.containsKey(last+1)){

                group.add(last+1);
                map.put(last+1,map.getOrDefault(last+1,0)-1);
                if(map.get(last+1)<=0){
                    map.remove(last+1);
                }
      
            }else{
                return false;
            }
          

        }
        System.out.println("group at the end of each inner while"+group);
        //increase the counter if one group is complete.
        counter++;
        System.out.println("Counter after increasing"+counter);
    }

       return true; 
    }
    
    public static void main(String[] args){

      //  int[] n = {1,2,3,6,2,3,4,7,8};
      //  int k=3;
        int[] n = {1,2,3,1,2,3,1,2,3};
        int k=3;
       // int[] n = {1,2,3,4,5};
     //   int k=4;
        System.out.println(isNStraightHand(n,k));

    }
}
