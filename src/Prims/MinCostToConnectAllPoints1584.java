package Prims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints1584 {

    public static  int minCostConnectPoints(int[][] points) {

     // first creating a map with adJacency list. the key of the map will be the position of the point in points
     // if we keep [x,y] as key it will be complex imp and array is also not suitable as a key for map
     // we can always returive the coordinated of point by the index

     // int[] will be storing the index of neighbour and distance to neighbour. so two digit
     HashMap<Integer,List<int[]>> map = new HashMap<>();

     for( int i=0;i<points.length;i++){

        map.put(i,new ArrayList<>());
       
     }

     // now calculate the distance and create the map

     for (int i=0;i<points.length;i++){
       for(int j=i+1;j<points.length;j++){

        int[] iPoint = points[i];
        int[] jPoint = points[j];

        int distItoJ= Math.abs((iPoint[0]-jPoint[0])) + Math.abs(iPoint[1]-jPoint[1]);
        // now create 2 way nbour list <i,(j.d)> <j,(i,d)>
        int[] neighBourJ = new int[2];
      
        neighBourJ[0]=j;
        neighBourJ[1]=distItoJ;
  
        List<int[]> neighBoursOfI= map.get(i);
        neighBoursOfI.add(neighBourJ);
        map.put(i, neighBoursOfI);

        int[] neighBourI = new int[2];

        neighBourI[0]=i;
        neighBourI[1]=distItoJ;

        List<int[]> neighBoursOfJ= map.get(j);
        neighBoursOfJ.add(neighBourI);
        map.put(j, neighBoursOfJ);


       }


     }

     System.out.println(map);
    // now create a Min PQ based on distance,min distance at top

    PriorityQueue<int[]> minPq = new PriorityQueue<>((a,b)->(a[1]-b[1]));

    //start prims algo

    // choose a random point say the first one in the point array
    int[] point = new int[2];
    //index of the first array
    point[0]=0;
    //taking distance as 0 since from point0 to point0 is distance 0
    point[1]=0;
    // put the chosen random point in the queue
    minPq.add(point);
    HashSet<Integer> visitedMST = new HashSet<>();
    int minDistance =0;

    
    // we can keep the while condition like regular bfs
    while( !minPq.isEmpty())// visitedMST.size()<points.length//)
    {

        int[] currentPoint = minPq.poll();
        //if the dequed point is already there then ignore and continue;
        if(visitedMST.contains(currentPoint[0])){
            continue;
        }
        minDistance=minDistance+currentPoint[1];
        // in prims and dijikstra we mark a nide visited after dequeing
        visitedMST.add(currentPoint[0]);
        // this is required if the while loop we are running on q size
        if(visitedMST.size()==points.length){
            return minDistance;
        }


        List<int[]> neighBourPoints = map.get(currentPoint[0]);

        //add all unvisited neighbour in the pq

        for (int[] nPoint:neighBourPoints){
            // this check of adding the unvisited nodes in q/pq is common for regular bfs,prims,dijikstra
            if(!visitedMST.contains(nPoint[0])){
                
                minPq.add(nPoint);
                // in regular bfs we mark visited when enqueing but in prims/dijikstra we do that
                //while dequeing above
            }

        }





    }
   

//return minDistance;

return 0;


    }

     public static void main (String[] args){

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

       // int[][] points = {{3,12},{-2,5},{-4,1}};

        int result = minCostConnectPoints(points);
        System.out.println(result);
     }
}
