public class NumberOf1Bit191 {

    public static void main(String[] args){

        int res = hammingWeight(9);

        System.out.println(res);

        int res1 = hammingDistance(3,1);

        System.out.println(res1);

        int res2 = reverseBits(-3);

        System.out.println(res2);


    }

    public static int hammingWeight(int n) {

        int count =0;
        //To Check a bit at any position n in number x do (1 & (x >> n)).
        // the nth position is calculated from right o left. so 0th position is 31st position  from right position
        //To Set a bit at position n simply do (x |= (1 << n)).
       //You left shift 1 at position n and then add it x basically making that place also set (1).



        for (int i=31;i>=0;i--){
            int bit1 = (n>>i);
            //   System.out.println("bit1 -->>   "+bit1);
            int bit = (1 & bit1);
          //  System.out.println("bit -->>   "+bit);
            if(bit==1){
                count ++;
            }
        }



        return count;
    }
  

    public static int hammingDistance(int x,int y) {

        int count1 =0;
        //To Check a bit at any position n in number x do (1 & (x >> n)).
        // the nth position is calculated from right o left. so 0th position is 31st position  from right position
        //xor (^)
//If same then 0, if different then 1
//1 ^ 0 = 1
//1 ^ 1 = 0
//0 ^ 0 = 0
//0 ^ 1 = 1
//example: 1001 ^ 1100 = 0101

        for (int i=31;i>=0;i--){
           
            int bit2 =  (1 & (y>>i));
          //  System.out.println("bit2 >> "+bit2);
            int bit1 =  (1 & (x>>i));
           // System.out.println("bit1 -->>   "+bit1);
           
           
            int xorBit = (bit1^bit2);
         //   System.out.println("xorBit -->>   "+xorBit);
           
            
            if(xorBit==1){
                count1 ++;
            }
        }



        return count1;
    }
  

    public static  int reverseBits(int n) {

       
        int res =0;
        //To Check a bit at any position n in number x do (1 & (x >> n)).
        // the nth position is calculated from right o left. so 0th position is 31st position  from right position
        //To Set a bit at position n simply do (x |= (1 << n)).
       //You left shift 1 at position n and then add it x basically making that place also set (1).



        for (int i=31;i>=0;i--){
            int bit1 = (n>>i);
            //   System.out.println("bit1 -->>   "+bit1);
            int bit = (1 & bit1);
          //  System.out.println("bit -->>   "+bit);
           res= (res |= (bit << (31-i)));
        }



        return res;
        
    }

    //To Set a bit at position n simply do (x |= (1 << n)).
//You left shift 1 at position n and then add it x basically making that place also set (1).

}
