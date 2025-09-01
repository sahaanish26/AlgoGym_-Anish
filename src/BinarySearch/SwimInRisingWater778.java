package BinarySearch;

// this also resembles koko eating banana type problem
public class SwimInRisingWater778 {


    public static int swimInWater(int[][] grid) {

        int m = grid.length;

        int left = 0;
        //max value possible as per problem constraint 
        //0 <= grid[i][j] < n2
        int right =m*m;
        int ans =-1;

        while(left<=right){

            int mid = left + (right-left)/2;

            //we have to get the least time
            //so its like first thing on the left that satisfies the condition

            if(canReach(mid, grid)){
                            // one valid answer but go more to the left to get a better one
                            ans = mid;
                          right = mid-1;
                        }else{
            
                            left= mid+1;
                        }
            
                    }

                    return ans;
                    
                }
            
     private static boolean canReach(int mid, int[][] grid) {

                    // do a dfs with this value and see if we can reach from start to end with this constraint
                    // i.e cell value has to be less than or equal to this
                    // since n*n grid
                    int[][] visited = new int[grid.length][grid.length];

                    return dfsHelper(mid, grid,visited,0,0);
                                     
                                    }
                    
      private static boolean dfsHelper(int mid, int[][] grid, int[][] visited, int i, int j) {

                       if (i<0 || i>=grid.length) {
                        return false;
                       }
                       if (j<0 || j>=grid.length) {
                        return false;
                       }
                       // depth of cell is more than water so can not swim
                       if(grid[i][j]>mid){
                        return false;
                       }

                       visited[i][j]=1;

                       //able to reach the last cell
                       // so true
                       if(i==grid.length-1 && j==grid.length-1){
                        return true;
                       }
                      

                       boolean way1 =false;
                       boolean way2 =false;
                       boolean way3 =false;
                       boolean way4 =false;
                        
                     if(i+1<grid.length && visited[i+1][j]!=1){
                       way1=  dfsHelper(mid,grid,visited,i+1,j);
                    }
                    if(j+1<grid.length && visited[i][j+1]!=1){
                       way2 = dfsHelper(mid,grid,visited,i,j+1);
                    }
                    if(i-1>=0 && visited[i-1][j]!=1){
                       way3 = dfsHelper(mid,grid,visited,i-1,j);
                    }
                    if(j-1>=0 && visited[i][j-1]!=1){
                       way4=  dfsHelper(mid,grid,visited,i,j-1);
                    }
                  //does not work gives tle
                 //  visited[i][j]=0;
                       if(way1||way2||way3||way4){
                        return true;
                       }

                       return false;




                                           }

public static void main(String[] args){

   // int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};

    int[][] grid = {{0,2},{1,3}};

    System.out.println(swimInWater(grid));
}



}
