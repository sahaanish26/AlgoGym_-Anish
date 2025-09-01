package BinarySearch;

public class FindMinimunInRotatedSortedArray153 {

   // this will give the first position of the min occuence
    public static int findMin(int[] nums) {
    
            int left = 0;
            int right = nums.length-1;
            int pos=-1;
            int min = Integer.MAX_VALUE;
            
    
            while(left<=right){
    
                int mid = left + (right-left)/2;
                
                //probable place where answer can lie
                if(nums[mid]<nums[right]){
                    if(nums[mid]<min){
                        min =nums[mid];
                        pos=mid;
                    }
                   
                    right=mid-1;
                }
                 //probable place where answer can lie
                else if(nums[mid]==nums[right]){
                    if(nums[mid]<min){
                       min =nums[mid];
                       pos=mid;
                   }
    
                   
                  //this will also solve the problem 
                 // right=mid-1;
                 // but this should also solve the prob with arrays having duplicates
                 right=right-1;
                  
                 //right=right-1; ensures we just exclude the duplicate and go left of the dup element at right
                 
               }
                else if(nums[mid]>nums[right]){
                    left=mid+1;
                    
                }
                
    
            }
            System.out.println(pos);
    return nums[pos] ;
      
        }
    
        public static void main (String[] args){
           // int[] nums = {2,2,0,0,1,1};

           // int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};

            int[] nums = {1,1,1,1,1,1,1,1,2};

            findMin(nums);
    }
}
