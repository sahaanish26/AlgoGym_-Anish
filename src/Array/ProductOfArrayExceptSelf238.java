package Array;
import java.util.Arrays;

public  class ProductOfArrayExceptSelf238 {

    public static int[] productExceptSelf(int[] nums) {

        // product at ith position not including i from left
        // this is not exactly prefix sum or prefix product.
        // in prefix product the at i the ith is included
        // here key is not to take the ith
        // product at ith position not including i from left
        int [] pre = new int[nums.length];
        // product a t ith position not including i from right
        
        int [] post = new int[nums.length];

        int [] res = new int[nums.length];

        pre[0]=1;

        for (int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        System.out.println(Arrays.toString(pre));

        post[nums.length-1]=1;

        for (int j=nums.length-2;j>=0;j--){
            post[j]=post[j+1]*nums[j+1];
        }
        System.out.println(Arrays.toString(post));

        for(int k=0;k<nums.length;k++){
            res[k]=pre[k]*post[k];
        }
        System.out.println(Arrays.toString(res));


return res;

        
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,4};
        productExceptSelf(arr);

    }

}
