package DP;

public class BestTimeToBuyAndSellStockV3573 {


    public static long maximumProfit(int[] prices, int k) {
       // sending 2 times allowed transaction so that each sell and buy we can consider
       //1 transaction always one transaction happesn is ensured by the fact that
       //when buy>sell we can sell when sell>buy we can buy
       // skip we can always do
        return maximumProfitHelper(prices,0,k,0,0);
        
    }


    public static long maximumProfitHelper(int[] prices,int index, double allowed ,int buyCount , int sellCount  ) {
        
       // System.out.println("buycount1"+buyCount+"sellCount1"+sellCount+"allowed1"+allowed);
      
       
        if(allowed<=0){
            return 0l;
        }

        if(index>=prices.length){
            System.out.println("buycount"+buyCount+"sellCount"+sellCount+"allowed"+allowed);
    
            if(buyCount!=sellCount){
                return Long.MIN_VALUE;

            }
           
            return 0l;
        }

        

      //  System.out.println("buycount"+buyCount+"sellCount"+sellCount+"allowed"+allowed);
    

        //we can skip at any condition
        long buy = Long.MIN_VALUE;
        long buy1 = Long.MIN_VALUE;
        long sell = Long.MIN_VALUE;
        long sell1 =Long.MIN_VALUE;

        long skip = maximumProfitHelper(prices,index+1,allowed,buyCount,sellCount);

        if(buyCount>sellCount){
        // only sell can happen
         sell1 = (long )prices[index] + maximumProfitHelper(prices,index+1,allowed-0.5,buyCount,sellCount+1);

        }else if (buyCount<sellCount){
              // only buy can happen
               buy1 = - (long )prices[index] + maximumProfitHelper(prices,index+1,allowed-0.5,buyCount+1,sellCount);

        }else{
            // buy or sell both can happen
             buy = - (long )prices[index]+ maximumProfitHelper(prices,index+1,allowed-0.5,buyCount+1,sellCount);
             sell = (long )prices[index]+ maximumProfitHelper(prices,index+1,allowed-0.5,buyCount,sellCount+1);


        }

        long result = Math.max(Math.max(buy,sell), Math.max(buy1,sell1));
        long finalResult = Math.max(result,skip);


        return finalResult;



        
    }

    public static void main (String[] args ){

        int[] prices = {1,7,9,8,2};
        int k =2;
       // int[] prices = {12,16,19,19,8,1,19,13,9};
       // int k =3;
        

        System.out.println(maximumProfit(prices,k));
    }
}
