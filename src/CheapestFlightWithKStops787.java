import java.util.*;

class CheapestFlightWithKStops787 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] intArray1 = new int[]{ 0,1};
        int[] intArray2 = new int[]{ 1,2};
        int[] intArray3 = new int[]{ 0,2};
       // int[] intArray4 = new int[]{ 5,2};
       // int[] intArray5 = new int[]{ 7,0};
        int[][] points  = new int[][]{intArray1,intArray2,intArray3};
        int[] intArray6 = new int[]{ 0,1};
        //int[] intArray7 = new int[]{ -2,5};
      //  int[] intArray8 = new int[]{ -4,1};
        int[][] flights  = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        double[] succProb = new double[]{0.5,0.5,0.2};
        double[] succProb1 = new double[]{0.5};

        // int[][] points  = new int[][]{intArray6,intArray7,intArray8};


        // choices.add(1);
        // choices.add(3);
        // choices.add(5);

        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);
      //  System.out.println("Final result"+ maxProbability(3,points,succProb,0,2));
        System.out.println("Final result"+ findCheapestPrice1(4,flights,0,3,1));

    }


    public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {

    
    //int originalBelManFord = n-1;
    // node,distance
    Map<Integer,Integer> distanceMap = new HashMap<>();

    int [] distanceArray = new int[n];


    //creating distanceMap with initial distances.

    for (int j=0;j<n;j++){
      if (src == j){
        distanceMap.put(j,0);
        distanceArray[j]=0;
      }else{
        distanceMap.put(j,Integer.MAX_VALUE);
        distanceArray[j]=Integer.MAX_VALUE;
      }

    }

    System.out.println("distanceArray Initial"+Arrays.toString(distanceArray));

    //original bellman ford ..iterate upto less than number of node -1 times
    // but here we willcustomize to K times
    for ( int i=0 ;i<k+1;i++){

     // Map<Integer,Integer> distanceMap = distanceMap
    //concept of temp array is here to restrcit the number of normalization to satisfy the number of stop conditions.
    int[] tempDistanceArray = Arrays.copyOf(distanceArray,distanceArray.length);
    
    for (int m=0;m<flights.length;m++){

      int[] flightEdge = flights[m];
      int source = flightEdge[0];
      int originalDistanceAtSource = distanceArray[source];
      if(originalDistanceAtSource!=Integer.MAX_VALUE){
      
      int destination = flightEdge[1];
      int calculatedDistanceToDestination = originalDistanceAtSource + flightEdge[2];
      int originalDistanceToDestination = tempDistanceArray[destination];

      
        tempDistanceArray[destination]=Math.min(calculatedDistanceToDestination,originalDistanceToDestination);
      
    }

    }
    System.out.println("tempDistanceArray"+Arrays.toString(tempDistanceArray));

    distanceArray = tempDistanceArray;
    System.out.println("distanceArray"+Arrays.toString(distanceArray));




    }



       if (distanceArray[dst]==Integer.MAX_VALUE){return -1;};

       return distanceArray[dst];
        
    }


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

      int[] distance = new int[n];
      Arrays.fill(distance, Integer.MAX_VALUE);
      distance[src]=0;
      System.out.println("distance initial"+Arrays.toString(distance));

      /*
      we need to loop k+1 times. 
      because for 1st iteration, we find min cost flight with no stops
      so for (k+1)th iteration, we find min cost flights with k stops
      */
      for(int i=0;i<=k;i++){
          int[] temp = Arrays.copyOf(distance, n);
          for(int[] flight: flights){
              if(distance[flight[0]]!=Integer.MAX_VALUE){
                  temp[flight[1]] = Math.min(temp[flight[1]], distance[flight[0]] + flight[2]);
              }
          }
          System.out.println("temp"+Arrays.toString(temp));

          distance = temp;
      }

      return distance[dst]==Integer.MAX_VALUE ? -1: distance[dst];
  }





  }