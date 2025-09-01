package SlidingWindow;
import java.util.*;

public class SubArraysWithKDifferentIntegers992 {


    public static void main(String[] args){
      //  int [] nums = {1,2,1,2,3};
       // int k=2;

        int [] nums= {1,2,1,3,4};
        int k = 3;

    System.out.println(subarraysWithKDistinct(nums,k)-subarraysWithKDistinct(nums,k-1));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {

        int count=0;
        Map<Integer,Integer> slidingWindowMap = new HashMap();
        int leftP=0;
        int rightP=0;

        while(rightP<nums.length){
            int numberTobeAdded = nums[rightP];
            slidingWindowMap.put(numberTobeAdded,slidingWindowMap.getOrDefault(numberTobeAdded,0)+1);
            rightP++;
            while (slidingWindowMap.size()>k){
                int numberTobeRemoved = nums[leftP];
                slidingWindowMap.put(numberTobeRemoved,slidingWindowMap.getOrDefault(numberTobeRemoved,0)-1);
                if(slidingWindowMap.get(numberTobeRemoved)==0){
                    slidingWindowMap.remove(numberTobeRemoved);
                }
                leftP++;
            }
            count = count + rightP-leftP;

        }



        return count;
        
    }
    
}
