package DP;

import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSSsumtotarget2915 {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int[][] cache =  new int [nums.size()][target+1];
        for (int i=0;i<nums.size();i++){

            for (int j=0;j<=target;j++){
                cache[i][j]=-2;

            }



        }
        

       // return lengthOfLongestSubsequenceHelper(nums,0,target,cache);

       return lengthOfShortestSubsequenceHelper(nums,0,target,cache);


        
    }


    public int lengthOfLongestSubsequenceHelper(List<Integer> nums, int index, int target, int[][] cache) {


        if (target==0){
            return 0;
        }

        if(target<0){

            // invalid sum can not be made

            return -1;
        }
        // if there are not enough coins to make 
        if(index>=nums.size()){
            return -1;

        }
        if(cache[index][target]!=-2){
            return cache[index][target];


        }
       int include1 = 0;
       // int exclude =-1;
        int include = lengthOfLongestSubsequenceHelper(nums,index+1,target-nums.get(index),cache);
        int exclude = lengthOfLongestSubsequenceHelper(nums,index+1,target,cache);

        if(include>=0){
            include1 = 1 + include;
        }else{
            include1=-1; 
        }
       
    
        cache[index][target]= Math.max(include1,exclude);
        return Math.max(include1,exclude);





        
    }
    

    public int lengthOfShortestSubsequenceHelper(List<Integer> nums, int index, int target, int[][] cache) {


        if (target==0){
            return 0;
        }

        if(target<0){

            // invalid sum can not be made

            return -1;
        }
        // if there are not enough coins to make 
        if(index>=nums.size()){
            return -1;

        }
        if(cache[index][target]!=-2){
            return cache[index][target];


        }
       int include1 = 0;
       // int exclude =-1;
        int include = lengthOfLongestSubsequenceHelper(nums,index+1,target-nums.get(index),cache);
        int exclude = lengthOfLongestSubsequenceHelper(nums,index+1,target,cache);

        if(include>=0){
            include1 = 1 + include;
        }else{
            include1=-1; 
        }

        if(exclude<0){
            exclude=include1;
        }
       
    
        cache[index][target]= Math.min(include1,exclude);
        return Math.min(include1,exclude);





        
    }


    public static void main (String[] args){

        LengthOfLongestSSsumtotarget2915 c = new LengthOfLongestSSsumtotarget2915();

       // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); // Creates a fixed-size list

     List<Integer> numbers = Arrays.asList(1,1,5,4,5);
       int target = 30;

       System.out.println(c.lengthOfLongestSubsequence(numbers,target));

    }
}
