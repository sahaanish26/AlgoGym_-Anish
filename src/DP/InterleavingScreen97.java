package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InterleavingScreen97 {

    public static  boolean isInterleave(String s1, String s2, String s3) {
        HashMap<List<Integer>,Boolean> cache = new HashMap<>();

        return isInterleaveHelper(s1,s2,s3,0,0,0,cache);
        
    }

    public static boolean isInterleaveHelper(String s1, String s2, String s3, int index1,int index2,int index3,HashMap<List<Integer>,Boolean> cache) {

        //if s3 is finished but s1/s2 is stil there then false
        if (index3==s3.length()){
            if(index1<s1.length()|| index2<s2.length()){
                return false;
            }
        }

        //if 
       //when both strings are empty
        if(index1==s1.length()&&index2==s2.length()){
            //if s3 is also empty then solution found
            if(index3==s3.length()){
                return true;
                //if s3 is left or s3 is ehahusted  then solution can not be found
            }else{
                return false;
            }

           
        }
        
       //create key
       List<Integer> key = new ArrayList<>();
       key.add(index1);
       key.add(index2);
       key.add(index3);
       if(cache.containsKey(key)){
        return cache.get(key);
       }


        // there can be scenario when all chars of one of string s1,s2 can be selected but other one is there 
        //then choice will be only on available string
        //choose first char of s1 only if it is equal to first of s3 and s1 is not exhausted
        boolean option1 = false;
        boolean option2 = false;
        if(index1<s1.length() && s1.charAt(index1)==s3.charAt(index3)){
           
            option1=  isInterleaveHelper(s1,s2,s3,index1+1,index2,index3+1,cache);

        }

        if(index2<s2.length() && s2.charAt(index2)==s3.charAt(index3)){
           
            option2=  isInterleaveHelper(s1,s2,s3,index1,index2+1,index3+1,cache);

        }
        if(option1 || option2){
            cache.put(key, true);

         return true;
        }
        cache.put(key, false);
        return false;
        
    }
    

    public static void main(String[] args){

String s1 = "aabcc"; String s2 = "dbbca"; String s3 = "aadbbcbcac";
//String s1 = "aabcc";String  s2 = "dbbca"; String s3 = "aadbbbaccc";
System.out.println(isInterleave(s1,s2,s3));
        
    }
}
