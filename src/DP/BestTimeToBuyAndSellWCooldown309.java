package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestTimeToBuyAndSellWCooldown309 {


    public  static int maxProfit(int[] prices) {

        HashMap<List<Integer>,Integer> cache = new HashMap<>();
        // buyCount value can be either 0,1
       // int [][][][] memo = new int[prices.length][2][2][3]

       return maxProfitHelper(prices,0,0,0,"C",cache);
        
    }

    public static int maxProfitHelper(int[] prices, int index, int buyCount, int sellCount,String lastAction,  HashMap<List<Integer>,Integer> cache ) {
      
        // base case 
        if(index==prices.length){
            return 0;
        }
        List<Integer> key = new ArrayList<>();
        key.add(index);
        if(lastAction.equalsIgnoreCase("B")){
            key.add(1);
        }else if (lastAction.equalsIgnoreCase("S")){
            key.add(2);
        }else {
            key.add(3);
        }
        key.add(buyCount-sellCount);
         // if we add buyCount and SellCount directly we will still get correct answer but
        // caching will not be effective. as State value ranges will be very long so matches will
        // be very less. IN this problem we are allowed unlimited transactions but key is buy will always be more than 1 from sell or equal so when we make the diff there are only two possible states
        // 0 or 1
       // key.add(buyCount);
       // key.add(sellCount);
        
        

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int choice1=Integer.MIN_VALUE;
        int choice2=Integer.MIN_VALUE;

        // possible choice buy
        if(buyCount==sellCount && lastAction.equalsIgnoreCase("C")   ){

            choice1 =  prices[index]*(-1) + maxProfitHelper(prices,index+1,buyCount+1,sellCount,"B",cache);
        }


        // possible Choice Sell
        if(buyCount>sellCount){
             choice2 =  prices[index] + maxProfitHelper(prices,index+1,buyCount,sellCount+1,"S",cache);
    

        }


        // Possible Choice Cooldown, always we can cooldown

        int choice3 = maxProfitHelper(prices,index+1,buyCount,sellCount,"C",cache);

        int max = Math.max(choice3, Math.max(choice1,choice2));

        cache.put(key,max);

        return max;


        
    }

    public static void main (String[] args){

       // int[] p = {1,2,3,0,2};
       // int[] p = {1,2,4};
       int[] p =  {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
        System.out.println(maxProfit(p));
    }

}
