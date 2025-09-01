package DP;

import java.util.*;

class PartitionEqualSubSetSum416 {
    public boolean canPartition(int[] nums) {

        int sum =0;
        for (int i=0;i<nums.length;i++){
            sum = sum+ nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        HashMap<List<Integer>,Boolean> cache = new HashMap<>();

        //Arrays.sort(nums);

       return  canPartitionHelper(nums,0,cache,sum/2);
               
           }
       
           private boolean canPartitionHelper(int[] nums, int index,   HashMap<List<Integer>,Boolean> cache, int target) {

           
            if(target==0){
                return true;
            }
            // if target is less than 0 then also false from this path
            if(target<0){
                return false;
            }
            //if all choices exhausted but target not foumd
            if(index>=nums.length){
                return false;
            }

            // form the key
            List<Integer> key = new ArrayList<>();
            key.add(index);
            key.add(target);
            if(cache.containsKey(key)){
               
                System.out.println("found key");
                return cache.get(key);
            }

            boolean option1=false;
            boolean option2=true;


            option1 = canPartitionHelper(nums,index+1,cache,target-nums[index]);

              if (option1 ){
                cache.put(key, true);
                return true;


            }
            
            option2 = canPartitionHelper (nums,index+1,cache,target);

            if (option2){
                cache.put(key, true);
                return true;


            }
            cache.put(key, false);
            return false;

              
           }


}

// if we use 2d array as DP it is so much more efficient
class Solution { 

    private Boolean[][] cache;
         public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) { // Enhanced for loop for cleaner iteration
                sum += num;
            }
    
            if (sum % 2 != 0) {
                return false;
            }
    
            
    
            int targetSum = sum / 2;
            // Initialize the cache with dimensions based on the problem constraints
            // index can go from 0 to nums.length
            // target can go from 0 to targetSum
            cache = new Boolean[nums.length][targetSum + 1];
    
            // No need to sort, but can be helpful in some cases (not strictly necessary here)
            // Arrays.sort(nums);
    
            return canPartitionHelper(nums, 0, targetSum);
        }
    
    
              private boolean canPartitionHelper(int[] nums, int index, int target) {
            // Base cases
            if (target == 0) {
                return true; // We found a subset that sums to the target
            }
            if (target < 0) {
                return false; // Target sum exceeded
            }
            if (index >= nums.length) {
                return false; // All choices exhausted, target not found
            }
    
            // Check if the result for this state (index, target) is already in the cache
            // If cache[index][target] is not null, it means it has been computed before
            if (cache[index][target] != null) {
                return cache[index][target];
            }
    
            // Recursive calls
            // Option 1: Include the current number nums[index] in the current subset
            boolean option1 = canPartitionHelper(nums, index + 1, target - nums[index]);
    
            // If option1 is true, we found a solution, cache it and return
            if (option1) {
                cache[index][target] = true;
                return true;
            }
    
            // Option 2: Exclude the current number nums[index] from the current subset
            boolean option2 = canPartitionHelper(nums, index + 1, target);
    
            // Cache the result of option2 and return it
            cache[index][target] = option2;
            return option2;
        }
       }