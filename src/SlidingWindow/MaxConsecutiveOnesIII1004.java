package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/max-consecutive-ones-iii/description/
// flip at most k 0s is basically finding the longest valid window with atmost k 0s. so the invalid
// window is where 0 is present more than k.
public class MaxConsecutiveOnesIII1004 {


    public static int longestOnes(int[] nums, int k) {

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
    
           while(invalid(countMap,k) ){
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
                             
                             return max;

        
      
    }

    //since a valid window can have atmost K 0s , invalid windows is where more than k 0s are 
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
