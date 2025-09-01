package DP;

import java.util.HashMap;
import java.util.Map;

public class EditDistance72 {

    public int minDistance(String word1, String word2) {
        Map<String,Integer> cache = new HashMap<>();

        return minDistanceHelper(word1,0,word2,0,cache);
        
        
    }


    public int minDistanceHelper(String word1, int word1Start,String word2,int word2Start, Map<String,Integer> cache ) {

        System.out.println("word1"+word1+"word1Start"+word1Start+"word2"+word2+"word2Start"+word2Start);

        // base cases 
        //when both word1 and word2 is empty
        if(word1Start>=word1.length() && word2Start>=word2.length()){
            return 0;
        }
        //when word1 is empty but word2 is remaining
        //return the lenght of the remaining word2
        if(word1Start>=word1.length()){
            return word2.length() -word2Start;


        }

         //when word2 is empty but word1 is remaining
        //return the lenght of the remaining word1
        if(word2Start>=word2.length()){
            return word1.length() -word1Start;


        }
        
        String key= String.valueOf(word2Start)+"#"+String.valueOf(word1Start);
        if (cache.containsKey(key)){
            return cache.get(key);
        }


        // now comes the choices for exploration

        int option1 =Integer.MAX_VALUE;
        int option2 =Integer.MAX_VALUE ;
        int option3 =Integer.MAX_VALUE ;
        int option4 =Integer.MAX_VALUE;

        //case1 when the first char of both words are same
        if(word1.charAt(word1Start)==word2.charAt(word2Start)){
            // there are no operations required , hence no 1 +
              // explore the remaining part of both words

         option1 =  minDistanceHelper(word1,word1Start+1,word2,word2Start+1,cache);
       // cache.put(key, option1);

       // return option1;
        }  // when first char is not same
        else{
            // replace the current char from  word1 to make that equal to current char from word2
            // 1 + is for the operation
            // explore the remaining part of both words
             option2 = 1 +  minDistanceHelper(word1,word1Start+1,word2,word2Start+1,cache);

            // delete the current character from word1
             // 1 + is for the operation
             // explore the remaining part of both words
             option3 = 1+ minDistanceHelper(word1,word1Start+1,word2,word2Start,cache);

 // add a character(same as current character of word2) in the front of  the current character from word1 
             // 1 + is for the operation
             // explore the remaining part of both words
             option4 = 1+ minDistanceHelper(word1,word1Start,word2,word2Start+1,cache);

           // int combined = Math.min(option2,Math.min(option3,option4));
           // cache.put(key, combined);
          //  return combined;

        }
      
        int combined = Math.min(Math.min(option1,option2),Math.min(option3,option4));
        cache.put(key, combined);
        return combined;

        
    }

}
