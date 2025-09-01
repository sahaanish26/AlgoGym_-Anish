package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class palindromepartitioning131 {

    // Decisions:Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s

//Lets handle One decision ourselves and the rest by recursion
//One Decision=smallest unit of work: do/place one partition
//rest by recursion = pass the remaining string to same funcion
//Available Choices for this Decision : after one place/char of s or after two place/chars of s or after three place/chars of s 
//...upto last  place. since the entire string is also a valid partition
//Available safe choices :if string till 1 place , 2 places .. upto last place are pallindrome. [ This is where caching might be used]
//Choose with each choice , explore/search->recursion , Un-choose
//Base case ⇒no more decisions to make: when there are no more chars left .i.e string is empty. 


    public static List<List<String>> partition(String s) {
    
        List<List<String>> result =  new ArrayList<>();
        List<String> oneValidPartition =  new ArrayList<>();
        Set<String> pallindromeString = new HashSet<>();
    
        partitionHelper(s,oneValidPartition,result,pallindromeString);
    
    
        return result;
            
        }
    
        public  static void partitionHelper(String s,List<String> oneValidPartition, List<List<String>> result, Set<String> pallindromeString) {
    
            //Base case ⇒no more decisions to make: when there are no more chars left .i.e string is empty. 
            if(s.isEmpty()){
                result.add(new ArrayList<>(oneValidPartition));
            }
            System.out.println("pallindromeString"+pallindromeString);
            
            //Available Choices for this Decision : after one place/char of s or after two place/chars of s or after three place/chars of s 
            //...upto last  place. since the entire string is also a valid partition
           
            for (int i=0;i<s.length();i++){
                //since substring(i,j) excludes the jth index so passing as i+1
                String eachChoice = s.substring(0, i+1);
                String remainingString = "";
                if(i<s.length()-1){
                    remainingString = s.substring(i+1);
                }
               
                if(isPallindrome(eachChoice,0,i,pallindromeString)){
                    //choose the valid choice
                    oneValidPartition.add(eachChoice);
                    //explore with the valid choice
                    ////rest by recursion = pass the remaining string to same funcion
                    partitionHelper(remainingString,oneValidPartition,result,pallindromeString);
                    //unchoose
                    oneValidPartition.remove(oneValidPartition.size()-1);
    
    
                }
                         
                
                        }
                
                        
                
                        
                        
                    }
                
                    private static boolean isPallindrome(String eachChoice, int left, int right,Set<String> pallindromeString ) {

                        if(pallindromeString.contains(eachChoice)){
                            return true;
                        }
    
                        while(left<right){
                            if(eachChoice.charAt(left)!=eachChoice.charAt(right)){
                                return false;
                            }
                            left++;
                            right--;
                        }
                        //before returning true add it to the set
                        pallindromeString.add(eachChoice);
                        return true;
                       
                          }
    
                          public static void main(String[] args){
    
    
                            String s ="aabaa";
                            System.out.println(partition(s));
                      }
}
