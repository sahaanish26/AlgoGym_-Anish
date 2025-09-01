package PrefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//781 / 782 testcases passed
public class MaximumGoodSubArraySum3026 {

    public long maximumSubarraySum(int[] nums, int k) {

        long max = Long.MIN_VALUE;
        Map<Integer,List<Integer> >seenMap = new HashMap();
        //Here we do not need the map for prefix sum map 
        //since we are not looking for longest,shortest,count
        //we just need the sum between indices [range sum]
        // whenever condition is satisfied.
        // Condition at a index j if nums[j]+k or nums[j]-k 
        // is equal to nums[i] where i<j

        //prefix sum arrray
        long[] s = new long[nums.length];


        for (int j=0;j<nums.length;j++){
            if(j==0){
                s[j]=(long)nums[j];
            }
            else{
                s[j]=s[j-1]+ (long)nums[j];
            }
            //since this problem talks about absolute difference
            int oneOption = nums[j]+k;
            int otherOption = nums[j]-k;
             // find at which previous index of the array the number oneOption was seen
            if(seenMap.containsKey(oneOption)){
                //get the List of indexes where the number was seen
                // the problem did not mention if the array has dup
                //unique value so list is safe.
                List<Integer> indexList = seenMap.get(oneOption);
                for (int m=0 ;m<indexList.size();m++){
                    //nums[m] will add the number at start of the 
                    //subarray since s[j]-s[m] is not inclusive of
                    // nums[m]
                    //index where the number was last seen
                    int index =indexList.get(m);
                    long prefixsum = s[j]-s[index] + (long)nums[index];
                    if (prefixsum>max){
                        max=prefixsum;
                    }


                }
                //get the prefix sum from here
            }

             // find at which previous index of the array the number otherOption was seen
            if(seenMap.containsKey(otherOption)){
                //get the List of indexes where the number was seen
                // the problem did not mention if the array has dup
                //unique value so list is safe.
                List<Integer> indexList = seenMap.get(otherOption);

             for (int m=0 ;m<indexList.size();m++){
                    //nums[m] will add the number at start of the 
                    //subarray since s[j]-s[m] is not inclusive of
                    // nums[m]
                    //index where the number was last seen
                    int index =indexList.get(m);
                    long prefixsum = s[j]-s[index] + (long)nums[index];
                    if (prefixsum>max){
                        max=prefixsum;
                    }


                }
            }

          //put in seen map the current element 
          //this step should be at the very end in iteration
         List<Integer> seenIndexes =  seenMap.getOrDefault(nums[j],new ArrayList<>());
 //can we optimize here , do we need every instanc of nums[j] ?
         //781 / 782 testcases passed , this is the key to pass the last test case.
         //test case [3,1,3,1,3,1.................] , k =2
       if(seenIndexes.size()==0){
        seenIndexes.add(j);
       }else{
        // optimize
        int lastIndex= seenIndexes.get(seenIndexes.size()-1);
        if(s[j]<s[lastIndex]){ seenIndexes.add(j);}
      

       }

      //   seenIndexes.add(j);
          seenMap.put(nums[j], seenIndexes);

        }

        // if condition is not satisfied then return 0
        if (max == Long.MIN_VALUE){
            return 0;
        }
        return max;
        
    }

}
