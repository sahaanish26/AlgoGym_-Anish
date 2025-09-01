package Stack;

import java.util.HashMap;
import java.util.Stack;

public class validparenthesis20 {

    public boolean isValid(String s) {

      HashMap<Character, Character> Hmap = new HashMap<Character, Character>();
        Hmap.put(')','(');
        Hmap.put('}','{');
        Hmap.put(']','[');

        Stack<Character> st = new Stack<>();

        for (int i=0;i<s.length();i++){

            char c = s.charAt(i);

            // if opening push it in stack

            if(c=='(' || c=='{'|| c=='['){

                st.push(c);
            }

            // else if it is closing
            else{
             // we have a closing one but no opening one in stack
             // so an invalid scenario
                if(st.isEmpty()){
                    return false;
                }
                // stack is not empty
                else {
                    //if on top of stack there is an correct opening it is valid
                    if(Hmap.get(c)==st.peek()){
                        st.pop();
                    }else{
                        // invalid open so
                        return false;
                    }

                }


            }

        }

//at the end stack size needs to be zero.
        
      if (st.size()!=0){
        return false;
      }

      return true;
        
        
    }

}
