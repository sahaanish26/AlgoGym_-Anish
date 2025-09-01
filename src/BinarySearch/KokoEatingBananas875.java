package BinarySearch;
public class KokoEatingBananas875 {
    

    public static void main(String[] args){

       // int[] piles = {3,6,7,11};
      //  int h = 8;

        int[] piles=  {805306368,805306368,805306368};
        int h =1000000000;
     

       // int[] piles = {30,11,23,4,20};
       // int h = 5;

       // int[] piles = {312884470};

       // int h = 312884470;

        //int[] piles = {30,11,23,4,2};
        //int h = 6;

       System.out.println(minEatingSpeed(piles,h));
       

    }


    public static int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        for (int i=0;i<piles.length;i++){

            if (piles[i]>max){
                max = piles[i];
            }
        }
        // for problem like this 2226, the solution approach is find the max of the possible value of the answer that is asked? then binary search
        //and see if those values satisfy the constrain in problem. If maximum is being asked use the template last occurence of , if minimum is being
        //asked use first occurence of 
        //rate of eating will be from 1 to max. since koko can not eat more than one pile in an hour max rate will be max value in the pile.

       // int[] range = new int[max];
       /*  for (int j=0;j<max;j++){
            range[j]=j+1;
        } */
     

         // taking left value from 1, since invalid value will anywau come out of answer variable
      
        int left = 1;
        int right = max;
        int ans =-1;


        //since this is a minimization proble (min speed) , will have to find the first occurence of value that
//satisfies the condition
        while(left<=right){

            int mid = left + (right-left)/2;

            if(validCondition(piles,mid,h)){
              //  System.out.println("mid"+mid);
                ans=mid;
                right=mid-1;
            }else{
                left = mid+1;
            }

            



        }





        return ans;
        
    }


    private static boolean validCondition(int[] piles, int mid, int h) {
        int calCulatedHours = 0;
       // System.out.println("mid value"+mid);

        for (int m=0;m<piles.length;m++){
            // to get the ceil value
        // if (piles[m] % mid != 0) {
 
        //     // in case of odd number
        //     calCulatedHours += ((piles[m] / mid) + 1);
        // }
        // else {
 
        //     // in case of even number
        //     calCulatedHours += (piles[m] / mid);
        // }
            //calCulatedHours = calCulatedHours +  ( Math.abs(piles[m]/mid)+1) ;
            calCulatedHours =  calCulatedHours + (int)Math.ceil((double )(piles[m])/(double)(mid));
          // double div1= Math.ceil(div);
        
          // calCulatedHours=calCulatedHours+div1;


        }
        System.out.println("calCulatedHours"+calCulatedHours + "for value"+mid);
        if(calCulatedHours<=h && calCulatedHours>0 ){
            return true;
        }
        return false;
         }
}
