import java.util.LinkedList;
import java.util.Queue;

//https://stackoverflow.com/questions/66772752/algorithm-how-cant-i-use-sliding-window-approach-for-this-question

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/solutions/5235250/heap-solution-95-beats-sc-full-explanation-easy-for-beginners-to-understand/?envType=problem-list-v2&envId=prefix-sum

// I think this will be similar to the solution that Do with regular hashmap for sum equalsK.
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/solutions/2939116/java-treemap/?envType=problem-list-v2&envId=prefix-sum
public class ShortestSubarraywithSumatLeastK862 {

    public static void main (String[] args){

    System.out.println("Hello World");

    //int [] nums =  {2,1,4,3,5};
   // long k =10;


   // int [] nums =  {2,-1,2};
   // int k =3;


   //int [] nums =  {1,2};
   // int k =4;


    int [] nums =  {1};
    int k =1;

    System.out.println(shortestSubarray(nums,k));
}


public static int shortestSubarray(int[] nums, int k) {

    int min = Integer.MAX_VALUE;
    int leftP=0;
    int rightP=0;
    long sum =0;
   
   // Queue<Integer> windowSumIndex = new LinkedList<>();

    while(rightP<nums.length){
        sum =sum+nums[rightP];
       // windowSumIndex.add(rightP);
        rightP++;
    //decrease the window the moment when when the window becomes valid
        while(sum>=k){
        min = Math.min(min,rightP-leftP);
        sum = sum - nums[leftP];
          
          leftP++;
        }
        
     

    }
    if(min==Integer.MAX_VALUE){return -1;}


    return min;
        
}

public static int LongestSubarray(int[] nums, int k) {

    int min = Integer.MAX_VALUE;
    int leftP=0;
    int rightP=0;
    long sum =0;
   
   // Queue<Integer> windowSumIndex = new LinkedList<>();

    while(rightP<nums.length){
        sum =sum+nums[rightP];
       // windowSumIndex.add(rightP);
        rightP++;
    //decrease the window the moment when when the window becomes valid
        while(sum>=k){
        min = Math.min(min,rightP-leftP);
        sum = sum - nums[leftP];
          
          leftP++;
        }
        
     

    }
    if(min==Integer.MAX_VALUE){return -1;}


    return min;
        
}
    
}
