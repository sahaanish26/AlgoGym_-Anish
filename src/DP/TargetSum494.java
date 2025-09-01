package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum494 {


    public static int findTargetSumWays(int[] nums, int target) {

        HashMap<List<Integer>,Integer> cache = new HashMap<>();

        return findTargetSumWaysHelper(nums,target,0,cache);
        
    }


    public static int findTargetSumWaysHelper(int[] nums, int target, int index,HashMap<List<Integer>,Integer> cache) {
        System.out.println("target"+target+"index"+index);
        // we have to use all the numbers in array and then see if target is met
        // meeting target is not sufficient condition
        // so base condition()
        if(target==0 && index==nums.length){
            return 1;
        }
        if(index==nums.length){
            return 0;
        }
       // build the key of the cache
       List<Integer> key = new ArrayList<>();
       key.add(target);
       key.add(index);
       // list.equals checks values and also order is maintained. so (1,2) is not equal to (2,1) which is what we want.
       //check in cahce if value is already there
       if(cache.containsKey(key)){
        System.out.println("cache hit for"+"target"+target+"index"+index);
        return cache.get(key);
       }
       
        int number = nums[index];
         // once choice is to add+ in front of current number , so pass as is the number
        int choice1 = findTargetSumWaysHelper(nums,target-number,index+1,cache);
        // other choice is add - in front of current number
        int choice2 = findTargetSumWaysHelper(nums,target- (-1*number),index+1,cache);

        int result = choice1+ choice2;
        cache.put(key, result);
        return result ;
        
    }
    
    public static void main (String[] args){
        int[] nums  = {1,1,1,1,1};

        int target = 3;

       // int[] nums  = {1};

       // int target = 1;
         int res=  findTargetSumWays(nums,target);

         System.out.println("res"+res);

    }
}
