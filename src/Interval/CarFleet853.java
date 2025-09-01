package Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CarFleet853 {

    public int carFleet(int target, int[] position, int[] speed) {

        // this is also a merge interval kind of problem
        // we have to create a tuple of position and speed of each card and  
        // sort them based on position
        // then take the last [ unlike merge interval where we take the first] and put into Queue
        // then compare  starting from last-1 of the list [unlike merge where we start from 1] to the last in the queue.
        // if they intersect then merge else add in queue [ in merge interval we do it on start/end time -- here it will be on time to target]

        //Step 1  create the array of tuples
        List<int[]> tupleList = new ArrayList<>();
        for (int i=0;i<position.length;i++){
           int[] tuple = new int[2];
           tuple[0] = position[i];
           tuple[1] = speed[i];
           tupleList.add(tuple);

        }

        // Step 2 - sort the tuple list based on position [ not required if position is sorted- but it is not]

        ListComparator listComparator = new ListComparator();
        Collections.sort(tupleList,listComparator );
        System.out.println(tupleList.get(0)[0]);
        System.out.println(tupleList.get(tupleList.size()-1)[0]);
        

        Deque<int[]> q = new LinkedList<>();
        q.add(tupleList.get(tupleList.size()-1));

        for (int j =tupleList.size()-2;j>=0;j--){
            // this is where using a deque helps we can use peekLast
            int[] first = q.peekLast();
            int[] second = tupleList.get(j);

            // now find if they can collide and merge
            if(willCollide(first,second,target)){
                        // if the cars collide then combined fleet will have speed of first car
                        int[] fleet = new int[2];
                        fleet[1] = first[1];
                        // position is not important here as we need the size of the queue at the end
                        // we can put either first or last cars position 
                        fleet[0] = first[0];
                        //mistake I made using 
                      //  q.poll()
                       q.pollLast();
                       // both Queue and dequee will add at the last by default
                        q.add(fleet);
                        }else{
                            q.add(second);
                        }
            
            
            
            
                    }
                   
                    
            return q.size();
            
                    
                }
            
                private boolean willCollide(int[] first, int[] second, int target) {

                    int firstCarDistanceToTarget = target- first[0];
                    int secondCarDistanceToTarget = target- second[0];
                    double timeFirst = (double)firstCarDistanceToTarget/(double)first[1];
                    double timeSecond = (double)secondCarDistanceToTarget/(double)second[1];
                    if(timeSecond<=timeFirst){
                        return true;
                    }
                    return false;


                   
                }

}

// creates the comparator for comparing stock value
 class ListComparator implements Comparator<int[]> {

    // override the compare() method
    public int compare(int[] s1, int[] s2)
    {
        if (s1[0]==s2[0])
            return 0;
        else if (s1[0] > s2[0])
            return 1;
        else
            return -1;
    }
}

