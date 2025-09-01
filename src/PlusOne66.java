import java.util.Arrays;

public class PlusOne66 {

    public static void main(String[] args){

        int[] digits ={9,9,9};

        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));


    }

    public static int[] plusOne(int[] digits) {

        int carry=0;

        for (int j=digits.length-1;j>=0;j--){
            int current = digits[j];
            int sum = current + carry;
            if(j==digits.length-1){
                sum=sum+1;
            }
            if (sum>=10){
                carry=1;
                current=0;
            }else{
                current=sum;
                carry=0;
            }
            digits[j]=current;

        }
        if (carry==0){
            return digits;
        }

        int[] modified = new int[digits.length+1];
        modified[0]=1;
        for (int i=0;i<digits.length;i++){
            modified[i+1]=digits[i];
        }





        return modified;
        
    }
    
}
