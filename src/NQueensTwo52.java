import java.util.*;

class NQueensTwo52 {

public static void main(String[] args){

    System.out.println(solveNQueens(4));
}

    public static List<List<String>> solveNQueens(int n) {
          Set<List<Integer>> path =  new HashSet<>();
        List<List<List<Integer>>> allPaths = new ArrayList<>();
        List<List<String>> allPathsString = new ArrayList<>();

        solveNQueensHelper(0,path,allPaths,n,n,allPathsString);
        
      //  System.out.println(allPaths.size());
     //   System.out.println(allPathsString.size());
     //  System.out.println(allPaths);
     //  System.out.println(allPathsString);
    return allPathsString;
        
    }
     public static  void solveNQueensHelper(int row, Set<List<Integer>> path, List<List<List<Integer>>> allPaths,int n, int numBerOfQuuens,List<List<String>> allPathsString) {
     //   System.out.println("inside solveNQueensHelper"+row+"path"+path);

       //all row had been covered
    if(row==n){
            //no queens are left to be placed
       if(numBerOfQuuens==0){
        //a valid path found
       // System.out.println(path);
        List<String> stringPath = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<n;j++){
                List<Integer> localGrid = new ArrayList<>();
                localGrid.add(i);
                localGrid.add(j);
                if(path.contains(localGrid)){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }



            }
            String eachRowString = sb.toString();
            stringPath.add(eachRowString);


        }

        allPaths.add(new ArrayList<>(path));
        allPathsString.add(new ArrayList<>(stringPath));

       }
    
   }else{
       //in each row available choices are all columns
       for (int i=0;i<n;i++){
        List<Integer> grid = new ArrayList<>();
        grid.add(row);
        grid.add(i);

       // System.out.println(isValidPosition(grid,path,n));

       if( isValidPosition(grid,path,n)){

        path.add(grid);
        solveNQueensHelper(row+1,path,allPaths,n,numBerOfQuuens-1,allPathsString);
        path.remove(grid);
       // path.remove(path.size()-1);
       
       
              }
       
       
            }
              }
       
               
              
       
       
       
       
       
       
               
           
       }
     private static boolean isValidPosition(List<Integer> grid, Set<List<Integer>> path,int n) {
          //  System.out.println("inside  isValidPosition"+grid+"path"+path);
            if(path.size()==0){
                return true;
            }

           for  (List<Integer> queenPresent :path){
            //queen is present in same row
            if(queenPresent.get(0)==grid.get(0)){
            //    System.out.println("same row");
         
                return false;
            }
            //queen is present in same column
            if(queenPresent.get(1)== grid.get(1)){
             //   System.out.println("same col");
         
                return false;
            }

            //now check the diagonal cases.
           int  queenPresentRow=queenPresent.get(0);
           int  queenPresentCol=queenPresent.get(1);
           while((queenPresentRow>=0 && queenPresentRow<n) && (queenPresentCol>=0 && queenPresentCol<n )){
                 if (queenPresentRow==grid.get(0) && queenPresentCol==grid.get(1)){
                 //   System.out.println("same diag -1,-1");
                    return false;
                 }

                
                 queenPresentRow=queenPresentRow-1;
                 queenPresentCol=queenPresentCol-1;
           }

             queenPresentRow=queenPresent.get(0);
             queenPresentCol=queenPresent.get(1);

             while((queenPresentRow>=0 && queenPresentRow<n) && (queenPresentCol>=0 && queenPresentCol<n )){
                if (queenPresentRow==grid.get(0)&& queenPresentCol==grid.get(1) ){
                 //   System.out.println("same diag +1,+1");
                   return false;
                }

                queenPresentRow=queenPresentRow+1;
                queenPresentCol=queenPresentCol+1;
          }


             queenPresentRow=queenPresent.get(0);
             queenPresentCol=queenPresent.get(1);

             while((queenPresentRow>=0 && queenPresentRow<n) && (queenPresentCol>=0 && queenPresentCol<n )){
                if (queenPresentRow==grid.get(0)&& queenPresentCol==grid.get(1)){
                   // System.out.println("same diag +1,-1");
                 
                   return false;
                }

               
                queenPresentRow=queenPresentRow+1;
                queenPresentCol=queenPresentCol-1;
          }

          queenPresentRow=queenPresent.get(0);
          queenPresentCol=queenPresent.get(1);

          while((queenPresentRow>=0 && queenPresentRow<n) && (queenPresentCol>=0 && queenPresentCol<n )){
             if (queenPresentRow==grid.get(0)&&queenPresentCol==grid.get(1) ){
              //  System.out.println("same diag -1,+1");
                 
                return false;
             }

           
             queenPresentRow=queenPresentRow-1;
             queenPresentCol=queenPresentCol+1;
       }
          



           }
              
        return true;}

}