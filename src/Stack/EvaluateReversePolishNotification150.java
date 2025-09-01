package Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotification150 {


    public static int evalRPN(String[] tokens) {

        Set<String> operands =  new HashSet<>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");

        Stack<Integer> st = new  Stack<>();

        for (int i =0 ;i <tokens.length;i++){

            String c = tokens[i];
            // if the string is not one of the operands then it should go to stack
            if(!operands.contains(c)){
                // convert the string to int and put into stack
                int ci = Integer.parseInt(c);
                st.add(ci);

            }else{
             // we have encountered one of the operators
             // so take out the last two digits before the operand
             if(c.equals("+")){
                int last = st.pop();
                int first = st.pop();
                int sum = last + first;
                st.add(sum);
             }else if (c.equals("*")){
                int last = st.pop();
                int first = st.pop();
                int prod = last * first;
                st.add(prod);
             }
             else if (c.equals("-")){
                int last = st.pop();
                int first = st.pop();
                int sub =first -last;
                st.add(sub);
             }
             else if (c.equals("/")){
                int last = st.pop();
                int first = st.pop();
                int div =first/last;
                st.add(div);
             }


            }
        }
        return st.pop();

        
    }


    public static void main (String[] args){
      //  String[] tokens  = {"2","1","+","3","*"};
       // String[] tokens = {"4","13","5","/","+"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(evalRPN(tokens));
    }
}
