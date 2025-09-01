public class CountOFSubsets {


    public int countSubSets(int[] nums) {


        return countSubSetsHelper(nums,0);




    }


    public int countSubSetsHelper(int[] nums,int index) {


        if(index>=nums.length){
            return 1;


        }

        int include =0;
        int exclude =0 ;


        include = countSubSetsHelper(nums,index+1);
        
        exclude = countSubSetsHelper(nums,index+1);


        return include + exclude ;




    }

    public static void main(String[] args){


        int[] nums  = {1,2};

        CountOFSubsets c = new CountOFSubsets();

        System.out.println(c.countSubSets(nums));

    }

}
