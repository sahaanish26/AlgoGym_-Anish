package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MaximumErasureValue1695 {

    public static int maximumUniqueSubarray(int[] nums) {
         if(nums.length==0){return 0;}
    
          int max = Integer.MIN_VALUE;
          int right=0;
          int left =0;
        
          Map<Integer,Integer> countMap=new HashMap();
          
          int sumSofar =0;
           int maxSumSofar = Integer.MIN_VALUE;
        // Map<Integer,Queue> countReverseMap=new HashMap();
        //stores the values of sum of all values of map countMap
           int countMapValueSum=0;
    
    
          while(right<nums.length){
            int c = nums[right];
            countMap.put(c,countMap.getOrDefault(c,0)+1);
            sumSofar=sumSofar+c;
            countMapValueSum=countMapValueSum+1;
           
            right++;
    
            //while loop until the window becomes just invalid
            //window invalid -- when countmap has frequency more than one
    
           while(invalid(countMap,countMapValueSum) ){
                              int r = nums[left];
                              countMap.put(r,countMap.getOrDefault(r,0)-1);
                              countMapValueSum=countMapValueSum-1;
                             if(countMap.get(r)<=0){
                              countMap.remove(r);
                             }
                             sumSofar=sumSofar-r;
                             left++;
                             }
                             // length of a valid substring with given criteria
                            int  length = right - left;
                            // max length everytime
                           // max = Integer.max(max,length);

                            if (length>=max){
                              max=length;
                              //we need to get sum of all valid windows not neccesarily the
                             // longest valid window.
                            // maxright=right;
                            // maxLeft=left;
                           //  System.out.println("maxright"+right);
                          //   System.out.println("maxLeft"+left);
                             

                            }
                            // this is a sum of a valid window.
                            if(sumSofar>maxSumSofar){
                                maxSumSofar=sumSofar;
                            }
                           
                             
                            }   
                             // for (int i= maxLeft;   i<  maxright;i++){
                              //  output = output + nums[i];
                             // }                                                                   
                             // return  max;  
                             return maxSumSofar;

       
    }                 
                        
 private static boolean invalid(Map<Integer,Integer> countMap, int countMapValueSum) {
    
    // this method can take again another o(n)
              //  for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                 //   Integer key = entry.getKey();
                 //   Integer value = entry.getValue();
                 //   if (value>1) return true;
               // }
// we are checking the sum of values to the number of keys. for a valid map every key should
//have value of 1 that way countMapValueSum=size of map.
               if (countMapValueSum>countMap.size()){
                return true;
               }
    
                return false;
    
                    }
    
    
 public static void main(String[] args){
    
                  //  int[] nums = {5,2,1,2,5,2,1,2,5};
                    //4,2,4,5,6
                    int[] nums = {4,2,4,5,6};
                   
                       int result =  maximumUniqueSubarray(nums);
                       System.out.println(result);

                }
}
