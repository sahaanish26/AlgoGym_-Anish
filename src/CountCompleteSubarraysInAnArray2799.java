import java.util.*;
public class CountCompleteSubarraysInAnArray2799 {

    public static void main( String[] args){
   int[] nums = {5,5,5,5};
   System.out.println(countCompleteSubarrays(nums));

    }

    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> numberSet = new HashSet();

        for (int i=0;i<nums.length;i++){
            numberSet.add(nums[i]);
        }
        int totalUniqueNumbers = numberSet.size();




        return (countCompleteSubarraysHelper(nums,totalUniqueNumbers)-countCompleteSubarraysHelper(nums,totalUniqueNumbers-1));
        
    }


    public static int countCompleteSubarraysHelper(int[] nums, int k) {

        int count=0;
        Map<Integer,Integer> slidingWindowMap = new HashMap();
        int leftP=0;
        int rightP=0;

        while(rightP<nums.length){
            int numberTobeAdded = nums[rightP];
            slidingWindowMap.put(numberTobeAdded,slidingWindowMap.getOrDefault(numberTobeAdded,0)+1);
            rightP++;
            while (slidingWindowMap.size()>k){
                int numberTobeRemoved = nums[leftP];
                slidingWindowMap.put(numberTobeRemoved,slidingWindowMap.getOrDefault(numberTobeRemoved,0)-1);
                if(slidingWindowMap.get(numberTobeRemoved)==0){
                    slidingWindowMap.remove(numberTobeRemoved);
                }
                leftP++;
            }
            count = count + rightP-leftP;

        }



        return count;
        
    }
    
    
}
