package DFS;

import java.util.Arrays;

public class UniquePathsii980 {

    public static int uniquePathsIII(int[][] grid) {
    
            int m = grid.length;
            int n = grid[0].length;
            boolean [][] visited = new boolean[m][n];
            int[] start = new int[2];
            int [] end = new int[2];
            int countAvailaablecells=0;
    
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        start[0] =i;
                        start[1]=j;
                        // this is a very key step ..even the starting node has to be
                        //counted as available since we are doing -1 as we choose the start point
                        countAvailaablecells++;
    
                    }else  if(grid[i][j]==2){
                        end[0] =i;
                        end[1]=j;
    
                    }else  if(grid[i][j]==0){
                        countAvailaablecells++;
    
                    }
    
    
                }
            }
          // System.out.println("countAvailaablecells"+countAvailaablecells+"start"+Arrays.toString(start)+"end"+Arrays.toString(end));
            int result = dfsHelper(start[0],start[1],end[0],end[1],visited,countAvailaablecells,grid);
                        
                                return result;
                            }
                        
                            // there is a scope to memoize with row,col and countAvailaablecells
                            private static int dfsHelper(int startI, int startJ, int endI, int endJ, boolean[][] visited, int countAvailaablecells, int[][] grid) {
   // System.out.println("startI"+startI);
    //System.out.println("startJ"+startJ);
   // System.out.println("countAvailaablecells"+countAvailaablecells);
                    //// invalid conditions
                    // invalid coordinates
                    if(startI<0 || startJ<0|| startI>=grid.length|| startJ>=grid[0].length){
                        return 0;
                    }
                    // if already visited , in grid based problem instead of checking "all unvisited neighbour"
                    // while calling doing it after the call is made
                    if(visited[startI][startJ]){
                        return 0;
                    }
                    // if this is an obstacle
                    if(grid[startI][startJ]==-1){
                        return 0;
                    }
                       
                    // when a valid path is found
                       if(startI==endI && startJ==endJ && countAvailaablecells==0){
    
                        return 1;
                       }
    
                       //choose
                       visited[startI][startJ]=true;
                       int result=0;
    
                       // explore all paths
    
                       int result1 = dfsHelper(startI,startJ+1,endI,endJ,visited,countAvailaablecells-1,grid) ;
                       int result2 = dfsHelper(startI,startJ-1,endI,endJ,visited,countAvailaablecells-1,grid) ;
                       int result3 = dfsHelper(startI+1,startJ,endI,endJ,visited,countAvailaablecells-1,grid) ;
                       int result4 = dfsHelper(startI-1,startJ,endI,endJ,visited,countAvailaablecells-1,grid) ;
                      
                       result = result1+result2+result3+result4;
                     
                      //unchoose
                      visited[startI][startJ]=false;
    
    
                       return result;
    
                         }
    
    
               public static void main(String[] args)  {
          // int[][] grid ={{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
           int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
          //int[][] grid = {{0,1},{2,0}};
                int rs = uniquePathsIII(grid);

                System.out.println("rs"+rs);

            
           }        
}
