package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RottingOrange994 {
    public static  int orangesRotting(int[][] grid) {

        //loop through the grid        
        
        //a  Count the rotten oranges  and put the rotten oranges in a queue, visited set
        //b) count fresh orange
        //c) count empty cell
        //After the BFS at the end if all oranges can be rotten then at the end rootten count = initial rotten count + fresh count else all
        // oranges can not be rotten
        //alterntively we can decrement the fresh orange count and check if frshorange count is 0.
        
        
        
        //BFS 
        //BFS from all the rotten oranges , do level by level traversal
        // at each level keep the count of queue and sum them up , that will give total rotten number at the end of bfs.
        // put the directioanly available fresh oranges into rotten queue only if those has not been visited or 
        // do not put any empty cell into rotten queue.
        //keep count of level 
        //at the end level is the answer if total number of rotten = a+b else -1;
         //alterntively we can decrement the fresh orange count and check if frshorange count is 0.
       
        
        //a  Count the rotten oranges  and put the rotten oranges in a queue, visted set
        //b) count fresh orange
        //c) count empty cell
        
        int rottenOrange =0;
        int freshOrange =0 ;
        int empty=0;
        Queue<List<Integer>> rottenQueue = new LinkedList<>();
        Set<List<Integer>> rottenQueueSet = new HashSet<>();
        for (int i =0; i<grid.length;i++){
        
            for (int j=0;j<grid[i].length; j++){
        
                if (grid[i][j] ==2 ){
                    List<Integer> gridBlock = new ArrayList<>();
                    gridBlock.add(i);
                    gridBlock.add(j);
                    //set in BFS Q
                    rottenQueue.add(gridBlock);
                    //set in visited Que
                    rottenQueueSet.add(gridBlock);
        
                    rottenOrange++;
        
                }else if (grid[i][j] ==1){
                    freshOrange++;
                }
                else if (grid[i][j] ==0){
                    empty++;
                }
        
        
            }
        }
        
        
        int copyFreshOrange= freshOrange;
        //if there are no rotten orange and no fresh orange either then return 0
        //check added in second attempt. in first attempt 305/307 passes. fail case [[0]].
        if(rottenOrange==0 && freshOrange==0 ){
            return 0;
        }
        
        //After the BFS at the end if all oranges can be rotten then at the end rootten count = initial rotten count + fresh count else all
        // oranges can not be rotten
        
        
        
        //BFS 
        //BFS from all the rotten oranges , do level by level traversal
        // at each level keep the count of queue and sum them up , that will give total rotten number at the end of bfs.
        // put the directioanly available fresh oranges into rotten queue only if those has not been visited or 
        // do not put any empty cell into rotten queue.
        //keep count of level 
        //at the end level is the answer if total number of rotten = a+b else -1;
        int level =0;
        int sumOfAllRottenOrangeAfterBFS =0 ;
        while(!rottenQueue.isEmpty()){
        
        int sizeAteachlevel = rottenQueue.size();
        sumOfAllRottenOrangeAfterBFS=sumOfAllRottenOrangeAfterBFS+sizeAteachlevel;
        
        for (int i=0;i<sizeAteachlevel;i++){
        
        List<Integer> currentRottenOrange = rottenQueue.poll();
        int currentRow = currentRottenOrange.get(0);
        int currentCol = currentRottenOrange.get(1);
        
        
        
        List<Integer> leftToCurrent = new ArrayList<>();
        
        if (currentCol>0){
            leftToCurrent.add(currentRow);
            leftToCurrent.add(currentCol-1);
        
            if(!rottenQueueSet.contains(leftToCurrent)){
           // if grid to left has fresh orange
           if(grid[currentRow][currentCol-1] ==1){
           
            //make the orange rotten
            grid[currentRow][currentCol-1]=2;
            copyFreshOrange--;
            //put rotten orange in queue
            rottenQueue.add(leftToCurrent);
            rottenQueueSet.add(leftToCurrent);
        
        
           }
        }
        }
        
        List<Integer> rightToCurrent = new ArrayList<>();
        
        if ( currentCol<grid[0].length-1 ){
            rightToCurrent.add(currentRow);
            rightToCurrent.add(currentCol+1);
        
            if(!rottenQueueSet.contains(rightToCurrent)){
           // if grid to left has fresh orange
           if(grid[currentRow][currentCol+1] ==1){
           
            //make the orange rotten
            grid[currentRow][currentCol+1]=2;
            copyFreshOrange--;
            //put rotten orange in queue
            rottenQueue.add(rightToCurrent);
            rottenQueueSet.add(rightToCurrent);
        
        
           }
        }
        }
        
        List<Integer> aboveToCurrent = new ArrayList<>();
        
        if ( currentRow>0){
            aboveToCurrent.add(currentRow-1);
            aboveToCurrent.add(currentCol);
        
            if(!rottenQueueSet.contains(aboveToCurrent)){
           // if grid to left has fresh orange
           if(grid[currentRow-1][currentCol] ==1){
           
            //make the orange rotten
            grid[currentRow-1][currentCol]=2;
            copyFreshOrange--;
            //put rotten orange in queue
            rottenQueue.add(aboveToCurrent);
            rottenQueueSet.add(aboveToCurrent);
        
        
           }
        }
        
        
        }
        
        List<Integer> downToCurrent = new ArrayList<>();
        
        
        if ( currentRow<grid.length-1){
            downToCurrent.add(currentRow+1);
            downToCurrent.add(currentCol);
        
            if(!rottenQueueSet.contains(downToCurrent)){
           // if grid to left has fresh orange
           if(grid[currentRow+1][currentCol] ==1){
           
            //make the orange rotten
            grid[currentRow+1][currentCol]=2;
            copyFreshOrange--;
            //put rotten orange in queue
            rottenQueue.add(downToCurrent);
            rottenQueueSet.add(downToCurrent);
        
        
           }
        }
        
        
        }
        
        
        
        
        
        
        
        }
        
        level++;
        
        
        }
        
        //System.out.println("copyFreshOrange"+copyFreshOrange);
        //System.out.println("sumOfAllRottenOrangeAfterBFS"+sumOfAllRottenOrangeAfterBFS);
        //System.out.println("freshOrange"+freshOrange);
        //System.out.println("empty"+empty);
        
        
        //if(sumOfAllRottenOrangeAfterBFS==rottenOrange+freshOrange){
        
            //return level-1;
        //}
        //alternaively if at then end copyFreshOrange>0 then also we can return -1
        
        if(copyFreshOrange>0){
            return -1;
        }
        //level -1 because at 0 the they are inflcitng , caught in debugging.
        return level -1;
            }
        
        
    public static void main(String[]args){

       // int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
     //   int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = {{0,2}};

        System.out.println(orangesRotting(grid));


    }
}
    
