import java.util.*;

public class PartitiontoKEqualSumSubsets698 {

public static void main(String[] args){

   // int[] nums = {2,2,1,4,3,3,5};
   // int k = 4;
    int[] nums= {10,10,7,8,10,4,9,7,9,10,4,6,7,1,8,5};
    int k = 5;

    canPartitionKSubsets(nums,k);

}


public static boolean canPartitionKSubsets(int[] nums,int k){
    int sum =0;
    for (int i =0 ;i<nums.length;i++){
        sum=sum + nums[i];
    }
    if(sum%k!=0){
        return false;
    }


    List<List<Integer>> allPaths = new ArrayList<>();
    Map<Integer,List<Integer>> pathMap = new HashMap<>();
    Map<Integer,Integer> sumMap = new HashMap<>();
    Map<Set<List<Integer>>,Boolean> cacheMap= new HashMap<>();
    

    for (int i=0;i<k;i++){
        List<Integer> path1 = new ArrayList<>();
        int pathSum =0;
        pathMap.put(i,path1);
        sumMap.put(i,pathSum);


    }
   
      List<Integer> choices = new ArrayList<>();
    for (int i =0 ;i<nums.length;i++){
        choices.add(nums[i]);
    }
  Collections.sort(choices,Collections.reverseOrder());
  if(choices.get(0)>sum/k){
    return false;
  }
  //if(choices.get(0)==sum/k){
 //   if(choices.size()==k){
 //       return true;
 //   }
 //   return false;
//  }
   boolean result = canPartitionHelperBooleanK( choices,allPaths,sumMap,pathMap,sum/k,k,0,cacheMap);

  // System.out.println("allPaths"+allPaths );
  // System.out.println("numCalls"+numCalls );
   System.out.println("result"+result );

   return result;



}

public static boolean canPartitionHelperBooleanK(List<Integer> choices, List<List<Integer>> allPaths , Map<Integer,Integer> sumMap,Map<Integer,List<Integer>> pathMap, int desiredSum , int k,int level, Map<Set<List<Integer>>,Boolean> cacheMap){
  //  numCalls++;
   
    //System.out.println("choices"+choices+"path1"+path1+"path2"+path2);
    Set<List<Integer>> sumSetKeyForCache = new HashSet<>();
    for (Map.Entry<Integer,Integer> entry : sumMap.entrySet()){
        List<Integer> eachBucketSumList = new ArrayList<>();
        eachBucketSumList.add(entry.getValue());
        sumSetKeyForCache.add(eachBucketSumList);
      }
      if(cacheMap.containsKey(sumSetKeyForCache)){
       // System.out.println("Cahce Hit for "+sumSetKeyForCache+"value found"+cacheMap.get(sumSetKeyForCache));
        return cacheMap.get(sumSetKeyForCache);
      }
     


if (choices.isEmpty()  ){

for (Map.Entry<Integer,Integer> entry : sumMap.entrySet()){
    if (entry.getValue()!=desiredSum){
        return false;
    }
}
// System.out.println("****bucket****"+pathMap);
return true;

}

//to add sumCondition later
if (!choices.isEmpty()){


//pruning for bucket deficiency .. If number of deficient bucket is more than number of choices then not possible to find true result in
// that path
int pendingBucket=0;
for (Map.Entry<Integer,Integer> entry : sumMap.entrySet()){
    if (entry.getValue()!=desiredSum){
        pendingBucket++;
    }
}

if(pendingBucket>0 &&choices.size()>=pendingBucket){



 int currentChoice = choices.get(0);
 choices.remove(0);


for (int i=0;i<k;i++){
    
    // get each bucket path and sum
   List<Integer> path = pathMap.get(i) ;
   int sum  = sumMap.get(i);
   if(sum<desiredSum && sum+currentChoice<=desiredSum){
              //choose
   path.add(currentChoice);
   sum=sum+currentChoice;
   sumMap.put(i,sum);
  // System.out.println("sumMapp"+sumMap+"choices"+choices);
   pendingBucket=0;
   int totalpending =0;
  for (Map.Entry<Integer,Integer> entry : sumMap.entrySet()){
      if (entry.getValue()!=desiredSum){
         totalpending=totalpending+desiredSum-entry.getValue();
          pendingBucket++;
      }
  
    }
   
   //explore
   boolean result =false;
   if(choices.size()>=pendingBucket){
  // System.out.println("i"+i+"sumMapp"+sumMap+"choices"+choices);
   
    int choicesum=0;
    for (int j=0;j<choices.size();j++){
        choicesum=choicesum+choices.get(j);
    }
    if(choicesum!=totalpending){
        System.out.println("totalpending"+totalpending);
    }
   
    result = canPartitionHelperBooleanK(choices,allPaths,sumMap,pathMap,desiredSum,k,level+1,cacheMap);
    Set<List<Integer>> sumSetKey = new HashSet<>();
    for (Map.Entry<Integer,Integer> entry : sumMap.entrySet()){
        List<Integer> eachBucketSumList = new ArrayList<>();
        eachBucketSumList.add(entry.getValue());
        sumSetKey.add(eachBucketSumList);
    
      }
     
    cacheMap.put(sumSetKey,result);
  //  System.out.println("result"+result+"   level"+level+"  **pathMap "+pathMap+" sumMap   "+sumMap+"choices"+choices+"cacheMap"+cacheMap );
   
  
  }
   //unchoose
   path.remove(path.size()-1);
   sumMap.put(i,sumMap.get(i)-currentChoice);
  if(result){
    return result;
  }
}

}

// System.out.println("sumMapp"+sumMap+"choices"+choices);


choices.add(0,currentChoice);




}



    
}

return false;
}
}
