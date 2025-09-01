import java.util.*;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

*/


public class CombinationSum40 {
    public static int numcalls;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
       int[] intArray = new int[]{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
       int target = 30;
        // choices.add(1);
        // choices.add(3);
        // choices.add(5);

        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);

       // int[] intArray = new int[]{ 9864,411,411,411,411,411,411,411,411,411,411,411};
       // int target =9864;

      // int[] intArray = new int[]{ 1};
      // int target = 2;


        System.out.println("Final result"+ combinationSum(intArray,target) );
        System.out.println("numcalls "+ numcalls );


    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> resultSets = new ArrayList<>();
        List<Integer> chosen = new ArrayList<Integer>();
        List<Integer> choices = new ArrayList<Integer>();
        Set<Integer> choiceSet = new HashSet<>();
       int sum =0;

        for (int i : candidates)
        {
            choices.add(i);
            choiceSet.add(i);
            sum=sum+i;
        }
        System.out.println("choiceSet"+choiceSet);
        System.out.println("sum"+sum);

       
      //  if(choiceSet.size()==1 &&  sum%choices.get(0)==0){
            //there can be only one way.
           // int targetSum =0;
          //  List<Integer> res = new ArrayList<>();
          // for(int j=0;j<choices.size();j++){
          //  targetSum =targetSum+choices.get(j);
          //  res.add(choices.get(j));
         //   if(targetSum==target){
            //    resultSets.add(res);
           //     return resultSets;
          //  }
         //  }
            
     //   }
        
        Collections.sort(choices,Collections.reverseOrder());
        Set<List<Integer>> set = new HashSet<>();
        combinationSumHelper(choices,chosen,resultSets,target,set);

        return resultSets;
    }

    private static void combinationSumHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, int target, Set<List<Integer>> set) {
        numcalls++;
        System.out.println("chosen"+chosen+"choices"+choices+"target"+target);

        if(target==0){
            if(!set.contains(chosen)){
                set.add(new ArrayList<>(chosen));
            resultSets.add(new ArrayList<>(chosen));
        }
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
            if( target<= maxPossible){
            combinationSumHelper(choices,chosen,resultSets,target,set);
            }
            //unchoose
            for(int h=0;h<=numDup;h++){
                choices.add(0,firstChoice);
            }
            

            //choose
            //choose the first choice
            chosen.add(firstChoice);
            choices.remove(0);
           
            if(target-firstChoice>=0 && target<= maxPossible){
            combinationSumHelper(choices,chosen,resultSets,target-firstChoice,set);
            }
            //unchoose
            chosen.remove(chosen.size()-1);
            choices.add(0,firstChoice);

        }
    }
}
