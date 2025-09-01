import java.util.*;
public class MinCostClimbingStairs746 {

    public static int numberOfCall;

    public static void main(String[] args){


       // int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(numberOfCall);
    }

   
    public static int minCostClimbingStairs(int[] cost) {

        
        

        Map<Integer,Integer> cacheMap = new HashMap<>();
        return minCostClimbingStairsHelper( cost ,cost.length,cacheMap );
            
    }


    private static int minCostClimbingStairsHelper(int[] cost, int i, Map<Integer, Integer> cacheMap) {
       // System.out.println("call for"+i);
       // numberOfCall++;
        if(i==-1 || i==-2){
            return 0;
        }
        if(cacheMap.containsKey(i)){
         //   System.out.println("Cache hit for"+i);
            return cacheMap.get(i);
        }
       // System.out.println("no cache hit for"+i);


        int minCost;
        if(i>=0 && i<cost.length){
            minCost = cost[i] + Math.min(minCostClimbingStairsHelper(cost,i-1,cacheMap),minCostClimbingStairsHelper(cost,i-2,cacheMap) );

        }else{
            minCost =  Math.min(minCostClimbingStairsHelper(cost,i-1,cacheMap),minCostClimbingStairsHelper(cost,i-2,cacheMap) );

        }

       
       cacheMap.put(i,minCost);
       return minCost;

        }

    
}



