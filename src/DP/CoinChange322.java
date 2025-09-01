package DP;

import java.util.List;

public class CoinChange322 {

    public  int coinChange(int[] coins, int amount) {

        int[][] cache =  new int [coins.length][amount+1];

        for (int i=0;i<coins.length;i++){

            for (int j=0;j<=amount;j++){
                cache[i][j]=-2;

            }



        }

        return lengthOfShortestSubsequenceHelper(coins,0,amount,cache);




    }

     public int lengthOfShortestSubsequenceHelper(int[] coins, int index, int target, int[][] cache) {

        System.out.println("target"+target);


        if (target==0){
            return 0;
        }

        if(target<0){

            // invalid sum can not be made

            return -1;
        }
        // if there are not enough coins to make 
        if(index>=coins.length){
            return -1;

        }
        if(cache[index][target]!=-2){
           // return cache[index][target];


        }
       int include1 = 0;
       // int exclude =-1;
        int include = lengthOfShortestSubsequenceHelper(coins,index,target-coins[index],cache);
        int exclude = lengthOfShortestSubsequenceHelper(coins,index+1,target,cache);

        if(include>=0){
            include1 = 1 + include;
        }else{
            include1=-1; 
        }

        if(exclude<0){
            exclude=include1;
        }
       
    
        cache[index][target]= Math.min(include1,exclude);
        return Math.min(include1,exclude);





        
    }

    
    public static void main (String[] args){

        int[] coins = {2};
        int amount =0;

        CoinChange322 c = new CoinChange322();
       int ans =  c.coinChange(coins,amount);

       System.out.println(ans);


    }
}
