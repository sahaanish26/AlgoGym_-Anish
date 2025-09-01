package Dijkstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {

    public static  int networkDelayTime( int[][] times, int n,int k) {

        // definition of map/graph
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        //first create a default map
        for (int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        
        }
         // create the directional map
        for (int i=0;i<times.length;i++){

            int[] time = times[i];
            int source = time[0];
            int dest = time[1];
            int distance = time[2];

            int[] neighBour = new int[2];
            neighBour[0]=dest;
            neighBour[1]=distance;
            List<int[]> allNeighbours = map.get(source);
            allNeighbours.add(neighBour);
            map.put(source, allNeighbours);

        }

        System.out.println(map);
        
        // create the initial distance map, only for source dist=0 else infinite
        HashMap<Integer,Integer> distanceMap = new HashMap<>();


        for (int i=1;i<=n;i++){
           if(i==k){
            distanceMap.put(i,0);
           }else{
            distanceMap.put(i,Integer.MAX_VALUE);
           }
        
        }

        System.out.println("distanceMap"+distanceMap);

       HashSet<Integer> visited = new HashSet<>();
       PriorityQueue<int[]> minPq= new PriorityQueue<>((a,b)->a[1]-b[1]);

       // put the starting node in pQ
       int[] start =new int[2];
       start[0]=k;
       start[1]=0;

       minPq.add(start);

       while(!minPq.isEmpty()){

        int[] current = minPq.poll();
        System.out.println("current node after popping"+current);

        if(visited.contains(current[0])){
            continue;
        }

        visited.add(current[0]);


        // for unvsited neighbours

        List<int[]> neighBours =  map.get(current[0]);

        for (int[] eachN :neighBours ){

            if(!visited.contains(eachN[0])){
                int dFromMap = distanceMap.get(eachN[0]);
                int calcD = current[1] + eachN[1];
                if(calcD<dFromMap){
                    //add in pq
                    // update distanceMap
                    distanceMap.put(eachN[0], calcD);
                    int[] updatedNode = new int[2];
                    updatedNode[0]=eachN[0];
                    updatedNode[1]=calcD;
                    minPq.add(updatedNode);

                }

            }
        }




       }

// now find the max value from the distanceMap that will be the minimum time required


//taking a random distance as max to start with
int max = distanceMap.get(k);

for (int i=1;i<=n;i++){

    if (distanceMap.get(i)>max){
        max=distanceMap.get(i);
    }
}

if (max== Integer.MAX_VALUE){
    return -1;
}

return max;

    }

    
    public static void main(String[] args){

        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};

   int result = networkDelayTime(times,4,2);

   System.out.println("result"+result);

    }
}
