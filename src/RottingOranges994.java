import java.util.*;
public class RottingOranges994 {

    public static void main(String[] args){
       // int [][]grid = {{2,1,1},{0,1,1},{1,0,1}};
        int [][]grid = {{0,2}};
       
       
     System.out.println(orangesRotting(grid));

    }


    public static int orangesRotting(int[][] grid) {
     Queue<int[]> rottenOranges = new LinkedList();
     int freshOrange = 0;
     int rottenOrange =0;
     int emptyCell =0;

     for (int i=0;i<grid.length;i++){
        for (int j=0;j<grid[0].length;j++){
            int currentGridValue = grid[i][j];
            if(currentGridValue==0){
                emptyCell++;
            }else if(currentGridValue==1){
                freshOrange++;
            }
            else if(currentGridValue==2){
                rottenOrange++;
                //add all rottenOranges cells into queue
                int[] rottenOrangeGrid = new int[2];
                rottenOrangeGrid[0]=i;
                rottenOrangeGrid[1]=j;
                rottenOranges.add(rottenOrangeGrid);
            }

        }
     }
   //  System.out.println("freshOrange"+freshOrange);
    // System.out.println("rottenOrange"+rottenOrange);
   //  System.out.println("emptyCell"+emptyCell);
    


     if (freshOrange==0){return 0;}


//start bfs
int level =0;
Set<List<Integer>> visitedCells = new HashSet<>();
  

while(!rottenOranges.isEmpty()&& freshOrange>0 ){
   // System.out.println("**"+rottenOranges.size());
    //fatal mistake never add array as key in hashset or hashmap
   int qSize=rottenOranges.size();
  // System.out.println("qSize"+rottenOranges.size());
   
    //if (level>5){break;}
   for (int k=0;k<qSize;k++){
    int[] currentRottenOrange = rottenOranges.poll();
   // System.out.println("currentRottenOrange"+Arrays.toString(currentRottenOrange));
    List<Integer> currentNode = new ArrayList<>();
    currentNode.add(0,currentRottenOrange[0]);
    currentNode.add(1,currentRottenOrange[1]);
    visitedCells.add(currentNode);
    

    List<int[]> neighBouringRottenOranges = new ArrayList<>();
    int currentRow=currentRottenOrange[0];
    int currentColumn = currentRottenOrange[1];
    //check for left of current grid
    if(currentColumn>0){
       int rowLeftGrid =currentRow;
       int colLeftGrid = currentColumn-1;
       //works without 2 check as well
       if(grid[rowLeftGrid][colLeftGrid]==1 || grid[rowLeftGrid][colLeftGrid]==2 ){
        int[] left = new int[2];
        left[0]=rowLeftGrid;
        left[1]=colLeftGrid;
        neighBouringRottenOranges.add(left);
       }
    }

    //check for right of current grid
    if(currentColumn<grid[0].length-1){
        int rowRightGrid =currentRow;
        int colRightGrid = currentColumn+1;
        if(grid[rowRightGrid][colRightGrid]==1 || grid[rowRightGrid][colRightGrid]==2  ){
         int[] right = new int[2];
         right[0]=rowRightGrid;
         right[1]=colRightGrid;
         neighBouringRottenOranges.add(right);
        }
     }

     //check for upper of current grid
    if(currentRow>0){
        int rowUpperGrid =currentRow-1;
        int colUpperGrid = currentColumn;
        if(grid[rowUpperGrid][colUpperGrid]==1||grid[rowUpperGrid][colUpperGrid]==2 ){
         int[] upper = new int[2];
         upper[0]=rowUpperGrid;
         upper[1]=colUpperGrid;
         neighBouringRottenOranges.add(upper);
        }
     }

      //check for lower of current grid
    if(currentRow<grid.length-1){
        int rowLowerGrid =currentRow+1;
        int colLowerGrid = currentColumn;
        if(grid[rowLowerGrid][colLowerGrid]==1 ||grid[rowLowerGrid][colLowerGrid]==2 ){
         int[] lower = new int[2];
         lower[0]=rowLowerGrid;
         lower[1]=colLowerGrid;
         neighBouringRottenOranges.add(lower);
        }
     }

     for (int[] neighbour :neighBouringRottenOranges){
        List<Integer> neighbourList = new ArrayList<>();
        neighbourList.add(0,neighbour[0]);
        neighbourList.add(1,neighbour[1]);
       // System.out.println("neighbourList"+neighbourList);
      //  System.out.println("visitedCells"+visitedCells);
  
       if(!visitedCells.contains(neighbourList)){
            //update neighbour to rotten tomato and add in queue
            int row =neighbour[0];
            int col = neighbour[1];
            if(grid[row][col]==1){
                grid[row][col]=2;
                freshOrange--;
            }
            //if the orange is already rotten no need to change and empty cell can not be there in neigbours

            rottenOranges.add(neighbour);
        }
     }

   }
   level =level+1;
  // System.out.println("freshOrange"+freshOrange+"at level"+level);
}

  // System.out.println("freshOrange"+freshOrange);
        if(freshOrange!=0){return -1;}

        return level;
        
    }
    
}
