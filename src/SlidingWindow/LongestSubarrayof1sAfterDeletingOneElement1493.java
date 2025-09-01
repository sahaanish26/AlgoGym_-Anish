package SlidingWindow;

import java.util.HashMap;

import java.util.Map;
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

// difference with MaxConsecutiveOnesIII1004 is that we have to return max -1 , since it wants the length after being deleted
public class LongestSubarrayof1sAfterDeletingOneElement1493 {


     public static int longestSubarray(int[] nums) {

        if (nums.length==0) return 0;

          int max = Integer.MIN_VALUE;
          int right=0;
          int left =0;
        // map keys are only 0 and 1
          Map<Integer,Integer> countMap=new HashMap();
          
    
    
          while(right<nums.length){
            int c = nums[right];
            countMap.put(c,countMap.getOrDefault(c,0)+1);
            right++;
    
            //while loop until the window becomes just invalid
            //window invalid -- when countmap has frequency more than one
    
           while(invalid(countMap,1) ){
                              int r = nums[left];
                              countMap.put(r,countMap.getOrDefault(r,0)-1);
                               if(countMap.get(r)<=0){
                              countMap.remove(r);
                             }
                            
                             left++;
                             }
                             // length of a valid substring with given criteria
                            int  length = right - left;
                            // max length everytime
                           // max = Integer.max(max,length);

                            if (length>=max){
                              max=length;
                    
                            }
                          
                           
                             
                            }   
                            

                             return max-1;

        
      
    }

    //since a valid window can have atmost k 0s , invalid windows is where more than k 0s are 
    //there
    private static boolean invalid(Map<Integer,Integer> countMap,int k) {
    
        // this method can take again another o(n)
                  //  for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                     //   Integer key = entry.getKey();
                     //   Integer value = entry.getValue();
                     //   if (value>1) return true;
                   // }
    // we are checking the sum of values to the number of keys. for a valid map every key should
    //have value of 1 that way countMapValueSum=size of map.
                   if (countMap.getOrDefault(0,0)>k){
                    return true;
                   }
        
                    return false;
        
                        }
    

}
