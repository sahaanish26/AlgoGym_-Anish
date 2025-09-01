import java.util.*;

public class SetMatrixZeroes73 {


    public static void main(String[] args){

       // int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        
       // int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

       // int [][] matrix = {{0,1}};

      int[][] matrix= {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
      
       

        setZeroes(matrix);

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.println("values"+ matrix[i][j]);
            }
        }



    }


    public static  void setZeroes(int[][] matrix) {
      //  System.out.println("matrix lenght"+matrix.length);
       // System.out.println("matrix[0] lenght"+matrix[0].length);
        List<List<Integer>> startPoints = new ArrayList<>();


        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    List<Integer> startPoint = new ArrayList<>();
                    startPoint.add(0,i);
                    startPoint.add(1,j);
                    startPoints.add(startPoint);
    
                }
            }
        }


    Set<List<Integer>> visitedNodes= new HashSet<>();
    // 1=row+
    // 2=row-
    // 3=col+
    // 4=col-

    for(int i=0;i<startPoints.size();i++){
     
          
            //not doing any visited check since a path traversed can be traversed again here.
            // we can not call one dfs and traverse in all four directions as the movement need to happen
            // strictly along a row or along a column. If we call one dfs and traverse in 4 direction from each
            //next grid all four dir will be traversed hence 4 sep calls with one direction move need to be done.
           dfsHelper(visitedNodes,startPoints.get(i),matrix,1);
           dfsHelper(visitedNodes,startPoints.get(i),matrix,2);
           dfsHelper(visitedNodes,startPoints.get(i),matrix,3);
           dfsHelper(visitedNodes,startPoints.get(i),matrix,4);
       
   
        
    }
    
}


    private static void dfsHelper(Set<List<Integer>> visitedNodes, List<Integer> currentNode, int[][] matrix,int dir) {
        //set the value to 0;
       // System.out.println("currentNode"+currentNode+"dir"+dir);
        matrix[currentNode.get(0)][currentNode.get(1)]=0;
        visitedNodes.add(currentNode);

        List<List<Integer>> potentialNeighbours = new ArrayList<>();

        if(dir==1){
            if(currentNode.get(0)<matrix.length-1 && matrix[currentNode.get(0)+1][currentNode.get(1)]!=0 ){
                List<Integer> rightNNode= new ArrayList<>();
                rightNNode.add(0,currentNode.get(0)+1);
                rightNNode.add(1,currentNode.get(1));
                potentialNeighbours.add(rightNNode);

            }
        }
        if(dir==2){
            if(currentNode.get(0)>0 ){
                List<Integer> leftNNode= new ArrayList<>();
                leftNNode.add(0,currentNode.get(0)-1);
                leftNNode.add(1,currentNode.get(1));
                potentialNeighbours.add(leftNNode);

            }
        }
        if(dir==3){
            if(currentNode.get(1)<matrix[0].length-1 ){
                List<Integer> upperNNode= new ArrayList<>();
                upperNNode.add(0,currentNode.get(0));
                upperNNode.add(1,currentNode.get(1)+1);
                potentialNeighbours.add(upperNNode);

            }
        }
        if(dir==4){
            if(currentNode.get(1)>0 ){
                List<Integer> lowerNNode= new ArrayList<>();
                lowerNNode.add(0,currentNode.get(0));
                lowerNNode.add(1,currentNode.get(1)-1);
                potentialNeighbours.add(lowerNNode);

            }
        }

        for (List<Integer> neighbour:potentialNeighbours){

          
                dfsHelper(visitedNodes,neighbour,matrix,dir);

            
        }


           }

        }
