package Array;
public class MaximumSubArray52 {

    // use kadanes alogo to get max sum subarray 
    // but kadanes does not work for all negative
    // so we need a sep check
   
        public static int maxSubArray(int[] nums) {
    
             int maxNegative =  Integer.MIN_VALUE;
            if (checkAllNegative(nums)){
                for (int i=0;i<nums.length;i++){ maxNegative = Math.max(nums[i],maxNegative);
                    //System.out.println(maxNegative);
                }
               
                    return maxNegative;
                }
        
                int maxSumsoFar =0;
                int[] sumSofar= new int[nums.length];
                sumSofar[0]=nums[0];
                if(sumSofar[0]<0){
                    sumSofar[0]=0;
                }
                if(sumSofar[0]>maxSumsoFar){
                    maxSumsoFar=sumSofar[0];
                }
               
        
                for (int i=1 ; i<nums.length;i++ ){
                    sumSofar[i]=sumSofar[i-1]+nums[i];
                    if(sumSofar[i]<0){
                        sumSofar[i]=0;
                    }
                    if(sumSofar[i]>maxSumsoFar){
                        maxSumsoFar=sumSofar[i];
                    }
        
                    System.out.println("sumsofar at"+i+"index"+sumSofar[i]+ "maxSumsoFar"+maxSumsoFar);
        
                }
                
                return maxSumsoFar;
            }
        
          
    private static boolean checkAllNegative(int[] nums) {
   boolean flag =true;

   for (int i=0; i<nums.length;i++){
   

    if (nums[i]>0){
        return false;
    }


}
return flag;
                }    


                public static void main(String[] args) {
       int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
      // int[] arr ={5,4,-1,7,8};
      // int [] arr = {-1,-2,-3,-4};
       System.out.println(maxSubArray(arr)); 
        
    }
}
