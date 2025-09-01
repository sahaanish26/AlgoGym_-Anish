package Stack;

import java.util.Stack;

public class DailyTemperature739 {


  // The implementation of the solution uses a stack data structure 
   //to keep track of the indices of days that have not yet found a warmer future temperature. 
   //The stack will help us maintain the order in which we need to find the next warmer temperature while iterating through the temperatures only once, which achieves a time complexity of O(n), where n is the number of days.
   //better solution using a standard template
   public int[] dailyTemperatures(int[] temperatures) {

    int [] res = new int[temperatures.length];
   
    // stack to store the index
    Stack<Integer> st = new Stack<>();
    //push the 0th index
   // st.push(0);
    //start iteration from the first and compare with stack
    for (int i=0;i<temperatures.length;i++){

        
        // found a next higher temp in index i, prev lower was in top of the stack prevIndex
        //take out all lower temps from current and calculate index
        // the pop has to be in while loop ..not in if since we need to pop all lower temp
        // than current one and calculate
        while(st.size()>0 && temperatures[st.peek()]<temperatures[i]){
          
             int prevIndex=  st.pop();
            res[prevIndex]=i-prevIndex;
          
           

        }
         st.push(i);
        //System.out.println("at index"+i+"stack"+st);
    }
    // the remaining items in stack can not have any greater temp
   // while(!st.isEmpty()){
       // res[st.pop()]=0;
    //}

    return res;
    
}


//old solution
public int[] dailyTemperatures1(int[] temperatures) {

    int [] res = new int[temperatures.length];
   
    // stack to store the index
    Stack<Integer> st = new Stack<>();
    //push the 0th index
   // st.push(0);
    //start iteration from the first and compare with stack
    for (int i=0;i<temperatures.length;i++){

        
        // found a next higher temp in index i, prev lower was in top of the stack prevIndex
        //take out all lower temps from current and calculate index
        // the pop has to be in while loop ..not in if since we need to pop all lower temp
        // than current one and calculate
        while(st.size()>0 && temperatures[st.peek()]<temperatures[i]){
          
             int prevIndex=  st.pop();
            res[prevIndex]=i-prevIndex;
          
           

        }
         st.push(i);
        //System.out.println("at index"+i+"stack"+st);
    }
    // the remaining items in stack can not have any greater temp
   // while(!st.isEmpty()){
       // res[st.pop()]=0;
    //}

    return res;
    
}

}
