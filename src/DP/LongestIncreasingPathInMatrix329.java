package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestIncreasingPathInMatrix329 {

    public static int longestIncreasingPath(int[][] matrix) {
    
            //Get longest increasing path starting at each position
           // int row=0;
           // int col =0;
           int max=0;
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            HashMap<List<Integer>,Integer> cache =  new HashMap<>();
            // get the max increasing path for each starting point.[ i.e taking each cell as a starting node]
            // the key to optimizing the solution is to create the cache and store the max starting at (i,j)
            // the (i,j) will be touched in multiple times during traversal which will reduce the count of recursion
            for(int i=0; i<matrix.length;i++){
                for(int j=0; j<matrix[0].length;j++){
           
            int res=  longestIncreasingPathHelper(matrix, i,j,-1,visited,cache);
            max = Math.max(max, res);
            System.out.println("res"+res+"at"+i +"*"+j);
                }
    
              
    
        }
                    return max;
           
                    
                }
            
               //work even without visited, since there is no chance of visiting the same node as we have the condition check on
               // increasing value
                private static int longestIncreasingPathHelper(int[][] matrix, int row, int col,int prev ,boolean[][] visited, HashMap<List<Integer>,Integer> cache){
                    //base cases
    
                if(row<0 || row>=matrix.length){
                    return 0;
                }
    
                if(col<0 || col>=matrix[0].length){
                    return 0;
                }
    
                    if(prev>=matrix[row][col]){
    
                    return 0;
                 }
                 //create key
                 List<Integer> key = new ArrayList<>();
                 key.add(row);
                 key.add(col);
                 if(cache.containsKey(key)){
                    System.out.println("cache Hit"+cache);
                    return cache.get(key);
                 }

                 int current = matrix[row][col];
                  //choose  
               //  visited[row][col]=true;
    
                 // now  explore all options
                 // option 1
                
                 // go to the right
    
                 int option1 = longestIncreasingPathHelper(matrix,row,col+1,current,visited,cache);
                  // go to the left
                 int option2 = longestIncreasingPathHelper(matrix,row,col-1,current,visited,cache);
    
                   // go to the top
                 int option3 = longestIncreasingPathHelper(matrix,row-1,col,current,visited,cache);
    
                     // go to the bottom
                 int option4 = longestIncreasingPathHelper(matrix,row+1,col,current,visited,cache);
    
                    //answer is 1(lenght of current choice) + max (optionss)
    
                  int max =  Math.max(Math.max(option3, option4),Math.max(option1, option2));
    
                  int ans = 1 + max;
    
    
                // unchoose
               // visited[row][col]=true;
                
                cache.put(key,ans);
                return ans;
    
    
    
    
    
    
                           }
    
    
                         
            
                           public static void main(String[] args){
    
                           int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
                           int ans = longestIncreasingPath(matrix);
                           System.out.println("ans"+ans);

                       }

}
