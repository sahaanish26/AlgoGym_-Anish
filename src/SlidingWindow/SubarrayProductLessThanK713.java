package SlidingWindow;
import java.util.HashMap;
import java.util.Map;

public class SubarrayProductLessThanK713 {

    public static void main (String[] args){
        int[] nums = {10,5,2,6};
        int k=100;

       // int[] nums = {1,2,3};
       // int k=0;
        System.out.println(numSubarrayProductLessThanK(nums,k));

    }

    

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k==0)
          return 0;
    int leftP=0;
    int rightP=0;
    Map<Character,Integer> characterCountMap = new HashMap<>();
    int productWindow = 1;
    //int max = Integer.MIN_VALUE;
     int count =0;   

    while(rightP<nums.length && leftP<nums.length ){

       int iRightP = nums[rightP];
      // characterCountMap.put(cRightP,characterCountMap.getOrDefault(cRightP,0)+1);
      productWindow= productWindow*iRightP;
       rightP++;
      //Increase the window until it becomes invalid [for longest].
      //start inner while loop after the condition is violated
       while(productWindow>=k && leftP<rightP){
           int iLeftP = nums[leftP];
           productWindow=productWindow/iLeftP;
           leftP++;

       }
     //  max = Math.max(max,rightP-leftP);

        //count of all windows/subarray meeting the condition.[count of subarrays WithAtMostKDistinctChar]
        count = count + rightP-leftP ;
      
      

    }


       return count;
       
    



   }
}
