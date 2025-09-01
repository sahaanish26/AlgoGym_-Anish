package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()){return 0;}
    
          int max = Integer.MIN_VALUE;
          int right=0;
          int left =0;
          Map<Character,Integer> countMap=new HashMap();
    
    
          while(right<s.length()){
            Character c = s.charAt(right);
            countMap.put(c,countMap.getOrDefault(c,0)+1);
            right++;
    
            //while loop until the window becomes just invalid
            //window invalid -- when countmap has frequency more than one
    
           while(invalid(countMap) ){
                              Character r = s.charAt(left);
                              countMap.put(r,countMap.getOrDefault(r,0)-1);
                             if(countMap.get(r)<=0){
                              countMap.remove(r);
                             }
                             left++;
                             }
                             // length of a valid substring with given criteria
                            int  lemgth = right - left;
                            // max length everytime
                            max = Integer.max(max,lemgth);
                             
                            }                                                                                
                              return  max;                                                 
                          }
                      
                        
 private static boolean invalid(Map<Character,Integer> countMap) {
    
                for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value>1) return true;
                }
    
                return false;
    
                    }
    
    
 public static void main(String[] args){
    
                    String s ="pwwkew";
                       int result =  lengthOfLongestSubstring(s);
                       System.out.println(result);

                }
}
