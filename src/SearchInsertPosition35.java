public class SearchInsertPosition35 {


    public static void main (String[] args){

        int target =-28;
       int nums[] = {-21,-3,-1};

       // int[] nums = {1,3,5,6};
      //  int target = 5 ;

       // int[] nums = {1,3,5,6};
      //  int target = 2 ;

      //  int[] nums = {1,3,5,6};
     //   int target = 7 ;

        int index =searchInsert(nums,target);

        System.out.println("index"+index);



    }


    public static int searchInsert(int[] nums, int target) {

        //essentialy the problem statement is the last occurence of a number<=target [ maximization]
        //also it can be thought of the first occurence of a number>=target [minimization]

       int left = 0;
       int ans =-1;
       int right = nums.length-1;
       while (left <= right) {
         int mid = left + (right - left) / 2 ;
         if (isValid(nums, mid,target)) {
            //find a valid but find more in right which may be present.
            ans=mid;
            left=mid+1;

          
         } else {
           right =mid -1;
         }
       }

      if (ans>=0 && nums[ans]==target){
        return ans;
       }
     
       
       return (ans+1);
             
         }

         public static boolean isValid (int[] nums , int index, int target) {

           // essentialy the problem statement is the last occurence of a number<=target

            if(nums[index]<=target){
                return true;
            }
    
            return false;
        }
    
}
