package Matrix;

//Rotate image – good solution - transpose and reverse based on concept

public class RotateImage48 {

   
    public void rotate(int[][] matrix) {

         ///first we have to transpose  basically swap values of [i][j]=[j][i] where j==i
         
         for (int i=0; i<matrix.length;i++){
         //since matrix size is n*n  not m*n hence matric[0].length is not essentia;
         //j=i not 
          for (int j= i;j <matrix.length;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
          }
         }

         // after transposing reverse the matrix rowwise
         for ( int i=0;i<matrix.length;i++){

            int[] eachRow = matrix[i];


            // for each row reverse
            int left =0;
            int right = eachRow.length-1;
            while (left<right){

                int temp = eachRow[left];
                eachRow[left]= eachRow[right];
                eachRow[right]=temp;
                left++;
                right--;

            }


         }


         


        
    }


}
