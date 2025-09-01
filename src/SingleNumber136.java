public class SingleNumber136 {


    private static int singleNumber(int[] nums) {
    
         int result=0;
         // a^b^c^a^b is equivalent to a^a^b^b^c. the same number XOR is 0 , [a^a=0, a^b=1].
         //since there is only one number with one entry rest are in pair. the pairs will cancel each other
         //at the end result will contain the origial number 
         
        for (int i=0;i<nums.length;i++){
            result=result^nums[i];

        }




        return result;
        
    }


    public static void main (String[] args){

       // int[] nums = {2,2,1};

       // int[] nums = {4,1,2,1,2};

       int[] nums = {1};


     System.out.println(singleNumber(nums)) ;





    }
    
}
