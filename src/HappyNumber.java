import java.util.HashSet;
import java.util.Set;

public class HappyNumber {


    public static  boolean isHappy(int n) {

          // keep on doing the process
        // if same number reappears return false
        // if 1 appears return true
        Set<Integer> present = new HashSet<>();
        int sum=0;

      while(n>0){
     
        System.out.println("sum before each inner iteration"+sum);
        System.out.println("fresh number before each inner iteration"+n);
        //inner while loop for calculating sum of swaures of its digits
       while(n>=1){
           int firstDigitFromLast = n%10; //[ example 19. 19%10=9]
           int remainingNumber = n/10; //[ example 19. 19/10=1]
           int squareNumber = firstDigitFromLast*firstDigitFromLast;
           sum=sum+squareNumber;
           n = remainingNumber; 
       }
       System.out.println("sum after each inner iteration"+sum);
       if(sum==1){
        return true;
       }
       if(!present.contains(sum)){
        present.add(sum);
       }else{
        return false;
       }
       n=sum;
       //reset sum to 0
       sum=0;
    }
  
        
    return false;
    }
   
    public static void main(String[] args){

     int n = 99;
        System.out.println(isHappy(n));
    }
}
