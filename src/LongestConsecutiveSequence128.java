import java.util.*;

public class LongestConsecutiveSequence128 {


    public static void main(String[]args){

       // int[] nums  = {100,4,200,1,3,2};
       int[] nums ={0,3,7,2,5,8,4,6,0,1};


        System.out.println(longestConsecutive(nums));

    }


    public static int longestConsecutive(int[] nums) {

        Set<Integer> numberSet= new HashSet();
        int currentSequenceLength= 1;
        int maxSeqLength=1;

        for(int i=0;i<nums.length;i++){
            numberSet.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++){

            int num = nums[i];
            //find if it is start of sequence. i.e num-1 sould not contain in the set
            if(!numberSet.contains(num-1)){
                Queue sequence= new LinkedList<>();
                
                int startofSeq=num;
                
                while(numberSet.contains(startofSeq)){
                    sequence.add(startofSeq);
                    startofSeq++;
                }
                maxSeqLength = Math.max(sequence.size(),maxSeqLength);
             
            }
            
        }

        return maxSeqLength;
        
    }
    
}
