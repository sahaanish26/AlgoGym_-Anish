package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistinctSubsequences115 {

    public static int numDistinct(String s, String t) {
        HashMap<List<Integer>,Integer> cache = new HashMap<>();

        int sLen = s.length();
        int tLen = t.length();
        int[][] memo = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            for (int j = 0; j <= tLen; j++) {
                memo[i][j] = -1;
            }
        }

       return numDistinctHelper(s,t,0,0,memo);
        
    }

    
    public static int numDistinctHelper(String s, String t,int sIndex, int tIndex,  int[][] memo) {
        //System.out.println(sIndex+"*"+tIndex);
          //base cases
          //if both are empty then there is only one way to get 
          if(sIndex>=s.length() && tIndex>=t.length()){
              return 1;
          }
  
          // t is exhausted but s is still there. there is only 1 distinct empty subsequence. and only one way to get it
          if( tIndex>=t.length() && sIndex<s.length()){
              return 1;
          }
           
          // if s is exhausted but t is not then there can not be anyway.
           if( sIndex==s.length() && tIndex<t.length()){
              return 0;
          }
  
        
          if (memo[sIndex][tIndex] != -1) {
            return memo[sIndex][tIndex];
        }
          
  
          //check for caching
          // if the starting chars are equal
          int numWays1=0;
          int numWays2=0;
          int numWays3=0;
  
          if(s.charAt(sIndex)==t.charAt(tIndex)){
  
              //we can either take the first match 
  
              numWays1= numDistinctHelper(s,t,sIndex+1,tIndex+1,memo);
  
              // or we can check if skipping this char of S, can we still get the same char
  
              numWays2 = numDistinctHelper(s,t,sIndex+1,tIndex,memo);
  
  
          }else{
             //we skip current char of S and see if from the next char it starts matching
             numWays3= numDistinctHelper(s,t,sIndex+1,tIndex,memo);
          }
          int ans  = numWays1+numWays2+numWays3;
          memo[sIndex][tIndex] = ans;
          return  ans;
  
  
  
  
  
          
      }
     
      public static int numDistinctHelper1(String s, String t,int sIndex, int tIndex, HashMap<List<Integer>,Integer> cache) {
        //System.out.println(sIndex+"*"+tIndex);
          //base cases
          //if both are empty then there is only one way to get 
          if(sIndex>=s.length() && tIndex>=t.length()){
              return 1;
          }
  
          // t is exhausted but s is still there. there is only 1 distinct empty subsequence. and only one way to get it
          if( tIndex>=t.length() && sIndex<s.length()){
              return 1;
          }
           
          // if s is exhausted but t is not then there can not be anyway.
           if( sIndex==s.length() && tIndex<t.length()){
              return 0;
          }
  
          List<Integer> key = new ArrayList<>();
          key.add(sIndex);
          key.add(tIndex);
  
          if(cache.containsKey(key)){
             // return cache.get(key);
          }
  
          //check for caching
          // if the starting chars are equal
          int numWays1=0;
          int numWays2=0;
          int numWays3=0;
  
          if(s.charAt(sIndex)==t.charAt(tIndex)){
  
              //we can either take the first match 
  
              numWays1= numDistinctHelper1(s,t,sIndex+1,tIndex+1,cache);
  
              // or we can check if skipping this char of S, can we still get the same char
  
              numWays2 = numDistinctHelper1(s,t,sIndex+1,tIndex,cache);
  
  
          }else{
             //we skip current char of S and see if from the next char it starts matching
             numWays3= numDistinctHelper1(s,t,sIndex+1,tIndex,cache);
          }
          int ans  = numWays1+numWays2+numWays3;
          cache.put(key, ans);
          return  ans;
  
  
  
  
  
          
      }
     

    public static void main(String[] args){

       // String s = "rabbbit";
      //  String t ="rabbit";

        //String s = "rabbbit";
       // String t ="";

       // String s = "babgbag";
        //String t ="bag";

        //TLE with hashMap but not with 2d map
        
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String t = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(numDistinct(s,t));
    }

}
