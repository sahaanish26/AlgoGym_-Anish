package SlidingWindow.Sorting;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


//https://leetcode.com/problems/frequency-of-the-most-frequent-element/solutions/5513173/video-sliding-window-solution
//Basically, we are trying to make all the numbers same in the window.
//We are allowed to increase numbers k times. when we try to make all numbers same in the window, simply
// window lenght * max number in the window should be less than equal to sum of window +k

//last test case fails one fails
public class FrequencyoftheMostFrequentElement1838 {


    public int maxFrequency(int[] nums, int k) {
if(nums.length==0){return 0;}
     Arrays.sort(nums);
          int max = Integer.MIN_VALUE;
          int right=0;
          int left =0;
          Deque<Integer> slidingQ = new LinkedList<>();
          Map<Integer,Integer> countMap=new HashMap();
          long sumSofar =0;
       
    
    
          while(right<nums.length){
            int c = nums[right];
            slidingQ.add(c);
            sumSofar=sumSofar+c;
            right++;
    
            //while loop until the window becomes just invalid
            //window invalid -- when countmap has frequency more than one
    
           while(invalid(slidingQ,k,sumSofar) ){
                                         int r = nums[left];
                                         slidingQ.remove();
                                        sumSofar=sumSofar-r;
                                        left++;
                                        }
                                        // length of a valid substring with given criteria
                                       int  length = right - left;
                                       // max length everytime
                                       max = Integer.max(max,length);
           
                                       if (length>=max){
                                         max=length;
                                         //we need to get sum of all valid windows not neccesarily the
                                        // longest valid window.
                                       // maxright=right;
                                       // maxLeft=left;
                                      //  System.out.println("maxright"+right);
                                     //   System.out.println("maxLeft"+left);
                                        
           
                                       }
                                     
                                      
                                        
                                       }   
                                        // for (int i= maxLeft;   i<  maxright;i++){
                                         //  output = output + nums[i];
                                        // }                                                                   
                                        // return  max;  
                                        return max;
           
           
           
           
           
                  
                   
               }
           
               private boolean invalid(Deque<Integer> slidingQ, int k, long sumSofar) {
                  int size =slidingQ.size();
                  int lastaddedElement = slidingQ.getLast();
                  long product =lastaddedElement*size;
                  if(product>sumSofar+k){
                    return true;
                  }

                  return false;
            
            }

}
