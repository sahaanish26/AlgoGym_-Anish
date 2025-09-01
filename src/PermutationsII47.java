import java.util.ArrayList;
import java.util.List;

public class PermutationsII47 {

    public static void main(String[] args){
        // String s1 = "ab";
        // String s2 = "eidbkooo";
  
         String s1 = "adc";
         String s2 = "dcda";
         int[] nums = {1,1,2};
         System.out.println(permuteUnique(nums));
  
      }
  
  

     public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> choices = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            choices.add(nums[i]);

        }
        List<Integer> chosen = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permuteUniqueHelper(choices,chosen,result);
        
                return result;
                
            }
        
        
        
            private static void permuteUniqueHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> result) {

             if(choices.size()==0){
                System.out.print("chosen"+chosen);
                if(!result.contains(chosen)){result.add(new ArrayList<>(chosen));}
                

             }else{

                for(int i=0;i<choices.size();i++){
                    //choose
                    int choice = choices.get(i);
                    chosen.add(choice);
                    choices.remove(i);
                    //explore
                    permuteUniqueHelper(choices,chosen,result);

                    //unchoose
                    chosen.remove(chosen.size()-1);
                    choices.add(i,choice);


                }


             }


                  }
    
}
