package BFS;
import java.util.*;
public class PacificAtlanticWaterFlow417 {


    public static void main(String[] args){

  int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

  pacificAtlantic(heights);

    }


    public static  List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();
        Queue<List<Integer>> pacificQueue = new LinkedList();
        Set<List<Integer>> pacificVisitedSet =  new HashSet();
        Queue<List<Integer>> atlanticQueue = new LinkedList();
        Set<List<Integer>> atlanticVisitedSet =  new HashSet();



        for (int i=0;i<heights.length;i++){

            for (int j=0;j<heights[0].length;j++){
                //on atlantic
                if(i==heights.length-1 || j==heights[0].length-1){
                    List<Integer> grid = new ArrayList();
                    grid.add(i);
                    grid.add(j);
                   
                    if(!atlanticVisitedSet.contains(grid)){
                        atlanticVisitedSet.add(grid);
                        atlanticQueue.add(grid);

                       
                    }
                  


                }

                //on pacific
                if(i== 0|| j==0){
                    List<Integer> grid = new ArrayList();
                    grid.add(i);
                    grid.add(j);
                   
                    if(!pacificVisitedSet.contains(grid)){
                        pacificVisitedSet.add(grid);
                        pacificQueue.add(grid);
                    }

                }
            }
        }

        System.out.println("pacificQueue"+pacificQueue+"pacificVisitedSet"+pacificVisitedSet+"atlanticQueue"+atlanticQueue+"atlanticVisitedSet"+atlanticVisitedSet);

//bfs from pacificQuue

while(pacificQueue.size()!=0){

  List<Integer> currentGrid= pacificQueue.poll();

  //find out eligible neighbors 1)has to be inside grid, 2)the adjacent grid value has to be more than or equal to current grid value, 3)not in already visited
  
  int curRow=currentGrid.get(0);
  int curCol = currentGrid.get(1);
  int curVal = heights[curRow][curCol];

  //left
  if(curCol>0){
    int leftRow=curRow;
    int leftCol = curCol-1;
    int leftVal=heights[leftRow][leftCol];
    if(leftVal>=curVal){
     
        List<Integer> leftGrid = new ArrayList();
        leftGrid.add(leftRow);
        leftGrid.add(leftCol);

        if(!pacificVisitedSet.contains(leftGrid)){
            pacificQueue.add(leftGrid);
            pacificVisitedSet.add(leftGrid);


        }

    }

  

  }

//right

  if(curCol<heights[0].length-1){
    int rightRow=curRow;
    int rightCol = curCol+1;
    int rightVal=heights[rightRow][rightCol];
    if(rightVal>=curVal){
     
        List<Integer> rightGrid = new ArrayList();
        rightGrid.add(rightRow);
        rightGrid.add(rightCol);

        if(!pacificVisitedSet.contains(rightGrid)){
            pacificQueue.add(rightGrid);
            pacificVisitedSet.add(rightGrid);


        }

    }

  

  }


  //up

  if(curRow>0){
    int upRow=curRow-1;
    int uPCol = curCol;
    int upVal=heights[upRow][uPCol];
    if(upVal>=curVal){
     
        List<Integer> uPGrid = new ArrayList();
        uPGrid.add(upRow);
        uPGrid.add(uPCol);

        if(!pacificVisitedSet.contains(uPGrid)){
            pacificQueue.add(uPGrid);
            pacificVisitedSet.add(uPGrid);


        }

    }

  

  }

  //down

  if(curRow<heights.length-1){
    int downRow=curRow+1;
    int downCol = curCol;
    int downVal=heights[downRow][downCol];
    if(downVal>=curVal){
     
        List<Integer> downGrid = new ArrayList();
        downGrid.add(downRow);
        downGrid.add(downCol);

        if(!pacificVisitedSet.contains(downGrid)){
            pacificQueue.add(downGrid);
            pacificVisitedSet.add(downGrid);


        }

    }

  

  }




}

System.out.println("pacificVisitedSet*****"+pacificVisitedSet);


while(atlanticQueue.size()!=0){

    List<Integer> currentGrid= atlanticQueue.poll();
  
    //find out eligible neighbors 1)has to be inside grid, 2)the adjacent grid value has to be more than or equal to current grid value, 3)not in already visited
    
    int curRow=currentGrid.get(0);
    int curCol = currentGrid.get(1);
    int curVal = heights[curRow][curCol];
  
    //left
    if(curCol>0){
      int leftRow=curRow;
      int leftCol = curCol-1;
      int leftVal=heights[leftRow][leftCol];
      if(leftVal>=curVal){
       
          List<Integer> leftGrid = new ArrayList();
          leftGrid.add(leftRow);
          leftGrid.add(leftCol);
  
          if(!atlanticVisitedSet.contains(leftGrid)){
              atlanticQueue.add(leftGrid);
              atlanticVisitedSet.add(leftGrid);
             
  
  
          }
  
      }
  
    
  
    }
  
  //right
  
    if(curCol<heights[0].length-1){
      int rightRow=curRow;
      int rightCol = curCol+1;
      int rightVal=heights[rightRow][rightCol];
      if(rightVal>=curVal){
       
          List<Integer> rightGrid = new ArrayList();
          rightGrid.add(rightRow);
          rightGrid.add(rightCol);
  
          if(!atlanticVisitedSet.contains(rightGrid)){
            atlanticQueue.add(rightGrid);
            atlanticVisitedSet.add(rightGrid);

           
  
  
          }
  
      }
  
    
  
    }
  
  
    //up
  
    if(curRow>0){
      int upRow=curRow-1;
      int uPCol = curCol;
      int upVal=heights[upRow][uPCol];
      if(upVal>=curVal){
       
          List<Integer> uPGrid = new ArrayList();
          uPGrid.add(upRow);
          uPGrid.add(uPCol);
  
          if(!atlanticVisitedSet.contains(uPGrid)){
            atlanticQueue.add(uPGrid);
            atlanticVisitedSet.add(uPGrid);
           
  
  
          }
  
      }
  
    
  
    }
  
    //down
  
    if(curRow<heights.length-1){
      int downRow=curRow+1;
      int downCol = curCol;
      int downVal=heights[downRow][downCol];
      if(downVal>=curVal){
       
          List<Integer> downGrid = new ArrayList();
          downGrid.add(downRow);
          downGrid.add(downCol);
  
          if(!atlanticVisitedSet.contains(downGrid)){
            atlanticQueue.add(downGrid);
            atlanticVisitedSet.add(downGrid);
           
  
          }
  
      }
  
    
  
    }
  
  
  
  
  }
  
  System.out.println("atlanticVisitedSet*****"+atlanticVisitedSet);
  
  Set<List<Integer>> intersection = new HashSet<>(pacificVisitedSet);
  // pass the another object to retain the values
  intersection.retainAll(atlanticVisitedSet);


  System.out.println("intersection*****"+intersection);
  
  
  
  List<List<Integer>> arr = new ArrayList<>(intersection);
System.out.println("arr*****"+arr);

      return arr;


        
    }
    
}
