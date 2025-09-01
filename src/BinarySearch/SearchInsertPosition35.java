package BinarySearch;

public class SearchInsertPosition35 {
 // minimize x such that condition(x) is true
 public int searchInsert(int[] nums, int target) {

    //essentialy the problem statement is the last occurence of a number<=target -- This is
    //true only if the array has distinct elements.
    //if the array  have dup elements then problem statement needs to be broken into two parts
    // a. if match found then find the first position of target. first occurence of number==target
    // b. if match not found find the last occurence of number that is less than target.last occurence of number<target

 
       // int left = 0;
       // int ans =-1;
       // int right = nums.length-1;
       // while (left <= right) {
        //  int mid = left + (right - left) / 2 ;
         // if (isValid(nums, mid,target)) {
             //find a valid but find more in right which may be present.
           //  ans=mid;
           //  left=mid+1;
 
           
        //  } else {
            //right =mid -1;
          //}
        //}
 
       //if (ans>=0 && nums[ans]==target){
       //  return ans;
       // }
      
        
       // return (ans+1);  
       
       int resIfexactFound = findFirstOccurence(nums,target);
       System.out.println("resIfexactFound"+resIfexactFound);
       if (resIfexactFound!=-1) return resIfexactFound;

       int resIfexactNotFound = findLastOccurence(nums,target);
       System.out.println("resIfexactNotFound"+resIfexactNotFound);
       // answer is the next position , since we have to insert after this 
       return resIfexactNotFound+1;

     }
 
 
     public boolean isValid (int[] nums , int index, int target) {
 
         if(nums[index]<=target){
             return true;
         }
 
         return false;
     }

     public int findFirstOccurence(int[] nums,int target){

     int left =0;
     int right =nums.length-1;
     int pos=-1;

     while(left<=right){

    int mid = left + (right-left)/2;

// first If condition should be where the answer/pos may lie
    if(nums[mid]==target){
        pos=mid;
        // go to further left to get the first occurence
        right=mid-1;
    }
    else if(target>nums[mid]){
        // go towards right
        left=mid+1;

    }
    else if(target<nums[mid]){
        // go towards left
        right=mid-1;

    }

     }

   return pos;

     }
     
     //last occurence of number<target
     public int findLastOccurence(int[] nums,int target){

        int left =0;
        int right =nums.length-1;
        int pos=-1;
   
        while(left<=right){
   
       int mid = left + (right-left)/2;
   
     
      // since we need to find the last occurence of number<target 
      //i.e target<number got further right to see for other numbers <target
      // first If condition should be where the answer/pos may lie
        if(target>nums[mid]){
           // go towards right
           left=mid+1;
           pos=mid;
       }
       else if(target<nums[mid]){
           // go towards left
           right=mid-1;
   
       }
       else  if(nums[mid]==target){
           
        // go to further left
        right=mid-1;
    }
   
        }
   
      return pos;
   
        }
   
    }
