import java.util.*;
public class PartitionEqualSubsetSum416 {
    public static int numcalls1;
    public static int numcalls;
    public static int numcalls2;
    

    public static void main(String[] args){

     //  int[] nums = {1,5,11,5};
     //  int[] nums = {1,2,3,5};


      // int [] nums = {4,3,2,3,5,2,1};
      
    // int[] nums={3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};

  //  int [] nums= {3,9,4,5,8,8,7,9,3,6,2,10,10,4,10,2};

   // int[] nums ={2,9,4,7,3,2,10,5,3,6,6,2,7,5,2,4};

     //   int [] nums = {3,2,3,6,6,6};


      // int[] nums =  {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        int[] nums ={4,4,4,4,4,4,4,4,8,8,8,8,8,8,8,8,12,12,12,12,12,12,12,12,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,40,40,40,40,40,40,40,40,44,44,44,44,44,44,44,44,48,48,48,48,48,48,48,48,52,52,52,52,52,52,52,52,56,56,56,56,56,56,56,56,60,60,60,60,60,60,60,60,64,64,64,64,64,64,64,64,68,68,68,68,68,68,68,68,72,72,72,72,72,72,72,72,76,76,76,76,76,76,76,76,80,80,80,80,80,80,80,80,84,84,84,84,84,84,84,84,88,88,88,88,88,88,88,88,92,92,92,92,92,92,92,92,96,96,96,96,96,96,96,96,97,99};
      int k =2;
     //  int k =10;
      //  int k =4;
    //   int k =5;
      //   int k =7;
   
   //canPartition(nums);
   List<Integer> choices = new ArrayList<>();
   for (int i =0 ;i<nums.length;i++){
       choices.add(nums[i]);
   }
  long before = System.currentTimeMillis();
   canPartition1(nums);
   long after = System.currentTimeMillis();
   System.out.println("time elapsed 1 "+(after-before));

   System.out.println("numcalls1     "+numcalls1);

   long before1 = System.currentTimeMillis();
   canPartition(nums);
   long after1 = System.currentTimeMillis();
   System.out.println("time elapsed my original  "+(after1-before1));

   System.out.println("numCalls    "+numcalls);

   long before2 = System.currentTimeMillis();
   numcalls=0;
   canPartition(choices);
   long after2 = System.currentTimeMillis();
   System.out.println("time elapsed passing a list directly  "+(after1-before1));

   System.out.println("numCalls    "+numcalls);

    }

     public static boolean canPartition1(int[] nums) {
        int total = 0;
        for(int n : nums) total += n;
        if(total % 2 != 0) return false;
        total /= 2;
        Boolean[][] mem = new Boolean[nums.length+1][total+1];
        return helper(nums, nums.length - 1, total , mem);
    } 

     private static boolean helper(int[] nums, int idx, int total, Boolean[][] mem) {
        numcalls1++;
        if(total == 0) return true;
        if(idx < 0 || total < 0) return false;
        if(mem[idx][total] != null) return mem[idx][total];
        boolean ans = false;
        ans = helper(nums, idx-1, total - nums[idx], mem) || helper(nums, idx-1, total, mem);
        mem[idx][total] = ans;
        return ans;
    }
    

    public static boolean canPartition(int[] nums){
        int sum =0;
        for (int i =0 ;i<nums.length;i++){
            sum=sum + nums[i];
        }
        if(sum%2!=0){
            return false;
        }


        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        Map<List<List<Integer>>,Boolean> cacheMap = new HashMap<>();

        List<Integer> choices = new ArrayList<>();
        for (int i =0 ;i<nums.length;i++){
            choices.add(nums[i]);
        }
       Collections.sort(choices);
      // boolean result = combinationSumHelper1( choices,chosen,allPaths,sum/2,cacheMap);
       boolean result = combinationSumHelper( choices,sum/2,cacheMap);

       System.out.println("allPaths"+allPaths );
       System.out.println("numCalls"+numcalls );
       System.out.println("result"+result );

       return result;



    }

 


   public static boolean canPartition(List<Integer> choices){
        int sum =0;
        for (int i =0 ;i<choices.size();i++){
            sum=sum + choices.get(i);
        }
        if(sum%2!=0){
            return false;
        }


        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        Map<List<List<Integer>>,Boolean> cacheMap = new HashMap<>();

        /* List<Integer> choices = new ArrayList<>();
        for (int i =0 ;i<nums.length;i++){
            choices.add(nums[i]);
        } */
       Collections.sort(choices);
      // boolean result = combinationSumHelper1( choices,chosen,allPaths,sum/2,cacheMap);
       boolean result = combinationSumHelper( choices,sum/2,cacheMap);

       System.out.println("allPaths"+allPaths );
       System.out.println("numCalls"+numcalls );
       System.out.println("result"+result );

       return result;



    }

 
   

    

