package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findtargetindicesaftersortingarray2089 {

    public static List<Integer> targetIndices(int[] nums, int target) {
    
    
            Arrays.sort(nums);
           // int l = minimum  possible answer  , r = maximum possible answer  ;
          // int firstIndex = findFirst(nums,target);
           int firstIndex = binarySearch(nums,target);
           System.out.println(firstIndex);
          // int lastIndex = findLast(nums, target);
           int lastIndex = binarySearch2(nums, target);
           System.out.println(lastIndex);
           
           List<Integer> response = new ArrayList<>();
           if(firstIndex==-1 || lastIndex==nums.length){
            return response;
           }

           if(firstIndex==lastIndex){
            response.add(firstIndex);
            return response;
           }

           for (int i=firstIndex;i<=lastIndex;i++){
            response.add(i);
           }
                     
                     
                      return response;
                       
                       
                   }
               
               
               
                   public static int findFirst(int[] nums, int target) {
               
                       // search space 
                       int left=-1;
                       int right = nums.length;
                       while(left+1<right){
                       int mid = left + (right-left)/2;
               
                       if (conditionThatMovestoLeftHalf(nums[mid],target)){
                       right=mid;
                               }else{
                       left=mid;
                               }
                       
                               }
                               if(isvalidIndex(right,nums) && nums[right]==target)
                                                              return right;
                               
                                                              return -1;
                                                      
                                                      
                                                             
                                                             // int l = minimum  possible answer  , r = maximum possible answer  ;
                                                             
                                                             
                                                              
                                                              
                                                          }
                                                      
                                                      
                                                          private static boolean isvalidIndex(int index, int[] nums) {
                                                            if(index>=0 && index<nums.length){
                                                                return true;
                                                            }
                                                            return false;
                                                         }
                               
                               
                               
                                                          private static  boolean conditionThatMovestoLeftHalf(int i, int target) {
                               if(target<=i){
                                   return true;
                               }
                               return false;
                                   }
                       
                                   private static  boolean conditionThatMovestoLeftHalf1(int i, int target) {
                                    if(target==i){
                                        return true;
                                    }
                                    return false;
                                        }
                            
                                        private static  boolean conditionThatMovestoLeftHalf2(int i, int target) {
                                            if(i<target){
                                                return true;
                                            }
                                            return false;
                                                }
                                   
                       
                           public static int findLast(int[] nums, int target) {
    
    // search space 
    int left=-1;
    int right = nums.length;
    while(left+1<right){
    int mid = left + (right-left)/2;
    
    if (conditionThatMovestoRightHalf(nums[mid],target)){
    left=mid;
            }else{
    right=mid;
            }
    
            }

            if(isvalidIndex(left,nums) && nums[left]==target)
            return left;

            return -1;
            
    
    
           
           // int l = minimum  possible answer  , r = maximum possible answer  ;
           
           
            
            
    
           
            // int l = minimum  possible answer  , r = maximum possible answer  ;
            
            
             
             
         }
    
    
    
                private static  boolean conditionThatMovestoRightHalf(int i, int target) {
                    if(target>=i) {
                        return true;
                    }
                    return false;
     
    
    }

    private static  boolean conditionThatMovestoRightHalf1(int i, int target) {
        if(target==i) {
            return true;
        }
        return false;


}

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstTrueIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (conditionThatMovestoLeftHalf1(nums[mid],target)) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return firstTrueIndex;
    }
    

    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstTrueIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (conditionThatMovestoLeftHalf2(nums[mid],target)) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return firstTrueIndex;
    }
    
    public static void main(String[] args){
        int[] nums = {1,2,5,2,3,2};
    
        List<Integer> res = targetIndices(nums,5);
        System.out.println(res);
}
}
