package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum39 {

      public static  List<List<Integer>> combinationSum(int[] candidates, int target) {

         List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // sort the candidates so that we can filter the duplicates easily
       Arrays.sort(candidates);
       // System.out.println(Arrays.toString(candidates));
        Set<List<Integer>> set = new HashSet<>();
        combinationSumHelper(candidates,target,0,path,res,set);
        System.out.println("res"+res);
        return res;
      }

      public  static void combinationSumHelper(int[] candidates, int target,int index , List<Integer> path ,  List<List<Integer>> result, Set<List<Integer>> set) {

        // base case if target ==0 then add the path in resultlist
        if(target==0){
            if(!set.contains(path)){
                set.add(new ArrayList<>(path));
            result.add(new ArrayList<>(path));
            }

        }
        // if not possible return 
        if(target<0){
            return;
        }
        if(index>=candidates.length){
            return;
        }
        // choose explore unchoose with choosing the option
        int currentNumber = candidates[index];
        path.add(currentNumber);
        // no index+1 since the choices are infinite 
        combinationSumHelper(candidates,target-currentNumber,index,path,result,set);
        //unchoose
        path.remove(path.size()-1);


        // choose explore unchoose without choosing the option.
        // when we say we do not choose, all occurence of this numbe rmust be skipped

        //skipping the number if they are same
   
       // path.add(currentNumber);
        combinationSumHelper(candidates,target,index+1,path,result,set);
        //unchoose
       // path.remove(path.size()-1);





        
    } 

    public static void main(String[] args){

        int[] candidates = {2,3,6,7};
        int target =7;

        combinationSum(candidates,target);
    }


}
