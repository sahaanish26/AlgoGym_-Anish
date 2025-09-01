package SlidingWindow;
import java.util.*;

//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
//this is literaly same as LongestRepeatingCharacterReplacement
//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {


    public static void main(String[] args){

      //  String s="ABAB";
      //  int k=2;


        String s="AABABBA";
        int k=1;

        int res = characterReplacement(s,k);

        System.out.println("res"+res);




    }


    public static int characterReplacement(String s, int k) {
    
        int left=0;
        int right=0;
        int maxN = Integer.MIN_VALUE;
        Map<Character,Integer> slidingMap = new HashMap<>();
        Deque<Character> slidingQueue = new LinkedList<>();

        while(right<s.length()){
          
            //operation
            char c = s.charAt(right);
            slidingMap.put(c,slidingMap.getOrDefault(c,0)+1);
            slidingQueue.addLast(c);
            right++;

            /*condition--apart from char with top frequency in running map, frequency of other char exceeds k
                    In other words lenght of window - frequency of topmost char in the window has to be more than k */

            while(condition(slidingQueue.size(),slidingMap,k)){
                char c1 = s.charAt(left);
                slidingMap.put(c1,slidingMap.getOrDefault(c1,0)-1);
                slidingQueue.removeFirst();
                // operation
                left++;
            }

             maxN = Math.max(maxN,right-left);




        }



        return maxN;
        
    }


    private static boolean condition(int size, Map<Character, Integer> slidingMap, int k) {

        System.out.println("slidingMap"+slidingMap+"size"+size);

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
