package Array;

public class MaximumProductSubArray152 {

    public int maxProduct(int[] nums) {
       
       
        int maxProduct = nums[0];
        int[] maxProductSoFar = new int[nums.length];
        int[] minProductSoFar = new int[nums.length];
        maxProductSoFar[0]=nums[0];
        minProductSoFar[0]=nums[0];

        for (int i=1;i<nums.length;i++){
            minProductSoFar[i]= Math.min(nums[i],Math.min(maxProductSoFar[i-1]*nums[i],nums[i]*minProductSoFar[i-1]));

            maxProductSoFar[i]= Math.max(nums[i],Math.max(maxProductSoFar[i-1]*nums[i],nums[i]*minProductSoFar[i-1]));

            if (maxProductSoFar[i]>maxProduct){
                maxProduct=maxProductSoFar[i];
            }
            


        }


    return maxProduct;

        
    }

}
