public class SearchA2DMatrix {


      // https://leetcode.com/discuss/explore/binary-search/2174241/JAVA-Binary-Search-Only-need-one-template/
      public int search(int[] nums, int target) {
        int left = 0 ;         int right = nums.length -1;
        while (left < right) {            
            int mid = left + (right-left)/2;            
            if(nums[mid] < target) {
                left = mid + 1;
            }
            else right = mid;
        }
        if(nums[left] == target)
            return left;
        return -1;
    }
    

    public static void main (String[] args){


       int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
      int target = 3;

     //  int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
     //  int target = 13;

     // int [][] matrix = {{1}};
     // int target = 2;

     // int [][] matrix = {{1},{3}};
      //int target = 4;
       System.out.println(searchMatrix(matrix,target));


    }



    public static boolean searchMatrix(int[][] matrix, int target) {

   //Left, right are possible search spaces, we need to check l,r when they exist in array [0, n-1]

  // It is possible to insert after len – 1, so right is len here instead.//#35 https://leetcode.com/problems/search-insert-position/

  //here we will find out which row the number can be  in and then we will find if the number exists in that number

  int rowNumber = getRow(matrix, target);
  System.out.println("row number"+rowNumber);
  if(rowNumber==-1){
    return false;
  }

  //now do a binary search on the particular row

  int[] identiFiedRow = matrix[rowNumber];
  int left =0; int right=identiFiedRow.length-1;

  
  
  while(left<right){
    int mid = left + (right-left)/2;
    System.out.println("mid in row "+mid);
  if(identiFiedRow[mid] < target){
    left = mid + 1;

   }else{
    right = mid;
   }


  }

  if(identiFiedRow[left] == target)
  return true;

    return false;  
    }





  private static int getRow( int[][] matrix,int target) {
    

            int left=0; int right = matrix.length-1;
            int mid=0;
           


    while (left<right){
   mid = left + (right-left)/2;
   //if target is more than the max aka last element of the row with index mid. 
   if(matrix[mid][matrix[mid].length-1] < target){
    left = mid + 1;
   }
   else{
    right = mid;
   }    

    }

    if(matrix[left][0] <= target && matrix[left][matrix[mid].length-1]>=target ){
    return left;}
return -1;
  


         }
  

  
}
