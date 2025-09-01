import java.util.Arrays;

public class BinarySearch704 {

    public static int  numcalls;

    public static void main (String[] args){

        int[] nums = {-1,0,3,5,9,12};
        int target=9;


        int[] nums1 = {5,7,7,8,8,10};
        int target1=8;


        //int[] nums2 = {4,5,6,7,0,1,2};
      // int target2=0;

     // int[] nums2 = {3,1};
     //  int target2=1;

      // int[] nums2 = {1,3,5};
     //  int target2=1;

      // int[] nums2 = {4,5,6,7,8,1,2,3};
      // int target2=8;

        int[] nums2 = {3,4,5,6,1,2};
        int target2=2;

        System.out.println(search(nums,target));

        System.out.println( Arrays.toString( searchRange(nums1,target1))   );


        System.out.println(searchInRotatedSortedArray(nums2,target2));
       
       // return (nums1,target1,0,nums1.length-1);

    }

    public static  int search(int[] nums, int target) {


        return searchHelper(nums,target,0,nums.length-1);

       



        
    }
    

    public  static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1,-1};

        int first = searchHelperFirstOccur(nums,target,0,nums.length-1);

        if(first==-1){
            return result;
        }

        int last=  searchHelperLastOccur(nums,target,0,nums.length-1);
        result[0]=first;
        result[1]=last;

        return result;

      
        
    }

    public  static int searchHelper(int[] nums, int target,int left,int right) {

        if (left>right){
            return -1;
        }
        if (left<0 || right>=nums.length){
            return -1;
        }

        int result =-1;

        int mid = left + (right-left)/2;
        if (nums[mid]==target){
            
            result=mid;
        }else if (nums[mid]<target){
            result = searchHelper(nums,target,mid+1,right);
        }
        else if (nums[mid]>target){
            result = searchHelper(nums,target,left,mid-1);
        }


        return result;
        
    }
    


    public  static int searchHelperFirstOccur(int[] nums, int target,int left,int right) {

        if (left>right){
            return -1;
        }
        if (left<0 || right>=nums.length){
            return -1;
        }

        int result =-1;

        int mid = left + (right-left)/2;
        if (nums[mid]==target){
         //   System.out.println("mid"+mid);
            if(mid==0 || (mid>0 && nums[mid-1]<target)){
                result = mid;
            }else if (nums[mid-1]==target){
                result =searchHelperFirstOccur(nums,target,left,mid-1);
         
            }
            
           
        }else if (nums[mid]<target){
            result = searchHelperFirstOccur(nums,target,mid+1,right);
        }
        else if (nums[mid]>target){
            result = searchHelperFirstOccur(nums,target,left,mid-1);
        }


        return result;
        
    }
   
    public  static int searchHelperLastOccur(int[] nums, int target,int left,int right) {

        if (left>right){
            return -1;
        }
        if (left<0 || right>=nums.length){
            return -1;
        }

        int result =-1;

        int mid = left + (right-left)/2;
        if (nums[mid]==target){
            //System.out.println("mid"+mid);
            if(mid==nums.length-1 || (mid<nums.length-1 && nums[mid+1]>target)){
                result = mid;
            }else if (nums[mid+1]==target){
                result =searchHelperLastOccur(nums,target,mid+1,right);
         
            }
            
           
        }else if (nums[mid]<target){
            result = searchHelperLastOccur(nums,target,mid+1,right);
        }
        else if (nums[mid]>target){
            result = searchHelperLastOccur(nums,target,left,mid-1);
        }


        return result;
        
    }
   

    public static int searchInRotatedSortedArray(int[] nums, int target) {

      int result =  searchInRotatedSortedArrayHelper(nums,target,0,nums.length-1);
      System.out.println(" numcalls++"+ numcalls);
      return result;

        
    }

    private static int searchInRotatedSortedArrayHelper(int[] nums, int target, int left, int right) {

        numcalls++;


        if (left>right){
            return -1;
        }
        if (left<0 || right>=nums.length){
            return -1;
        }

        int result =-1;
      

        int mid = left + (right-left)/2;
        System.out.println("mid"+mid);
       // System.out.println("nums[mid]"+nums[mid]);
       
        if (nums[mid]==target){
          //  System.out.println("target"+target);
           
          
                return mid;
           
           
        } else {

            //target has to be in either left or right of mid
            
            //search left
            //add  condition when we should search left
            //1. if left half is increasing and target is within the range.
            //2. If left half is decrasing and target is withn the range.----Invalid ..left half is seeingly decrasing..it is actually non monotonic
            //3. If left half is not monotonic then search it
                System.out.println("left search");
                if(condition(nums,mid,left,target)){
            int res1= searchInRotatedSortedArrayHelper(nums,target,left,mid-1);

           if(res1>=0){
            return res1;
           }
        }
        
            //search right
            //add condition when we should search right
            //1. if right half is increasing and target is in range
            //2. If right half is decrasing and target is less than number in mid -- invalid
             //3. If right half is not monotonic then search it
     
                System.out.println("right search");
            int res2= searchInRotatedSortedArrayHelper(nums,target,mid+1,right);
            if(res2>=0){
                return res2;
               }

            
      
        
    }

        return result;
        
           }

    private static boolean condition(int[] nums, int mid, int left,int target) {
       //1. if left half is increasing and target is within the range.
       

      if(mid==0){
       if( nums[left] >nums[mid] ){
        if(target>=nums[mid] && target<=nums[left]){
            return true;

        }

       }
    }else{
       
       if( nums[left] >nums[mid-1]  &&  nums[mid-1]>nums[mid] ){

        if(target>=nums[mid] && target<=nums[left]){
            return true;

        }

       }
    }


     //2. If left half is decrasing and target is withn the range.
     if(mid==0){
        if( nums[left] <nums[mid] ){
         if(target<=nums[mid] && target>=nums[left]){
             return true;
 
         }
 
        }
     }else{
        
        if( nums[left] <nums[mid-1]  &&  nums[mid-1]<nums[mid] ){
 
         if(target<=nums[mid] && target>=nums[left]){
             return true;
 
         }
 
        }
     }
 



       return false;
    }

    private static boolean isIndexValid(int[] nums, int index) {



        if ( index>=0 && index <= nums.length-1 ){

            return true;
        }

return false;
          }
}



