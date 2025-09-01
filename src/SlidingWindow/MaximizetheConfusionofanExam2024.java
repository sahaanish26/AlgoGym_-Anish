package SlidingWindow;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
//this is literaly same as LongestRepeatingCharacterReplacement
//https://leetcode.com/problems/longest-repeating-character-replacement/
public class MaximizetheConfusionofanExam2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
         int left=0;
        int right=0;
        int maxN = Integer.MIN_VALUE;
        Map<Character,Integer> slidingMap = new HashMap<>();
        Deque<Character> slidingQueue = new LinkedList<>();

        while(right<answerKey.length()){
          
            //operation
            char c = answerKey.charAt(right);
            slidingMap.put(c,slidingMap.getOrDefault(c,0)+1);
            slidingQueue.addLast(c);
            right++;

            /*condition--apart from char with top frequency in running map, frequency of other char exceeds k
                    In other words lenght of window - frequency of topmost char in the window has to be more than k */

            while(iinvalid(slidingQueue.size(),slidingMap,k)){
                char c1 = answerKey.charAt(left);
                slidingMap.put(c1,slidingMap.getOrDefault(c1,0)-1);
                slidingQueue.removeFirst();
                // operation
                left++;
            }

             maxN = Math.max(maxN,right-left);




        }



        return maxN;
       
    }

    private  boolean iinvalid(int size, Map<Character, Integer> slidingMap, int k) {

       // System.out.println("slidingMap"+slidingMap+"size"+size);

        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character,Integer> pair:slidingMap.entrySet()){

            if(pair.getValue()>max){
                max = pair.getValue();
            }


        }

        if(size-max>k){
            return true;
        }
return false;

           }

}
