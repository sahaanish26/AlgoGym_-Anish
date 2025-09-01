import java.util.*;
public class CountNumberofNiceSubArrays1248 {


    public static void main(String[] args){

       // int[] nums = {1,1,2,1,1};
       // int k =3;
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k =2;
        System.out.println(numberOfSubarrays(nums,k)-numberOfSubarrays(nums,k-1) );
        System.out.println(numberOfSubarrays1(nums,k)-numberOfSubarrays1(nums,k-1) );

    }

    //leetcode runtime 27ms
    public static int numberOfSubarrays(int[] nums, int k) {

        int count =0 ;
        int rightP=0;
        int leftP=0;
        Queue<Integer> slidingWindowQueue = new LinkedList<>();
        int slidingWindowCounter = 0;


        while(rightP<nums.length){
            int numbertoBeAdded = nums[rightP];
            if(numbertoBeAdded%2!=0){
             slidingWindowQueue.add(numbertoBeAdded);
              //  slidingWindowCounter=slidingWindowCounter+1;
            }
            rightP++;
           // while( //slidingWindowQueue.size()>k)
            while(slidingWindowQueue.size()>k){
                int numbertoBeDeleted = nums[leftP];
                if(numbertoBeDeleted%2!=0){
                  slidingWindowQueue.remove(numbertoBeDeleted);
                   // slidingWindowCounter=slidingWindowCounter-1;
                }
                leftP++;
                 

            }

            count = count+(rightP-leftP);

        }

        return count;
    }

   //leetcode runtime 14ms
    public static int numberOfSubarrays1(int[] nums, int k) {

        int count =0 ;
        int rightP=0;
        int leftP=0;
      //  Queue<Integer> slidingWindowQueue = new LinkedList<>();
        int slidingWindowCounter = 0;


        while(rightP<nums.length){
            int numbertoBeAdded = nums[rightP];
            if(numbertoBeAdded%2!=0){
           //  slidingWindowQueue.add(numbertoBeAdded);
                slidingWindowCounter=slidingWindowCounter+1;
            }
            rightP++;
           // while( //slidingWindowQueue.size()>k)
            while(slidingWindowCounter>k){
                int numbertoBeDeleted = nums[leftP];
                if(numbertoBeDeleted%2!=0){
                //  slidingWindowQueue.remove(numbertoBeDeleted);
                    slidingWindowCounter=slidingWindowCounter-1;
                }
                leftP++;
                 

            }

            count = count+(rightP-leftP);

        }

        return count;
    }

    
}
