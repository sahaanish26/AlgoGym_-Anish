package DP;

public class PallindromicSubstrings647 {

    public static int countSubstrings(String s) {

    int oddCount =0;
    int evenCount =0;

        // loop over the string and consider each index as the middle

        for ( int i =0; i<s.length();i++){

            //odd lenght case
             //take i as middle and expand outward in both directions
            int towardsLeft=i;
            int towardsRight=i;
            while(towardsLeft>=0 && towardsRight<s.length() ) {

            if(s.charAt(towardsLeft)==s.charAt(towardsRight)){
                //substring is pallindrome increase the count
                oddCount =oddCount+1;
                towardsLeft= towardsLeft-1;
                towardsRight=towardsRight+1;

            }else{
                //for the first unmatch 
                break;
            }

            }


            //even lenght case
             //take i as middle and expand outward in both directions
           

             int towardsLeftEven=i;
             // for even towardsRightEven=i+1
             int towardsRightEven=i+1;
             while(towardsLeftEven>=0 && towardsRightEven<s.length() ) {
 
             if(s.charAt(towardsLeftEven)==s.charAt(towardsRightEven)){
                 //substring is pallindrome increase the count
                 evenCount =evenCount+1;
                 towardsLeftEven= towardsLeftEven-1;
                 towardsRightEven=towardsRightEven+1;
 
             }else{
                 //for the first unmatch 
                 break;
             }
 
             }

       

        











        }
        
        System.out.println("evenCount"+evenCount);
        System.out.println("oddCount"+oddCount);
       

        return oddCount+ evenCount ;

    }

    public static void main(String[ ] args){
        String s = "aabaa";
        System.out.println(countSubstrings(s));
    }
}
