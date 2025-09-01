import java.util.*;

public class ArrayRankTransform1331 {

    public static void main(String[] args){

      //  Map<Integer,Integer> rankMap = new TreeMap<>();
       // rankMap.put(10,1);
      //  rankMap.put(40,1);
      //  rankMap.put(30,1);
      //  rankMap.put(20,1);

       // for(Map.Entry<Integer,Integer> entry : rankMap.entrySet()) {
       //     Integer key = entry.getKey();
        //    Integer value = entry.getValue();
          
        //    System.out.println(key + " => " + value);
        //  }
//int[] arr = {40,10,20,30};
//int[] arr = {100,100,100};
int[] arr = {37,12,28,9,100,56,80,5,12};
//[37,12,28,9,100,56,80,5,12]
int[] result = arrayRankTransform(arr);
System.out.println("res"+Arrays.toString(result));
    }


    public static int[] arrayRankTransform(int[] arr) {
        if (arr.length==0){return arr;}

        Map<Integer,Integer> rankMap = new TreeMap<>();

        for (int i=0;i<arr.length;i++){
            if(!rankMap.containsKey(arr[i])){
                rankMap.put(arr[i],1);

            }


        }
        Map<Integer,Integer> map = new HashMap<>();
        int rank=1;

        for(Map.Entry<Integer,Integer> entry : rankMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
          
           // System.out.println(key + " => " + value);
            map.put(key,rank);
            rank++;
          }

          int[] result = new int[arr.length];

          for (int i=0;i<arr.length;i++ ){
            int rankValue = map.get(arr[i]);
            result[i]=rankValue;


          }




        return result;
        
    }
    
}
