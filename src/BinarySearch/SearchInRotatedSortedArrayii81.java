package BinarySearch;

public class SearchInRotatedSortedArrayii81 {

    public  static boolean search(int[] nums, int target) {

        //get the index where first occurence of the min occurs

 int left=0;
 int right = nums.length -1;

 while(left<right && nums[left]==nums[right] ){
    if (target==nums[left]){
        return true;
    }
    left++;
    right--;
   
  
 }
 System.out.println(left);
 System.out.println(right);
 if(left>nums.length|| right<0 || right<left){
    return false;
 }

        int minIndex = findMin(nums,left,right);
        System.out.println("minIndex"+minIndex);
        //target is the min itself return true;
        if(target==nums[minIndex]){
            return true;
        }

        if (target!=nums[minIndex]){
            //the target  will either lie on left or right of the min number

            //get first occurence of the target from left portion of the array. 
            int fromLeftSide = findFirstOccurence(nums,target,left,minIndex-1);
            System.out.println("fromLeftSide"+fromLeftSide);
            if(fromLeftSide>=0 && fromLeftSide<nums.length){
                return true;
            }
             //get first  occurence of the target from right portion of the array. 
           
            int fromRightSide = findFirstOccurence(nums,target,minIndex+1,right);
            System.out.println("fromRightSide"+fromRightSide);
            if(fromRightSide>=0 && fromRightSide<nums.length){
                return true;
            }

        }
        return false;
    }
        
   
// problem 153,154
    public static int findMin(int[] nums, int effectiveLeft, int effectiveRight) {
    
        int left = effectiveLeft;
        int right = effectiveRight;
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

//return nums[pos] ;
//return first position of the minimum element instead of the minimum value for
//convenience
return pos;



    

}

// problem 35,33
public static int findFirstOccurence(int[] nums,int target,int initialLeft, int initialRight){

    int left =initialLeft;
    int right =initialRight;
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
    
    public static void main (String[] args){
        //int[] nums = {2,5,6,0,0,1,2};
       // int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
         int[] nums = {1,1};
      
        search(nums,2);
}

}