    private static boolean combinationSumHelper1(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, int target,Map<List<List<Integer>>,Boolean> cacheMap) {
        numcalls++;
       // System.out.println("chosen"+chosen+"choices"+choices+"target"+target);


        //create cacheMap entry
       List<List<Integer>> mapKey1 = new ArrayList<>();
       List<Integer> keyChoices1 = new ArrayList<>(choices);
       List<Integer>keyTarget1 = new ArrayList<>();
       keyTarget1.add(target);
      //Collections.sort(keyChoices1);
       mapKey1.add(keyChoices1);
       mapKey1.add(keyTarget1);
       if(cacheMap.containsKey(mapKey1)){
       // System.out.println("Cache Hit for " +mapKey1 + "cache result"+cacheMap.get(mapKey1) );
       return cacheMap.get(mapKey1);
       }

        if(target==0){
        
            
                resultSets.add(new ArrayList<>(chosen));
                return true;
      
        }

        else if (target>0 && !choices.isEmpty()){

             // check if target is too large.
             int maxPossible = 0;
             for (int k=0;k<choices.size();k++){
                 maxPossible =maxPossible+choices.get(k) ;
             }
            

            //choose
            ///do not choose the first choice
            /// remove the first one from choice
            int firstChoice= choices.get(0);
            choices.remove(0);
            int numDup=0;
            //remove all duplicates , THE KEY IDEA OF NOT TAKING IS NOT CONSIDERING THIS VALUE AS A CHOICE itself anymore so take out all values for example all 1s
            while (!choices.isEmpty()&& choices.get(0)==firstChoice){
               numDup++;
                choices.remove(0);
               
            }
            //explore
            boolean result1 = false;
            if( target<= maxPossible){
                result1= combinationSumHelper1(choices,chosen,resultSets,target,cacheMap);

                List<List<Integer>> mapKey = new ArrayList<>();
                List<Integer> keyChoices = new ArrayList<>(choices);
                List<Integer>keyTarget = new ArrayList<>();
                keyTarget.add(target);
               // Collections.sort(keyChoices);
                mapKey.add(keyChoices);
                mapKey.add(keyTarget);
                cacheMap.put(mapKey, result1);
            }
            //unchoose
            for(int h=0;h<=numDup;h++){
                choices.add(0,firstChoice);
            }

            if(result1){
                return true;
            }
            

            //choose
            //choose the first choice
            chosen.add(firstChoice);
            choices.remove(0);
            boolean result2 = false;
            if(target-firstChoice>=0 && target<= maxPossible){
            result2= combinationSumHelper1(choices,chosen,resultSets,target-firstChoice,cacheMap);

            List<List<Integer>> mapKey = new ArrayList<>();
            List<Integer> keyChoices = new ArrayList<>(choices);
            List<Integer>keyTarget = new ArrayList<>();
            keyTarget.add(target);
           // Collections.sort(keyChoices);
            mapKey.add(keyChoices);
            mapKey.add(keyTarget);
            cacheMap.put(mapKey, result2);
            }
            //unchoose
            chosen.remove(chosen.size()-1);
            choices.add(0,firstChoice);

            if(result2){
                return true;
            }

        }
        return false;
    }

   private static boolean combinationSumHelper(List<Integer> choices,  int target,Map<List<List<Integer>>,Boolean> cacheMap) {
        numcalls++;
       // System.out.println("chosen"+chosen+"choices"+choices+"target"+target);


        //create cacheMap entry
       List<List<Integer>> mapKey1 = new ArrayList<>();
       List<Integer> keyChoices1 = new ArrayList<>(choices);
       List<Integer>keyTarget1 = new ArrayList<>();
       keyTarget1.add(target);
      //Collections.sort(keyChoices1);
       mapKey1.add(keyChoices1);
       mapKey1.add(keyTarget1);
       if(cacheMap.containsKey(mapKey1)){
      //  System.out.println("Cache Hit for " +mapKey1 + "cache result"+cacheMap.get(mapKey1) );
       return cacheMap.get(mapKey1);
       }

        if(target==0){
        
            
            //    resultSets.add(new ArrayList<>(chosen));
                return true;
      
        }

        else if (target>0 && !choices.isEmpty()){

             // check if target is too large.
             int maxPossible = 0;
             for (int k=0;k<choices.size();k++){
                 maxPossible =maxPossible+choices.get(k) ;
             }
            

            //choose
            ///do not choose the first choice
            /// remove the first one from choice
            int firstChoice= choices.get(0);
            choices.remove(0);
            int numDup=0;
            //remove all duplicates , THE KEY IDEA OF NOT TAKING IS NOT CONSIDERING THIS VALUE AS A CHOICE itself anymore so take out all values for example all 1s
            while (!choices.isEmpty()&& choices.get(0)==firstChoice){
               numDup++;
                choices.remove(0);
               
            }
            //explore
            boolean result1 = false;
            if( target<= maxPossible){
                result1= combinationSumHelper(choices,target,cacheMap);

                List<List<Integer>> mapKey = new ArrayList<>();
                List<Integer> keyChoices = new ArrayList<>(choices);
                List<Integer>keyTarget = new ArrayList<>();
                keyTarget.add(target);
               // Collections.sort(keyChoices);
                mapKey.add(keyChoices);
                mapKey.add(keyTarget);
                cacheMap.put(mapKey, result1);
            }
            //unchoose
            for(int h=0;h<=numDup;h++){
                choices.add(0,firstChoice);
            }

            if(result1){
                return true;
            }
            

            //choose
            //choose the first choice
          //  chosen.add(firstChoice);
            choices.remove(0);
            boolean result2 = false;
            if(target-firstChoice>=0 && target<= maxPossible){
            result2= combinationSumHelper(choices,target-firstChoice,cacheMap);

            List<List<Integer>> mapKey = new ArrayList<>();
            List<Integer> keyChoices = new ArrayList<>(choices);
            List<Integer>keyTarget = new ArrayList<>();
            keyTarget.add(target);
           // Collections.sort(keyChoices);
            mapKey.add(keyChoices);
            mapKey.add(keyTarget);
            cacheMap.put(mapKey, result2);
            }
            //unchoose
            //chosen.remove(chosen.size()-1);
            choices.add(0,firstChoice);

            if(result2){
                return true;
            }

        }
        return false;
    }



}
