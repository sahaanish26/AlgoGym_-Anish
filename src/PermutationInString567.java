import java.util.*;
public class PermutationInString567 {


    public static void main(String[] args){
      // String s1 = "ab";
      // String s2 = "eidbkooo";

       String s1 = "adc";
       String s2 = "dcda";
       System.out.println(checkInclusion(s1,s2));

    }



    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length()>s2.length()){
            return false;
        }
        int startWindow=0;
        int endWindow=0;
        //make the fixed window
        int windowSize =s1.length();
        Map<Character,Integer> targetMap= new HashMap();
        Map<Character,Integer> matchMap= new HashMap();


        for(int i=0;i<s1.length();i++){
          //  targetMap.put(s1.charAt(i),targetMap.getOrDefault(s1.charAt(i),0)+1);
            matchMap.put(s1.charAt(i),matchMap.getOrDefault(s1.charAt(i),0)+1);
            

        }

        while(endWindow-startWindow<windowSize){
            System.out.println("targetMap in first while loop"+targetMap);
            Character c = s2.charAt(endWindow);
            if(matchMap.containsKey(c)){
                targetMap.put(c, targetMap.getOrDefault(c,0)+1);
                
            }
            if (targetMap.equals(matchMap)){
                return true;
             }
            
            endWindow++;           
        }
        //restore endWindow
        endWindow--;
        System.out.println("start"+startWindow+"endWindow"+endWindow);

        while(endWindow<s2.length()-1){

            Character charRemoveFromWindow = s2.charAt(startWindow);
            System.out.println("charRemoveFromWindow"+charRemoveFromWindow);
            if(matchMap.containsKey(charRemoveFromWindow)){
                targetMap.put(charRemoveFromWindow, targetMap.getOrDefault(charRemoveFromWindow,0)-1);
                
            }
            System.out.println("targetMap in second  while loop after add "+targetMap);
           
            startWindow++;
            endWindow++;
            Character charAddToWindow = s2.charAt(endWindow);
            System.out.println("charAddToWindow"+charAddToWindow);
           
            if(matchMap.containsKey(charAddToWindow)){
                targetMap.put(charAddToWindow, targetMap.getOrDefault(charAddToWindow,0)+1);
                
            }

            System.out.println("targetMap in second  while loop after remove "+targetMap);
           
            if (targetMap.equals(matchMap)){
                return true;
             }
                    
        }





        return false;
        
    }
    
}
