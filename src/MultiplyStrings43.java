import java.util.*;
public class MultiplyStrings43 {


    public static void main (String[] args){

        String num1 = "21";
        String  num2 = "100";

       // String num1 = "823";
       // String  num2 = "456";


        System.out.println(multiply(num1,num2));


    }
    // mistake to remember ..never assume carry is 1 [ unlike some sum problem], carry will be sum/10 since it is product problem.
    //

    public static  String multiply(String num1, String num2) {

       // if (num1.matches("0*")||num2.matches("0*")){
      //      return "0";
     //   }

        int maxLength = num1.length()+num2.length();

        char [] res = new char[maxLength];

        for(int a=0;a<maxLength;a++){
            res[a]='0';


          }
          int outerLoopindex =maxLength-1;
          int innerLoopindex =maxLength-1;

        for (int i=num2.length()-1;i>=0;i--){
            int carry =0;
            for (int j=num1.length()-1;j>=0;j--){
                int num1Int = Character.getNumericValue(num1.charAt(j));
                int num2Int = Character.getNumericValue(num2.charAt(i));
                int resNumber = Character.getNumericValue(res[innerLoopindex]);
                int prod = num1Int*num2Int;
                int sum = prod + carry+resNumber;
                if (sum>=10){
                    carry=sum/10;
                    int modulo= sum%10;
                    res[innerLoopindex]=Character.forDigit(modulo, 10);
                }
                else{
                    res[innerLoopindex]=Character.forDigit(sum, 10);
                    carry=0;
                }
                innerLoopindex=innerLoopindex-1;
        
            }
            System.out.println("inner iter 1+"+Arrays.toString(res));
            //after every inner loop placing the carryover value.
            if (carry>0){
                int resNumber = Character.getNumericValue(res[innerLoopindex]);
                if (resNumber+carry>=10){
                    int carryfwd=(resNumber+carry)/10;
                    int modulo= (resNumber+carry)%10;
                    res[innerLoopindex]=Character.forDigit(modulo, 10);
                    res[innerLoopindex-1]=Character.forDigit(carryfwd, 10);
                 


                }else{
                    res[innerLoopindex]=Character.forDigit(resNumber+carry, 10);
                }
                 
               
            }
            System.out.println("inner iter 1+ carry"+Arrays.toString(res));
            carry=0;
            outerLoopindex=outerLoopindex-1;
            innerLoopindex=outerLoopindex;
           // index=index+num1.length()-1;

        }




    StringBuilder sb = new StringBuilder();
    for (int i=0;i<res.length;i++){
        sb.append(res[i]);


    }

    String resultString = sb.toString();

    if (resultString.charAt(0)=='0'){
        return resultString.substring(1);
    }


        return resultString ;
        
    }

    
    
}
