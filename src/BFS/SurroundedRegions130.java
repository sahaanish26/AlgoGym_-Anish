package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SurroundedRegions130 {

    public void solve(char[][] board) {

      //  Set<int[]> visited = new HashSet<>();
      int m = board.length;
      int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

         boolean[][] visited = new boolean[m][n];
        
        for(int i = 0;i<m;i++){
            Arrays.fill(visited[i] , false);
        }

        for(int i=0;i<board.length;i++){

            for (int j=0;j<board[0].length;j++){

                if(i==0 || i==( board.length-1)|| j==0|| j==(board[0].length-1) ){

                    int[] cell = new int[2];
                    cell[0]=i;
                    cell[1]=j;

                    //add all the border cell with 0 which are not visited already
                    // in queue
                    if(!visited[i][j] && board[i][j]=='O' ){

                        visited[i][j]=true;
                        q.add(cell);
                        // mark the cell rotten/ i.e not a true 0
                        board[i][j]='#';

                    }
                }
            }
        }
        

        // now start the bfs and convert all connected 0 to #
        int level =0;
        while(!q.isEmpty()){

            int qSize = q.size();

            for (int i=0;i<qSize;i++){

                int[] current = q.poll();
                int currentRow = current[0];
                int currentColumn = current[1];

                // check right
                int rightRow=currentRow;
                int rightColumn = currentColumn+1;
                if(rightColumn<n){
                    // if the row is not visited and row is equal to O
                    if(!visited[rightRow][rightColumn]){
                        if(board[rightRow][rightColumn]=='O'){
                            visited[rightRow][rightColumn]=true;
                            board[rightRow][rightColumn]='#';
                            int[] rightCell = new int[2];
                            rightCell[0]=rightRow;
                            rightCell[1]=rightColumn;
                            q.add(rightCell);

                        }
                    }

                }

                // check left
                int leftRow=currentRow;
                int leftColumn = currentColumn-1;
                if(leftColumn>=0){
                    // if the row is not visited and row is equal to O
                    if(!visited[leftRow][leftColumn]){
                        if(board[leftRow][leftColumn]=='O'){
                            visited[leftRow][leftColumn]=true;
                            board[leftRow][leftColumn]='#';
                            int[] leftCell = new int[2];
                            leftCell[0]=leftRow;
                            leftCell[1]=leftColumn;
                            q.add(leftCell);

                        }
                    }

                }

                // check upwords
                int upRow=currentRow-1;
                int upColumn = currentColumn;
                if(upRow>=0){
                    // if the row is not visited and row is equal to O
                    if(!visited[upRow][upColumn]){
                        if(board[upRow][upColumn]=='O'){
                            visited[upRow][upColumn]=true;
                            board[upRow][upColumn]='#';
                            int[] upCell = new int[2];
                            upCell[0]=upRow;
                            upCell[1]=upColumn;
                            q.add(upCell);

                        }
                    }

                }

                // check downWards
                int downRow=currentRow+1;
                int downColumn = currentColumn;
                if(downRow<m){
                    // if the row is not visited and row is equal to O
                    if(!visited[downRow][downColumn]){
                        if(board[downRow][downColumn]=='O'){
                            visited[downRow][downColumn]=true;
                            board[downRow][downColumn]='#';
                            int[] downCell = new int[2];
                            downCell[0]=downRow;
                            downCell[1]=downColumn;
                            q.add(downCell);

                        }
                    }

                }






            }


            level++;



        }
        
        // now mark the cells which are still o to X


        for(int i=0;i<board.length;i++){

            for (int j=0;j<board[0].length;j++){

                if(board[i][j]=='O'){
                    board[i][j]='X';

                }
            }
        }
       



        // then mark back the cells with # to o

        for(int i=0;i<board.length;i++){

            for (int j=0;j<board[0].length;j++){

                if(board[i][j]=='#'){
                    board[i][j]='O';

                }
            }
        }
       
    }

}
