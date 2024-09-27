import java.util.*;

public class MergeTripletsToFormTargetTriplets1899 {

    public static void main(String[] args){
   // int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
    //int[] target = {2,7,5};

    int[][]triplets = {{2,5,3},{2,3,4},{1,2,5},{5,2,3}};
    int[] target = {5,5,5};
    System.out.println(mergeTriplets1(triplets,target));

    }
    
    
    
    public static  boolean mergeTriplets(int[][] triplets, int[] target) {
       Queue<int[]> possibleMergedTriplet = new LinkedList<>();
       if(triplets.length==1){
        if(triplets[0][0]== target[0] && triplets[0][1]== target[1] && triplets[0][2]== target[2] ){
            return true;
        }
        else{
            return false;
        }
       }
       int startP=1;
       possibleMergedTriplet.add(triplets[0]);

       while(startP<triplets.length){
        int[] firstTriplet = possibleMergedTriplet.peek();
        int[] secondTriplet = triplets[startP];
       if( Math.max(firstTriplet[0],secondTriplet[0])<= target[0] && Math.max(firstTriplet[1],secondTriplet[1])<= target[1] && Math.max(firstTriplet[2],secondTriplet[2])<= target[2]){
        //then we can merge
        possibleMergedTriplet.poll();
        int[] mergedTriplet = new int[3];
        mergedTriplet[0] = Math.max(firstTriplet[0],secondTriplet[0]);
        mergedTriplet[1] = Math.max(firstTriplet[1],secondTriplet[1]);
        mergedTriplet[2] = Math.max(firstTriplet[2],secondTriplet[2]);
        possibleMergedTriplet.add(mergedTriplet);
        if(mergedTriplet[0]==target[0] && mergedTriplet[1]==target[1] && mergedTriplet[2]==target[2] ){
            return true;
        }
       }else{
        // if the current triplet in queue is invalid pop it and add the triplet from original list
        if(firstTriplet[0]>target[0]||firstTriplet[1]>target[1] ||firstTriplet[2]>target[2] ){

            possibleMergedTriplet.poll();
            int[] mergedTriplet = new int[3];
            mergedTriplet[0] = secondTriplet[0];
            mergedTriplet[1] = secondTriplet[1];
            mergedTriplet[2] = secondTriplet[2];
            possibleMergedTriplet.add(mergedTriplet);

        }

       }

       startP++;
       }

        return false;
        
    }
    

    public static  boolean mergeTriplets1(int[][] triplets, int[] target) {
        Deque<int[]> possibleMergedTriplet = new LinkedList<>();
        if(triplets.length==1){
         if(triplets[0][0]== target[0] && triplets[0][1]== target[1] && triplets[0][2]== target[2] ){
             return true;
         }
         else{
             return false;
         }
        }
        int startP=1;
        possibleMergedTriplet.add(triplets[0]);
 
        while(startP<triplets.length){
         int[] firstTriplet = possibleMergedTriplet.getLast();
         int[] secondTriplet = triplets[startP];
        if( Math.max(firstTriplet[0],secondTriplet[0])<= target[0] && Math.max(firstTriplet[1],secondTriplet[1])<= target[1] && Math.max(firstTriplet[2],secondTriplet[2])<= target[2]){
         //then we can merge
         possibleMergedTriplet.pollLast();
         int[] mergedTriplet = new int[3];
         mergedTriplet[0] = Math.max(firstTriplet[0],secondTriplet[0]);
         mergedTriplet[1] = Math.max(firstTriplet[1],secondTriplet[1]);
         mergedTriplet[2] = Math.max(firstTriplet[2],secondTriplet[2]);
         possibleMergedTriplet.add(mergedTriplet);
         if(mergedTriplet[0]==target[0] && mergedTriplet[1]==target[1] && mergedTriplet[2]==target[2] ){
             return true;
         }
        }else{
         // if the current triplet in queue is invalid pop it and add the triplet from original list
         if(firstTriplet[0]>target[0]||firstTriplet[1]>target[1] ||firstTriplet[2]>target[2] ){
 
             possibleMergedTriplet.pollLast();
            // int[] mergedTriplet = new int[3];
            // mergedTriplet[0] = secondTriplet[0];
            // mergedTriplet[1] = secondTriplet[1];
           //  mergedTriplet[2] = secondTriplet[2];
             possibleMergedTriplet.add(secondTriplet);
 
         }
 
        }
 
        startP++;
        }
 
         return false;
         
     }
 
}


