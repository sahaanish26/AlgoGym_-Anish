package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LongestIncreasingSequence300 {

       
        public int lengthOfLIS(int[] nums) {
            HashMap<Integer, Integer> memo = new HashMap<>((nums.length*4)/3+1);
            HashMap<List<Integer>, Integer> memo1 = new HashMap<>((nums.length*4)/3+1);
            // since prev index can be from -1 to n-1 so length shold be length +1
            int[][] memoArray = new int[nums.length][nums.length+1];
            for (int i=0 ; i<nums.length;i++){

                for (int j=0;j<=nums.length;j++){
                    memoArray[i][j]=-1;
                }
            }
           // return solve1(nums, -1, 0, memo);
           // return solve(nums, -1, 0, memo);
           return solveWithArray(nums, -1, 0, memoArray);
        }
        
    
        private int solve1(int[] nums, int prevIndex, int currentIndex, HashMap<String, Integer> memo) {
            if (currentIndex == nums.length) {
                return 0;
            }
    
            String key = prevIndex + "-" + currentIndex;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
    
            // Explore: Option 1: Don't choose the current element
            int exclude = solve1(nums, prevIndex, currentIndex + 1, memo);
    
            // Explore: Option 2: Choose the current element if it's greater than the previous
            int include = 0;
            if (prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
                include = 1 + solve1(nums, currentIndex, currentIndex + 1, memo);
            }
            
            // Choose the best option
            int result = Math.max(include, exclude);
            
            // Memoize the result
            memo.put(key, result);
            return result;
        }
        
        private int solve2(int[] nums, int prevNum, int currentIndex, HashMap<Integer, Integer> memo) {
            if (currentIndex >= nums.length) {
                return 0;
            }
    
            int key = currentIndex*nums.length +prevNum;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
    
            // Explore: Option 1: Don't choose the current element
            int exclude = solve(nums, prevNum, currentIndex + 1, memo);
    
            // Explore: Option 2: Choose the current element if it's greater than the previous
            int include = 0;
            if ( nums[currentIndex] > prevNum) {
                include = 1 + solve(nums, nums[currentIndex], currentIndex + 1, memo);
            }
            
            // Choose the best option
            int result = Math.max(include, exclude);
            
            // Memoize the result
            memo.put(key, result);
            return result;
        }
        
    
        private int solve(int[] nums, int prevIndex, int currentIndex, HashMap<Integer, Integer> memo) {
            if (currentIndex >= nums.length) {
                return 0;
            }
    
            int key = currentIndex*nums.length +prevIndex;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
    
            // Explore: Option 1: Don't choose the current element
            int exclude = solve(nums, prevIndex, currentIndex + 1, memo);
    
            // Explore: Option 2: Choose the current element if it's greater than the previous
            int include = 0;
            if ( prevIndex == -1  || nums[currentIndex] > nums[prevIndex]) {
                include = 1 + solve(nums, currentIndex, currentIndex + 1, memo);
            }
            
            // Choose the best option
            int result = Math.max(include, exclude);
            
            // Memoize the result
            memo.put(key, result);
            return result;
        }
       
        private int solve4(int[] nums, int prevIndex, int currentIndex, HashMap<List<Integer>, Integer> memo) {
            if (currentIndex >= nums.length) {
                return 0;
            }
    
           // int key = currentIndex*nums.length +prevIndex;
            List<Integer> key = new ArrayList<>();
            key.add(currentIndex);
            key.add(currentIndex);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
    
            // Explore: Option 1: Don't choose the current element
            int exclude = solve4(nums, prevIndex, currentIndex + 1, memo);
    
            // Explore: Option 2: Choose the current element if it's greater than the previous
            int include = 0;
            if ( prevIndex == -1  || nums[currentIndex] > nums[prevIndex]) {
                include = 1 + solve4(nums, currentIndex, currentIndex + 1, memo);
            }
            
            // Choose the best option
            int result = Math.max(include, exclude);
            
            // Memoize the result
            memo.put(key, result);
            return result;
        }
       

        private int solveWithArray(int[] nums, int prevIndex, int currentIndex, int[][]memo ){
        if (currentIndex == nums.length) {
            return 0;
        }
            
    
           // int key = currentIndex*nums.length +prevIndex;
           // if (memo.containsKey(key)) {
             //   return memo.get(key);
          //  }
           //using previousIndex+1 bceause prev index starts with -1, but array can not have -1 index
            // so prevIndex will be +1
          if(memo[currentIndex][prevIndex+1]!=-1){
            return   memo[currentIndex][prevIndex+1];

          }
    
            // Explore: Option 1: Don't choose the current element
            int exclude = solveWithArray(nums, prevIndex, currentIndex + 1, memo);
    
            // Explore: Option 2: Choose the current element if it's greater than the previous
            int include = 0;
            if ( prevIndex == -1  || nums[currentIndex] > nums[prevIndex]) {
                include = 1 + solveWithArray(nums, currentIndex, currentIndex + 1, memo);
            }
            
            // Choose the best option
            int result = Math.max(include, exclude);
            
            // Memoize the result
          //  memo.put(key, result);
           //using previousIndex+1 bceause prev index starts with -1, but array can not have -1 index
            // so prevIndex will be +1
          memo[currentIndex][prevIndex+1] = result;
            return result;
        }
      
}
