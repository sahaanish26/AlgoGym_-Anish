package SlidingWindow;

import java.util.HashMap;
import java.util.Map.Entry;

public class MinimumWindowSubstring76 {

    //solved with template for shortest window
    //https://docs.google.com/document/d/1TGLuOpypK40FUauaxcCkQiRFrsVPO_5RRI0uTzJM-y8/edit?tab=t.mee5rmga1v1b

    public static String minWindow(String s, String t) {

      int left=0;
      int right=0;
      int min = Integer.MAX_VALUE;
      String minAnswer = "";

      HashMap<Character,Integer> windowCountMap= new HashMap<>();
      int windowCount=0;
      HashMap<Character,Integer> inputCountMap= new HashMap<>();
      int inputCount=t.length();
     

      for (int i=0;i<t.length();i++){
        char c = t.charAt(i);
        inputCountMap.put(c,inputCountMap.getOrDefault(c,0)+1);
      }
     
      while(right<s.length()){
        System.out.println("first while");
      //  System.out.println("windowCountMap"+windowCountMap+"windowCountMapExtra"+windowCountMapExtra);
   

        char c = s.charAt(right);
        windowCountMap.put(c,windowCountMap.getOrDefault(c,0)+1);
     //increase the window expected char count
      if(inputCountMap.containsKey(c)){
        windowCount = windowCount+1;
       
      }
      //increase right index
     right++;

      // now the inner loop while the window is valid
      //MISTAKE in while condition check: instead of comparing two maps created another windowCount variable which holds the count of
      //all valid characters . i.e characters in t. NO this did not work failed test case. becaue abbc =4
      //baac will give 4 but this is wrong
      // "acbbaca" , "aba"

      while(condition(inputCountMap,windowCountMap)){
            //  System.out.println("inputCountMap"+inputCountMap+"windowCountMapExtra"+windowCountMapExtra);
             // System.out.println("right"+right+"left"+left+"min"+min);
           
            //decrease the window.
            // got first valid window satisfying the condition
            //take the min of that
            if(min>=right-left){
              min = right-left;
              //do not put right +1, right is fine
               minAnswer = s.substring(left, right);
            }
               char d = s.charAt(left);
                // now decrease the window
               windowCountMap.put(d,windowCountMap.get(d)-1);
               if(windowCountMap.get(d)<=0){
                  windowCountMap.remove(d);
                  
               }
               //decrease the windowCount
               if (inputCountMap.containsKey(d)){
                  windowCount=windowCount-1;
                
              
               }
               left++;
             //  System.out.println("inputCountMap"+inputCountMap+"windowCountMapExtra"+windowCountMapExtra);
            
           
      
            }
            
            //get the substring
           
      
      
            }
      
            
            return minAnswer;
      
            }
            
            
      
            
      
      
       
              
          
      // the window is valid as long as the numer of each required character is greater than or equal to the than the required count
      // In order the window to be valid each character has to be present atleast {can be more} required number of times. [ MISTAKE NOT EQUAL]
      // mistake : the condition can not be straightforward equal  condition
     private static boolean condition(HashMap<Character,Integer> inputCountMap,
          HashMap<Character,Integer> windowCountMapExtra) {

            //iterating over inputCountMap since it should be smaller in size
            // this map holds the required count of characters

            for (Entry<Character, Integer> entry :inputCountMap.entrySet() ){
            //  if(windowCountMapExtra.containsKey(entry.getKey())){
            // if the passed map does not contain all the char atleast the required amonut of time then false
                                               
                if ( windowCountMapExtra.getOrDefault(entry.getKey(),0) < entry.getValue()){

                 return false;

                }
           //   }

            }
            return true;
            }
      
      
      
      
      
      
      
      
      
      
      
      
      
          public static void main(String[] args){

        String s= "ADOBECODEBANC";
        String t= "ABC";

       // String s= "a";
      // String t= "a";

     // String s ="acbbaca";
     // String t= "aba";
        String result = minWindow(s,t);

     System.out.println(result);

    }


  }
