package DP;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber198 {

    public int rob(int[] nums) {

   Map<Integer,Integer> cache = new HashMap<>();

   return  robHelper(nums,0,cache);

        
    }

    public int robHelper(int[] nums , int index, Map<Integer,Integer> cache) {

        //base case when there are no more houses to ron
        if(index>=nums.length){
            return 0;
        }

        if(cache.containsKey(index)){
            return cache.get(index);
        }


        // choice1 take the current index , in that case the next index can not be 
        // passed as remainig valid param for recurion , it will be one after that

        int option1 = nums[index] + robHelper(nums,index+2,cache);

        // choice 2 to take not the current index and pass the reamining to param as recursion

        int option2 = 0+ robHelper(nums,index+1,cache);

        int result = Math.max(option1, option2);

        cache.put(index,result);

        return result;








        
        
    }

}
