package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI496 {


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // first find out the next geater element for num2 array

        Stack<Integer> st = new Stack<>();

        HashMap<Integer,Integer> resultIndex = new HashMap<>();
        HashMap<Integer,Integer> resultNumber = new HashMap<>();
        int[] res1 = new int[nums2.length];
       


for (int i=0;i<nums2.length;i++){
          //since we need to find the next greater element, stack has to be monotonicaly decreasing
          //so stack becomes invalid if the number at current index is greater than the last number in the stack
        while(!st.isEmpty() &&  nums2[st.peek()]<nums2[i] ){
            int prevIndex = st.pop();
            resultIndex.put(prevIndex,i);
            res1[prevIndex] = i-prevIndex;
            resultNumber.put(nums2[prevIndex],nums2[i] );

        }
        st.push(i);
    }
System.out.println(resultIndex);
System.out.println(resultNumber);
System.out.println(Arrays.toString(res1));
    int[] res = new int[nums1.length];

    for (int i = 0; i < nums1.length; i++){

        res[i]=resultNumber.getOrDefault(nums1[i],-1);
    }


return res;
        
    }


    public static void main(String[] args){

  //int[] nums1 ={4,1,2};
  //int[] nums2 = {1,3,4,2};
  int[] nums1 ={2,4};
  int[] nums2 = {1,2,3,4};


  System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));

    }
}
