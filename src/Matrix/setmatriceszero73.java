package Matrix;

import java.util.HashSet;
import java.util.Set;

public class setmatriceszero73 {

     //key to the solution is to store the row and column where 0 is spotted while traversing first time
        //and then in the second traversal make the box 0 if either of row/column number is in the
        // set
        //neetocde solution

    public void setZeroes(int[][] matrix) {

        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> columnZero = new HashSet<>();


        for (int i= 0;i<matrix.length;i++){

            for ( int j=0;j<matrix[0].length;j++){

                if(matrix[i][j]==0){
                    rowZero.add(i);
                    columnZero.add(j);

                }
            }
        }

        System.out.println("rowZero"+rowZero);
        System.out.println("columnZero"+columnZero);


        // now if i/j is part of rowzero/rowcoulmn will make it 0

        for (int i= 0;i<matrix.length;i++){

            for ( int j=0;j<matrix[0].length;j++){

                if(rowZero.contains(i) || columnZero.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }


        
    }

}
