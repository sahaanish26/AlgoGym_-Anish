package generic;

import java.util.*;

class GfG {

    // A utility function that returns true if there is
    // a subset of arr[] with sum equal to given sum
    static boolean isSubsetSum(int[] arr, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (arr[n - 1] > sum)
            return isSubsetSum(arr, n - 1, sum);

        // Check if sum can be obtained by any of the following
        // (a) including the last element
        // (b) excluding the last element
        return isSubsetSum(arr, n - 1, sum) || 
               isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    // Returns true if arr[] can be partitioned in two
    // subsets of equal sum, otherwise false
    static boolean findPartition(int[] arr) {
      
        // Calculate sum of the elements in array
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // If sum is odd, there cannot be two 
        // subsets with equal sum
        if (sum % 2 != 0)
            return false;

        // Find if there is subset with sum equal 
        //to half of total sum
        return isSubsetSum(arr, arr.length, sum / 2);
    }

    // Driver code
    public static void main(String[] args) {
      //  int[] arr = { 3, 1, 5, 9, 12 };
        int[] arr = { 1,2,3,4,6 };
        System.out.println(findPartition(arr) ? "True" : "False");
    }
}
