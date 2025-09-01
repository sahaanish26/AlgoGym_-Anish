import java.util.*;
public class ValidSudoku35{


    public static void main(String[] args){


    
       


    }

    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<board.length;i++){
            char [] row = board[i];
            // for each row
            Set<Character> rowSet = new HashSet<>();

            for (int k=0;k<row.length;k++){

                if(rowSet.contains(row[k])){
                    return false;
                }
                if(row[k]!='.'){
                    rowSet.add(row[k]) ;
                }

            }
            

        }


      for (int i=0;i<board.length;i++){
        Set<Character> colSet = new HashSet<>();
        for(int j=0;j<board[0].length;j++){
            
            char colValue = board[j][i];
            // for each row
            {
                if(colSet.contains(colValue)){
                    return false;
                }
                if(colValue!='.'){
                    colSet.add(colValue) ;
                }

            }

        }
    }

//create start and end points in loop
for (int startRow =0;startRow<9;startRow=startRow+3){

    for (int startCol=0;startCol<9;startCol=startCol+3 ){
    if(!helperGrid(startRow,startCol,board)){
        return false;
    }
    }
}
    





        return true;
        
    }

    public static boolean  helperGrid(int startRow,int startCol, char[][] board){
    Set<Character> gridSet = new HashSet<>();
    for (int i=startRow;i<startRow+3;i++){
       System.out.println("startRow"+startRow+"startCol"+startCol);
        for(int j=startCol;j<startCol+3;j++){
            
            char Value = board[i][j];
            // for each row
            {
                if(gridSet.contains(Value)){
                    System.out.println("i"+i+"j"+j);
                    System.out.println("gridSet"+gridSet+"Value"+Value);
                    return false;
                }
                if(Value!='.'){
                    gridSet.add(Value) ;
                }

            }

        }
    }

    return true;
}


    
}