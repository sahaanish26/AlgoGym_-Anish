package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses93 {

 public static List<String> restoreIpAddresses(String s) {
 
   // Decisions:Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s

   // Lets handle One decision ourselves and the rest by recursion
   // One Decision=smallest unit of work: Insert one dot
  //  Available Choices for this Decision : after one place/char of s or after two place/chars of s or after three place/chars of s (since o-255 allowed)
   // Available safe choices :all the constraints i. e less than 255 , can not start with 0, 
   // Choose with each choice , explore/search->recursion , Un-choose
   // Base case ⇒no more decisions to make: when there are no more digits and 4”. “Are already on the path. 
    
 

 List<String> allPaths = new ArrayList<>();
 List<String> sb = new ArrayList<>();
 if (s.length()<4){
    return allPaths;

 }
 
 restoreIpAddressesHelper(s,sb,allPaths,0);
 
 return allPaths;
 
         
     }
 
 
     public static  void restoreIpAddressesHelper(String s , List<String> sb, List<String> allPaths, int dotcount){
 
       //System.out.println("sb"+sb);
       //System.out.println("dotcount"+dotcount);
 
       if(s.isEmpty() && dotcount==4 ){
        //dont do this as this will cause issue during backtracking when
        // those are deleted as part of unchoose
        // sb.remove(sb.size()-1);
        System.out.print(sb);
        StringBuilder sb1 =  new StringBuilder();
        for (String s1: sb){
            sb1.append(s1);
        }
        //iterate over list sb and all of them to make the resultant
        //that resultant need to be added in allPaths.
        String resultant = sb1.toString();
       // System.out.print("resultant"+resultant);
        //take out the 4th dot from the resultant string
         allPaths.add(resultant.substring(0, resultant.length() - 1));
      //   System.out.print("allPaths"+allPaths);
       }
 
       if(s.isEmpty()){
         return;
       }
 
       if( dotcount>4 ){
         return;
       }
       //if .is 4 but stil s is there then return since ..it can not be valid.
 
       //(three dots are placed and the number is within 0 to 255 and no trailing 0s then add the number to the path and add it to allpaths)
       // other condition can be if 4 . are placed already and the s is empty then we can add the path to allpaths. the path is valid from
       //the fact that . Also delete the last . from path before adding in allpaths
      //once choice
      char firstCharOnly = s.charAt(0); // can we use str.substring(0, 1);
      String strFirstCharOnly = String.valueOf(firstCharOnly);
      //add the .
      strFirstCharOnly =strFirstCharOnly + ".";
     // sb.add(firstCharOnly);
     // sb.add('.');
      sb.add(strFirstCharOnly);
      //explore with that choice
      restoreIpAddressesHelper(s.substring(1),sb,allPaths,dotcount+1);
 
      //unchoose the .
      sb.remove(sb.size()-1);
      
      
 
 
      //second choice
      //add the first two char as choice
      // but only if s length is more than 1 and  the first of the two char is not 0 and 
      if(s.length()>1 && !(s.charAt(0)=='0') ){
    
      String strFirstTwochar = s.substring(0, 2);
      strFirstTwochar = strFirstTwochar + ".";
      sb.add(strFirstTwochar);
      //explore with that choice
      restoreIpAddressesHelper(s.substring(2),sb,allPaths,dotcount+1);
      //unchoose 
      sb.remove(sb.size()-1);
      
    }
 
      //third choice
      //add the three  char as choice
      //// but only if s length is more than 2 the first of the two char is not 0  and value is less than 255
    
      if(s.length()>2 && !(s.charAt(0)=='0') && Integer.parseInt(s.substring(0, 3))<=255) {
     

      String strFirstThreechar = s.substring(0, 3);
      strFirstThreechar = strFirstThreechar + ".";
      sb.add(strFirstThreechar);
      //explore with that choice
      restoreIpAddressesHelper(s.substring(3),sb,allPaths,dotcount+1);
 
      //unchoose 
      sb.remove(sb.size()-1);
     
     
      
    }
     
 
     }
 
 
     public static void main(String[] args){
 
        String  s = "101023";
        System.out.println("main method");
        System.out.println("final result"+restoreIpAddresses(s));

    }
}
