import java.util.*;
public class MinimumWindowSubstring76 {


    public static void main(String[] args){

       String original=  "ADOBECODEBANC";
       String toCompare = "ABC";
        String result = minWindowString( original , toCompare);

        System.out.println("Result is"+result );



    }

    private static String minWindowString(String original, String toCompare) {

        Map<Character,Integer> toCompareMap = new HashMap<>();

        Map<Character,Integer> originalRunningMap = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end =0;

        for (int i = 0; i<toCompare.length();i++){

            Character c = toCompare.charAt(i);
            toCompareMap.put(c,toCompareMap.getOrDefault(c, 0)+1);
        }
        System.out.println("toCompareMap"+toCompareMap);
        int leftP =0 ; int rightP=0;

        while(rightP<original.length()){
            Character cRightP= original.charAt(rightP);
            originalRunningMap.put(cRightP,originalRunningMap.getOrDefault(cRightP,0)+1);
            rightP++;


            // since min widow so while (valid condition). 
            while(compare(originalRunningMap,toCompareMap)){
                System.out.println("each valid originalRunningMap"+originalRunningMap);
                System.out.println("Start"+leftP+"end"+rightP);
            if (rightP-leftP<min){
                //another min occurence found.
                start =leftP;
                end = rightP;
            }
            min  = Math.min(min,rightP-leftP);
            Character cLeftP = original.charAt(leftP);
            originalRunningMap.put(cLeftP,originalRunningMap.getOrDefault(cLeftP,0)-1);
            if(originalRunningMap.get(cLeftP)<=0){
                originalRunningMap.remove(cLeftP);
            }
            leftP++;

            }
        }
        System.out.println("min"+min);
        return original.substring(start, end);

    }

    private static boolean compare(Map<Character, Integer> originalRunningMap, Map<Character, Integer> toCompareMap) {
       System.out.println("originalRunning Map" + originalRunningMap);
       boolean result =false;
        for (Map.Entry<Character,Integer> entry : toCompareMap.entrySet()){
         //   System.out.println("entry"+entry);
            if( originalRunningMap.containsKey(entry.getKey()) && originalRunningMap.get(entry.getKey())>=toCompareMap.get(entry.getKey())){
                result=true;

            }
            else{
                return false;
            }
        
        
        }
        System.out.println("result boolean"+result);
        
        return result;
      
    }
    
}
