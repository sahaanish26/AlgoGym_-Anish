import java.util.*;
class ContinuousSubarraySum523 {
    public  static boolean checkSubarraySum(int[] nums, int k) {

    int[] prefixSum = new int[nums.length];
    int[] prefixSumModulo = new int[nums.length];
    //Map(sum, List<Index1,index2>)
    //Map to store prefix sum and at which index of prefix sum array the prefix sum was found
    // for a +,- array same prefix sum can be obtained at many indexes
    Map<Integer,List<Integer>> indexMap = new HashMap<>();
    List<Integer> firstList = new ArrayList<>();
    firstList.add(-1);
    //for the first entry in Map put -1 as index for sum 0.
    indexMap.put(0,firstList);

    //sj-si=k
    //sj-k=si
    int count=0;
    int maxSizeArray = 0;

  for (int j= 0 ; j<nums.length;j++){

    int remainder = nums[j]%k;
    if(remainder<0){
        remainder=remainder+k;
    }

   if(j==0){
    
    prefixSum[j]=nums[j];
    if(prefixSum[j]%k>=0){
    prefixSumModulo[j]=prefixSum[j]%k;}
    else{
        prefixSumModulo[j]=prefixSum[j]%k + k;
    }
   }else{
    prefixSum[j] = prefixSum[j-1] + nums[j];
    if(prefixSum[j]%k>=0){
        prefixSumModulo[j]=prefixSum[j]%k;
    }
        else{
           prefixSumModulo[j]=prefixSum[j]%k + k;
        }
   }

   if (indexMap.containsKey(prefixSumModulo[j])){
       count= count+ indexMap.get(prefixSumModulo[j]).size();
      // for (int n=0;n<indexMap.get(prefixSumModulo[j]).size() ;n++){
       // System.out.println("match found at"+j+"and"+ indexMap.get(prefixSumModulo[j]).get(n));

      // }
       //taking the earliest match from Map
       int possibleMaxSize = j-indexMap.get(prefixSumModulo[j]).get(0);
       //int possibleMinSize= j -indexMap.get(prefixSumModulo[j]).get(indexMap.get(prefixSumModulo[j]).size()-1);
       if (possibleMaxSize>=2){return true ;}
      // maxSizeArray = Math.max(maxSizeArray,j-indexMap.get(prefixSumModulo[j]).get(0));
   }

   List<Integer> indexList = indexMap.getOrDefault(prefixSumModulo[j], new ArrayList<>());
   indexList.add(j);
   indexMap.put(prefixSumModulo[j],indexList);


  }

//System.out.println("maxSizeArray"+maxSizeArray);
        return  false;
}

}