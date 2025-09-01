package TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartiitonLabels763 {
    // neetcode video is vey helpful for understanding the concept
    public static  List<Integer> partitionLabels(String s) {

        Map<Character,Integer> charLastPlace =  new HashMap<>();

        for (int i =0;i<s.length();i++){

            charLastPlace.put(s.charAt(i),i);

        }

        int left=0;
       // int lastOfPartitionSoFar=charLastPlace.get(s.charAt(left));
        List<Integer> ans = new ArrayList<>();

        // outer while loop
       while(left<s.length()) {
        // check the last occurence of the first char of a new partition.
        // new partition starts at left
        int lastOfPartitionSoFar=charLastPlace.get(s.charAt(left));
        int partitionlength=0;
        // inner while loop
        // until the left pointer reaches lastOfPartitionSoFar we are extending the current partition.
        
        while(left<=lastOfPartitionSoFar){
            partitionlength++;
            int lastOccurenceOfCurChar = charLastPlace.get(s.charAt(left));
            if(lastOccurenceOfCurChar>lastOfPartitionSoFar){
                lastOfPartitionSoFar=lastOccurenceOfCurChar;
            }
            left++;
              // new partition will  start at new value of left
        
        }
        ans.add(partitionlength);
        // new partition will  start at new value of left
    }
        
    return ans;
    }
    
    public static void main(String[] args){

       // String s= "ababcbacadefegdehijhklij";
       // String s= "a";
      //  String s= "abbcbcdefegdehijhklij";
        String s = "eccbbbbdec";

        System.out.println(partitionLabels(s));

    }
}
